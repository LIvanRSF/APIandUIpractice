package helpers;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    String regFirstName = faker.name().firstName();
    String regLastName = faker.name().lastName();
    String regEmail = faker.internet().emailAddress();
    String regPassword = faker.internet().password();
}
