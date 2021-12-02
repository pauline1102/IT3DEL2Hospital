package business;

import data.LoginData;
import data.UserDAO;

import javax.ws.rs.WebApplicationException;

public class LoginController {

    public String validateUser(LoginData loginData) {
        LoginData user = UserDAO.findUser(loginData.getUsername());
        System.out.println("Logindata: " + loginData);
        System.out.println("userFOund" + user);
        if (user!=null && user.getPassword().equals(loginData.getPassword())){
            String token = JWTHandler.generateJwtToken(loginData);
            System.out.println(token);
            return  token;
        }
        throw new WebApplicationException("forkert brugernavn/kodeord",401);
    }
}

