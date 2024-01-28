package com.activityplanner.user.helper;

import java.security.SecureRandom;
import java.util.Base64;

public class SaltGenerator {

    private static final int SALT_LENGTH = 16;

    public static String generateUniqueSalt() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] salt = new byte[SALT_LENGTH];
        secureRandom.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }
}
