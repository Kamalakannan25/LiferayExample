/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.builder.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Student}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Student
 * @generated
 */
public class StudentWrapper
	extends BaseModelWrapper<Student>
	implements ModelWrapper<Student>, Student {

	public StudentWrapper(Student student) {
		super(student);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("stuId", getStuId());
		attributes.put("stuName", getStuName());
		attributes.put("stuAddress", getStuAddress());
		attributes.put("stuAge", getStuAge());
		attributes.put("stuJoinDate", getStuJoinDate());
		attributes.put("stuPhoneNo", getStuPhoneNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long stuId = (Long)attributes.get("stuId");

		if (stuId != null) {
			setStuId(stuId);
		}

		String stuName = (String)attributes.get("stuName");

		if (stuName != null) {
			setStuName(stuName);
		}

		String stuAddress = (String)attributes.get("stuAddress");

		if (stuAddress != null) {
			setStuAddress(stuAddress);
		}

		Integer stuAge = (Integer)attributes.get("stuAge");

		if (stuAge != null) {
			setStuAge(stuAge);
		}

		Date stuJoinDate = (Date)attributes.get("stuJoinDate");

		if (stuJoinDate != null) {
			setStuJoinDate(stuJoinDate);
		}

		Long stuPhoneNo = (Long)attributes.get("stuPhoneNo");

		if (stuPhoneNo != null) {
			setStuPhoneNo(stuPhoneNo);
		}
	}

	@Override
	public Student cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the primary key of this student.
	 *
	 * @return the primary key of this student
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the stu address of this student.
	 *
	 * @return the stu address of this student
	 */
	@Override
	public String getStuAddress() {
		return model.getStuAddress();
	}

	/**
	 * Returns the stu age of this student.
	 *
	 * @return the stu age of this student
	 */
	@Override
	public int getStuAge() {
		return model.getStuAge();
	}

	/**
	 * Returns the stu ID of this student.
	 *
	 * @return the stu ID of this student
	 */
	@Override
	public long getStuId() {
		return model.getStuId();
	}

	/**
	 * Returns the stu join date of this student.
	 *
	 * @return the stu join date of this student
	 */
	@Override
	public Date getStuJoinDate() {
		return model.getStuJoinDate();
	}

	/**
	 * Returns the stu name of this student.
	 *
	 * @return the stu name of this student
	 */
	@Override
	public String getStuName() {
		return model.getStuName();
	}

	/**
	 * Returns the stu phone no of this student.
	 *
	 * @return the stu phone no of this student
	 */
	@Override
	public long getStuPhoneNo() {
		return model.getStuPhoneNo();
	}

	/**
	 * Returns the uuid of this student.
	 *
	 * @return the uuid of this student
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this student.
	 *
	 * @param primaryKey the primary key of this student
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the stu address of this student.
	 *
	 * @param stuAddress the stu address of this student
	 */
	@Override
	public void setStuAddress(String stuAddress) {
		model.setStuAddress(stuAddress);
	}

	/**
	 * Sets the stu age of this student.
	 *
	 * @param stuAge the stu age of this student
	 */
	@Override
	public void setStuAge(int stuAge) {
		model.setStuAge(stuAge);
	}

	/**
	 * Sets the stu ID of this student.
	 *
	 * @param stuId the stu ID of this student
	 */
	@Override
	public void setStuId(long stuId) {
		model.setStuId(stuId);
	}

	/**
	 * Sets the stu join date of this student.
	 *
	 * @param stuJoinDate the stu join date of this student
	 */
	@Override
	public void setStuJoinDate(Date stuJoinDate) {
		model.setStuJoinDate(stuJoinDate);
	}

	/**
	 * Sets the stu name of this student.
	 *
	 * @param stuName the stu name of this student
	 */
	@Override
	public void setStuName(String stuName) {
		model.setStuName(stuName);
	}

	/**
	 * Sets the stu phone no of this student.
	 *
	 * @param stuPhoneNo the stu phone no of this student
	 */
	@Override
	public void setStuPhoneNo(long stuPhoneNo) {
		model.setStuPhoneNo(stuPhoneNo);
	}

	/**
	 * Sets the uuid of this student.
	 *
	 * @param uuid the uuid of this student
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected StudentWrapper wrap(Student student) {
		return new StudentWrapper(student);
	}

}