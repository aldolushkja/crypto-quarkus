package it.alushkja.crypto.hashing;

import it.alushkja.crypto.Utils;
import org.apache.commons.codec.digest.DigestUtils;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.time.LocalDate;
import java.util.logging.Logger;

@Path("/api/v1/hashing")
public class HashingController {

    public static final String DEFAULT_HASH_ALGORITHM = "SHA-1";
    @Inject
    Logger LOGGER;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response hashContent(JsonObject request, @Context HttpServletRequest httpServletRequest) {
        try {
            final var inputText = request.getJsonString("inputText").getString();
            final var algorithm = request.getJsonString("algorithm").getString();
            if (Utils.isNullOrEmpty(algorithm)) {
                //using SHA-1 as default
                final var instance = MessageDigest.getInstance(DEFAULT_HASH_ALGORITHM);
                final var digest = instance.digest(inputText.getBytes(StandardCharsets.UTF_8));
                return Response.ok(Json.createObjectBuilder().add("outputText", DigestUtils.shaHex(digest)).build()).build();
            }

            final var instance = MessageDigest.getInstance(algorithm.toUpperCase());
            final var digest = instance.digest(inputText.getBytes(StandardCharsets.UTF_8));
            final var outputText = DigestUtils.shaHex(digest);
            final var dir = Paths.get(System.getProperty("user.home") + "/crypto-quarkus");
            final var logFileName = dir + "/data_" + LocalDate.now().toString().replace(" ", "_") + ".log";
            LOGGER.info("> Check if folder exists: " + dir);
            LOGGER.info("> Current working file is: " + logFileName);
            if (!Files.isDirectory(dir)) Files.createDirectory(dir);
            var logLine = String.format("Date=%s,IP=%s,Algorithm=%s,InputText=%s,OutputText=%s"
                    , LocalDate.now(), httpServletRequest.getRemoteAddr(), algorithm, inputText, outputText);
            LOGGER.info(logLine);
//            Files.write(Paths.get(logFileName), Collections.singleton(logLine), StandardOpenOption.APPEND);
            return Response.ok(Json.createObjectBuilder().add("outputText", outputText).build()).build();
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            return Response.status(400).entity(e.getLocalizedMessage()).build();
        }
    }
}
