<%@page import="org.json.JSONArray"%>
<%@ include file="/init.jsp" %>

<h1>ADD EMPLOYEE PAGE</h1>

<%
JSONArray postObject = (JSONArray) request.getAttribute("responseId");

%>

<portlet:actionURL name="addEmployee" var="addEmployeeActionURL" />

<aui:form action="<%= addEmployeeActionURL %>" name="AddEmployeeForm" method="POST">


<aui:row>
        <aui:col width="30">
            <aui:input name="employeeName" label="Employee Name" type="text" />
        </aui:col>
</aui:row>

<aui:row>
        <aui:col width="30">
            <aui:input name="employeeAddress" label="Employee Address" type="text" />
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
            <aui:button type="submit" name="Submit" value="Submit"></aui:button>
        </aui:col>
        <aui:col width="10">
            <aui:button type="reset" name="Reset" value="Reset"></aui:button>
        </aui:col>
    </aui:row>


</aui:form>