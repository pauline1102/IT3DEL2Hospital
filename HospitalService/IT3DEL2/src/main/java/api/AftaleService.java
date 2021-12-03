package api;

import business.JWTHandler;
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
        return aftaleDAO.getAftaler(cpr);
    }
}



