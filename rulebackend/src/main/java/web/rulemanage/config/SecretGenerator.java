package web.rulemanage.config;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretGenerator {
    public static void main(String[] args) {
        byte[] randomBytes = new byte[24];
        new SecureRandom().nextBytes(randomBytes);
        String secret = Base64.getEncoder().encodeToString(randomBytes);
        System.out.println("JWT Secret: " + secret);
    }
}