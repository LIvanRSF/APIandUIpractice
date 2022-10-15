package helpers;

import com.github.javafaker.Faker;

public class TestData {
    Faker faker = new Faker();

    public String regFirstName = faker.name().firstName();
    public String regLastName = faker.name().lastName();
    public String regEmail = faker.internet().emailAddress();
    public String regPassword = faker.internet().password();
}
