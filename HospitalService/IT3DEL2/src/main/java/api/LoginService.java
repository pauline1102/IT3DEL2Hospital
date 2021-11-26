package api;

import business.JWTHandler;
import data.LoginData;
import data.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;


    @Path("login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)

    public class LoginService {
        @POST
        public String postLoginData(LoginData login) {
            if (login!=null && "brian".equals(login.getUsername()) && "kodeord".equals(login.getPassword())){
                String token = JWTHandler.generateJwtToken(new User(login.getUsername(), ""));
                System.out.println(token);
                return  token;
            }
            throw new WebApplicationException("forkert brugernavn/kodeord",401);
        }
    }
