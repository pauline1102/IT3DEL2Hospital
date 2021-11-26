package business;

import data.LoginData;
import data.UserDAO;

import javax.ws.rs.WebApplicationException;

public class LoginController {
    private static LoginData loginData;
    private static UserDAO userDAO = new UserDAO(loginData.getUsername(), "");

    public String validateUser(LoginData loginData) {
        LoginData user = UserDAO.findUser(loginData.getUsername());
        if (user!=null && user.getPassword().equals(loginData.getUsername())){
            String token = JWTHandler.generateJwtToken(new UserDAO(loginData.getUsername(), ""));
            System.out.println(token);
            return  token;
        }
        throw new WebApplicationException("forkert brugernavn/kodeord",401);
    }
}

