<%@page import="org.json.JSONObject"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="org.json.JSONArray"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL name="updateEmployee" var="updateEmployeeActionURL" />

  <%
String empId = ParamUtil.getString(request, "id");
 System.out.println("empId........" + empId);
JSONArray updateObject = (JSONArray) request.getAttribute("updateResponse");
System.out.println("Update Data........ : "+ updateObject);

long id = 0;
String empName = "";
String empAddress = "";	

if (updateObject != null) {
	  
 for(int i = 0; i < updateObject.length(); i++){
	JSONObject update = updateObject.getJSONObject(i);
	id = update.getLong("id");
	empName = update.getString("employeeName");
	 /* if (empId != null && empId.equals(String.valueOf(id))) { 
		 empName = update.getString("employeeName");
		 System.out.println("empName......." + empName);
		 empAddress = update.getString("employeeAddress");
		 break;
	}  */
  }  
}else{
	 System.out.println("Update object is null");
 }
%>  

<aui:form action="<%= updateEmployeeActionURL %>" name="UpdateEmployeeForm" method="POST">

    <aui:input name="id" type="text" value="<%= String.valueOf("id") %>" />

    <aui:row>
        <aui:col width="30">
            <aui:input name="employeeName" label="Employee Name" type="text" value="<%=empName %>" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="30">
            <aui:input name="employeeAddress" label="Employee Address" type="text"  />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="30">
            <aui:input name="employeeAge" label="Employee Age" type="text" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="30">
            <aui:input name="employeePhoneNo" label="Employee Phone No" type="text" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="30">
            <aui:input name="employeePhoto" label="Employee Photo" type="file" />
        </aui:col>
    </aui:row>

    <aui:row>
        <aui:col width="10">
            <aui:button type="submit" name="Submit" value="Update"></aui:button>
        </aui:col>
        <aui:col width="10">
            <aui:button type="reset" name="Reset" value="Reset"></aui:button>
        </aui:col>
    </aui:row>
</aui:form>