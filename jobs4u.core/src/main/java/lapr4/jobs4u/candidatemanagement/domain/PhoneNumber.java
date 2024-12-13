package lapr4.jobs4u.candidatemanagement.domain;

import eapli.framework.domain.model.ValueObject;
import jakarta.persistence.Embeddable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Embeddable

public class PhoneNumber implements ValueObject {
    private String phoneNumber;

    // Constructor
    public PhoneNumber(String phoneNumber) {
        if (!validatePhoneNumber(phoneNumber))
            throw new IllegalArgumentException("PhoneNumber must follow Portuguese pattern");

        this.phoneNumber = phoneNumber;
    }

    protected PhoneNumber() {
    }

    /**
     * Checks if the number has a valid format, in this case a portuguese one
     *
     * @param phoneNumber
     * @return
     */
    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber != null && !phoneNumber.isBlank()) {
            String numberRegex = "^\\d{9}$";        // Regular expression for phone number format
            Pattern pat = Pattern.compile(numberRegex);
            Matcher matcher = pat.matcher(phoneNumber);
            return matcher.matches();
        }
        return false;
    }

    @Override
    public String toString() {
        return phoneNumber;
    }
}
