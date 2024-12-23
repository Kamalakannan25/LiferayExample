<%@page import="com.demo.builder.model.Student"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>


<%
List<Student> student = (List<Student>)request.getAttribute("student");
%>


<portlet:renderURL var="addRenderURL">
    <portlet:param name="mvcPath" value="/addStudent.jsp"/>
</portlet:renderURL>
 
 
 <c:if
        test="${permissionChecker.hasPermission(scopeGroupId, portletDisplay.rootPortletId, portletDisplay.resourcePK, ADD_STUDENT)}">

        <aui:a href="<%=addRenderURL.toString()%>" label="Add"
            cssClass="btn btn-light" />
    </c:if>
    
    
    <portlet:renderURL var="jstlRenderURL">
    <portlet:param name="mvcPath" value="/JSTL.jsp"/>
</portlet:renderURL>
 
<div class="mb-5">
    <a href="<%= jstlRenderURL %>" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> JSTL
    </a>
</div>
 
<%-- <div class="mb-5">
    <a href="<%= addRenderURL %>" class="btn  btn-primary btn-default">
        <i class="glyphicon glyphicon-plus"></i> Add
    </a>
</div> --%>

<table id="moduleTable" class="display">
    <thead>
        <tr>
            <th>Student Id</th>
            <th>Name</th>
            <th>Address</th>
            <th>Age</th>
            <th>Joining Date</th>
            <th>Phone No</th>
        </tr>
    </thead>
    <tbody>
    <% 
    for(Student stud : student){ 
    %>
   <tr>
   <td> <%=stud.getStuId() %></td>
   <td> <%=stud.getStuName() %></td>
   <td> <%=stud.getStuAddress() %></td>
   <td> <%=stud.getStuAge() %></td>
   <td> <%=stud.getStuJoinDate() %></td>
   <td> <%=stud.getStuPhoneNo() %></td>
   
   </tr>
   
   <%  } %>
     
    
    
    </tbody>
    </table>


<script>
$(document).ready(function() {
    $('#moduleTable').DataTable();
});
</script>