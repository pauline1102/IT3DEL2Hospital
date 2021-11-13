package Aftale;

import Patient.Patient;

import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Path("aftaler")
public class AftaleService {

    private AftaleDAO aftaleDAO;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    // Altid tænk object-orienteret. Tænk på den virkelige verden og derefter lav det om til kode.
    // En service er en der yder noget. Tænk på AftaleService som en sekretær der opretter og gemmer aftaler i databasen.
    // Vi skal give vores "sekretær" adgang til databasen for at gøre det, og derfor skal vi give ham/hende adgang ved hjælp af vores connetion
    // Nu hvor sekretæren har adgang, kan vi nemt oprette og gemme data i databasen.

    public AftaleService(Connection connection) {
        this.aftaleDAO = new AftaleDAO();
        this.connection = connection;
    }

    // Dette er CRUD - Create, Read, Update, Delete metoder i selve programmet.

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void opretAftale(Aftale aftale) {
        aftaleDAO.addAftale(aftale);
        addAftale(aftale);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Aftale getAftale(String cpr) {
        for (Aftale aftale : aftaleDAO.getAftaler()){
            if (aftale.getCpr().equals(cpr)){
                return aftale;
            }
        }
        return null;
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAftale(String cpr) {
        System.out.println("Removing aftale with CPR: " + cpr);
        for (Aftale aftale : aftaleDAO.getAftaler()) {
            if (aftale.getCpr().equals(cpr)) {
                System.out.println("Aftale med patient: " + cpr + ": DATE: " + aftale.getDate() + " CPR: " + cpr + " has been deleted");
            }

        }
    }

        @PUT
        @Consumes(MediaType.APPLICATION_JSON)
        public void editAftale(String cpr, Date nyDate){
            for (Aftale aftale : aftaleDAO.getAftaler()) {
                if (aftale.getCpr().equals(cpr)) {
                    Date beforeDate = aftale.getDate();
                    aftale.setDate(nyDate);
                    System.out.println("Aftale with patient: " + cpr + " has been changed from: " + beforeDate + " to: " + nyDate);
                }
            }
        }

        // Her starter metoderne for at gemme jeres data til databasen.

        public void addAftale (Aftale aftale){
            int year = aftale.getDate().getYear();
            int month = aftale.getDate().getMonth();
            int day = aftale.getDate().getDay();

            String insertAftale = "INSERT INTO aftale (CPR, date)" + " VALUES (" + aftale.getCpr() + ", '"+ year + "-" + month + "-" + day + "');";
            System.out.println(insertAftale);

            try {
                preparedStatement = connection.prepareStatement(insertAftale);
                preparedStatement.setString(1, aftale.getCpr());
                preparedStatement.setDate(2, (java.sql.Date) aftale.getDate());
                preparedStatement.execute();
            } catch (SQLException ex) {
                System.out.println("Ups.. Der opstod en fejl under oprettelsen af aftalen. Prøv igen eller kontakt udviklerne!");
            }
        }

        public String hentCpr (String cpr) throws NullPointerException {
            String patientcpr = "SELECT CPR from sundtek.aftale where cpr =" + cpr + ";";
            String CPRnr = "";
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(patientcpr);
                while (resultSet.next()) {
                    double cprNr = resultSet.getDouble(1);
                    CPRnr = String.valueOf(cprNr);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Wooops.. Kunne ikke hente aftalen. ");
            }
            return CPRnr;
        }

        public String hentDato (String cpr) throws NullPointerException {
            String patientaftale = "SELECT date FROM sundtek.aftale where cpr =" + cpr + ";";
            String date = "";
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(patientaftale);
                while (resultSet.next()) {
                    Date datedata = resultSet.getDate(2);
                    date = String.valueOf(datedata);
                }
            } catch (SQLException g) {
                g.printStackTrace();
                System.out.println("Ups.. Kunne ikke hente patientaftalen.. :(");
            }
            return date;
        }

        //public void hentAftale(Aftale nyAftale){
        //System.out.println(nyAftale.getDate());
        //System.out.println(nyAftale.getCpr());
        //aftaleController.saveAftale(nyAftale);
        //}

    public AftaleDAO getAftaleDAO(){
        return aftaleDAO;
    }
    }
