package util;

public abstract class DBUser {

    private String uid;
    private String pwd;
    private String cat;

    public DBUser() {
    }

    public DBUser(String userID, String password, String catalog) {
        uid = userID;
        pwd = password;
        cat = catalog;
    }

    public String getUserID() {
        return uid;
    }

    public void setUserID(String value) {
        uid = value;
    }

    public String getPassword() {
        return pwd;
    }

    public void setPassword(String value) {
        pwd = value;
    }

    public String getCatalog() {
        return cat;
    }

    public void setCatalog(String catalog) {
        cat = catalog;
    }
}