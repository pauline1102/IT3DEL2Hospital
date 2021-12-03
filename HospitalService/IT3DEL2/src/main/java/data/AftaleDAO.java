package data;

import DB.DBConnector;
import api.AftaleService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AftaleDAO {
    private static Connection connection = new DBConnector().getMYSQLConnection();;


    public List<Aftale> getAftaler() {
        String getAftaler = "SELECT * FROM aftale";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAftaler);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Aftale> aftaleList = new ArrayList<>();
            while (resultSet.next()){
                String cpr = resultSet.getString("CPR");
                String date = resultSet.getString("date");
                Aftale aftale = new Aftale(date,cpr);
                aftaleList.add(aftale);
            }
            return aftaleList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    public void addAftale(Aftale aftale){

        String insertAftale = "INSERT INTO aftale (CPR, date)" + " VALUES (?,?);";
        System.out.println(insertAftale);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAftale);
            preparedStatement.setString(1, aftale.getCpr());
            preparedStatement.setString(2, aftale.getDate());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Ups.. Der opstod en fejl under oprettelsen af aftalen. Prøv igen eller kontakt udviklerne!");
            ex.printStackTrace();
        }

    }

    public List<Aftale> getAftaler(String findCpr) {
        String getAftaler = "SELECT * FROM aftale WHERE CPR = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAftaler);
            preparedStatement.setString(1,findCpr);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Aftale> aftaleList = new ArrayList<>();
            while (resultSet.next()){
                String cpr = resultSet.getString("CPR");
                String date = resultSet.getString("date");
                Aftale aftale = new Aftale(date,cpr);
                aftaleList.add(aftale);
            }
            return aftaleList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }
}

