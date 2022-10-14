package tests.demowebshop;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

import com.codeborne.selenide.Selenide;
import config.demowebshop.App;
import helpers.AllureAttachments;
import helpers.demowebshop.GetCookies;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DemoWebShopApiUiTests extends TestBase {

    String login = App.config.userLogin();
    String password = App.config.userPassword();

    @Test
    @Tag("demowebshop")
    @DisplayName("Success log in test")
    void addToCartAuthorized() {
        step("Get cookie of authorized user and set it into browser", () -> {
            GetCookies.getAuthorizedCookies(login, password);
        });

        step("Open main page", () ->
            open(""));

        step("Verify registration", () ->
            $(".account").shouldHave(text(login)));
    }

    @Test
    @Tag("demowebshop")
    @DisplayName("Edit customer profile")
    void editCustomerProfile() {
        step("Get cookie of authorized user and set it into browser", () ->
            GetCookies.getAuthorizedCookies(login, password));

        step("Open customer info", () ->
            open("/customer/info"));

        step("Edit customer info and save changes", () -> {
            $("#Email").setValue("test_" + login);
            $(byName("save-info-button")).click();
            $(".account").shouldHave(text("test_" + login));
        });

        //Возвращаем значение почты (логина) в первоначальное
        step("Change customer info to default values", () -> {
            $("#Email").setValue(login);
            $(byName("save-info-button")).click();
            $(".account").shouldHave(text(login));
        });
    }
}
