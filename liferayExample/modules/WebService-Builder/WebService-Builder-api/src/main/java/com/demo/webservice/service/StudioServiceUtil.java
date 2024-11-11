/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.service;

import com.demo.webservice.model.Studio;

import com.liferay.portal.kernel.exception.PortalException;

/**
 * Provides the remote service utility for Studio. This utility wraps
 * <code>com.demo.webservice.service.impl.StudioServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StudioService
 * @generated
 */
public class StudioServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.demo.webservice.service.impl.StudioServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static Studio addStudioDetails(
			String cameraName, String cameraModel, long cameraPrice,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws PortalException {

		return getService().addStudioDetails(
			cameraName, cameraModel, cameraPrice, serviceContext);
	}

	public static Studio deleteStudio(long studioId) throws PortalException {
		return getService().deleteStudio(studioId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static Studio getStudio(long studioId) throws PortalException {
		return getService().getStudio(studioId);
	}

	public static Studio updateStudioDetails(
			long studioId, String cameraName, String cameraModel,
			long cameraPrice)
		throws PortalException {

		return getService().updateStudioDetails(
			studioId, cameraName, cameraModel, cameraPrice);
	}

	public static StudioService getService() {
		return _service;
	}

	public static void setService(StudioService service) {
		_service = service;
	}

	private static volatile StudioService _service;

}