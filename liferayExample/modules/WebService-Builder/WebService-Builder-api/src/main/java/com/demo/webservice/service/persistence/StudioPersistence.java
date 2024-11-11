/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.service.persistence;

import com.demo.webservice.exception.NoSuchStudioException;
import com.demo.webservice.model.Studio;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the studio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudioUtil
 * @generated
 */
@ProviderType
public interface StudioPersistence extends BasePersistence<Studio> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StudioUtil} to access the studio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the studios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching studios
	 */
	public java.util.List<Studio> findByUuid(String uuid);

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
	public java.util.List<Studio> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Studio> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Studio>
			orderByComparator);

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
	public java.util.List<Studio> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Studio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching studio
	 * @throws NoSuchStudioException if a matching studio could not be found
	 */
	public Studio findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Studio>
				orderByComparator)
		throws NoSuchStudioException;

	/**
	 * Returns the first studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching studio, or <code>null</code> if a matching studio could not be found
	 */
	public Studio fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Studio>
			orderByComparator);

	/**
	 * Returns the last studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching studio
	 * @throws NoSuchStudioException if a matching studio could not be found
	 */
	public Studio findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Studio>
				orderByComparator)
		throws NoSuchStudioException;

	/**
	 * Returns the last studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching studio, or <code>null</code> if a matching studio could not be found
	 */
	public Studio fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Studio>
			orderByComparator);

	/**
	 * Returns the studios before and after the current studio in the ordered set where uuid = &#63;.
	 *
	 * @param studioId the primary key of the current studio
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next studio
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	public Studio[] findByUuid_PrevAndNext(
			long studioId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Studio>
				orderByComparator)
		throws NoSuchStudioException;

	/**
	 * Removes all the studios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of studios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching studios
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the studio in the entity cache if it is enabled.
	 *
	 * @param studio the studio
	 */
	public void cacheResult(Studio studio);

	/**
	 * Caches the studios in the entity cache if it is enabled.
	 *
	 * @param studios the studios
	 */
	public void cacheResult(java.util.List<Studio> studios);

	/**
	 * Creates a new studio with the primary key. Does not add the studio to the database.
	 *
	 * @param studioId the primary key for the new studio
	 * @return the new studio
	 */
	public Studio create(long studioId);

	/**
	 * Removes the studio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio that was removed
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	public Studio remove(long studioId) throws NoSuchStudioException;

	public Studio updateImpl(Studio studio);

	/**
	 * Returns the studio with the primary key or throws a <code>NoSuchStudioException</code> if it could not be found.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	public Studio findByPrimaryKey(long studioId) throws NoSuchStudioException;

	/**
	 * Returns the studio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio, or <code>null</code> if a studio with the primary key could not be found
	 */
	public Studio fetchByPrimaryKey(long studioId);

	/**
	 * Returns all the studios.
	 *
	 * @return the studios
	 */
	public java.util.List<Studio> findAll();

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
	public java.util.List<Studio> findAll(int start, int end);

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
	public java.util.List<Studio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Studio>
			orderByComparator);

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
	public java.util.List<Studio> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Studio>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the studios from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of studios.
	 *
	 * @return the number of studios
	 */
	public int countAll();

}