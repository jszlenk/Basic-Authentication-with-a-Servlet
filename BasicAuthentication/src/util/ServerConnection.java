package util;

import java.sql.Connection;

public interface ServerConnection {

    Connection getConnection();
    String getConnectionURL();
    String getConnectionDetails();
}
