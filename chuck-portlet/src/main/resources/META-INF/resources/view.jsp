<%@ include file="/init.jsp" %>
<%
    int userCount = GetterUtil.getInteger(renderRequest.getAttribute("USER_COUNT"));
    String fact = GetterUtil.getString(renderRequest.getAttribute("CHUCK_FACT"));
%>
<p>
    <b><liferay-ui:message key="chuck_portlet_ChuckPortlet.caption"/></b>
</p>
<p>The portal has <%= userCount %> users.</p>
<p><%= fact %></p>