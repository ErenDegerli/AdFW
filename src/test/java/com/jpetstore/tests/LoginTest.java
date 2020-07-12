package com.jpetstore.tests;

import com.jpetstore.steps.JPetstoreSteps;
import io.github.artsok.RepeatedIfExceptionsTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.jpetstore.tags.JPetStoreTags.SMOKE;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(TestListener.class)
@DisplayName("Login Tests")
public class LoginTest extends JPetstoreSteps {

    @Tag(SMOKE)
    @Test
    @DisplayName("As a valid user, a user must be able to login with valid credentials.")
    @Description("Logging into the app via sign on page")
    void doLogin() {
        navigateToApp();
        navigateToSignInpage();
        doLogin("test", "test");

        assertEquals("Welcome test!" , getGreetingMessage());

        /*Soft assertions
        assertAll(
                () -> assertEquals("Welcome John!" , getGreetingMessage()),
                () -> assertEquals("Welcome test!" , getGreetingMessage()),
                () -> assertEquals("hello test!" , getGreetingMessage())
        );*/
    }

    /*
    @Nested
    class NegativeTests {
        @Test
        @DisplayName("User must not be able to login with invalid credentials")
        void invalidLogin() {
            navigateToApp();

            navigateToSignInpage();
            doLogin("j2ee", "j233434");

            assertEquals("Invalid username or password. Signon failed.", getMessageOnInvalidLogin());
        }

        @Nested
        class NegativeTestsLogin {
            @Test
            @DisplayName("User must not be able to login with invalid credentials")
            void invalidLogin() {
                navigateToApp();
                navigateToSignInpage();
                doLogin("j2ee", "j233434");

                assertEquals("Invalid username or password. Signon failed.", getMessageOnInvalidLogin());
            }
        }
    }*/
}
