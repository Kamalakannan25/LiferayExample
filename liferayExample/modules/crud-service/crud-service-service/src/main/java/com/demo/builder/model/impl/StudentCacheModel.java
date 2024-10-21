/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.builder.model.impl;

import com.demo.builder.model.Student;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Student in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudentCacheModel implements CacheModel<Student>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudentCacheModel)) {
			return false;
		}

		StudentCacheModel studentCacheModel = (StudentCacheModel)object;

		if (stuId == studentCacheModel.stuId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, stuId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", stuId=");
		sb.append(stuId);
		sb.append(", stuName=");
		sb.append(stuName);
		sb.append(", stuAddress=");
		sb.append(stuAddress);
		sb.append(", stuAge=");
		sb.append(stuAge);
		sb.append(", stuJoinDate=");
		sb.append(stuJoinDate);
		sb.append(", stuPhoneNo=");
		sb.append(stuPhoneNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Student toEntityModel() {
		StudentImpl studentImpl = new StudentImpl();

		if (uuid == null) {
			studentImpl.setUuid("");
		}
		else {
			studentImpl.setUuid(uuid);
		}

		studentImpl.setStuId(stuId);

		if (stuName == null) {
			studentImpl.setStuName("");
		}
		else {
			studentImpl.setStuName(stuName);
		}

		if (stuAddress == null) {
			studentImpl.setStuAddress("");
		}
		else {
			studentImpl.setStuAddress(stuAddress);
		}

		studentImpl.setStuAge(stuAge);

		if (stuJoinDate == Long.MIN_VALUE) {
			studentImpl.setStuJoinDate(null);
		}
		else {
			studentImpl.setStuJoinDate(new Date(stuJoinDate));
		}

		studentImpl.setStuPhoneNo(stuPhoneNo);

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		stuId = objectInput.readLong();
		stuName = objectInput.readUTF();
		stuAddress = objectInput.readUTF();

		stuAge = objectInput.readInt();
		stuJoinDate = objectInput.readLong();

		stuPhoneNo = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(stuId);

		if (stuName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stuName);
		}

		if (stuAddress == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(stuAddress);
		}

		objectOutput.writeInt(stuAge);
		objectOutput.writeLong(stuJoinDate);

		objectOutput.writeLong(stuPhoneNo);
	}

	public String uuid;
	public long stuId;
	public String stuName;
	public String stuAddress;
	public int stuAge;
	public long stuJoinDate;
	public long stuPhoneNo;

}