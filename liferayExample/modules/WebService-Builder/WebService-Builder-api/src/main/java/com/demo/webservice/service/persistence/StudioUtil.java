/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.service.persistence;

import com.demo.webservice.model.Studio;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the studio service. This utility wraps <code>com.demo.webservice.service.persistence.impl.StudioPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudioPersistence
 * @generated
 */
public class StudioUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Studio studio) {
		getPersistence().clearCache(studio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Studio> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Studio> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Studio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Studio> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Studio> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Studio update(Studio studio) {
		return getPersistence().update(studio);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Studio update(Studio studio, ServiceContext serviceContext) {
		return getPersistence().update(studio, serviceContext);
	}

	/**
	 * Returns all the studios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching studios
	 */
	public static List<Studio> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the studios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of studios
	 * @param end the upper bound of the range of studios (not inclusive)
	 * @return the range of matching studios
	 */
	public static List<Studio> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the studios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of studios
	 * @param end the upper bound of the range of studios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching studios
	 */
	public static List<Studio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Studio> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the studios where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudioModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of studios
	 * @param end the upper bound of the range of studios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching studios
	 */
	public static List<Studio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Studio> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching studio
	 * @throws NoSuchStudioException if a matching studio could not be found
	 */
	public static Studio findByUuid_First(
			String uuid, OrderByComparator<Studio> orderByComparator)
		throws com.demo.webservice.exception.NoSuchStudioException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching studio, or <code>null</code> if a matching studio could not be found
	 */
	public static Studio fetchByUuid_First(
		String uuid, OrderByComparator<Studio> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching studio
	 * @throws NoSuchStudioException if a matching studio could not be found
	 */
	public static Studio findByUuid_Last(
			String uuid, OrderByComparator<Studio> orderByComparator)
		throws com.demo.webservice.exception.NoSuchStudioException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching studio, or <code>null</code> if a matching studio could not be found
	 */
	public static Studio fetchByUuid_Last(
		String uuid, OrderByComparator<Studio> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the studios before and after the current studio in the ordered set where uuid = &#63;.
	 *
	 * @param studioId the primary key of the current studio
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next studio
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	public static Studio[] findByUuid_PrevAndNext(
			long studioId, String uuid,
			OrderByComparator<Studio> orderByComparator)
		throws com.demo.webservice.exception.NoSuchStudioException {

		return getPersistence().findByUuid_PrevAndNext(
			studioId, uuid, orderByComparator);
	}

	/**
	 * Removes all the studios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of studios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching studios
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the studio in the entity cache if it is enabled.
	 *
	 * @param studio the studio
	 */
	public static void cacheResult(Studio studio) {
		getPersistence().cacheResult(studio);
	}

	/**
	 * Caches the studios in the entity cache if it is enabled.
	 *
	 * @param studios the studios
	 */
	public static void cacheResult(List<Studio> studios) {
		getPersistence().cacheResult(studios);
	}

	/**
	 * Creates a new studio with the primary key. Does not add the studio to the database.
	 *
	 * @param studioId the primary key for the new studio
	 * @return the new studio
	 */
	public static Studio create(long studioId) {
		return getPersistence().create(studioId);
	}

	/**
	 * Removes the studio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio that was removed
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	public static Studio remove(long studioId)
		throws com.demo.webservice.exception.NoSuchStudioException {

		return getPersistence().remove(studioId);
	}

	public static Studio updateImpl(Studio studio) {
		return getPersistence().updateImpl(studio);
	}

	/**
	 * Returns the studio with the primary key or throws a <code>NoSuchStudioException</code> if it could not be found.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	public static Studio findByPrimaryKey(long studioId)
		throws com.demo.webservice.exception.NoSuchStudioException {

		return getPersistence().findByPrimaryKey(studioId);
	}

	/**
	 * Returns the studio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio, or <code>null</code> if a studio with the primary key could not be found
	 */
	public static Studio fetchByPrimaryKey(long studioId) {
		return getPersistence().fetchByPrimaryKey(studioId);
	}

	/**
	 * Returns all the studios.
	 *
	 * @return the studios
	 */
	public static List<Studio> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the studios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of studios
	 * @param end the upper bound of the range of studios (not inclusive)
	 * @return the range of studios
	 */
	public static List<Studio> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the studios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of studios
	 * @param end the upper bound of the range of studios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of studios
	 */
	public static List<Studio> findAll(
		int start, int end, OrderByComparator<Studio> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the studios.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StudioModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of studios
	 * @param end the upper bound of the range of studios (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of studios
	 */
	public static List<Studio> findAll(
		int start, int end, OrderByComparator<Studio> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the studios from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of studios.
	 *
	 * @return the number of studios
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static StudioPersistence getPersistence() {
		return _persistence;
	}

	public static void setPersistence(StudioPersistence persistence) {
		_persistence = persistence;
	}

	private static volatile StudioPersistence _persistence;

}