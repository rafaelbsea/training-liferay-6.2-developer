<%@ include file="/html/init.jsp" %>

<%
	Manufacturer manufacturer = null;
	long manufacturerId = ParamUtil.getLong(request, "manufacturerId");
	if (manufacturerId > 0) {
		manufacturer = ManufacturerLocalServiceUtil.getManufacturer(manufacturerId);
	}
	String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= manufacturer %>" model="<%= Manufacturer.class %>" />
<portlet:renderURL var="viewManufacturerURL" />
<portlet:actionURL name='<%= manufacturer == null ? "addManufacturer" : "updateManufacturer" %>' var="editManufacturerURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewManufacturerURL %>"
	title='<%= (manufacturer != null) ? manufacturer.getName() : "new-manufacturer" %>'
/>

<aui:form action="<%= editManufacturerURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />

		<aui:input type="hidden" name="manufacturerId" value='<%= manufacturer == null ? "" : manufacturer.getManufacturerId() %>'/>
		<aui:input name="name" />
		<aui:input name="emailAddress" />
		<aui:input name="website" />
		<aui:input name="phoneNumber" />
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel"  onClick="<%= viewManufacturerURL %>" />
	</aui:button-row>
</aui:form>