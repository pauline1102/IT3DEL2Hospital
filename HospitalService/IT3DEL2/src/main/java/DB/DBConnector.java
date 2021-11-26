package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

        private static Connection connection = null;
        private static String MYSQLDriver = "jdbc:mysql://" + "mysql-db.caprover.diplomportal.dk:3306/";
        private static String url;

        public Connection getMYSQLConnection(String username, String password, String Schema){
            url = MYSQLDriver + Schema + "?serverTimezone=Europe/Amsterdam&amp";
            try {
                //sørger for at tomcat læser den her (eller noget)
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(url, username, password);

                if (connection != null) {
                    System.out.println("Connected to MYSQL Schema:"+Schema);
                }
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
            return connection;
        }
    }


