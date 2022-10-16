package tests.demowebshop;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.AllureAttachments;
import helpers.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBaseWithUi {

    @BeforeAll
    static void setUp() {
        DriverSettings.configure();
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
