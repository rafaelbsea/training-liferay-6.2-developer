<%@ include file="/html/init.jsp"%>

<liferay-ui:success key="part-added" message="part-added-successfully" />
<liferay-ui:success key="part-deleted" message="part-deleted-successfully" />
<liferay-ui:success key="part-updated" message="part-updated-successfully" />


<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row>

	<portlet:renderURL var="addPartURL">
		<portlet:param name="mvcPath" value="/html/parts/edit_part.jsp" />
		<portlet:param name="redirect" value="<%=redirect%>" />
	</portlet:renderURL>

	<aui:button name="addPartButton" value="add-part"
		onClick="<%=addPartURL %>" />

</aui:button-row>

<liferay-ui:search-container
	emptyResultsMessage="part-empty-results-message">
	<liferay-ui:search-container-results
		results="<%= PartLocalServiceUtil.getPartsByGroupId(scopeGroupId, searchContainer.getStart(), searchContainer.getEnd()) %>"
		total="<%= PartLocalServiceUtil.getPartsCountByGroupId(scopeGroupId) %>" />

	<liferay-ui:search-container-row
		className="com.liferay.training.parts.model.Part" keyProperty="partId"
		modelVar="part" escapedModel="<%= true %>">
		<liferay-ui:search-container-column-text name="name"
			value="<%= part.getName(locale) %>" />

		<liferay-ui:search-container-column-text name="part-number"
			property="partNumber" />

		<liferay-ui:search-container-column-text name="quantity"
			property="quantity" />

		<liferay-ui:search-container-column-text name="order-date"
			value="<%= new SimpleDateFormat(\"MMMM dd, yyyy\").format(part.getOrderDate()) %>" />

		<%
			String manufacturerName = "";

					try {
						manufacturerName = HtmlUtil.escape(ManufacturerLocalServiceUtil
								.getManufacturer(part.getManufacturerId())
								.getName());
					} catch (Exception ex) {
					}
		%>

		<liferay-ui:search-container-column-text name="manufacturer"
			value="<%= manufacturerName %>" />

		<liferay-ui:search-container-column-jsp align="right"
			path="/html/parts/part_actions.jsp" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
