package com.demo.objects.portlet;


import com.demo.objects.constants.ObjectCrudPortletKeys;
import com.demo.objects.util.HttpConnectionUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.util.DLURLHelperUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.json.JSONArray;
import org.json.JSONObject;
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
		"javax.portlet.display-name=ObjectCrud",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ObjectCrudPortletKeys.OBJECTCRUD,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ObjectCrudPortlet extends MVCPortlet {
	
	private static final Log _log = LogFactoryUtil.getLog(ObjectCrudPortlet.class);

	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		String EmpData = HttpConnectionUtil.getUrl("http://localhost:8080", "/o/c/employees/");
		renderRequest.setAttribute("EmpData", EmpData);
				
		super.render(renderRequest, renderResponse);
	}
	
	
	
	
	public void addEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {

	    UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	    File file = uploadPortletRequest.getFile("employeePhoto"); 
	    String empName = ParamUtil.getString(uploadPortletRequest, "employeeName");
	    String empAddress = ParamUtil.getString(uploadPortletRequest, "employeeAddress");
	    int empAge = ParamUtil.getInteger(uploadPortletRequest, "employeeAge");
	    long empPhoneNo = ParamUtil.getLong(uploadPortletRequest, "employeePhoneNo");

	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

	    long repositoryId = themeDisplay.getScopeGroupId();
	    long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	    ServiceContext serviceContext = null;
	    try {
	        serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
	    } catch (PortalException e1) {
	        e1.printStackTrace();
	    }

	    try (InputStream is = new FileInputStream(file)) {
	        String title = file.getName();
	        String description = "Profile picture of " + empName;
	        String mimeType = MimeTypesUtil.getContentType(file);
	        FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", repositoryId, folderId, file.getName(), mimeType, title,
                    description, "", mimeType, is, file.length(), null, null, serviceContext);
	        

	            String fileEntryId = String.valueOf(fileEntry.getFileEntryId());
	            String fileEntryURL = DLURLHelperUtil.getPreviewURL(
	                    fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK, false, false);

	            // Construct Employee JSON data
	            JSONObject employeeData = new JSONObject();
	            employeeData.put("employeeName", empName);
	            employeeData.put("employeeAddress", empAddress);
	            employeeData.put("employeeAge", empAge);
	            employeeData.put("employeePhoneNo", empPhoneNo);
	            

	            JSONObject employeePhoto = new JSONObject();
	            employeePhoto.put("id", fileEntryId);

	            JSONObject link = new JSONObject();
	            link.put("href", fileEntryURL);
	            link.put("label", title);

	            employeePhoto.put("link", link);
	            employeePhoto.put("name", title);

	            employeeData.put("employeePhoto", employeePhoto);

	            // Send data to backend API
	            try {
	                String responseId = HttpConnectionUtil.postUrl(
	                        employeeData.toString(), "http://localhost:8080", "/o/c/employees/");

	                actionRequest.setAttribute("responseId", responseId);
	            } catch (UnirestException e) {
	                _log.error("Error adding employee data: " + e.getMessage(), e);
	            }
	        } 
	     catch (FileNotFoundException e) {
	        _log.error("File not found: " + e.getMessage(), e);
	    } catch (PortalException e) {
	        _log.error("Error uploading file: " + e.getMessage(), e);
	    }
	}
	
	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
	        throws IOException, PortletException {
	    
	    System.out.println("Inside updateEmployee method...");

	    UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
	    long id = ParamUtil.getLong(actionRequest, "id");
	    String empName = ParamUtil.getString(uploadPortletRequest, "employeeName");
	    String empAddress = ParamUtil.getString(uploadPortletRequest, "employeeAddress");
	    int empAge = ParamUtil.getInteger(uploadPortletRequest, "employeeAge");
	    long empPhoneNo = ParamUtil.getLong(uploadPortletRequest, "employeePhoneNo");

	    File file = uploadPortletRequest.getFile("employeePhoto");
	    if (file == null || !file.exists()) {
	        _log.error("File is missing or could not be found.");
	        return;
	    }

	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	    long repositoryId = themeDisplay.getScopeGroupId();
	    long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;

	    ServiceContext serviceContext;
	    try {
	        serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
	    } catch (PortalException e1) {
	        _log.error("Error initializing service context: ", e1);
	        return;
	    }

	    try (InputStream is = new FileInputStream(file)) {
	        String mimeType = MimeTypesUtil.getContentType(file);
	        FileEntry fileEntry = DLAppServiceUtil.addFileEntry(
	                 "", repositoryId, folderId, file.getName(), mimeType, 
	                file.getName(), "Updated profile picture of " + empName, "", mimeType, is, 
	                file.length(), null, null, serviceContext);
	        
//	        addFileEntry("", repositoryId, folderId, file.getName(), mimeType, title,
//	                description, "", mimeType, is, file.length(), null, null, serviceContext);

	        String fileEntryURL = DLURLHelperUtil.getPreviewURL(
	                fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK, false, false);

	        JSONObject employeeData = new JSONObject();
	        employeeData.put("employeeName", empName);
	        employeeData.put("employeeAddress", empAddress);
	        employeeData.put("employeeAge", empAge);
	        employeeData.put("employeePhoneNo", empPhoneNo);
	        employeeData.put("id", id);

	        JSONObject employeePhoto = new JSONObject();
	        employeePhoto.put("id", fileEntry.getFileEntryId());
	        employeePhoto.put("name", file.getName());
	        
	        JSONObject link = new JSONObject();
	        link.put("href", fileEntryURL);
	        link.put("label", file.getName());
	        
	        employeePhoto.put("link", link);
	        employeeData.put("employeePhoto", employeePhoto);

	        try {
	            String updateResponse = HttpConnectionUtil.putUrl(
	                    employeeData.toString(), "http://localhost:8080", "/o/c/employees/", id);
	            System.out.println("Update Response: " + updateResponse);
	            actionRequest.setAttribute("updateResponse", new JSONArray("[" + updateResponse + "]"));
	        } catch (UnirestException e) {
	            _log.error("Error updating employee data: ", e);
	        }
	    } catch (FileNotFoundException e) {
	        _log.error("File not found: ", e);
	    } catch (PortalException e) {
	        _log.error("Error uploading file: ", e);
	    }
	}


//	public void updateEmployee(ActionRequest actionRequest, ActionResponse actionResponse)
//	        throws IOException, PortletException {
//		
//		System.out.println("Update employee Method inside..............");
//
//		long id = ParamUtil.getLong(actionRequest, "id");
//		System.out.println("Update EmployeeId : " + id);
//		
//		
//	    UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);	    	    
//	    File file = uploadPortletRequest.getFile("employeePhoto");
//	    String empName = ParamUtil.getString(uploadPortletRequest, "employeeName");
//	    String empAddress = ParamUtil.getString(uploadPortletRequest, "employeeAddress");
//	    int empAge = ParamUtil.getInteger(uploadPortletRequest, "employeeAge");
//	    long empPhoneNo = ParamUtil.getLong(uploadPortletRequest, "employeePhoneNo");
//	    long empId = ParamUtil.getLong(uploadPortletRequest, "id");
//
//	    ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
//	    long repositoryId = themeDisplay.getScopeGroupId();
//	    long folderId = DLFolderConstants.DEFAULT_PARENT_FOLDER_ID;
//
//	    ServiceContext serviceContext;
//	    try {
//	        serviceContext = ServiceContextFactory.getInstance(DLFileEntry.class.getName(), actionRequest);
//	    } catch (PortalException e1) {
//	        _log.error("Error initializing service context: " + e1.getMessage(), e1);
//	        return;
//	    }
//
//	    try (InputStream is = new FileInputStream(file)) {
//	        String title = file.getName();
//	        String description = "Updated profile picture of " + empName;
//	        String mimeType = MimeTypesUtil.getContentType(file);
//	        FileEntry fileEntry = DLAppServiceUtil.addFileEntry("", repositoryId, folderId, file.getName(), mimeType, title,
//	                description, "", mimeType, is, file.length(), null, null, serviceContext);
//
//	        String fileEntryId = String.valueOf(fileEntry.getFileEntryId());
//	        String fileEntryURL = DLURLHelperUtil.getPreviewURL(
//	                fileEntry, fileEntry.getFileVersion(), themeDisplay, StringPool.BLANK, false, false);
//
//	        JSONObject employeeData = new JSONObject();
//	        employeeData.put("employeeName", empName);
//	        employeeData.put("employeeAddress", empAddress);
//	        employeeData.put("employeeAge", empAge);
//	        employeeData.put("employeePhoneNo", empPhoneNo);
//	        employeeData.put("id", empId);
//
//	        JSONObject employeePhoto = new JSONObject();
//	        employeePhoto.put("id", fileEntryId);
//
//	        JSONObject link = new JSONObject();
//	        link.put("href", fileEntryURL);
//	        link.put("label", title);
//
//	        employeePhoto.put("link", link);
//	        employeePhoto.put("name", title);
//
//	        employeeData.put("employeePhoto", employeePhoto);
//
//	        try {
//	            String updateResponse = HttpConnectionUtil.putUrl(employeeData.toString(), "http://localhost:8080", "/o/c/employees/", id);
//	            System.out.println("Update Response : " +updateResponse);
//	            actionRequest.setAttribute("updateResponse", updateResponse);
//	        } catch (UnirestException e) {
//	            _log.error("Error updating employee data: " + e.getMessage(), e);
//	        }
//	    } catch (FileNotFoundException e) {
//	        _log.error("File not found: " + e.getMessage(), e);
//	    } catch (PortalException e) {
//	        _log.error("Error uploading file: " + e.getMessage(), e);
//	    }
//	}
	
	@Override
	private void processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException  {
	    System.out.println("Inside Delete URL Method......");
	    try {
	        long id = ParamUtil.getLong(actionRequest, "id");
	        System.out.println("Employee Id : " + id);
	        
	        // Perform the deletion and get response
	        String deleteResponse = HttpConnectionUtil.deleteUrl("http://localhost:8080", "/o/c/employees/", id);
	        
	        // Log response for verification
	        System.out.println("Delete Response: " + deleteResponse);
	        
	        // Send response as a request attribute
	        actionRequest.setAttribute("deleteResponse", deleteResponse);
	        
	    } catch (UnirestException e) {
	        _log.error("Error deleting URL Generator", e);
	    } catch (NumberFormatException e) {
	        _log.error("Invalid ID format", e);
	    }
	    super.processAction(actionRequest, actionResponse);
	}
	

//	@ProcessAction(name = "deleteURLGenerator")
//	private void deleteURLGenerator(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
//		System.out.println("Inside Delete URL Method......");
//		try {
//			long id = ParamUtil.getLong(actionRequest, "id");
//			System.out.println("Employee Id : " + id);
//			String deleteResponse = HttpConnectionUtil.deleteUrl("http://localhost:8080", "/o/c/employees/", id);
//
//			actionRequest.setAttribute("deleteResponse", deleteResponse);
//		} catch (UnirestException e) {
//			_log.error("Error deleting URL Generator", e);
//		} catch (NumberFormatException e) {
//			_log.error("Invalid ID format", e);
//		}
//	}
}