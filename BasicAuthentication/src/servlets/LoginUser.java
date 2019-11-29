package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.User;

@WebServlet("/LoginUser")
public class LoginUser extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uid = request.getParameter("uid");
        String pwd = request.getParameter("pwd");
        int authLevel = 1;

        User wu = new User();
        wu.setUserId(uid);
        wu.setPassword(pwd);
        wu.setAuthLevel(authLevel);

        HttpSession sh = request.getSession();
        sh.setAttribute("authorized_user", wu);

                int cookieLife = 3600 * 24 * 7;
                Cookie uidCook = new Cookie("credentials_uid", uid);
                uidCook.setMaxAge(cookieLife);
                response.addCookie(uidCook);
                Cookie pwdCook = new Cookie("credentials_pwd", pwd);
                uidCook.setMaxAge(cookieLife);
                response.addCookie(pwdCook);



        String target = ((request.getParameter("dest") == null
                || request.getParameter("dest").equals(""))
                ? "index.jsp"
                : request.getParameter("dest") + ".jsp");
        response.sendRedirect(target);
    }
}