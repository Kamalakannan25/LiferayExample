<%@ include file="/init.jsp" %>
<%@page import="org.json.JSONObject"%>
<%@page import="org.json.JSONArray"%>



<%
String jsonData = (String) request.getAttribute("EmpData");
JSONObject EmpData = new JSONObject(jsonData);
JSONArray jsonArray = EmpData.getJSONArray("items");

%> 


<table id="moduleTable" class="display">
    <thead>
        <tr>
            <th>ID</th>
            <th>Emp Name</th>
            <th>Emp Address</th>
            <th>Emp Age</th>
            <th>Emp Phone No</th>
            <th>Emp Photo</th>
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
        </tr>
    
    <% } %>
    </tbody>
    </table>


<script>
$(document).ready(function() {
    $('#moduleTable').DataTable();
});
</script>


