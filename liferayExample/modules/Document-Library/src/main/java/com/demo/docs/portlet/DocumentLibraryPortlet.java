package com.demo.docs.portlet;

import com.demo.docs.constants.DocumentLibraryPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Suchismita
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=DocumentLibrary",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + DocumentLibraryPortletKeys.DOCUMENTLIBRARY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class DocumentLibraryPortlet extends MVCPortlet {
	
	 private static final Log _log = LogFactoryUtil.getLog(DocumentLibraryPortlet.class);
	
	@Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
            throws IOException, PortletException {
    	
    	 ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
         long repositoryId = themeDisplay.getScopeGroupId();
         long folderId = 0; 

         List<FileEntry> fileEntries = DocumentListUtil.getDocuments(repositoryId, folderId);
         
         renderRequest.setAttribute("fileEntries", fileEntries);
         super.doView(renderRequest, renderResponse);
     }
	
	public void addaction(ActionRequest actionRequest, ActionResponse actionResponse)
            throws PortletException, IOException {
        try {

            ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
            UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

            String parentFolderName = uploadPortletRequest.getParameter("parentFolderName");
            String subFolderName = uploadPortletRequest.getParameter("subFolderName");

            File[] imageFiles = uploadPortletRequest.getFiles("imageFiles");
            String[] imageFileNames = uploadPortletRequest.getFileNames("imageFiles");

            File[] videoFiles = uploadPortletRequest.getFiles("videoFiles");
            String[] videoFileNames = uploadPortletRequest.getFileNames("videoFiles");

            File[] otherFiles = uploadPortletRequest.getFiles("otherFiles");
            String[] otherFileNames = uploadPortletRequest.getFileNames("otherFiles");

            List<FileEntry> fileEntries = FileUploadUtil.uploadFiles(
                uploadPortletRequest, themeDisplay, imageFiles, videoFiles, otherFiles, 
                imageFileNames, videoFileNames, otherFileNames, 
                parentFolderName, subFolderName
            );

            for (FileEntry fileEntry : fileEntries) {
                _log.info("Successfully uploaded file with FileEntryId: " + fileEntry.getFileEntryId());
            }

        } catch (Exception e) {
            _log.error("Error processing file upload action: " + e.getMessage(), e);
            throw new PortletException("File upload failed.", e);
        }
    }
}