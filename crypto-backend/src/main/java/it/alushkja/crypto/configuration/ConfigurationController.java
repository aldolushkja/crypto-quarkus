package it.alushkja.crypto.configuration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/api/v1/configuration")
public class ConfigurationController {

    @GET
    public Response getConfigurations() {
        return Response.ok().build();
    }
}
