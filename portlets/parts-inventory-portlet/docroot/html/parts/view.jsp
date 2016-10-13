<%@ include file="/html/init.jsp"%>


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