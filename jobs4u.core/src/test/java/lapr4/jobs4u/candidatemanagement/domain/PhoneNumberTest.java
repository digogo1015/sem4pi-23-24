package lapr4.jobs4u.candidatemanagement.domain;

import org.junit.Test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PhoneNumberTest {

    private final PhoneNumber phoneNumber1 = new PhoneNumber("999888777");
    private final PhoneNumber phoneNumber2 = new PhoneNumber("111222333");

    @Test
    public void testEqualsWithDifferentNumber(){
        final boolean expected = phoneNumber1.equals(phoneNumber2);

        assertFalse(expected);
    }

    @Test
    public void testEqualsWithSameNumber(){
        final boolean expected = phoneNumber1.equals(phoneNumber1);

        assertTrue(expected);
    }

    @Test
    public void testNullPhoneNumber(){
        boolean check = true;
        try {
            PhoneNumber number = new PhoneNumber(null);
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void testBlankPhoneNumber(){
        boolean check = true;
        try {
            PhoneNumber number = new PhoneNumber("");
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void testInvalidPhoneNumber(){
        boolean check = true;
        try {
            PhoneNumber number = new PhoneNumber("1234");
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void testInvalidPhoneNumber2(){
        boolean check = true;
        try {
            PhoneNumber number = new PhoneNumber("1234456789101112");
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void testValidPhoneNumber(){
        boolean check = true;
        try {
            PhoneNumber number = new PhoneNumber("999888777");
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertTrue(check);
    }

    @Test
    public void testValidPhoneNumber2(){
        boolean check = true;
        try {
            PhoneNumber number = new PhoneNumber("111222333");
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertTrue(check);
    }
}