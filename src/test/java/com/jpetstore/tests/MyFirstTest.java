package com.jpetstore.tests;

import com.jpetstore.driver.DriverManager;
import org.junit.jupiter.api.*;
import static com.jpetstore.util.PropKey.PORT;
import static com.jpetstore.util.PropKey.URL;

@DisplayName("My Browser Tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MyFirstTest extends DriverManager {

    @Test
    //@DisplayName("This is my first selenium test!")
    void this_is_my_first_selenium_test() {

        String url = prop.getProperty(URL.getPropVal());
        String port = prop.getProperty(PORT.getPropVal());
        String finalUrl = url + port;

        driver.get(finalUrl);
    }
}