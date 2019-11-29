package models;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 1L;
    private String uid;
    private String pwd;
    private int authLevel;

    public User() {
    }

    public String getUserId() {
        return uid;
    }

    public void setUserId(String value) {
        uid = value;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String value) {
        pwd = value;
    }

    public int getAuthLevel() {
        return authLevel;
    }

    public void setAuthLevel(int value) {
        authLevel = value;
    }

    public String toString() {
        return String.format("UID: %s\tPWD: %s\tAuthLevel: %d\n"
                , getUserId()
                , getPassword()
                , getAuthLevel());
    }
}