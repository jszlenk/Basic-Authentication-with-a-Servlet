<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
</head>
<c:import url="header.jsp" />
<table style="width:100%;">
    <tr>
        <td style="width:25%;height:80%;" valign="top">
            <c:import url="navbar.jsp" />
        </td>
        <td style="width:75%;height:80%;">
            <form id="login" method="post" action="j_security_check">
                <table style="width:450px;">
                    <tr>
                        <td>
                            <span>UserName:</span>
                        </td>
                        <td>
                            <input name="j_username" type="text" style="width:250px;" value="${cookie.credentials_uid.value}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>Password:</span>
                        </td>
                        <td>
                            <input name="j_password" type="password" style="width:250px;" value="${cookie.credentials_pwd.value}"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="right">
                            <input type="submit" value="Sign In"
                                   style="width:250px;" />
                        </td>
                    </tr>
                </table>
                <input type="hidden" name="dest" value="${param.dest}" />
            </form>
        </td>
    </tr>
</table>
<c:import url="footer.jsp">
    <c:param name="copyright" value="${initParam.copyright}" />
    <c:param name="weblink" value="${initParam.weblink}" />
</c:import>
</body>
</html>