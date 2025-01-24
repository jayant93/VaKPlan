package com.vakPlan.user.utility;

import java.security.SecureRandom;

/**
 * Contains utility functions
 */
public class Utility {

    final static int passwordLength = 12;
    public static String generateRandomPassword() {
        // Define characters to be used in the password
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        SecureRandom random = new SecureRandom();

        // StringBuilder to build the password
        StringBuilder password = new StringBuilder(passwordLength);

        // Loop to generate each character randomly
        for (int i = 0; i < passwordLength; i++) {
            int index = random.nextInt(characters.length());
            password.append(characters.charAt(index));
        }

        return password.toString();
    }

}
