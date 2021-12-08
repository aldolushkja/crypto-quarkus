package it.alushkja.crypto.base64;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;

import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@Path("/api/v1/base64")
@Consumes("application/json")
@Produces("application/json")
public class Base64Controller {

    @POST
    @Path("/encode")
    public Response encodeBase64(JsonObject request) {
        final var encoded = Base64.encodeBase64String(request.getString("inputText").getBytes(StandardCharsets.UTF_8));
        return Response.ok(Json.createObjectBuilder().add("outputText", encoded).build()).build();
    }

    @POST
    @Path("/decode")
    public Response decodeBase64(JsonObject request) {
        final var encoded = Base64.decodeBase64(request.getString("inputText").getBytes(StandardCharsets.UTF_8));
        return Response.ok(Json.createObjectBuilder().add("outputText", Arrays.toString(encoded)).build()).build();
    }
}
