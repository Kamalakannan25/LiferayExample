/**
 * SPDX-FileCopyrightText: (c) 2024 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package com.demo.webservice.model.impl;

import com.demo.webservice.model.Studio;
import com.demo.webservice.model.StudioModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Blob;
import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Studio service. Represents a row in the &quot;Studio_Studio&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StudioModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudioImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StudioImpl
 * @generated
 */
@JSON(strict = true)
public class StudioModelImpl
	extends BaseModelImpl<Studio> implements StudioModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a studio model instance should use the <code>Studio</code> interface instead.
	 */
	public static final String TABLE_NAME = "Studio_Studio";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"studioId", Types.BIGINT},
		{"cameraName", Types.VARCHAR}, {"cameraModel", Types.VARCHAR},
		{"cameraPrice", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("studioId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("cameraName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cameraModel", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("cameraPrice", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Studio_Studio (uuid_ VARCHAR(75) null,studioId LONG not null primary key,cameraName VARCHAR(75) null,cameraModel VARCHAR(75) null,cameraPrice LONG)";

	public static final String TABLE_SQL_DROP = "drop table Studio_Studio";

	public static final String ORDER_BY_JPQL = " ORDER BY studio.studioId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Studio_Studio.studioId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link #getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long UUID_COLUMN_BITMASK = 1L;

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *		#getColumnBitmask(String)}
	 */
	@Deprecated
	public static final long STUDIOID_COLUMN_BITMASK = 2L;

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
	}

	public StudioModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _studioId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStudioId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studioId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Studio.class;
	}

	@Override
	public String getModelClassName() {
		return Studio.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Studio, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Studio, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Studio, Object> attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Studio)this));
		}

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Studio, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Studio, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Studio)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Studio, Object>> getAttributeGetterFunctions() {
		return AttributeGetterFunctionsHolder._attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Studio, Object>>
		getAttributeSetterBiConsumers() {

		return AttributeSetterBiConsumersHolder._attributeSetterBiConsumers;
	}

	private static class AttributeGetterFunctionsHolder {

		private static final Map<String, Function<Studio, Object>>
			_attributeGetterFunctions;

		static {
			Map<String, Function<Studio, Object>> attributeGetterFunctions =
				new LinkedHashMap<String, Function<Studio, Object>>();

			attributeGetterFunctions.put("uuid", Studio::getUuid);
			attributeGetterFunctions.put("studioId", Studio::getStudioId);
			attributeGetterFunctions.put("cameraName", Studio::getCameraName);
			attributeGetterFunctions.put("cameraModel", Studio::getCameraModel);
			attributeGetterFunctions.put("cameraPrice", Studio::getCameraPrice);

			_attributeGetterFunctions = Collections.unmodifiableMap(
				attributeGetterFunctions);
		}

	}

	private static class AttributeSetterBiConsumersHolder {

		private static final Map<String, BiConsumer<Studio, Object>>
			_attributeSetterBiConsumers;

		static {
			Map<String, BiConsumer<Studio, ?>> attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<Studio, ?>>();

			attributeSetterBiConsumers.put(
				"uuid", (BiConsumer<Studio, String>)Studio::setUuid);
			attributeSetterBiConsumers.put(
				"studioId", (BiConsumer<Studio, Long>)Studio::setStudioId);
			attributeSetterBiConsumers.put(
				"cameraName",
				(BiConsumer<Studio, String>)Studio::setCameraName);
			attributeSetterBiConsumers.put(
				"cameraModel",
				(BiConsumer<Studio, String>)Studio::setCameraModel);
			attributeSetterBiConsumers.put(
				"cameraPrice",
				(BiConsumer<Studio, Long>)Studio::setCameraPrice);

			_attributeSetterBiConsumers = Collections.unmodifiableMap(
				(Map)attributeSetterBiConsumers);
		}

	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_uuid = uuid;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), replaced by {@link
	 *             #getColumnOriginalValue(String)}
	 */
	@Deprecated
	public String getOriginalUuid() {
		return getColumnOriginalValue("uuid_");
	}

	@JSON
	@Override
	public long getStudioId() {
		return _studioId;
	}

	@Override
	public void setStudioId(long studioId) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_studioId = studioId;
	}

	@JSON
	@Override
	public String getCameraName() {
		if (_cameraName == null) {
			return "";
		}
		else {
			return _cameraName;
		}
	}

	@Override
	public void setCameraName(String cameraName) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cameraName = cameraName;
	}

	@JSON
	@Override
	public String getCameraModel() {
		if (_cameraModel == null) {
			return "";
		}
		else {
			return _cameraModel;
		}
	}

	@Override
	public void setCameraModel(String cameraModel) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cameraModel = cameraModel;
	}

	@JSON
	@Override
	public long getCameraPrice() {
		return _cameraPrice;
	}

	@Override
	public void setCameraPrice(long cameraPrice) {
		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		_cameraPrice = cameraPrice;
	}

	public long getColumnBitmask() {
		if (_columnBitmask > 0) {
			return _columnBitmask;
		}

		if ((_columnOriginalValues == null) ||
			(_columnOriginalValues == Collections.EMPTY_MAP)) {

			return 0;
		}

		for (Map.Entry<String, Object> entry :
				_columnOriginalValues.entrySet()) {

			if (!Objects.equals(
					entry.getValue(), getColumnValue(entry.getKey()))) {

				_columnBitmask |= _columnBitmasks.get(entry.getKey());
			}
		}

		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Studio.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Studio toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, Studio>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StudioImpl studioImpl = new StudioImpl();

		studioImpl.setUuid(getUuid());
		studioImpl.setStudioId(getStudioId());
		studioImpl.setCameraName(getCameraName());
		studioImpl.setCameraModel(getCameraModel());
		studioImpl.setCameraPrice(getCameraPrice());

		studioImpl.resetOriginalValues();

		return studioImpl;
	}

	@Override
	public Studio cloneWithOriginalValues() {
		StudioImpl studioImpl = new StudioImpl();

		studioImpl.setUuid(this.<String>getColumnOriginalValue("uuid_"));
		studioImpl.setStudioId(this.<Long>getColumnOriginalValue("studioId"));
		studioImpl.setCameraName(
			this.<String>getColumnOriginalValue("cameraName"));
		studioImpl.setCameraModel(
			this.<String>getColumnOriginalValue("cameraModel"));
		studioImpl.setCameraPrice(
			this.<Long>getColumnOriginalValue("cameraPrice"));

		return studioImpl;
	}

	@Override
	public int compareTo(Studio studio) {
		long primaryKey = studio.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Studio)) {
			return false;
		}

		Studio studio = (Studio)object;

		long primaryKey = studio.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isEntityCacheEnabled() {
		return true;
	}

	/**
	 * @deprecated As of Athanasius (7.3.x), with no direct replacement
	 */
	@Deprecated
	@Override
	public boolean isFinderCacheEnabled() {
		return true;
	}

	@Override
	public void resetOriginalValues() {
		_columnOriginalValues = Collections.emptyMap();

		_columnBitmask = 0;
	}

	@Override
	public CacheModel<Studio> toCacheModel() {
		StudioCacheModel studioCacheModel = new StudioCacheModel();

		studioCacheModel.uuid = getUuid();

		String uuid = studioCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			studioCacheModel.uuid = null;
		}

		studioCacheModel.studioId = getStudioId();

		studioCacheModel.cameraName = getCameraName();

		String cameraName = studioCacheModel.cameraName;

		if ((cameraName != null) && (cameraName.length() == 0)) {
			studioCacheModel.cameraName = null;
		}

		studioCacheModel.cameraModel = getCameraModel();

		String cameraModel = studioCacheModel.cameraModel;

		if ((cameraModel != null) && (cameraModel.length() == 0)) {
			studioCacheModel.cameraModel = null;
		}

		studioCacheModel.cameraPrice = getCameraPrice();

		return studioCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Studio, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Studio, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Studio, Object> attributeGetterFunction = entry.getValue();

			sb.append("\"");
			sb.append(attributeName);
			sb.append("\": ");

			Object value = attributeGetterFunction.apply((Studio)this);

			if (value == null) {
				sb.append("null");
			}
			else if (value instanceof Blob || value instanceof Date ||
					 value instanceof Map || value instanceof String) {

				sb.append(
					"\"" + StringUtil.replace(value.toString(), "\"", "'") +
						"\"");
			}
			else {
				sb.append(value);
			}

			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, Studio>
			_escapedModelProxyProviderFunction =
				ProxyUtil.getProxyProviderFunction(
					Studio.class, ModelWrapper.class);

	}

	private String _uuid;
	private long _studioId;
	private String _cameraName;
	private String _cameraModel;
	private long _cameraPrice;

	public <T> T getColumnValue(String columnName) {
		columnName = _attributeNames.getOrDefault(columnName, columnName);

		Function<Studio, Object> function =
			AttributeGetterFunctionsHolder._attributeGetterFunctions.get(
				columnName);

		if (function == null) {
			throw new IllegalArgumentException(
				"No attribute getter function found for " + columnName);
		}

		return (T)function.apply((Studio)this);
	}

	public <T> T getColumnOriginalValue(String columnName) {
		if (_columnOriginalValues == null) {
			return null;
		}

		if (_columnOriginalValues == Collections.EMPTY_MAP) {
			_setColumnOriginalValues();
		}

		return (T)_columnOriginalValues.get(columnName);
	}

	private void _setColumnOriginalValues() {
		_columnOriginalValues = new HashMap<String, Object>();

		_columnOriginalValues.put("uuid_", _uuid);
		_columnOriginalValues.put("studioId", _studioId);
		_columnOriginalValues.put("cameraName", _cameraName);
		_columnOriginalValues.put("cameraModel", _cameraModel);
		_columnOriginalValues.put("cameraPrice", _cameraPrice);
	}

	private static final Map<String, String> _attributeNames;

	static {
		Map<String, String> attributeNames = new HashMap<>();

		attributeNames.put("uuid_", "uuid");

		_attributeNames = Collections.unmodifiableMap(attributeNames);
	}

	private transient Map<String, Object> _columnOriginalValues;

	public static long getColumnBitmask(String columnName) {
		return _columnBitmasks.get(columnName);
	}

	private static final Map<String, Long> _columnBitmasks;

	static {
		Map<String, Long> columnBitmasks = new HashMap<>();

		columnBitmasks.put("uuid_", 1L);

		columnBitmasks.put("studioId", 2L);

		columnBitmasks.put("cameraName", 4L);

		columnBitmasks.put("cameraModel", 8L);

		columnBitmasks.put("cameraPrice", 16L);

		_columnBitmasks = Collections.unmodifiableMap(columnBitmasks);
	}

	private long _columnBitmask;
	private Studio _escapedModel;

}