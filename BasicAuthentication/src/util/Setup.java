package util;

import javax.servlet.*;

public class Setup implements ServletContextListener {
    private DBManager dbm = null;

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        if (dbm != null) {
            if (dbm.isConnected()) {
                dbm.closeConnection(false);
            }
        }
        dbm = null;
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext sc = sce.getServletContext();
        String uid = sc.getInitParameter("user");
        String pwd = sc.getInitParameter("password");
        String cat = sc.getInitParameter("db");

        ServerConnection scb = new MySQLServerConnection(uid, pwd, cat);

        dbm = new DBManager(scb);

        sc.setAttribute("DBM", dbm);
    }
}