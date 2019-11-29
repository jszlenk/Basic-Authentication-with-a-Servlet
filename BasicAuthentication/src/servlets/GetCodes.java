package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Queries;
import util.DBManager;

@WebServlet("/GetCodes")
public class GetCodes extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String baseURL = getServletContext().getInitParameter("baseURL");

        if (!request.isUserInRole("Admin")) {
            response.sendRedirect(baseURL + "/login.jsp");
            return;
        }

        HttpSession sh = request.getSession();

        if (getServletContext().getAttribute("DBM") != null) {
            DBManager dbm = (DBManager) getServletContext().getAttribute("DBM");
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    throw new IOException("Could not connect to database and open connection");
                }
            }

            ArrayList<String> allCountryCodes = new ArrayList<String>();
            String query = Queries.getCountryCodes();
            try {
                ResultSet rs = dbm.ExecuteResultSet(query);
                while (rs.next()) {
                    String c = rs.getString("countryCode");
                    allCountryCodes.add(c);
                }
                sh.setAttribute("countryCodes", allCountryCodes);
            } catch (Exception ex) {
                throw new IOException("Query could not be executed for get all codes");
            }
            response.sendRedirect(baseURL + "Protected/addCity.jsp");
        } else {
            response.sendRedirect(baseURL + "/login.jsp");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}