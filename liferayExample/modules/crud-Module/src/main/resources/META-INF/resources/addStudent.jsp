<%@ include file="/init.jsp" %>

<h1>Add Student</h1>

<portlet:actionURL name="addStudent" var="addRenderURL" />

<aui:form action="<%=addRenderURL%>" name="Add Form" method="POST">

<aui:row>
		<aui:col width="30">
			<aui:input name="stuName" label="Student Name" type="text" />
		</aui:col>
</aui:row>

<aui:row>
		<aui:col width="30">
			<aui:input name="stuAddress" label="Student Address" type="text" />
		</aui:col>
</aui:row>

<aui:row>
		<aui:col width="30">
			<aui:input name="stuAge" label="Student Age" type="text" />
		</aui:col>
</aui:row>

<aui:row>
		<aui:col width="30">
			<aui:input name="stuJoinDate" label="Student Joining Date" type="date" />
		</aui:col>
</aui:row>

<aui:row>
		<aui:col width="30">
			<aui:input name="stuPhoneNo" label="Student Phone No" type="text" />
		</aui:col>
</aui:row>

<aui:row>
		<aui:col width="10">
			<aui:button type="submit" name="Submit" value="Submit"></aui:button>
		</aui:col>
		<aui:col width="10">
			<aui:button type="reset" name="Reset" value="reset"></aui:button>
		</aui:col>
</aui:row>


</aui:form>
