/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.training.parts.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.training.parts.model.Manufacturer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Manufacturer in entity cache.
 *
 * @author rafael barros
 * @see Manufacturer
 * @generated
 */
public class ManufacturerCacheModel implements CacheModel<Manufacturer>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{manufacturerId=");
		sb.append(manufacturerId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", website=");
		sb.append(website);
		sb.append(", phoneNumber=");
		sb.append(phoneNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Manufacturer toEntityModel() {
		ManufacturerImpl manufacturerImpl = new ManufacturerImpl();

		manufacturerImpl.setManufacturerId(manufacturerId);
		manufacturerImpl.setCompanyId(companyId);
		manufacturerImpl.setGroupId(groupId);
		manufacturerImpl.setUserId(userId);

		if (name == null) {
			manufacturerImpl.setName(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setName(name);
		}

		if (emailAddress == null) {
			manufacturerImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setEmailAddress(emailAddress);
		}

		if (website == null) {
			manufacturerImpl.setWebsite(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setWebsite(website);
		}

		if (phoneNumber == null) {
			manufacturerImpl.setPhoneNumber(StringPool.BLANK);
		}
		else {
			manufacturerImpl.setPhoneNumber(phoneNumber);
		}

		manufacturerImpl.resetOriginalValues();

		return manufacturerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		manufacturerId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		name = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		website = objectInput.readUTF();
		phoneNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(manufacturerId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}

		if (phoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber);
		}
	}

	public long manufacturerId;
	public long companyId;
	public long groupId;
	public long userId;
	public String name;
	public String emailAddress;
	public String website;
	public String phoneNumber;
}