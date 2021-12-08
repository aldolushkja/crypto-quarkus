package it.alushkja.crypto.cryptography;

import it.alushkja.crypto.Utils;

import javax.enterprise.context.ApplicationScoped;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

@ApplicationScoped
public class ASymmetricEncriptionService {

    public void encryptSomeShortTextWithRsa() throws NoSuchAlgorithmException {
        KeyPairGenerator kpGen = KeyPairGenerator.getInstance("RSA");
        kpGen.initialize(1024);
        KeyPair keyPair = kpGen.generateKeyPair();

        Utils.printByteArray("private key", keyPair.getPrivate().getEncoded());
        Utils.printByteArray("public key", keyPair.getPublic().getEncoded());


    }
}
