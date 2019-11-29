<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Clear Session</title>
</head>
<body>
<c:import url="header.jsp"/>
<table style="width:100%;">
    <tr>
        <td style="width:25%;height:80%;" valign="top">
            <c:import url="navbar.jsp"/>
        </td>
        <td style="width:75%;height:80%;">
            <h1>Sessions Cleared</h1>
        </td>
    </tr>
</table>
<c:import url="footer.jsp">
    <c:param name="copyright" value="${initParam.copyright}"/>
    <c:param name="weblink" value="${initParam.weblink}"/>
</c:import>
</body>
</html>