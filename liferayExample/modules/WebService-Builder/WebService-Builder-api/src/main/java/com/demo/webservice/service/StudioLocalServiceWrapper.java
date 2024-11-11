/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.service;

import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * Provides a wrapper for {@link StudioLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StudioLocalService
 * @generated
 */
public class StudioLocalServiceWrapper
	implements ServiceWrapper<StudioLocalService>, StudioLocalService {

	public StudioLocalServiceWrapper() {
		this(null);
	}

	public StudioLocalServiceWrapper(StudioLocalService studioLocalService) {
		_studioLocalService = studioLocalService;
	}

	@Override
	public com.demo.webservice.model.Studio addStudio(
			String cameraName, String cameraModel, long cameraPrice,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioLocalService.addStudio(
			cameraName, cameraModel, cameraPrice, serviceContext);
	}

	/**
	 * Adds the studio to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studio the studio
	 * @return the studio that was added
	 */
	@Override
	public com.demo.webservice.model.Studio addStudio(
		com.demo.webservice.model.Studio studio) {

		return _studioLocalService.addStudio(studio);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new studio with the primary key. Does not add the studio to the database.
	 *
	 * @param studioId the primary key for the new studio
	 * @return the new studio
	 */
	@Override
	public com.demo.webservice.model.Studio createStudio(long studioId) {
		return _studioLocalService.createStudio(studioId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the studio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio that was removed
	 * @throws PortalException if a studio with the primary key could not be found
	 */
	@Override
	public com.demo.webservice.model.Studio deleteStudio(long studioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioLocalService.deleteStudio(studioId);
	}

	/**
	 * Deletes the studio from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studio the studio
	 * @return the studio that was removed
	 */
	@Override
	public com.demo.webservice.model.Studio deleteStudio(
		com.demo.webservice.model.Studio studio) {

		return _studioLocalService.deleteStudio(studio);
	}

	@Override
	public <T> T dslQuery(com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {
		return _studioLocalService.dslQuery(dslQuery);
	}

	@Override
	public int dslQueryCount(
		com.liferay.petra.sql.dsl.query.DSLQuery dslQuery) {

		return _studioLocalService.dslQueryCount(dslQuery);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studioLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _studioLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.webservice.model.impl.StudioModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _studioLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.webservice.model.impl.StudioModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _studioLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _studioLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _studioLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.demo.webservice.model.Studio fetchStudio(long studioId) {
		return _studioLocalService.fetchStudio(studioId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _studioLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _studioLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _studioLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the studio with the primary key.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio
	 * @throws PortalException if a studio with the primary key could not be found
	 */
	@Override
	public com.demo.webservice.model.Studio getStudio(long studioId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioLocalService.getStudio(studioId);
	}

	/**
	 * Returns a range of all the studios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.demo.webservice.model.impl.StudioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of studios
	 * @param end the upper bound of the range of studios (not inclusive)
	 * @return the range of studios
	 */
	@Override
	public java.util.List<com.demo.webservice.model.Studio> getStudios(
		int start, int end) {

		return _studioLocalService.getStudios(start, end);
	}

	/**
	 * Returns the number of studios.
	 *
	 * @return the number of studios
	 */
	@Override
	public int getStudiosCount() {
		return _studioLocalService.getStudiosCount();
	}

	@Override
	public com.demo.webservice.model.Studio updateStudio(
			long studioId, String cameraName, String cameraModel,
			long cameraPrice)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _studioLocalService.updateStudio(
			studioId, cameraName, cameraModel, cameraPrice);
	}

	/**
	 * Updates the studio in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect StudioLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param studio the studio
	 * @return the studio that was updated
	 */
	@Override
	public com.demo.webservice.model.Studio updateStudio(
		com.demo.webservice.model.Studio studio) {

		return _studioLocalService.updateStudio(studio);
	}

	@Override
	public BasePersistence<?> getBasePersistence() {
		return _studioLocalService.getBasePersistence();
	}

	@Override
	public StudioLocalService getWrappedService() {
		return _studioLocalService;
	}

	@Override
	public void setWrappedService(StudioLocalService studioLocalService) {
		_studioLocalService = studioLocalService;
	}

	private StudioLocalService _studioLocalService;

}