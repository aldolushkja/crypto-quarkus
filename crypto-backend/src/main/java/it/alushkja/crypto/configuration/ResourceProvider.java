package it.alushkja.crypto.configuration;

import java.util.logging.Logger;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;

public class ResourceProvider {
    @Produces
    Logger buildLogger(InjectionPoint ip) {
        return Logger.getLogger(ip.getBean().getBeanClass().getCanonicalName());
    }
}
