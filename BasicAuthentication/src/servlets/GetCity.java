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
import models.City;

@WebServlet("/GetCity")
public class GetCity extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sh = request.getSession();
        String baseURL = getServletContext().getInitParameter("baseURL");

        if (getServletContext().getAttribute("DBM") != null) {
            DBManager dbm = (DBManager) getServletContext().getAttribute("DBM");
            if (!dbm.isConnected()) {
                if (!dbm.openConnection()) {
                    throw new IOException("Could not connect to database and open connection");
                }
            }

            ArrayList<City> allCities = new ArrayList<City>();
            String query = Queries.getCities();
            try {
                ResultSet rs = dbm.ExecuteResultSet(query);
                while (rs.next()) {
                    City c = new City();
                    c.setId(rs.getInt("ID"));
                    c.setName(rs.getString("Name"));
                    c.setCountryCode(rs.getString("CountryCode"));
                    c.setDistrict(rs.getString("District"));
                    c.setPopulation(rs.getInt("Population"));
                    allCities.add(c);
                }
                sh.setAttribute("cityData", allCities);
            } catch (Exception ex) {
                throw new IOException("Query could not be executed for get all cities");
            }
            response.sendRedirect(baseURL + "Protected/listCities.jsp");
        } else {
            response.sendRedirect(baseURL + "/login.jsp");
        }
    }
}
