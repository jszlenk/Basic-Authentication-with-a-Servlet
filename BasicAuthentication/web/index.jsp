<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Index</title>
</head>
<body>
<c:import url="header.jsp"/>
<table style="width:100%;">
    <tr>
        <td style="width:25%;height:80%;" valign="top">
            <c:import url="navbar.jsp"/>
        </td>
        <td style="width:75%;height:80%;">
            <h1><c:out value="Hello World"/></h1>

            <c:if test="${sessionScope.authorized_user ne null}">
                <h2><c:out value="${sessionScope.authorized_user.userId}"/></h2>
            </c:if>
            <c:if test="${sessionScope.authorized_user eq null}">
                <h2><c:out value="Login"/></h2>
                <a href="login.jsp">here</a>
            </c:if>
        </td>
    </tr>
</table>
<c:import url="footer.jsp">
    <c:param name="copyright" value="${initParam.copyright}"/>
    <c:param name="weblink" value="${initParam.weblink}"/>
</c:import>
</body>
</html>