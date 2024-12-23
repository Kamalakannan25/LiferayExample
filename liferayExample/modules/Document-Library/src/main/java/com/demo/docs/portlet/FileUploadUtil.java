package com.demo.docs.portlet;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileUploadUtil {

	private static final Log _log = LogFactoryUtil.getLog(FileUploadUtil.class);

    public static List<FileEntry> uploadFiles(
            UploadRequest uploadRequest, ThemeDisplay themeDisplay, File[] imageFiles, File[] videoFiles, 
            File[] otherFiles, String[] imageFileNames, String[] videoFileNames, String[] otherFileNames, 
            String parentFolderName, String subFolderName) {

        List<FileEntry> fileEntries = new ArrayList<>();
        long repositoryId = themeDisplay.getScopeGroupId();
        long timestamp = System.currentTimeMillis();

        try {
            Folder parentFolder = getOrCreateFolder(uploadRequest, themeDisplay, repositoryId, 0, parentFolderName);
            Folder subFolder = getOrCreateFolder(uploadRequest, themeDisplay, repositoryId, parentFolder.getFolderId(), subFolderName);

            // Process images
            fileEntries.addAll(uploadSpecificFiles(uploadRequest, themeDisplay, imageFiles, imageFileNames, repositoryId, subFolder, "image", timestamp));

            // Process videos
            fileEntries.addAll(uploadSpecificFiles(uploadRequest, themeDisplay, videoFiles, videoFileNames, repositoryId, subFolder, "video", timestamp));

            // Process other files
            fileEntries.addAll(uploadSpecificFiles(uploadRequest, themeDisplay, otherFiles, otherFileNames, repositoryId, subFolder, "other", timestamp));

        } catch (Exception e) {
            _log.error("Error uploading files: " + e.getMessage(), e);
        }

        return fileEntries;
    }
	
    private static List<FileEntry> uploadSpecificFiles(
            UploadRequest uploadRequest, ThemeDisplay themeDisplay, File[] files, String[] fileNames, 
            long repositoryId, Folder subFolder, String fileType, long timestamp) throws Exception {

        List<FileEntry> fileEntries = new ArrayList<>();

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            String fileName = timestamp + "_" + fileNames[i];

            if (file != null && fileName != null && !fileName.isEmpty()) {
                String mimeType = MimeTypesUtil.getContentType(file);

                if (mimeType == null) {
                    _log.error("File " + fileName + " has no MIME type.");
                    continue;  // Skip if no MIME type is found
                }

                ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), uploadRequest);
                serviceContext.setScopeGroupId(themeDisplay.getScopeGroupId());
                serviceContext.setAddGuestPermissions(true);

                // Log file type
                if ("image".equals(fileType) && isImage(mimeType)) {
                    _log.info("Uploading image: " + fileName);
                } else if ("video".equals(fileType) && isVideo(mimeType)) {
                    _log.info("Uploading video: " + fileName);
                } else if ("other".equals(fileType)) {
                    _log.info("Uploading other file: " + fileName);
                }

                FileEntry fileEntry = DLAppServiceUtil.addFileEntry(
                        repositoryId, subFolder.getFolderId(), fileName,
                        mimeType, fileName,
                        "Uploaded by FileUploadUtil", "", file, serviceContext);

                fileEntries.add(fileEntry);
                _log.info("Successfully uploaded: " + fileName + " with FileEntryId: " + fileEntry.getFileEntryId());
            }
        }

        return fileEntries;
    }
    
    private static Folder getOrCreateFolder(
            UploadRequest uploadRequest, ThemeDisplay themeDisplay, long repositoryId, long parentFolderId,
            String folderName) throws Exception {

        Folder folder = null;
        boolean folderExists = false;

        try {
            folder = DLAppServiceUtil.getFolder(repositoryId, parentFolderId, folderName);
            folderExists = true;
        } catch (Exception e) {
            _log.info("Folder " + folderName + " does not exist, creating new folder.");
        }

        if (!folderExists) {
            ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), uploadRequest);
            folder = DLAppServiceUtil.addFolder(
                    "", repositoryId, parentFolderId, folderName, folderName, serviceContext);
        }

        return folder;
    }

    private static boolean isImage(String mimeType) {
        return mimeType.startsWith("image/");
    }

    private static boolean isVideo(String mimeType) {
        return mimeType.startsWith("video/");
    }
	
}
