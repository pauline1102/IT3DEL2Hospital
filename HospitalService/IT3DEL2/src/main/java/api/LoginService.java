package api;

import business.JWTHandler;
import business.LoginController;
import data.LoginData;
import data.UserDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

    @Path("login")
    public class LoginService {
        private static LoginController loginController = new LoginController();
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.TEXT_PLAIN)
        public String doLogin(LoginData loginData){
            //returner en token hvis det går godt
            return loginController.validateUser(loginData);
        }
    }

    /*

            }
            throw new WebApplicationException("forkert brugernavn/kodeord",401);
        }

     */