package it.alushkja.crypto.cryptography;

import javax.inject.Inject;
import javax.json.JsonObject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;

@Path("/api/v1/cryptography")
public class CryptographyController {

    @Inject
    ASymmetricEncriptionService ases;

    @POST
    @Path("/asymmetric")
    @Produces(MediaType.APPLICATION_JSON)
    public Response asymmetricEncription(JsonObject request) throws NoSuchAlgorithmException {
        ases.encryptSomeShortTextWithRsa();
        return Response.ok().build();
    }

    @POST
    @Path("/symmetric")
    @Produces(MediaType.APPLICATION_JSON)
    public Response symmetricEncription(JsonObject request) throws NoSuchAlgorithmException {
        ases.encryptSomeShortTextWithRsa();
        return Response.ok().build();
    }

}
