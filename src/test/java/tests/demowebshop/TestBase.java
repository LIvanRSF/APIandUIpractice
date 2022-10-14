package tests.demowebshop;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.demowebshop.App;
import helpers.AllureAttachments;
import helpers.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase {
    @BeforeAll
    static void setUp() {
        DriverSettings.configure();

        RestAssured.baseURI = App.config.apiBaseURI();
        Configuration.baseUrl = App.config.webBaseURL();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterAll() {
        AllureAttachments.addScreenshot();
        AllureAttachments.addConsoleLog();
        AllureAttachments.addPageSource();

        Selenide.closeWebDriver();
    }
}