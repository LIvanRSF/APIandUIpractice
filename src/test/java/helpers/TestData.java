package helpers;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String regFirstName = faker.name().firstName(),
        regLastName = faker.name().lastName(),
        regEmail = faker.internet().emailAddress(),
        regPassword = faker.internet().password();
}
