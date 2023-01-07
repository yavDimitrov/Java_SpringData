package bg.softuni.gamestore.constants;

public enum Validation {
    ;

    public static final String EMAIL_PATTERN = "^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-]+)(\\.[a-zA-Z]{2,5}){1,2}$";
    public static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,}$";
    public static final String EMAIL_NOT_VALID_MESSAGE = "Incorrect email.";
    public static final String USERNAME_OR_PASSWORD_NOT_VALID_MESSAGE = "Incorrect username / password";
    public static final String PASSWORDS_MISS_MATCHING_MESSAGE = "Passwords are not matching";
    public static final String COMMAND_NOT_FOUND_MESSAGE = "Command not found";
}
