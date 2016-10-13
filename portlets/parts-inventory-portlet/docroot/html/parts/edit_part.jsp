<%@ include file="/html/init.jsp" %>

<%
Part part = null;
long partId = ParamUtil.getLong(request, "partId");
if (partId > 0) {
	part = PartLocalServiceUtil.getPart(partId);
}
List<Manufacturer> manufacturers = ManufacturerLocalServiceUtil.getManufacturersByGroupId(scopeGroupId);
String redirect = ParamUtil.getString(request, "redirect");
%>

<aui:model-context bean="<%= part %>" model="<%= Part.class %>" />
<portlet:renderURL var="viewPartURL" />
<portlet:actionURL name='<%= part == null ? "addPart" : "updatePart" %>' var="editPartURL" windowState="normal" />

<liferay-ui:header
	backURL="<%= viewPartURL %>"
	title='<%= (part != null) ? part.getName(locale) : "new-part" %>'
/>

<aui:form action="<%= editPartURL %>" method="POST" name="fm">
	<aui:fieldset>
		<aui:input type="hidden" name="redirect" value="<%= redirect %>" />
		<aui:input type="hidden" name="partId" value='<%= part == null ? "" : part.getPartId() %>'/>
		<aui:input name="name" />
		<aui:input name="partNumber" />	
		<aui:input name="orderDate" />
		<aui:input name="quantity"/>
		<aui:select name="manufacturerId" showEmptyOption="<%= true %>" label="Manufacturer">

	 		<%
				for(Manufacturer manufacturer: manufacturers){
			%>
			<aui:option value="<%= manufacturer.getManufacturerId() %>" selected="<%= part != null && manufacturer.getManufacturerId() == part.getManufacturerId() %>"><%=HtmlUtil.escape(manufacturer.getName())%></aui:option>
			<%
				}
			%>

		</aui:select>

		 
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button type="cancel" onClick="<%= viewPartURL %>" />
	</aui:button-row>
</aui:form>