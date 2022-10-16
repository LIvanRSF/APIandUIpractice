package tests.demowebshop;

import static helpers.CustomApiListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class DemoWebShopApiTests extends TestBaseApi{

    @Test
    @Tag("demowebshop")
    @DisplayName("Add product to cart without registration")
    void addToCartAnonim() {

        String body = "addtocart_31.EnteredQuantity=1";
        given()
            .filter(withCustomTemplates())
            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
            .cookie("Nop.customer", "bcde825c-656f-442d-9469-f54e00f127b3")
            .body(body)
            .log().all()
            .when()
            .post("/addproducttocart/details/31/1")
            .then()
            .log().all()
            .statusCode(200)
            .body("success", Matchers.is(true));
    }
}
