package api;

import business.JWTHandler;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


@Provider
public class AuthFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println(containerRequestContext.getUriInfo().getPath());
//Undgå at afvise folk der prøver at logge ind.
        if (!"login".equals(containerRequestContext.getUriInfo().getPath())) {
            String authorization = containerRequestContext.getHeaderString("Authorization");
            if (authorization==null){
                throw new WebApplicationException("manglende header", 401);
            }
            JWTHandler.validate(authorization.split(" ")[1]);
        }
    }
}

