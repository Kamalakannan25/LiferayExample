/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.service.impl;

import com.demo.webservice.model.Studio;
import com.demo.webservice.service.base.StudioLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=com.demo.webservice.model.Studio",
	service = AopService.class
)
public class StudioLocalServiceImpl extends StudioLocalServiceBaseImpl {

	public Studio addStudio(String cameraName, String cameraModel, long cameraPrice, ServiceContext serviceContext)
			throws PortalException {

		long studioId = counterLocalService.increment(Studio.class.getName());

		Studio studio = createStudio(studioId);

		studio.setCameraModel(cameraModel);
		studio.setCameraName(cameraName);
		studio.setCameraPrice(cameraPrice);

		return super.addStudio(studio);

	}

	public Studio updateStudio(long studioId, String cameraName, String cameraModel, long cameraPrice)
			throws PortalException {

		Studio studio = getStudio(studioId);

		studio.setCameraName(cameraName);
		studio.setCameraModel(cameraModel);
		studio.setCameraPrice(cameraPrice);

		return super.updateStudio(studio);

	}
	
	
}