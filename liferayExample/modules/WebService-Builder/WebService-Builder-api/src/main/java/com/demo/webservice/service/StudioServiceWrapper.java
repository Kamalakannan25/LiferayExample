/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StudioService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudioService
 * @generated
 */
public class StudioServiceWrapper
	implements ServiceWrapper<StudioService>, StudioService {

	public StudioServiceWrapper() {
		this(null);
	}

	public StudioServiceWrapper(StudioService studioService) {
		_studioService = studioService;
	}

	@Override
	public com.demo.webservice.model.Studio addStudioDetails(
			String cameraName, String cameraModel, long cameraPrice,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioService.addStudioDetails(
			cameraName, cameraModel, cameraPrice, serviceContext);
	}

	@Override
	public com.demo.webservice.model.Studio deleteStudio(long studioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioService.deleteStudio(studioId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studioService.getOSGiServiceIdentifier();
	}

	@Override
	public com.demo.webservice.model.Studio getStudio(long studioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioService.getStudio(studioId);
	}

	@Override
	public com.demo.webservice.model.Studio updateStudioDetails(
			long studioId, String cameraName, String cameraModel,
			long cameraPrice)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioService.updateStudioDetails(
			studioId, cameraName, cameraModel, cameraPrice);
	}

	@Override
	public StudioService getWrappedService() {
		return _studioService;
	}

	@Override
	public void setWrappedService(StudioService studioService) {
		_studioService = studioService;
	}

	private StudioService _studioService;

}