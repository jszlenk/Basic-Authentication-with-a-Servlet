<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cities</title>
</head>
<body>
	<c:import url="../header.jsp" />
	<c:choose>
		<c:when test="${sessionScope.cityData eq null}">
			<jsp:forward page="../GetCity" />
		</c:when>
		<c:otherwise>
			<h1><c:out value="Welcome Back ${sessionScope.authorized_user.userId}" /></h1>
		</c:otherwise>
	</c:choose>
	
	<table style="width:100%;">
		<tr>
			<td style="width:25%;height:80%;" valign="top">
				<c:import url="../navbar.jsp" />
			</td>
			<td style="width:75%;height:80%;">
				<table border=1> 
					<tr>
						<td>ID</td>
						<td>NAME</td>
						<td>COUNTRY_CODE</td>
						<td>DISTRICT</td>
						<td>POPULATION</td>
					</tr>
					<c:forEach var="city" items="${sessionScope.cityData}">
						<tr>
							<td>${city.id}</td>
							<td>${city.name}</td>
							<td>${city.countryCode}</td>
							<td>${city.district}</td>
							<td>${city.population}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
	<c:import url="../footer.jsp">
		<c:param name="copyright" value="${initParam.copyright}" />
		<c:param name="weblink" value="${initParam.weblink}" />
	</c:import>
</body>
</html>