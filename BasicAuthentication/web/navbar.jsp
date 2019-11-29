<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<ul style="list-style-type:none; padding:0px; margin:0px 0px 0px 0px;">
    <li><a href="${pageContext.request.contextPath}/index.jsp">Home</a></li>
    <li><a href="${pageContext.request.contextPath}/Protected/listCities.jsp">View Cities</a></li>
    <c:if test="${pageContext.request.isUserInRole('Admin')}">
    <li><a href="${pageContext.request.contextPath}/Protected/addCity.jsp">Add a new City</a>
        </c:if>
    <li><a href="${pageContext.request.contextPath}/SignOut">Sign Out</a></li>
    <li><a href="${pageContext.request.contextPath}/ClearSessions">Clear Sessions</a></li>
</ul>
