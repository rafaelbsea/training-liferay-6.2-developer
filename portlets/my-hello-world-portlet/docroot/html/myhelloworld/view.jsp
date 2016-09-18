<%@ include file="/html/init.jsp" %>

<%
String name = (String)request.getAttribute("ATTRIBUTE_NAME");
%>
<p>Hello <%= name %>!</p>
