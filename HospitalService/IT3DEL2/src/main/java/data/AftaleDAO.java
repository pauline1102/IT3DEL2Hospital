package data;

import DB.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class AftaleDAO {
    //Forbind til database
    //private static Connection connection = new DBConnector().getMYSQLConnection("pauline", "Pauline1234", "sundtek");;
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

//    public void addAftale(Aftale nyAftale){
//        //TODO tilføj aftaler til database
//        System.out.println("Opretter aftale...");
//        this.aftaleList.add(nyAftale);
//        System.out.println("Aftale oprettet! " + nyAftale);
//    }

}

