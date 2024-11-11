package com.demo.head.internal.resource.v1_0;

import com.demo.head.resource.v1_0.StudentResource;

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
}