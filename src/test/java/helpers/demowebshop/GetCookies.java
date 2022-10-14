package helpers.demowebshop;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

public class GetCookies {
    static String cookieName = "NOPCOMMERCE.AUTH";
    static String contentType = "application/x-www-form-urlencoded; charset=UTF-8";

    public static void getAuthorizedCookies(String login, String password) {
        String authorizedCookie = given()
            .contentType(contentType)
            .formParam("Email", login)
            .formParam("Password", password)
            .log().all()
            .when()
            .post("/login")
            .then()
            .log().all()
            .statusCode(302)
            .extract()
            .cookie(cookieName);

        step("Open minimal content, becouse cookie can be set when site is opened", () ->
            open("/Themes/DefaultClean/Content/images/logo.png"));

        step("Set cookie to browser", () ->
            WebDriverRunner.getWebDriver().manage().addCookie
                (new Cookie(cookieName, authorizedCookie)));
    }
}
