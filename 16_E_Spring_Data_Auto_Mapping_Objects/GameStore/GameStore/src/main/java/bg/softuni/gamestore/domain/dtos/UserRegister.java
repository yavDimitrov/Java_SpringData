package bg.softuni.gamestore.domain.dtos;

import bg.softuni.gamestore.domain.entities.User;
import bg.softuni.gamestore.service.user.UserService;

import java.util.regex.Pattern;

import static bg.softuni.gamestore.constants.Validation.*;

public class UserRegister {
    private String email;

    private String password;

    private String confirmPassword;

    private String fullName;

    public UserRegister(String email, String password, String confirmPassword, String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
        validate();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    private void validate() throws IllegalArgumentException {

        boolean isEmailValid = Pattern.matches(EMAIL_PATTERN, this.email);

        if(!isEmailValid) {
            throw new IllegalArgumentException(EMAIL_NOT_VALID_MESSAGE);
        }

        boolean isPasswordValid = Pattern.matches(PASSWORD_PATTERN, this.password);

        if(!isPasswordValid) {
            throw new IllegalArgumentException(USERNAME_OR_PASSWORD_NOT_VALID_MESSAGE);
        }

        if(!password.equals(confirmPassword)) {
            throw new IllegalArgumentException(PASSWORDS_MISS_MATCHING_MESSAGE);
        }
    }

    public User toUser () {
        return new User(email, password, fullName);
    }

}
