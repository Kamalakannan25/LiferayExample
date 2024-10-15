/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.demo.builder.service.impl;

import com.demo.builder.model.Student;
import com.demo.builder.service.StudentLocalServiceUtil;
import com.demo.builder.service.base.StudentLocalServiceBaseImpl;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import java.util.Date;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.demo.builder.model.Student",
	service = AopService.class
)
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	
	public void addStudent(String stuName, String stuAddress, int stuAge, Date stuJoinDate, long stuPhoneNo) {
		
		long stuId = CounterLocalServiceUtil.increment(Student.class.getName());
		Student student = StudentLocalServiceUtil.createStudent(stuId);
		student.setStuId(stuId);
		student.setStuName(stuName);
		student.setStuAddress(stuAddress);
		student.setStuAge(stuAge);
		student.setStuJoinDate(stuJoinDate);
		student.setStuPhoneNo(stuPhoneNo);
		StudentLocalServiceUtil.addStudent(student);
	}
}