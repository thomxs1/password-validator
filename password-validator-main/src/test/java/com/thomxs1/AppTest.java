package com.thomxs1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.cthiebaud.passwordvalidator.ValidationResult;
import com.thomxs1.passwordvalidator.PasswordValidation;

/**
 * Test class for PasswordValidation.
 * Verifies that passwords meet all specified criteria or provide appropriate validation messages.
 */
public class AppTest {

    private final PasswordValidation passwordValidation = new PasswordValidation();

    /**
     * Tests a valid password that fulfills all criteria.
     */
    @Test
    public void testValidPassword() {
        String validPassword = "BayernMünchen1!GoodLifeKevin";
        ValidationResult result = passwordValidation.validate(validPassword);
        assertTrue(result.isValid(), "Password should be valid.");
        assertEquals("Password is valid.", result.message(), "Validation message should be correct.");
    }

    /**
     * Tests an invalid password that is shorter than the minimum length.
     */
    @Test
    public void testPasswordTooShort() {
        String shortPassword = "short";
        ValidationResult result = passwordValidation.validate(shortPassword);
        assertFalse(result.isValid(), "Password should be invalid if shorter than the minimum length.");
        assertEquals("Password must be at least 8 characters long.", result.message());
    }

    /**
     * Tests an empty password.
     */
    @Test
    public void testEmptyPassword() {
        String emptyPassword = "";
        ValidationResult result = passwordValidation.validate(emptyPassword);
        assertFalse(result.isValid(), "Password should be invalid when empty.");
        assertEquals("Password must not be empty.", result.message());
    }

    /**
     * Tests a password without an uppercase letter.
     */
    @Test
    public void testPasswordWithoutUppercase() {
        String password = "bayern1!goodlife";
        ValidationResult result = passwordValidation.validate(password);
        assertFalse(result.isValid(), "Password should be invalid without an uppercase letter.");
        assertEquals("Password must contain at least one uppercase letter.", result.message());
    }

    /**
     * Tests a password without a special character.
     */
    @Test
    public void testPasswordWithoutSpecialCharacter() {
        String password = "BayernMuenchen1GoodLife";
        ValidationResult result = passwordValidation.validate(password);
        assertFalse(result.isValid(), "Password should be invalid without a special character.");
        assertEquals("Password must contain at least one special character.", result.message());
    }

    /**
     * Tests a password with repeated sequences of identical characters.
     */
    @Test
    public void testPasswordWithRepeatedSequences() {
        String password = "Bayern111!!!GoodLife";
        ValidationResult result = passwordValidation.validate(password);
        assertFalse(result.isValid(), "Password should be invalid with repeated sequences of identical characters.");
        assertEquals("Password must not contain repeated sequences of identical characters.", result.message());
    }

    /**
     * Tests a password containing spaces.
     */
    @Test
    public void testPasswordWithSpaces() {
        String password = "Bayern München 1 !";
        ValidationResult result = passwordValidation.validate(password);
        assertFalse(result.isValid(), "Password should be invalid if it contains spaces.");
        assertEquals("Password must not contain spaces.", result.message());
    }

    /**
     * Tests a password missing a Bundesliga club name.
     */
    @Test
    public void testPasswordWithoutBundesligaClub() {
        String password = "Valid1!GoodLifeKevin";
        ValidationResult result = passwordValidation.validate(password);
        assertFalse(result.isValid(), "Password should be invalid without a Bundesliga club name.");
        assertEquals("Password must contain the name of a Bundesliga club.", result.message());
    }
}
