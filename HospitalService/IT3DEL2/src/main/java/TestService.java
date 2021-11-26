import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

    @Path("tokentest")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)

    public class TestService {
        @POST
        public User postToken(String token) {
            return JWTHandler.validate(token);
        }

        @GET
        public String getSecret(@HeaderParam("authorization") String auth){
            JWTHandler.validate(auth.split(" ")[1]);
            return "succes";
        }
    }
