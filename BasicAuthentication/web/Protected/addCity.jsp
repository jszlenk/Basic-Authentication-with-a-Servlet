<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Add City</title>
</head>
<body>
<c:import url="${initParam.baseURL}/header.jsp"/>
<c:choose>
    <c:when test="${sessionScope.countryCodes eq null}">
        <jsp:forward page="../GetCodes"/>
    </c:when>
    <c:otherwise>
        <h1><c:out value="Welcome Back ${sessionScope.authorized_user.userId}"/></h1>
    </c:otherwise>
</c:choose>

<table style="width:100%;">
    <tr>
        <td style="width:25%;height:80%;" valign="top">
            <c:import url="${initParam.baseURL}/navbar.jsp"/>
        </td>
        <td style="width:75%;height:80%;">
            <form action="${initParam.baseURL}/Protected/AddCity" method="post">
                <table border=1>
                    <tr>
                        <td>ID</td>
                        <td>
                            <span>Assigned when added</span>
                        </td>
                    </tr>
                    <tr>
                        <td>NAME</td>
                        <td>
                            <input type="text" name="cityName" style="width:100%;"/>
                        </td>
                    </tr>
                    <tr>
                        <td>COUNTRY_CODE</td>
                        <td>
                            <select name="cityCountryCode" style="width:100%;">
                                <option selected>--- Choose One ---</option>
                                <c:forEach var="cCode" items="${sessionScope.countryCodes}">
                                    <option>${cCode}</option>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>DISTRICT</td>
                        <td><input name="cityDistrict" type="text" style="width:100%;"/>
                    </tr>
                    <tr>
                        <td>POPULATION</td>
                        <td><input name="cityPopulation" type="text" style="width:100%;"/></td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input type="submit" name="addcity" value="Add City" style="width:200px;"/>
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
</table>
<c:import url="${initParam.baseURL}/footer.jsp">
    <c:param name="copyright" value="${initParam.copyright}"/>
    <c:param name="weblink" value="${initParam.weblink}"/>
</c:import>
</body>
</html>