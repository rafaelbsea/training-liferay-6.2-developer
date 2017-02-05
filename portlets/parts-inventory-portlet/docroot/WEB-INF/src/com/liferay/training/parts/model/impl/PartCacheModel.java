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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.training.parts.model.Part;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Part in entity cache.
 *
 * @author rafael barros
 * @see Part
 * @generated
 */
public class PartCacheModel implements CacheModel<Part>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{partId=");
		sb.append(partId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", manufacturerId=");
		sb.append(manufacturerId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", partNumber=");
		sb.append(partNumber);
		sb.append(", orderDate=");
		sb.append(orderDate);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Part toEntityModel() {
		PartImpl partImpl = new PartImpl();

		partImpl.setPartId(partId);
		partImpl.setCompanyId(companyId);
		partImpl.setGroupId(groupId);
		partImpl.setUserId(userId);
		partImpl.setManufacturerId(manufacturerId);

		if (name == null) {
			partImpl.setName(StringPool.BLANK);
		}
		else {
			partImpl.setName(name);
		}

		if (partNumber == null) {
			partImpl.setPartNumber(StringPool.BLANK);
		}
		else {
			partImpl.setPartNumber(partNumber);
		}

		if (orderDate == Long.MIN_VALUE) {
			partImpl.setOrderDate(null);
		}
		else {
			partImpl.setOrderDate(new Date(orderDate));
		}

		partImpl.setQuantity(quantity);

		partImpl.resetOriginalValues();

		return partImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		partId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		manufacturerId = objectInput.readLong();
		name = objectInput.readUTF();
		partNumber = objectInput.readUTF();
		orderDate = objectInput.readLong();
		quantity = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(partId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(manufacturerId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (partNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(partNumber);
		}

		objectOutput.writeLong(orderDate);
		objectOutput.writeInt(quantity);
	}

	public long partId;
	public long companyId;
	public long groupId;
	public long userId;
	public long manufacturerId;
	public String name;
	public String partNumber;
	public long orderDate;
	public int quantity;
}