<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>



<%
String jsonData = (String) request.getAttribute("EmpData");
JSONObject EmpData = new JSONObject(jsonData);
JSONArray jsonArray = EmpData.getJSONArray("items");

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
                    
                </td>
        </tr>
    
    <% } %>
    </tbody>
    </table>


<script>
$(document).ready(function() {
    $('#moduleTable').DataTable();
});
</script>


