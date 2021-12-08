package it.alushkja.crypto;

import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/ping")
public class PingController {

    @GET
    public Response getDefaultHostname() {
        final var hostname = System.getenv().getOrDefault("HOSTNAME", "unknown");
        final var message = String.format("%d > Responding from hostname = %s\n", System.currentTimeMillis(), hostname);
        System.out.println(message);
        return Response.ok(Json.createObjectBuilder().add("hostname", hostname).add("time", System.currentTimeMillis()).build()).build();
    }
}
