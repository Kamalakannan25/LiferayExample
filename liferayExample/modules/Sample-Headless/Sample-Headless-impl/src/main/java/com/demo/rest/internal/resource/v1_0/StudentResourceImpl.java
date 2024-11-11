package com.demo.rest.internal.resource.v1_0;



import com.demo.rest.resource.v1_0.StudentResource;
import com.headless.build.model.Student;
import com.headless.build.service.StudentLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ServiceScope;

/**
 * @author Suchismita
 */
@Component(
	properties = "OSGI-INF/liferay/rest/v1_0/student.properties",
	scope = ServiceScope.PROTOTYPE, service = StudentResource.class
)
public class StudentResourceImpl extends BaseStudentResourceImpl {
	
	
	
	@Override
	public com.demo.rest.dto.v1_0.Student getStudent() throws Exception {

	    List<Student> studentEntity = StudentLocalServiceUtil.getStudents(-1, -1);
	    JSONObject studentObject = JSONFactoryUtil.createJSONObject();
	    JSONArray dataObject = JSONFactoryUtil.createJSONArray();

	    for(Student entry : studentEntity) {
	        JSONObject studentSingleObject = JSONFactoryUtil.createJSONObject();
	        studentSingleObject.put("id", entry.getId());
	        studentSingleObject.put("name", entry.getName());
	        studentSingleObject.put("standard", entry.getStandard());
	        dataObject.put(studentSingleObject);
	    }

	    studentObject.put("data", dataObject);
	    studentObject.put("message", "Student data listing successfully");

	    return (com.demo.rest.dto.v1_0.Student) studentObject; // Return JSONObject
	}
	
//	protected Student _commonResponse(JSONObject studentObject) throws Exception{
//		return new Student() {{
//			data = studentObject.get("data");
//			message = studentObject.get("message");
//		}};
//	}
}