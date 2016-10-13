<%@ include file="/html/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>

<aui:button-row cssClass="manufacturer-buttons">
	
		<portlet:renderURL var="addManufacturerURL">
			<portlet:param name="mvcPath"
				value="/html/manufacturer/edit_manufacturer.jsp" />
			<portlet:param name="redirect" value="<%=redirect%>" />
		</portlet:renderURL>
		
		<aui:button name="addPartButton" value="add-manufacturer"
			onClick="<%=addManufacturerURL %>" />	
</aui:button-row>

