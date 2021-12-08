package it.alushkja.crypto.configuration;

import io.quarkus.runtime.Startup;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Collections;
import java.util.logging.Logger;

@Startup
public class LoggerProvider {

    @Inject
    Logger LOGGER;

    public Path dir;

    @PostConstruct
    public void initLogDirectory() {
        dir = Paths.get(System.getProperty("user.home") + "/crypto-quarkus");
        final var logFileName = dir + "/data_" + LocalDate.now().toString().replace(" ", "_") + ".log";
        LOGGER.info("> Check if folder exists: " + dir);
        if (!Files.isDirectory(dir)) {
            try {
                Files.createDirectory(dir);
                LOGGER.info("> Current working file is: " + logFileName);
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.info("> Unable to work into directory: " + dir + " with file " + logFileName);
            }
        }
    }

    public void logToFile(String s) {
        dir = Paths.get(System.getProperty("user.home") + "/crypto-quarkus");
        final var logFileName = dir + "/data_" + LocalDate.now().toString().replace(" ", "_") + ".log";
        LOGGER.info("> Check if folder exists: " + dir);
        if (!Files.isDirectory(dir)) {
            try {
                Files.createDirectory(dir);
                LOGGER.info("> Current working file is: " + logFileName);
                Files.write(Paths.get(logFileName), Collections.singleton(s), StandardOpenOption.APPEND);
            } catch (IOException e) {
                e.printStackTrace();
                LOGGER.info("> Unable to work into directory: " + dir + " with file " + logFileName);
            }
        }
    }

}
