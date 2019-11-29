package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLServerConnection extends DBUser implements ServerConnection {

    public MySQLServerConnection(String uid, String pwd, String cat) {
        super(uid, pwd, cat);
    }

    @Override
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(getConnectionURL());
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String getConnectionURL() {
        return String.format("jdbc:mysql://localhost/%s?user=%s&password=%s&serverTimezone=UTC"
                , getCatalog()
                , getUserID()
                , getPassword());
    }

    @Override
    public String getConnectionDetails() {
        return "MySQL Database Connection to " + getCatalog();
    }
}