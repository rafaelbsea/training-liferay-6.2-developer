/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.training.parts.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.liferay.training.parts.model.Manufacturer;
import com.liferay.training.parts.model.ManufacturerModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Manufacturer service. Represents a row in the &quot;Inventory_Manufacturer&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.training.parts.model.ManufacturerModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ManufacturerImpl}.
 * </p>
 *
 * @author rafael barros
 * @see ManufacturerImpl
 * @see com.liferay.training.parts.model.Manufacturer
 * @see com.liferay.training.parts.model.ManufacturerModel
 * @generated
 */
public class ManufacturerModelImpl extends BaseModelImpl<Manufacturer>
	implements ManufacturerModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a manufacturer model instance should use the {@link com.liferay.training.parts.model.Manufacturer} interface instead.
	 */
	public static final String TABLE_NAME = "Inventory_Manufacturer";
	public static final Object[][] TABLE_COLUMNS = {
			{ "manufacturerId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "name", Types.VARCHAR },
			{ "emailAddress", Types.VARCHAR },
			{ "website", Types.VARCHAR },
			{ "phoneNumber", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table Inventory_Manufacturer (manufacturerId LONG not null primary key,companyId LONG,groupId LONG,userId LONG,name VARCHAR(75) null,emailAddress VARCHAR(75) null,website VARCHAR(75) null,phoneNumber VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table Inventory_Manufacturer";
	public static final String ORDER_BY_JPQL = " ORDER BY manufacturer.name ASC";
	public static final String ORDER_BY_SQL = " ORDER BY Inventory_Manufacturer.name ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.liferay.training.parts.model.Manufacturer"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.liferay.training.parts.model.Manufacturer"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.liferay.training.parts.model.Manufacturer"),
			true);
	public static long GROUPID_COLUMN_BITMASK = 1L;
	public static long NAME_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.liferay.training.parts.model.Manufacturer"));

	public ManufacturerModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _manufacturerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setManufacturerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _manufacturerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Manufacturer.class;
	}

	@Override
	public String getModelClassName() {
		return Manufacturer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("manufacturerId", getManufacturerId());
		attributes.put("companyId", getCompanyId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("name", getName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("website", getWebsite());
		attributes.put("phoneNumber", getPhoneNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long manufacturerId = (Long)attributes.get("manufacturerId");

		if (manufacturerId != null) {
			setManufacturerId(manufacturerId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String phoneNumber = (String)attributes.get("phoneNumber");

		if (phoneNumber != null) {
			setPhoneNumber(phoneNumber);
		}
	}

	@Override
	public long getManufacturerId() {
		return _manufacturerId;
	}

	@Override
	public void setManufacturerId(long manufacturerId) {
		_manufacturerId = manufacturerId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@Override
	public String getWebsite() {
		if (_website == null) {
			return StringPool.BLANK;
		}
		else {
			return _website;
		}
	}

	@Override
	public void setWebsite(String website) {
		_website = website;
	}

	@Override
	public String getPhoneNumber() {
		if (_phoneNumber == null) {
			return StringPool.BLANK;
		}
		else {
			return _phoneNumber;
		}
	}

	@Override
	public void setPhoneNumber(String phoneNumber) {
		_phoneNumber = phoneNumber;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Manufacturer.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Manufacturer toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Manufacturer)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ManufacturerImpl manufacturerImpl = new ManufacturerImpl();

		manufacturerImpl.setManufacturerId(getManufacturerId());
		manufacturerImpl.setCompanyId(getCompanyId());
		manufacturerImpl.setGroupId(getGroupId());
		manufacturerImpl.setUserId(getUserId());
		manufacturerImpl.setName(getName());
		manufacturerImpl.setEmailAddress(getEmailAddress());
		manufacturerImpl.setWebsite(getWebsite());
		manufacturerImpl.setPhoneNumber(getPhoneNumber());

		manufacturerImpl.resetOriginalValues();

		return manufacturerImpl;
	}

	@Override
	public int compareTo(Manufacturer manufacturer) {
		int value = 0;

		value = getName().compareTo(manufacturer.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Manufacturer)) {
			return false;
		}

		Manufacturer manufacturer = (Manufacturer)obj;

		long primaryKey = manufacturer.getPrimaryKey();

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

	@Override
	public void resetOriginalValues() {
		ManufacturerModelImpl manufacturerModelImpl = this;

		manufacturerModelImpl._originalGroupId = manufacturerModelImpl._groupId;

		manufacturerModelImpl._setOriginalGroupId = false;

		manufacturerModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Manufacturer> toCacheModel() {
		ManufacturerCacheModel manufacturerCacheModel = new ManufacturerCacheModel();

		manufacturerCacheModel.manufacturerId = getManufacturerId();

		manufacturerCacheModel.companyId = getCompanyId();

		manufacturerCacheModel.groupId = getGroupId();

		manufacturerCacheModel.userId = getUserId();

		manufacturerCacheModel.name = getName();

		String name = manufacturerCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			manufacturerCacheModel.name = null;
		}

		manufacturerCacheModel.emailAddress = getEmailAddress();

		String emailAddress = manufacturerCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			manufacturerCacheModel.emailAddress = null;
		}

		manufacturerCacheModel.website = getWebsite();

		String website = manufacturerCacheModel.website;

		if ((website != null) && (website.length() == 0)) {
			manufacturerCacheModel.website = null;
		}

		manufacturerCacheModel.phoneNumber = getPhoneNumber();

		String phoneNumber = manufacturerCacheModel.phoneNumber;

		if ((phoneNumber != null) && (phoneNumber.length() == 0)) {
			manufacturerCacheModel.phoneNumber = null;
		}

		return manufacturerCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{manufacturerId=");
		sb.append(getManufacturerId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", phoneNumber=");
		sb.append(getPhoneNumber());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.liferay.training.parts.model.Manufacturer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>manufacturerId</column-name><column-value><![CDATA[");
		sb.append(getManufacturerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Manufacturer.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Manufacturer.class
		};
	private long _manufacturerId;
	private long _companyId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _userId;
	private String _userUuid;
	private String _name;
	private String _emailAddress;
	private String _website;
	private String _phoneNumber;
	private long _columnBitmask;
	private Manufacturer _escapedModel;
}