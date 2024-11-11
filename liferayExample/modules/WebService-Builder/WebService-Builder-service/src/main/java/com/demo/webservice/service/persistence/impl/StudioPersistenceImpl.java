/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.service.persistence.impl;

import com.demo.webservice.exception.NoSuchStudioException;
import com.demo.webservice.model.Studio;
import com.demo.webservice.model.StudioTable;
import com.demo.webservice.model.impl.StudioImpl;
import com.demo.webservice.model.impl.StudioModelImpl;
import com.demo.webservice.service.persistence.StudioPersistence;
import com.demo.webservice.service.persistence.StudioUtil;
import com.demo.webservice.service.persistence.impl.constants.StudioPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the studio service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = StudioPersistence.class)
public class StudioPersistenceImpl
	extends BasePersistenceImpl<Studio> implements StudioPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>StudioUtil</code> to access the studio persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		StudioImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the studios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching studios
	 */
	@Override
	public List<Studio> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Studio> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Studio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Studio> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Studio> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Studio> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Studio> list = null;

		if (useFinderCache) {
			list = (List<Studio>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Studio studio : list) {
					if (!uuid.equals(studio.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_STUDIO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(StudioModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Studio>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching studio
	 * @throws NoSuchStudioException if a matching studio could not be found
	 */
	@Override
	public Studio findByUuid_First(
			String uuid, OrderByComparator<Studio> orderByComparator)
		throws NoSuchStudioException {

		Studio studio = fetchByUuid_First(uuid, orderByComparator);

		if (studio != null) {
			return studio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStudioException(sb.toString());
	}

	/**
	 * Returns the first studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching studio, or <code>null</code> if a matching studio could not be found
	 */
	@Override
	public Studio fetchByUuid_First(
		String uuid, OrderByComparator<Studio> orderByComparator) {

		List<Studio> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching studio
	 * @throws NoSuchStudioException if a matching studio could not be found
	 */
	@Override
	public Studio findByUuid_Last(
			String uuid, OrderByComparator<Studio> orderByComparator)
		throws NoSuchStudioException {

		Studio studio = fetchByUuid_Last(uuid, orderByComparator);

		if (studio != null) {
			return studio;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchStudioException(sb.toString());
	}

	/**
	 * Returns the last studio in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching studio, or <code>null</code> if a matching studio could not be found
	 */
	@Override
	public Studio fetchByUuid_Last(
		String uuid, OrderByComparator<Studio> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Studio> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Studio[] findByUuid_PrevAndNext(
			long studioId, String uuid,
			OrderByComparator<Studio> orderByComparator)
		throws NoSuchStudioException {

		uuid = Objects.toString(uuid, "");

		Studio studio = findByPrimaryKey(studioId);

		Session session = null;

		try {
			session = openSession();

			Studio[] array = new StudioImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, studio, uuid, orderByComparator, true);

			array[1] = studio;

			array[2] = getByUuid_PrevAndNext(
				session, studio, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Studio getByUuid_PrevAndNext(
		Session session, Studio studio, String uuid,
		OrderByComparator<Studio> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_STUDIO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(StudioModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(studio)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Studio> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the studios where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Studio studio :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(studio);
		}
	}

	/**
	 * Returns the number of studios where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching studios
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_STUDIO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "studio.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(studio.uuid IS NULL OR studio.uuid = '')";

	public StudioPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Studio.class);

		setModelImplClass(StudioImpl.class);
		setModelPKClass(long.class);

		setTable(StudioTable.INSTANCE);
	}

	/**
	 * Caches the studio in the entity cache if it is enabled.
	 *
	 * @param studio the studio
	 */
	@Override
	public void cacheResult(Studio studio) {
		entityCache.putResult(StudioImpl.class, studio.getPrimaryKey(), studio);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the studios in the entity cache if it is enabled.
	 *
	 * @param studios the studios
	 */
	@Override
	public void cacheResult(List<Studio> studios) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (studios.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Studio studio : studios) {
			if (entityCache.getResult(
					StudioImpl.class, studio.getPrimaryKey()) == null) {

				cacheResult(studio);
			}
		}
	}

	/**
	 * Clears the cache for all studios.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(StudioImpl.class);

		finderCache.clearCache(StudioImpl.class);
	}

	/**
	 * Clears the cache for the studio.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Studio studio) {
		entityCache.removeResult(StudioImpl.class, studio);
	}

	@Override
	public void clearCache(List<Studio> studios) {
		for (Studio studio : studios) {
			entityCache.removeResult(StudioImpl.class, studio);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(StudioImpl.class);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(StudioImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new studio with the primary key. Does not add the studio to the database.
	 *
	 * @param studioId the primary key for the new studio
	 * @return the new studio
	 */
	@Override
	public Studio create(long studioId) {
		Studio studio = new StudioImpl();

		studio.setNew(true);
		studio.setPrimaryKey(studioId);

		String uuid = PortalUUIDUtil.generate();

		studio.setUuid(uuid);

		return studio;
	}

	/**
	 * Removes the studio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio that was removed
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	@Override
	public Studio remove(long studioId) throws NoSuchStudioException {
		return remove((Serializable)studioId);
	}

	/**
	 * Removes the studio with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the studio
	 * @return the studio that was removed
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	@Override
	public Studio remove(Serializable primaryKey) throws NoSuchStudioException {
		Session session = null;

		try {
			session = openSession();

			Studio studio = (Studio)session.get(StudioImpl.class, primaryKey);

			if (studio == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudioException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(studio);
		}
		catch (NoSuchStudioException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Studio removeImpl(Studio studio) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(studio)) {
				studio = (Studio)session.get(
					StudioImpl.class, studio.getPrimaryKeyObj());
			}

			if (studio != null) {
				session.delete(studio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (studio != null) {
			clearCache(studio);
		}

		return studio;
	}

	@Override
	public Studio updateImpl(Studio studio) {
		boolean isNew = studio.isNew();

		if (!(studio instanceof StudioModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(studio.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(studio);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in studio proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Studio implementation " +
					studio.getClass());
		}

		StudioModelImpl studioModelImpl = (StudioModelImpl)studio;

		if (Validator.isNull(studio.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			studio.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(studio);
			}
			else {
				studio = (Studio)session.merge(studio);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(StudioImpl.class, studioModelImpl, false, true);

		if (isNew) {
			studio.setNew(false);
		}

		studio.resetOriginalValues();

		return studio;
	}

	/**
	 * Returns the studio with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the studio
	 * @return the studio
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	@Override
	public Studio findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudioException {

		Studio studio = fetchByPrimaryKey(primaryKey);

		if (studio == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudioException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return studio;
	}

	/**
	 * Returns the studio with the primary key or throws a <code>NoSuchStudioException</code> if it could not be found.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio
	 * @throws NoSuchStudioException if a studio with the primary key could not be found
	 */
	@Override
	public Studio findByPrimaryKey(long studioId) throws NoSuchStudioException {
		return findByPrimaryKey((Serializable)studioId);
	}

	/**
	 * Returns the studio with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studioId the primary key of the studio
	 * @return the studio, or <code>null</code> if a studio with the primary key could not be found
	 */
	@Override
	public Studio fetchByPrimaryKey(long studioId) {
		return fetchByPrimaryKey((Serializable)studioId);
	}

	/**
	 * Returns all the studios.
	 *
	 * @return the studios
	 */
	@Override
	public List<Studio> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Studio> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Studio> findAll(
		int start, int end, OrderByComparator<Studio> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Studio> findAll(
		int start, int end, OrderByComparator<Studio> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Studio> list = null;

		if (useFinderCache) {
			list = (List<Studio>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_STUDIO);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_STUDIO;

				sql = sql.concat(StudioModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Studio>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the studios from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Studio studio : findAll()) {
			remove(studio);
		}
	}

	/**
	 * Returns the number of studios.
	 *
	 * @return the number of studios
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_STUDIO);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "studioId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_STUDIO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return StudioModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the studio persistence.
	 */
	@Activate
	public void activate() {
		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"uuid_"}, true);

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			true);

		_finderPathCountByUuid = new FinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()}, new String[] {"uuid_"},
			false);

		StudioUtil.setPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		StudioUtil.setPersistence(null);

		entityCache.removeCache(StudioImpl.class.getName());
	}

	@Override
	@Reference(
		target = StudioPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = StudioPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = StudioPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_STUDIO =
		"SELECT studio FROM Studio studio";

	private static final String _SQL_SELECT_STUDIO_WHERE =
		"SELECT studio FROM Studio studio WHERE ";

	private static final String _SQL_COUNT_STUDIO =
		"SELECT COUNT(studio) FROM Studio studio";

	private static final String _SQL_COUNT_STUDIO_WHERE =
		"SELECT COUNT(studio) FROM Studio studio WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "studio.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Studio exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Studio exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		StudioPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	@Override
	protected FinderCache getFinderCache() {
		return finderCache;
	}

}