package lapr4.jobs4u.usermanagement.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import eapli.framework.infrastructure.authz.application.PasswordPolicy;
import eapli.framework.strings.util.StringPredicates;


public class UserPasswordPolicy implements PasswordPolicy {

    private static final int MAX_LENGTH = 10;
    private static final int MIN_LENGTH = 8;

    /*
     * (non-Javadoc)
     *
     * @see eapli.framework.infrastructure.authz.domain.model.PasswordPolicy#
     * meetsRequeriments(java.lang.String)
     */
    @Override
    public boolean isSatisfiedBy(final String rawPassword) {
        // sanity check
        if (StringPredicates.isNullOrEmpty(rawPassword)) {
            return false;
        }

        // at least 6 characters long
        if (rawPassword.length() < 8) {
            return false;
        }

        // at least one digit
        if (!StringPredicates.containsDigit(rawPassword)) {
            return false;
        }

        // at least a lower case letter
        if (!containsLowerCase(rawPassword)) {
            return false;
        }

        // at least one non-alphanumeric character
        if (!containsNonAlphaNumeric(rawPassword)) {
            return false;
        }

        // at least one capital letter
        return StringPredicates.containsCapital(rawPassword);
    }

    public static boolean containsLowerCase(final String text) {
        return text.matches(".*[a-z].*");
    }

    public static boolean containsNonAlphaNumeric(final String text) {

        boolean hasNonAlphaNumeric = false;

        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!StringPredicates.containsDigit(String.valueOf(c)) && !StringPredicates.containsAlpha(String.valueOf(c))) {
                hasNonAlphaNumeric = true;
            }
        }

        return hasNonAlphaNumeric;
    }

    public static String generatePassword() {
        String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
        String specialCharacters = "!@#$";
        String numbers = "1234567890";
        String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
        Random random = new Random();
        int length = generatePasswordLength();
        char[] password = new char[length];

        password[0] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
        password[1] = numbers.charAt(random.nextInt(numbers.length()));
        password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));

        for(int i = 3; i< length ; i++) {
            password[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
        }

        Collections.shuffle(Arrays.asList(password), random);

        return String.valueOf(password);
    }

    private static int generatePasswordLength()
    {
        Random random = new Random();
        return random.nextInt(MAX_LENGTH-MIN_LENGTH) + MIN_LENGTH;
    }

}
