package data;

import DB.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private String username;
    private String password;


    public UserDAO(String username, String password) {

    }

    public static LoginData findUser(String username){
        String findBruger = "SELECT * FROM brugere WHERE username = ?";
        try{
            Connection connection = new DBConnector().getMYSQLConnection("s205481", "iSdBO5cuIySWKV9I42kvo", "s205481");
            PreparedStatement preparedStatement = connection.prepareStatement(findBruger);
            preparedStatement.setString(1,username);
            ResultSet resultSet = preparedStatement.executeQuery();
            //Check om der var resultat og konverter til Java-Object (LoginData)
            if (resultSet.next()){
                LoginData foundUser = new LoginData();
                foundUser.setUsername(resultSet.getString("username"));
                foundUser.setPassword(resultSet.getString("password"));
                System.out.println(foundUser);
                return foundUser;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;

    }


    /*
     public UserDAO(String user, String s) {
        setUsername(user);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
     */

}

/*
 PreparedStatement preparedStatement = connection.prepareStatement(getAftaler);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Aftale> aftaleList = new ArrayList<>();
            while (resultSet.next()){
                String cpr = resultSet.getString("CPR");
                String date = resultSet.getString("date");
                Aftale aftale = new Aftale(date,cpr);
                aftaleList.add(aftale);
            }

 */