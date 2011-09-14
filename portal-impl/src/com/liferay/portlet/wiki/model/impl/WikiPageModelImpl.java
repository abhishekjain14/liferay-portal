/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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

package com.liferay.portlet.wiki.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;
import com.liferay.portlet.wiki.model.WikiPage;
import com.liferay.portlet.wiki.model.WikiPageModel;
import com.liferay.portlet.wiki.model.WikiPageSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * The base model implementation for the WikiPage service. Represents a row in the &quot;WikiPage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.liferay.portlet.wiki.model.WikiPageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link WikiPageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WikiPageImpl
 * @see com.liferay.portlet.wiki.model.WikiPage
 * @see com.liferay.portlet.wiki.model.WikiPageModel
 * @generated
 */
@JSON(strict = true)
public class WikiPageModelImpl extends BaseModelImpl<WikiPage>
	implements WikiPageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a wiki page model instance should use the {@link com.liferay.portlet.wiki.model.WikiPage} interface instead.
	 */
	public static final String TABLE_NAME = "WikiPage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "pageId", Types.BIGINT },
			{ "resourcePrimKey", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "nodeId", Types.BIGINT },
			{ "title", Types.VARCHAR },
			{ "version", Types.DOUBLE },
			{ "minorEdit", Types.BOOLEAN },
			{ "content", Types.CLOB },
			{ "summary", Types.VARCHAR },
			{ "format", Types.VARCHAR },
			{ "head", Types.BOOLEAN },
			{ "parentTitle", Types.VARCHAR },
			{ "redirectTitle", Types.VARCHAR },
			{ "status", Types.INTEGER },
			{ "statusByUserId", Types.BIGINT },
			{ "statusByUserName", Types.VARCHAR },
			{ "statusDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table WikiPage (uuid_ VARCHAR(75) null,pageId LONG not null primary key,resourcePrimKey LONG,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,nodeId LONG,title VARCHAR(255) null,version DOUBLE,minorEdit BOOLEAN,content TEXT null,summary STRING null,format VARCHAR(75) null,head BOOLEAN,parentTitle VARCHAR(255) null,redirectTitle VARCHAR(255) null,status INTEGER,statusByUserId LONG,statusByUserName VARCHAR(75) null,statusDate DATE null)";
	public static final String TABLE_SQL_DROP = "drop table WikiPage";
	public static final String ORDER_BY_JPQL = " ORDER BY wikiPage.nodeId ASC, wikiPage.title ASC, wikiPage.version DESC";
	public static final String ORDER_BY_SQL = " ORDER BY WikiPage.nodeId ASC, WikiPage.title ASC, WikiPage.version DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.entity.cache.enabled.com.liferay.portlet.wiki.model.WikiPage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.portal.util.PropsUtil.get(
				"value.object.finder.cache.enabled.com.liferay.portlet.wiki.model.WikiPage"),
			true);

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static WikiPage toModel(WikiPageSoap soapModel) {
		WikiPage model = new WikiPageImpl();

		model.setUuid(soapModel.getUuid());
		model.setPageId(soapModel.getPageId());
		model.setResourcePrimKey(soapModel.getResourcePrimKey());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setNodeId(soapModel.getNodeId());
		model.setTitle(soapModel.getTitle());
		model.setVersion(soapModel.getVersion());
		model.setMinorEdit(soapModel.getMinorEdit());
		model.setContent(soapModel.getContent());
		model.setSummary(soapModel.getSummary());
		model.setFormat(soapModel.getFormat());
		model.setHead(soapModel.getHead());
		model.setParentTitle(soapModel.getParentTitle());
		model.setRedirectTitle(soapModel.getRedirectTitle());
		model.setStatus(soapModel.getStatus());
		model.setStatusByUserId(soapModel.getStatusByUserId());
		model.setStatusByUserName(soapModel.getStatusByUserName());
		model.setStatusDate(soapModel.getStatusDate());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<WikiPage> toModels(WikiPageSoap[] soapModels) {
		List<WikiPage> models = new ArrayList<WikiPage>(soapModels.length);

		for (WikiPageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public Class<?> getModelClass() {
		return WikiPage.class;
	}

	public String getModelClassName() {
		return WikiPage.class.getName();
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.portal.util.PropsUtil.get(
				"lock.expiration.time.com.liferay.portlet.wiki.model.WikiPage"));

	public WikiPageModelImpl() {
	}

	public long getPrimaryKey() {
		return _pageId;
	}

	public void setPrimaryKey(long primaryKey) {
		setPageId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_pageId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@JSON
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	public long getPageId() {
		return _pageId;
	}

	public void setPageId(long pageId) {
		_pageId = pageId;
	}

	@JSON
	public long getResourcePrimKey() {
		return _resourcePrimKey;
	}

	public void setResourcePrimKey(long resourcePrimKey) {
		if (!_setOriginalResourcePrimKey) {
			_setOriginalResourcePrimKey = true;

			_originalResourcePrimKey = _resourcePrimKey;
		}

		_resourcePrimKey = resourcePrimKey;
	}

	public boolean isResourceMain() {
		return true;
	}

	public long getOriginalResourcePrimKey() {
		return _originalResourcePrimKey;
	}

	@JSON
	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	public long getNodeId() {
		return _nodeId;
	}

	public void setNodeId(long nodeId) {
		if (!_setOriginalNodeId) {
			_setOriginalNodeId = true;

			_originalNodeId = _nodeId;
		}

		_nodeId = nodeId;
	}

	public long getOriginalNodeId() {
		return _originalNodeId;
	}

	@JSON
	public String getTitle() {
		if (_title == null) {
			return StringPool.BLANK;
		}
		else {
			return _title;
		}
	}

	public void setTitle(String title) {
		if (_originalTitle == null) {
			_originalTitle = _title;
		}

		_title = title;
	}

	public String getOriginalTitle() {
		return GetterUtil.getString(_originalTitle);
	}

	@JSON
	public double getVersion() {
		return _version;
	}

	public void setVersion(double version) {
		if (!_setOriginalVersion) {
			_setOriginalVersion = true;

			_originalVersion = _version;
		}

		_version = version;
	}

	public double getOriginalVersion() {
		return _originalVersion;
	}

	@JSON
	public boolean getMinorEdit() {
		return _minorEdit;
	}

	public boolean isMinorEdit() {
		return _minorEdit;
	}

	public void setMinorEdit(boolean minorEdit) {
		_minorEdit = minorEdit;
	}

	@JSON
	public String getContent() {
		if (_content == null) {
			return StringPool.BLANK;
		}
		else {
			return _content;
		}
	}

	public void setContent(String content) {
		_content = content;
	}

	@JSON
	public String getSummary() {
		if (_summary == null) {
			return StringPool.BLANK;
		}
		else {
			return _summary;
		}
	}

	public void setSummary(String summary) {
		_summary = summary;
	}

	@JSON
	public String getFormat() {
		if (_format == null) {
			return StringPool.BLANK;
		}
		else {
			return _format;
		}
	}

	public void setFormat(String format) {
		_format = format;
	}

	@JSON
	public boolean getHead() {
		return _head;
	}

	public boolean isHead() {
		return _head;
	}

	public void setHead(boolean head) {
		_head = head;
	}

	@JSON
	public String getParentTitle() {
		if (_parentTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _parentTitle;
		}
	}

	public void setParentTitle(String parentTitle) {
		_parentTitle = parentTitle;
	}

	@JSON
	public String getRedirectTitle() {
		if (_redirectTitle == null) {
			return StringPool.BLANK;
		}
		else {
			return _redirectTitle;
		}
	}

	public void setRedirectTitle(String redirectTitle) {
		_redirectTitle = redirectTitle;
	}

	@JSON
	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	@JSON
	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getStatusByUserId(), "uuid",
			_statusByUserUuid);
	}

	public void setStatusByUserUuid(String statusByUserUuid) {
		_statusByUserUuid = statusByUserUuid;
	}

	@JSON
	public String getStatusByUserName() {
		if (_statusByUserName == null) {
			return StringPool.BLANK;
		}
		else {
			return _statusByUserName;
		}
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	@JSON
	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	/**
	 * @deprecated {@link #isApproved}
	 */
	public boolean getApproved() {
		return isApproved();
	}

	public boolean isApproved() {
		if (getStatus() == WorkflowConstants.STATUS_APPROVED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isDraft() {
		if (getStatus() == WorkflowConstants.STATUS_DRAFT) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isExpired() {
		if (getStatus() == WorkflowConstants.STATUS_EXPIRED) {
			return true;
		}
		else {
			return false;
		}
	}

	public boolean isPending() {
		if (getStatus() == WorkflowConstants.STATUS_PENDING) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public WikiPage toEscapedModel() {
		if (isEscapedModel()) {
			return (WikiPage)this;
		}
		else {
			if (_escapedModelProxy == null) {
				_escapedModelProxy = (WikiPage)ProxyUtil.newProxyInstance(_classLoader,
						_escapedModelProxyInterfaces,
						new AutoEscapeBeanHandler(this));
			}

			return _escapedModelProxy;
		}
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		if (_expandoBridge == null) {
			_expandoBridge = ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
					WikiPage.class.getName(), getPrimaryKey());
		}

		return _expandoBridge;
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		getExpandoBridge().setAttributes(serviceContext);
	}

	@Override
	public Object clone() {
		WikiPageImpl wikiPageImpl = new WikiPageImpl();

		wikiPageImpl.setUuid(getUuid());
		wikiPageImpl.setPageId(getPageId());
		wikiPageImpl.setResourcePrimKey(getResourcePrimKey());
		wikiPageImpl.setGroupId(getGroupId());
		wikiPageImpl.setCompanyId(getCompanyId());
		wikiPageImpl.setUserId(getUserId());
		wikiPageImpl.setUserName(getUserName());
		wikiPageImpl.setCreateDate(getCreateDate());
		wikiPageImpl.setModifiedDate(getModifiedDate());
		wikiPageImpl.setNodeId(getNodeId());
		wikiPageImpl.setTitle(getTitle());
		wikiPageImpl.setVersion(getVersion());
		wikiPageImpl.setMinorEdit(getMinorEdit());
		wikiPageImpl.setContent(getContent());
		wikiPageImpl.setSummary(getSummary());
		wikiPageImpl.setFormat(getFormat());
		wikiPageImpl.setHead(getHead());
		wikiPageImpl.setParentTitle(getParentTitle());
		wikiPageImpl.setRedirectTitle(getRedirectTitle());
		wikiPageImpl.setStatus(getStatus());
		wikiPageImpl.setStatusByUserId(getStatusByUserId());
		wikiPageImpl.setStatusByUserName(getStatusByUserName());
		wikiPageImpl.setStatusDate(getStatusDate());

		wikiPageImpl.resetOriginalValues();

		return wikiPageImpl;
	}

	public int compareTo(WikiPage wikiPage) {
		int value = 0;

		if (getNodeId() < wikiPage.getNodeId()) {
			value = -1;
		}
		else if (getNodeId() > wikiPage.getNodeId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = getTitle().toLowerCase()
					.compareTo(wikiPage.getTitle().toLowerCase());

		if (value != 0) {
			return value;
		}

		if (getVersion() < wikiPage.getVersion()) {
			value = -1;
		}
		else if (getVersion() > wikiPage.getVersion()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		WikiPage wikiPage = null;

		try {
			wikiPage = (WikiPage)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = wikiPage.getPrimaryKey();

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
		WikiPageModelImpl wikiPageModelImpl = this;

		wikiPageModelImpl._originalUuid = wikiPageModelImpl._uuid;

		wikiPageModelImpl._originalResourcePrimKey = wikiPageModelImpl._resourcePrimKey;

		wikiPageModelImpl._setOriginalResourcePrimKey = false;

		wikiPageModelImpl._originalGroupId = wikiPageModelImpl._groupId;

		wikiPageModelImpl._setOriginalGroupId = false;

		wikiPageModelImpl._originalNodeId = wikiPageModelImpl._nodeId;

		wikiPageModelImpl._setOriginalNodeId = false;

		wikiPageModelImpl._originalTitle = wikiPageModelImpl._title;

		wikiPageModelImpl._originalVersion = wikiPageModelImpl._version;

		wikiPageModelImpl._setOriginalVersion = false;
	}

	@Override
	public CacheModel<WikiPage> toCacheModel() {
		WikiPageCacheModel wikiPageCacheModel = new WikiPageCacheModel();

		wikiPageCacheModel.uuid = getUuid();

		String uuid = wikiPageCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			wikiPageCacheModel.uuid = null;
		}

		wikiPageCacheModel.pageId = getPageId();

		wikiPageCacheModel.resourcePrimKey = getResourcePrimKey();

		wikiPageCacheModel.groupId = getGroupId();

		wikiPageCacheModel.companyId = getCompanyId();

		wikiPageCacheModel.userId = getUserId();

		wikiPageCacheModel.userName = getUserName();

		String userName = wikiPageCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			wikiPageCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			wikiPageCacheModel.createDate = createDate.getTime();
		}
		else {
			wikiPageCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			wikiPageCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			wikiPageCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		wikiPageCacheModel.nodeId = getNodeId();

		wikiPageCacheModel.title = getTitle();

		String title = wikiPageCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			wikiPageCacheModel.title = null;
		}

		wikiPageCacheModel.version = getVersion();

		wikiPageCacheModel.minorEdit = getMinorEdit();

		wikiPageCacheModel.content = getContent();

		String content = wikiPageCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			wikiPageCacheModel.content = null;
		}

		wikiPageCacheModel.summary = getSummary();

		String summary = wikiPageCacheModel.summary;

		if ((summary != null) && (summary.length() == 0)) {
			wikiPageCacheModel.summary = null;
		}

		wikiPageCacheModel.format = getFormat();

		String format = wikiPageCacheModel.format;

		if ((format != null) && (format.length() == 0)) {
			wikiPageCacheModel.format = null;
		}

		wikiPageCacheModel.head = getHead();

		wikiPageCacheModel.parentTitle = getParentTitle();

		String parentTitle = wikiPageCacheModel.parentTitle;

		if ((parentTitle != null) && (parentTitle.length() == 0)) {
			wikiPageCacheModel.parentTitle = null;
		}

		wikiPageCacheModel.redirectTitle = getRedirectTitle();

		String redirectTitle = wikiPageCacheModel.redirectTitle;

		if ((redirectTitle != null) && (redirectTitle.length() == 0)) {
			wikiPageCacheModel.redirectTitle = null;
		}

		wikiPageCacheModel.status = getStatus();

		wikiPageCacheModel.statusByUserId = getStatusByUserId();

		wikiPageCacheModel.statusByUserName = getStatusByUserName();

		String statusByUserName = wikiPageCacheModel.statusByUserName;

		if ((statusByUserName != null) && (statusByUserName.length() == 0)) {
			wikiPageCacheModel.statusByUserName = null;
		}

		Date statusDate = getStatusDate();

		if (statusDate != null) {
			wikiPageCacheModel.statusDate = statusDate.getTime();
		}
		else {
			wikiPageCacheModel.statusDate = Long.MIN_VALUE;
		}

		return wikiPageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", pageId=");
		sb.append(getPageId());
		sb.append(", resourcePrimKey=");
		sb.append(getResourcePrimKey());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", nodeId=");
		sb.append(getNodeId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append(", minorEdit=");
		sb.append(getMinorEdit());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", summary=");
		sb.append(getSummary());
		sb.append(", format=");
		sb.append(getFormat());
		sb.append(", head=");
		sb.append(getHead());
		sb.append(", parentTitle=");
		sb.append(getParentTitle());
		sb.append(", redirectTitle=");
		sb.append(getRedirectTitle());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", statusByUserId=");
		sb.append(getStatusByUserId());
		sb.append(", statusByUserName=");
		sb.append(getStatusByUserName());
		sb.append(", statusDate=");
		sb.append(getStatusDate());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(73);

		sb.append("<model><model-name>");
		sb.append("com.liferay.portlet.wiki.model.WikiPage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageId</column-name><column-value><![CDATA[");
		sb.append(getPageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>resourcePrimKey</column-name><column-value><![CDATA[");
		sb.append(getResourcePrimKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nodeId</column-name><column-value><![CDATA[");
		sb.append(getNodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>minorEdit</column-name><column-value><![CDATA[");
		sb.append(getMinorEdit());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>summary</column-name><column-value><![CDATA[");
		sb.append(getSummary());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>format</column-name><column-value><![CDATA[");
		sb.append(getFormat());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>head</column-name><column-value><![CDATA[");
		sb.append(getHead());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentTitle</column-name><column-value><![CDATA[");
		sb.append(getParentTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>redirectTitle</column-name><column-value><![CDATA[");
		sb.append(getRedirectTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserId</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusByUserName</column-name><column-value><![CDATA[");
		sb.append(getStatusByUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusDate</column-name><column-value><![CDATA[");
		sb.append(getStatusDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = WikiPage.class.getClassLoader();
	private static Class<?>[] _escapedModelProxyInterfaces = new Class[] {
			WikiPage.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _pageId;
	private long _resourcePrimKey;
	private long _originalResourcePrimKey;
	private boolean _setOriginalResourcePrimKey;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _nodeId;
	private long _originalNodeId;
	private boolean _setOriginalNodeId;
	private String _title;
	private String _originalTitle;
	private double _version;
	private double _originalVersion;
	private boolean _setOriginalVersion;
	private boolean _minorEdit;
	private String _content;
	private String _summary;
	private String _format;
	private boolean _head;
	private String _parentTitle;
	private String _redirectTitle;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserUuid;
	private String _statusByUserName;
	private Date _statusDate;
	private transient ExpandoBridge _expandoBridge;
	private WikiPage _escapedModelProxy;
}