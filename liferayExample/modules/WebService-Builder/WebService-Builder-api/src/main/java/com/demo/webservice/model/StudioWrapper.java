/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Studio}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Studio
 * @generated
 */
public class StudioWrapper
	extends BaseModelWrapper<Studio> implements ModelWrapper<Studio>, Studio {

	public StudioWrapper(Studio studio) {
		super(studio);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("studioId", getStudioId());
		attributes.put("cameraName", getCameraName());
		attributes.put("cameraModel", getCameraModel());
		attributes.put("cameraPrice", getCameraPrice());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long studioId = (Long)attributes.get("studioId");

		if (studioId != null) {
			setStudioId(studioId);
		}

		String cameraName = (String)attributes.get("cameraName");

		if (cameraName != null) {
			setCameraName(cameraName);
		}

		String cameraModel = (String)attributes.get("cameraModel");

		if (cameraModel != null) {
			setCameraModel(cameraModel);
		}

		Long cameraPrice = (Long)attributes.get("cameraPrice");

		if (cameraPrice != null) {
			setCameraPrice(cameraPrice);
		}
	}

	@Override
	public Studio cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the camera model of this studio.
	 *
	 * @return the camera model of this studio
	 */
	@Override
	public String getCameraModel() {
		return model.getCameraModel();
	}

	/**
	 * Returns the camera name of this studio.
	 *
	 * @return the camera name of this studio
	 */
	@Override
	public String getCameraName() {
		return model.getCameraName();
	}

	/**
	 * Returns the camera price of this studio.
	 *
	 * @return the camera price of this studio
	 */
	@Override
	public long getCameraPrice() {
		return model.getCameraPrice();
	}

	/**
	 * Returns the primary key of this studio.
	 *
	 * @return the primary key of this studio
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the studio ID of this studio.
	 *
	 * @return the studio ID of this studio
	 */
	@Override
	public long getStudioId() {
		return model.getStudioId();
	}

	/**
	 * Returns the uuid of this studio.
	 *
	 * @return the uuid of this studio
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
	 * Sets the camera model of this studio.
	 *
	 * @param cameraModel the camera model of this studio
	 */
	@Override
	public void setCameraModel(String cameraModel) {
		model.setCameraModel(cameraModel);
	}

	/**
	 * Sets the camera name of this studio.
	 *
	 * @param cameraName the camera name of this studio
	 */
	@Override
	public void setCameraName(String cameraName) {
		model.setCameraName(cameraName);
	}

	/**
	 * Sets the camera price of this studio.
	 *
	 * @param cameraPrice the camera price of this studio
	 */
	@Override
	public void setCameraPrice(long cameraPrice) {
		model.setCameraPrice(cameraPrice);
	}

	/**
	 * Sets the primary key of this studio.
	 *
	 * @param primaryKey the primary key of this studio
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the studio ID of this studio.
	 *
	 * @param studioId the studio ID of this studio
	 */
	@Override
	public void setStudioId(long studioId) {
		model.setStudioId(studioId);
	}

	/**
	 * Sets the uuid of this studio.
	 *
	 * @param uuid the uuid of this studio
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
	protected StudioWrapper wrap(Studio studio) {
		return new StudioWrapper(studio);
	}

}