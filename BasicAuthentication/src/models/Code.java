package models;

import java.io.Serializable;

public class Code implements Serializable {

    private static final long serialVersionUID = 1L;
    private String countryCode;

    public Code() {
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String value) {
        countryCode = value;
    }

    public String toString() {
        return String.format("Country Code: %s\n"
                , getCountryCode());
    }
}