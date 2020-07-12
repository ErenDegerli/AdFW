package com.jpetstore.tests;

import com.jpetstore.driver.DriverManager;
import com.jpetstore.util.PropKey;
import org.junit.jupiter.api.*;

import static com.jpetstore.util.PropKey.PORT;
import static com.jpetstore.util.PropKey.URL;

@Disabled
@DisplayName("My Browser Tests")
@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class MySecondTest extends DriverManager {

    @Disabled
    @Test
    @DisplayName("This is my second selenium test!")
    void launchBrowser() throws InterruptedException {

        String url = prop.getProperty(URL.getPropVal());
        String port = prop.getProperty(PORT.getPropVal());
        String finalUrl = url + port;

        driver.get(finalUrl);
    }
}