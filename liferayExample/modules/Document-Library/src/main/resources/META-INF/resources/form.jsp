<%@ include file="./init.jsp" %>

<%@ page import="com.liferay.portal.kernel.theme.ThemeDisplay" %>
<%@ page import="com.liferay.portal.kernel.util.WebKeys" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>

<portlet:actionURL var="uploadURL" name="addaction">
    <portlet:param name="paramName" value="paramValue" />
</portlet:actionURL>

<style>
    /* Custom CSS to improve form appearance */
   .form-container {
    max-width: 800px;
    margin: 0 auto;
    padding: 25px;
    background-color: #ffffff;
    border-radius: 15px;
    box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
}
.aui-fieldset {
    background-color: #f7f7f7;
    border: 1px solid #ddd;
    padding: 20px;
    border-radius: 10px;
}
.aui-input {
    margin-bottom: 15px;
    border-radius: 8px;
}
.aui-button {
    background-color: #00bfa5;
    color: white;
    padding: 10px 20px;
    border-radius: 10px;
}
.aui-button:hover {
    background-color: #00897b;
}
</style>

<div class="form-container">
    <aui:form action="${uploadURL}" method="post" enctype="multipart/form-data">
        <aui:fieldset label="Upload Files">
            <!-- Image Upload Input -->
            <aui:input name="imageFiles" type="file" multiple="true" label="Select Images" />
            <!-- Video Upload Input -->
            <aui:input name="videoFiles" type="file" multiple="true" label="Select Videos" />
            <!-- Generic File Upload Input -->
            <aui:input name="otherFiles" type="file" multiple="true" label="Select Other Files" />
            <!-- Folder Name Inputs -->
            <aui:input name="parentFolderName" type="text" label="Parent Folder Name" />
            <aui:input name="subFolderName" type="text" label="Subfolder Name" />
        </aui:fieldset>

        <!-- Submit Button with enhanced design -->
        <aui:button type="submit" value="Upload Files" class="aui-button" />
    </aui:form>
</div>