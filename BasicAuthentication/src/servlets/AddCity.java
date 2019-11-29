package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.Queries;
import util.DBManager;
import models.City;

@WebServlet("/Protected/AddCity")
public class AddCity extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("cityName");
        String countryCode = request.getParameter("cityCountryCode");
        String district = request.getParameter("cityDistrict");
        String population = request.getParameter("cityPopulation");
        String baseURL = getServletContext().getInitParameter("baseURL");

        if (name == null || name.equals("")
                || countryCode == null || countryCode.equals("")
                || district == null || district.equals("")
                || population == null || population.equals("")) {
            response.sendRedirect(baseURL + "/Protected/addCity.jsp");
        }

        try {
            City c = new City();
            c.setCountryCode(countryCode);
            c.setDistrict(district);
            c.setPopulation(Integer.parseInt(population));
            c.setName(name);
            c.setId(-1);

            if (getServletContext().getAttribute("DBM") != null) {
                DBManager dbm = (DBManager) getServletContext().getAttribute("DBM");
                if (!dbm.isConnected()) {
                    if (!dbm.openConnection()) {
                        throw new IOException("Could not connect to database and open connection");
                    }
                }

                String query = Queries.insertCity(c);

                try {
                    dbm.ExecuteNonQuery(query);
                } catch (Exception ex) {
                    throw new IOException("Query could not be executed for get all codes");
                }

                HttpSession sh = request.getSession();
                sh.setAttribute("cityData", null);
                response.sendRedirect(baseURL + "/GetCity");
            } else {
                throw new Exception("No database connection.");
            }
        } catch (Exception ex) {
            response.sendRedirect(baseURL + "/errorHandler.jsp");
        }
    }
}
