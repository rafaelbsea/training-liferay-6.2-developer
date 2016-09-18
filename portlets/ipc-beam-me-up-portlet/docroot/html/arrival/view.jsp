<%@ include file="/html/init.jsp" %>

<%String beammeup = (String)renderRequest.getParameter("beammeup");%>
<p>And the destination is...</p>
<p>
<% if (beammeup!=null) { %>
		
		<%=beammeup %>!
<% } else { %>
		... waiting for transporting.
<% } %>