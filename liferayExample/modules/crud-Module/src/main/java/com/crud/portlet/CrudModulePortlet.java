package com.crud.portlet;

import com.crud.constants.CrudModulePortletKeys;
import com.demo.builder.model.Student;
import com.demo.builder.service.StudentLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

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
		"javax.portlet.display-name=CrudModule",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CrudModulePortletKeys.CRUDMODULE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CrudModulePortlet extends MVCPortlet {
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		List<Student> student = StudentLocalServiceUtil.getStudents(-1, -1);
		System.out.println("Student List : "+ student );
		renderRequest.setAttribute("student", student);
		
		super.render(renderRequest, renderResponse);
	}
	
	
	public void addStudent(ActionRequest actionRequest, ActionResponse actionResponse) {
		System.out.println("Inside Add student Method");
		
		String stuName = ParamUtil.getString(actionRequest, "stuName");
		String stuAddress = ParamUtil.getString(actionRequest, "stuAddress");
		int stuAge = ParamUtil.getInteger(actionRequest, "stuAge");
		DateFormat dateFormat = new SimpleDateFormat("mm/dd/yyyy");
		Date stuJoinDate = ParamUtil.getDate(actionRequest, "stuJoinDate", dateFormat); 
		long stuPhoneNo = ParamUtil.getLong(actionRequest, "stuPhoneNo");
		StudentLocalServiceUtil.addStudent(stuName, stuAddress, stuAge, stuJoinDate, stuPhoneNo);
	}
}