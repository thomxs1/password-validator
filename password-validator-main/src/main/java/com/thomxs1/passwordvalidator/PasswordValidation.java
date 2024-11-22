package com.thomxs1.passwordvalidator;

import java.util.Arrays;
import java.util.List;

import com.cthiebaud.passwordvalidator.PasswordValidator;
import com.cthiebaud.passwordvalidator.ValidationResult;

/**
 * Implementation of the PasswordValidator interface to validate passwords
 * against specific criteria. This validator enforces various conditions,
 * including length requirements, character diversity, and inclusion of specific
 * predefined terms.
 */
public class PasswordValidation implements PasswordValidator {

    /**
     * The minimum length required for a valid password.
     */
    private static final int MIN_LENGTH = 8;

    /**
     * Validates a given password based on defined criteria.
     *
     * @param potentialPassword The password to be validated.
     * @return A ValidationResult indicating whether the password is valid and an
     * associated message.
     */
@Override
public ValidationResult validate(String potentialPassword) {
    // Check if password is null or empty
    if (potentialPassword == null || potentialPassword.isEmpty()) {
        return new ValidationResult(false, "Password must not be empty.");
    }

    // Check if password length is valid
    if (potentialPassword.length() < MIN_LENGTH) {
        return new ValidationResult(false, "Password must be at least " + MIN_LENGTH + " characters long.");
    }

    // Check if password contains spaces
    if (potentialPassword.contains(" ")) {
        return new ValidationResult(false, "Password must not contain spaces.");
    }

    // Check for forbidden repeated sequences
    if (containsForbiddenSequence(potentialPassword)) {
        return new ValidationResult(false, "Password must not contain repeated sequences of identical characters.");
    }

    // Check if password contains at least one uppercase letter
    if (!containsUpperCase(potentialPassword)) {
        return new ValidationResult(false, "Password must contain at least one uppercase letter.");
    }

    // Check if password contains at least one lowercase letter
    if (!containsLowerCase(potentialPassword)) {
        return new ValidationResult(false, "Password must contain at least one lowercase letter.");
    }

    // Check if password contains at least one digit
    if (!containsDigit(potentialPassword)) {
        return new ValidationResult(false, "Password must contain at least one digit.");
    }

    // Check if password contains at least one special character
    if (!containsSpecialCharacter(potentialPassword)) {
        return new ValidationResult(false, "Password must contain at least one special character.");
    }

    // Check if password contains the name of a Bundesliga club
    if (!containsBundesligaClub(potentialPassword)) {
        return new ValidationResult(false, "Password must contain the name of a Bundesliga club.");
    }

    // Check if password contains the name of a Graduation song
    if (!containsGraduationSong(potentialPassword)) {
        return new ValidationResult(false, "Password must contain the name of a Graduation song.");
    }

    // Check if password contains the name of a course member
    if (!containsCourseMember(potentialPassword)) {
        return new ValidationResult(false, "Password must contain the first name of a course member.");
    }

    // If all checks pass
    return new ValidationResult(true, "Password is valid.");
}


    // Helper methods to check various conditions

    /**
     * Checks if the password contains at least one uppercase letter.
     *
     * @param password The password to check.
     * @return True if the password contains an uppercase letter, false otherwise.
     */
    private boolean containsUpperCase(String password) {
        return password.matches(".*[A-Z].*");
    }

    /**
     * Checks if the password contains at least one lowercase letter.
     *
     * @param password The password to check.
     * @return True if the password contains a lowercase letter, false otherwise.
     */
    private boolean containsLowerCase(String password) {
        return password.matches(".*[a-z].*");
    }

    /**
     * Checks if the password contains at least one digit.
     *
     * @param password The password to check.
     * @return True if the password contains a digit, false otherwise.
     */
    private boolean containsDigit(String password) {
        return password.matches(".*[0-9].*");
    }

    /**
     * Checks if the password contains at least one special character.
     *
     * @param password The password to check.
     * @return True if the password contains a special character, false otherwise.
     */
    private boolean containsSpecialCharacter(String password) {
        return password.matches(".*[_!@#$%^&*(),.?\":{}|<>].*");
    }

    /**
     * Checks if the password contains the name of a Bundesliga club.
     *
     * @param password The password to check.
     * @return True if the password contains a Bundesliga club name, false otherwise.
     */
    private boolean containsBundesligaClub(String password) {
        List<String> bundesligaClubs = Arrays.asList(
                "BayernMünchen", "BorussiaDortmund", "BayerLeverkusen", "VfLWolfsburg",
                "BorussiaMönchengladbach", "EintrachtFrankfurt", "UnionBerlin", "VfBStuttgart",
                "WerderBremen", "Mainz05", "SCFreiburg", "TSGHoffenheim", "FCAugsburg",
                "FCHeidenheim", "StPauli", "HolsteinKiel", "VfLBochum");

        return bundesligaClubs.stream().anyMatch(club -> password.toLowerCase().contains(club.toLowerCase()));
    }

    /**
     * Checks if the password contains the name of a Graduation song.
     *
     * @param password The password to check.
     * @return True if the password contains a Graduation song name, false otherwise.
     */
    private boolean containsGraduationSong(String password) {
        List<String> graduationSongs = Arrays.asList(
                "GoodMorning", "Champion", "Stronger", "IWonder", "GoodLife", "CantTellMeNothing", 
                "BarryBonds", "DrunkAndHotGirls", "FlashingLights", "EverythingIAm", "TheGlory", 
                "Homecoming", "BigBrother", "GoodNight");

        return graduationSongs.stream().anyMatch(song -> password.toLowerCase().contains(song.toLowerCase()));
    }

    /**
     * Checks if the password contains the first name of a course member.
     *
     * @param password The password to check.
     * @return True if the password contains a course member's first name, false otherwise.
     */
    private boolean containsCourseMember(String password) {
        List<String> courseMembers = Arrays.asList(
                "Kevin", "Willi", "Sören", "Nils", "Raphael", "Mikail", "Markus", "Timo", "Christine",
                "Celine", "Matthis", "Justus", "Josef", "Elias", "Yannick", "Niklas", "Adi", "Thomas",
                "Oliver", "Sinan", "Dietrich", "Tina", "Kim", "Vincent", "Luis", "Daniel", "Tim", 
                "Theocharis", "Marios");

        return courseMembers.stream().anyMatch(member -> password.toLowerCase().contains(member.toLowerCase()));
    }

    /**
     * Checks if the password contains repeated sequences of identical characters.
     *
     * @param password The password to check.
     * @return True if the password contains forbidden sequences, false otherwise.
     */
    private boolean containsForbiddenSequence(String password) {
        return password.matches(".*([a-zA-Z0-9])\\1{2,}.*");
    }
}