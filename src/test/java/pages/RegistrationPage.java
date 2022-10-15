package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    public RegistrationPage openPage() {
        open("/register");
        return this;
    }

    public RegistrationPage setUserGender() {
        $("#gender-male").click();
        return this;
    }

    public RegistrationPage setFirstName(String firstName) {
        $("#FirstName").setValue(firstName);
        return this;
    }

    public RegistrationPage setLastName(String lastName) {
        $("#LastName").setValue(lastName);
        return this;
    }

    public RegistrationPage setUserEmail(String userEmail) {
        $("#Email").setValue(userEmail);
        return this;
    }

    public RegistrationPage setUserPassword(String userPassword) {
        $("#Password").setValue(userPassword);
        return this;
    }

    public RegistrationPage setUserPasswordConfirm(String userPasswordConfirm) {
        $("#ConfirmPassword").setValue(userPasswordConfirm);
        return this;
    }

    public RegistrationPage clickRegisterButton() {
        $("#register-button").click();
        return this;
    }

    public RegistrationPage checkRegistrationResult() {
        $(".result").getText();
        return this;
    }
}
