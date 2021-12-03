package DB;

import data.AftaleDAO;
import data.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String MYSQLDriver = "jdbc:mysql://" + "mysql-db.caprover.diplomportal.dk/";
    private static String url;

    public static Connection getMYSQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-db.caprover.diplomportal.dk/" + "s205481?user=s205481&password=iSdBO5cuIySWKV9I42kvo");
            if (connection != null) {
                System.out.println("Connected to MYSQL Schema: s205481");
            }
            return connection;
        } catch (SQLException  | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}


/*
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

    private static String MYSQLDriver = "jdbc:mysql://" + "mysql-db.caprover.diplomportal.dk:3306/";
    private static String url;

    public static Connection getMYSQLConnection(String username, String password, String Schema) {
        url = MYSQLDriver + Schema + "?serverTimezone=Europe/Amsterdam&amp";
        try {
            //sørger for at tomcat læser den her (eller noget)
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            if (connection != null) {
                System.out.println("Connected to MYSQL Schema:" + Schema);
            }
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}



 */