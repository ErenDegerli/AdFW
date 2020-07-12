package com.jpetstore.tests;

import com.github.javafaker.Faker;
import com.jpetstore.steps.JPetstoreSteps;
import io.github.artsok.RepeatedIfExceptionsTest;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.jpetstore.tags.JPetStoreTags.REGISTRATION;
import static com.jpetstore.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.*;

@Tag(REGRESSION)
@ExtendWith(TestListener.class)
@DisplayName("Registration Test")
public class RegistrationTest extends JPetstoreSteps {

    @Tag(REGISTRATION)
    @RepeatedIfExceptionsTest(repeats = 3)
    @DisplayName("Add a new user to the store & verify if the")
    void addNewUserToStoreAndVerifyLogin() throws InterruptedException {

        Faker faker = new Faker();

        String userName = "j2ee" + faker.number().randomNumber(10,false);
        String password = faker.internet().password();
        String repeatPassword = password;
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phoneNumber = faker.phoneNumber().cellPhone();
        String addr1 = faker.address().buildingNumber();
        String addr2 = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String zipCode = faker.address().zipCode();
        String country = faker.address().country();

        navigateToApp();
        navigateToSignInpage();
        navigateToRegistrationPage();
        addNewUserInformation(userName,password,repeatPassword);
        addAccountInformation(firstName,lastName,email,phoneNumber,addr1,addr2,city,state,zipCode,country);
        addProfileInformation("english", "DOGS", true, true);
        clickSaveAccountInformation();

        //Login & Verify Account Creation
        Thread.sleep(1000);
        navigateToSignInpage();
        doLogin(userName,password);
        String greetingMessage = getGreetingMessage();
        assertEquals("Welcome " + firstName + "!", greetingMessage);
    }
}
