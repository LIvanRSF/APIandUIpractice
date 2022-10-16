package tests.demowebshop;

import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.DriverSettings;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBaseApi {

    @BeforeAll
    static void setUp() {
        DriverSettings.configure();
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
