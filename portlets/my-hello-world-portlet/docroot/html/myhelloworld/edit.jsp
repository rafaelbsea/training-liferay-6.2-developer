<%@ include file="/html/init.jsp"%>

<form action="<portlet:actionURL />" method="post"
	name="<portlet:namespace/>fm">
	<label for="<portlet:namespace />name">Name:</label> <input
		name="<portlet:namespace />name" type="text" /> <br />
	<br /> <input type="submit" value="Add Name" />
</form>
