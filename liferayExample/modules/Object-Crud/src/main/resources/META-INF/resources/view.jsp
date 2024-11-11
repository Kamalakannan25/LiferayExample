<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>



<%
String jsonData = (String) request.getAttribute("EmpData");
JSONObject EmpData = new JSONObject(jsonData);
JSONArray jsonArray = EmpData.getJSONArray("items");

String deleteResponsesssss = (String) request.getAttribute("deleteResponse");

%> 

<portlet:renderURL var="addEmployeeRenderURL">
    <portlet:param name="mvcPath" value="/addEmployee.jsp"/>
</portlet:renderURL>
 
<div class="mb-5">
    <a href="<%= addEmployeeRenderURL %>" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Add Employee
    </a>
</div>

<table id="moduleTable" class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Emp Name</th>
            <th>Emp Address</th>
            <th>Emp Age</th>
            <th>Emp Phone No</th>
            <th>Emp Photo</th>
            <th>Actions</th>
        </tr>
    </thead>
    <tbody>
    <%
    for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject module = jsonArray.getJSONObject(i);
        long id = module.getLong("id");
        String employeeName = module.getString("employeeName");
        String employeeAddress = module.getString("employeeAddress");
        int employeeAge = module.getInt("employeeAge");
        long employeePhoneNo = module.getLong("employeePhoneNo");
        String employeePhoto = module.getJSONObject("employeePhoto").getJSONObject("link").getString("href");
    %>
    <tr>
            <td><%= id %></td>
            <td><%= employeeName %></td>
            <td><%= employeeAddress %></td>
            <td><%= employeeAge %></td>
            <td><%= employeePhoneNo %></td>
            <td><img src="<%= employeePhoto %>" height="50" width="50"></td>
            <td>
                    <portlet:renderURL var="editRenderURL">
                    	<portlet:param name="mvcPath" value="/updateEmployee.jsp"/>
                         <portlet:param name="id" value="<%=String.valueOf(id) %>"/>
                    </portlet:renderURL>
                    <a href="<%= editRenderURL %>" class="btn btn-primary">Edit</a>
                    
                    <portlet:actionURL var="deleteEmployeeActionURL" name="deleteURLGenerator">
    					<portlet:param name="id" value="${id}" />
					</portlet:actionURL>
                	
                	<%-- <button onclick="deleteURLGenerator('${deleteEmployeeActionURL}');">Delete Employee</button> --%>
                	<button onclick="deleteEmployee('${deleteEmployeeActionURL}');">Delete Employee</button>
                <%-- <button type="button" class="btn btn-danger" onclick="deleteURLGenerator('<%= deleteEmployeeActionURL %>')">Delete</button> --%>
                    
                </td>
        </tr>
    
    <% } %>
    </tbody>
    </table>


<script>
$(document).ready(function() {
    $('#moduleTable').DataTable();
});



function deleteEmployee(url) {
    if (confirm("Are you sure you want to delete this employee?")) {
        fetch(url, {
            method: 'POST'
        }).then(response => {
            if (response.ok) {
                alert("Employee deleted successfully!");
                location.reload(); // Refresh the page or handle as needed
            } else {
                alert("Failed to delete employee.");
            }
        }).catch(error => {
            console.error("Error during deletion:", error);
            alert("An error occurred while deleting the employee.");
        });
    }
}
</script>


