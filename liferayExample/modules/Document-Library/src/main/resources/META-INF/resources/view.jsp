<%@page import="com.liferay.portal.kernel.repository.model.Folder"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>

<portlet:renderURL var="EntryRenderURL">
	<portlet:param name="jspPage" value='/form.jsp' />
</portlet:renderURL>

<!-- Page Header -->
<div class="container mt-4">
    <h2 class="text-center mb-4">Folders and Files Management</h2>

    <!-- Search and Filter Section -->
    <div class="row mb-3">
        <div class="col-md-8">
            <input type="text" id="searchInput" class="form-control" placeholder="Search files or folders..." />
        </div>
        <div class="col-md-4">
            <button class="btn btn-primary btn-block" onclick="searchFiles()">Search</button>
            
            <aui:a href="<%=EntryRenderURL.toString()%>" label="Add Employee"
			cssClass="btn btn-light" />
        </div>
    </div>
    
    <!-- Folders and Files Table -->
    <div class="table-responsive">
        <table class="table table-bordered table-hover table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Name</th>
                    <th>Type</th>
                    <th>Actions</th>
                    <th>Preview</th>
                </tr>
            </thead>
            <tbody>
            
            <%
                    
                    long folderId = ParamUtil.getLong(request, "folderId", DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

                   
                    long groupId = themeDisplay.getScopeGroupId();

                   
                    List<FileEntry> fileEntries = DLAppServiceUtil.getFileEntries(
                        groupId, folderId, 0, 10, null); 

                    
                    List<Folder> folders = DLAppServiceUtil.getFolders(
                        groupId, folderId, 0, 10, null); 

                    if ((folders != null && !folders.isEmpty()) || (fileEntries != null && !fileEntries.isEmpty())) {

                        // List subfolders
                        if (folders != null && !folders.isEmpty()) {
                            for (Folder folder : folders) {
                %>
                
                 <tr>
                                    <td><%= folder.getName() %></td>
                                    <td><span class="badge badge-primary">Folder</span></td>
                                    <td>
                                        <a href="?folderId=<%= folder.getFolderId() %>" class="btn btn-info btn-sm">Open</a>
                                    </td>
                                    <td>
                                        <span class="text-muted">N/A</span>
                                    </td>
                                </tr>
                <%
                            }
                        }

                        
                        if (fileEntries != null && !fileEntries.isEmpty()) {
                            for (FileEntry fileEntry : fileEntries) {
                %>
                                <tr>
                                    <td><%= fileEntry.getTitle() %></td>
                                    <td><span class="badge badge-secondary">File</span></td>
                                    <td>
                                        <a href="<%= themeDisplay.getPathContext() %>/documents/<%= themeDisplay.getScopeGroupId() %>/<%= fileEntry.getFolderId() %>/<%= fileEntry.getTitle() %>/<%= fileEntry.getUuid() %>" class="btn btn-success btn-sm" download>
                                            <i class="fas fa-download"></i> Download
                                        </a>
                                    </td>
                                    <td>
                                        <%
                                            if (fileEntry.getMimeType().startsWith("image/")) {
                                        %>
                                            <a href="<%= themeDisplay.getPathContext() %>/documents/<%= themeDisplay.getScopeGroupId() %>/<%= fileEntry.getFolderId() %>/<%= fileEntry.getTitle() %>/<%= fileEntry.getUuid() %>" target="_blank" class="btn btn-warning btn-sm">
                                                <i class="fas fa-eye"></i> Preview
                                            </a>
                                        <%
                                            } else {
                                                out.print("<span class='text-muted'>Not Available</span>");
                                            }
                                        %>
                                    </td>
                                </tr>
                <%
                            }
                        }
                    } else {
                %>
                        <tr>
                            <td colspan="4" class="text-center">No folders or files found.</td>
                        </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</div>
                
                <!-- Add some custom JavaScript for searching -->
<script>
    function searchFiles() {
        const searchQuery = document.getElementById("searchInput").value.toLowerCase();
        const rows = document.querySelectorAll("tbody tr");

        rows.forEach(row => {
            const name = row.cells[0].textContent.toLowerCase();
            if (name.includes(searchQuery)) {
                row.style.display = "";
            } else {
                row.style.display = "none";
            }
        });
    }
</script>

<style>
   button.btn.btn-primary.btn-block {
    width: 85px;
}
a.btn.btn-light {
    margin-left: 90px;
    margin-top: -62px;
}
</style>

<!-- Include Bootstrap and FontAwesome for icons -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
 





