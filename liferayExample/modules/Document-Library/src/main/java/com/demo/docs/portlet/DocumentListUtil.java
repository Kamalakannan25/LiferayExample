package com.demo.docs.portlet;

import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.repository.model.FileEntry;

import java.util.List;

public class DocumentListUtil {

	public static List<FileEntry> getDocuments(long repositoryId, long folderId) {
        try {
            
            List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(repositoryId, folderId);
            return fileEntries;
        } catch (PortalException | SystemException e) {
            e.printStackTrace();
        }
        return null;
    }
	
}
