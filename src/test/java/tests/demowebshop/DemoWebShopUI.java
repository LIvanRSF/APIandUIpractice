package tests.demowebshop;

import helpers.TestData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class DemoWebShopUI extends TestBaseWithUi {

    TestData testData = new TestData();
    RegistrationPage regPage = new RegistrationPage();
    String password = testData.regPassword;

    @Test
    @Tag("demowebshop")
    @DisplayName("Registration new customer test")
    void registrationNewUserTest() {
        regPage.openPage()
            .setUserGender()
            .setFirstName(testData.regFirstName)
            .setFirstName(testData.regFirstName)
            .setLastName(testData.regLastName)
            .setUserEmail(testData.regEmail)
            .setUserPassword(password)
            .setUserPasswordConfirm(password)
            .clickRegisterButton()
            .checkRegistrationResult();
    }
}
