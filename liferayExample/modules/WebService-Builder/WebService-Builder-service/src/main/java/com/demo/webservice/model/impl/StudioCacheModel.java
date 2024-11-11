/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.model.impl;

import com.demo.webservice.model.Studio;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Studio in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StudioCacheModel implements CacheModel<Studio>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StudioCacheModel)) {
			return false;
		}

		StudioCacheModel studioCacheModel = (StudioCacheModel)object;

		if (studioId == studioCacheModel.studioId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, studioId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", studioId=");
		sb.append(studioId);
		sb.append(", cameraName=");
		sb.append(cameraName);
		sb.append(", cameraModel=");
		sb.append(cameraModel);
		sb.append(", cameraPrice=");
		sb.append(cameraPrice);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Studio toEntityModel() {
		StudioImpl studioImpl = new StudioImpl();

		if (uuid == null) {
			studioImpl.setUuid("");
		}
		else {
			studioImpl.setUuid(uuid);
		}

		studioImpl.setStudioId(studioId);

		if (cameraName == null) {
			studioImpl.setCameraName("");
		}
		else {
			studioImpl.setCameraName(cameraName);
		}

		if (cameraModel == null) {
			studioImpl.setCameraModel("");
		}
		else {
			studioImpl.setCameraModel(cameraModel);
		}

		studioImpl.setCameraPrice(cameraPrice);

		studioImpl.resetOriginalValues();

		return studioImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		studioId = objectInput.readLong();
		cameraName = objectInput.readUTF();
		cameraModel = objectInput.readUTF();

		cameraPrice = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(studioId);

		if (cameraName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cameraName);
		}

		if (cameraModel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cameraModel);
		}

		objectOutput.writeLong(cameraPrice);
	}

	public String uuid;
	public long studioId;
	public String cameraName;
	public String cameraModel;
	public long cameraPrice;

}