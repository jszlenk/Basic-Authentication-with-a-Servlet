package util;

import models.City;

public class Queries {
    public static String getCities() {
        return "select * from city";
    }

    public static String getCountryCodes() {
        return "select * from code";

    }

    public static String insertCity(City c) {

        return String.format("INSERT INTO city "
                        + "(Name, CountryCode, District, Population) "
                        + "VALUES ('%s', '%s', '%s', '%d')"
                , c.getName()
                , c.getCountryCode()
                , c.getDistrict()
                , c.getPopulation());
    }
}