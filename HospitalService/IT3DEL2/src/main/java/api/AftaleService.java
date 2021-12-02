package api;

import data.Aftale;
import data.AftaleDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Path("aftaler")
public class AftaleService {

    private AftaleDAO aftaleDAO = new AftaleDAO();
    ;
    private PreparedStatement preparedStatement;
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Aftale> getAftaler() {
        return aftaleDAO.getAftaler();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void opretAftale(Aftale aftale) {
        aftaleDAO.addAftale(aftale);
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cpr}")
    public List<Aftale> getAftale(@PathParam("cpr") String cpr) {

        //TODO: Make some real code
        throw new WebApplicationException("Ikke implementeret endnu", Response.Status.NOT_IMPLEMENTED);
    }

//    @DELETE
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void deleteAftale(String cpr) {
//        throw new WebApplicationException("Ikke implementeret endnu", Response.Status.NOT_IMPLEMENTED);
////        System.out.println("Removing aftale with CPR: " + cpr);
////        for (Aftale aftale : aftaleDAO.getAftaler()) {
////            if (aftale.getCpr().equals(cpr)) {
////                System.out.println("Aftale med patient: " + cpr + ": DATE: " + aftale.getDate() + " CPR: " + cpr + " has been deleted");
////            }
////
////        }
//    }
//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void editAftale(String cpr, String nyDate) {
////            for (Aftale aftale : aftaleDAO.getAftaler()) {
////                if (aftale.getCpr().equals(cpr)) {
////                    String beforeDate = aftale.getDate();
////                    aftale.setDate(nyDate);
////                    System.out.println("Aftale with patient: " + cpr + " has been changed from: " + beforeDate + " to: " + nyDate);
////                }
////            }
//    }

}


//        public String hentCpr (String cpr) throws NullPointerException {
//            String patientcpr = "SELECT CPR from sundtek.aftale where cpr =" + cpr + ";";
//            String CPRnr = "";
//            try {
//                statement = connection.createStatement();
//                resultSet = statement.executeQuery(patientcpr);
//                while (resultSet.next()) {
//                    double cprNr = resultSet.getDouble(1);
//                    CPRnr = String.valueOf(cprNr);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.out.println("Wooops.. Kunne ikke hente aftalen. ");
//            }
//            return CPRnr;
//        }
//
//        public List<String> hentDato (String cpr) throws NullPointerException {
//            String patientaftale = "SELECT date FROM sundtek.aftale where cpr = '10-12-1999-7878'";
//            List<String> date = new ArrayList<>();
//            try {
//                statement = connection.createStatement();
//                resultSet = statement.executeQuery(patientaftale);
//                while (resultSet.next()) {
//                    date.add(resultSet.getString(1));
//
//                }
//            } catch (SQLException g) {
//                g.printStackTrace();
//                System.out.println("Ups.. Kunne ikke hente patientaftalen.. :(");
//            }
//            return date;
//        }

//public void hentAftale(Aftale nyAftale){
//System.out.println(nyAftale.getDate());
//System.out.println(nyAftale.getCpr());
//aftaleController.saveAftale(nyAftale);
//}


