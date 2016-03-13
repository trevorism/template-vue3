package webapi

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
class RootController {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getEndpoints(){
        return ["ping"]
    }

    @GET
    @Path("ping")
    @Produces(MediaType.APPLICATION_JSON)
    public String ping(){
        return "pong"
    }
}
