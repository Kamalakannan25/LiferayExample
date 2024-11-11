/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.service.impl;

import com.demo.webservice.model.Studio;
import com.demo.webservice.service.base.StudioServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = {
		"json.web.service.context.name=studio",
		"json.web.service.context.path=Studio"
	},
	service = AopService.class
)
public class StudioServiceImpl extends StudioServiceBaseImpl {
	
	public Studio addStudioDetails(String cameraName, String cameraModel, long cameraPrice,
			ServiceContext serviceContext) throws PortalException {
		return studioLocalService.addStudio(cameraName, cameraModel, cameraPrice, serviceContext);
	}

	public Studio updateStudioDetails(long studioId, String cameraName, String cameraModel, long cameraPrice)
			throws PortalException {

		return studioLocalService.updateStudio(studioId, cameraName, cameraModel, cameraPrice);

	}

	 public Studio getStudio(long studioId) throws PortalException{
	        
	        return studioLocalService.getStudio(studioId);
	        
	    }

	 public Studio deleteStudio(long studioId) throws PortalException{
	        
	        return studioLocalService.deleteStudio(studioId);
	    }
}