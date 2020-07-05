package com.jpetstore.tests;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import static com.jpetstore.util.PropKey.BROWSER;

public class TestBase {

    static WebDriver driver;
    static PropertyReader propertyReader = PropertyReader.getInstance();

    @BeforeAll
    public static void init() {

        if(propertyReader.getProperty(BROWSER.getPropVal()).equalsIgnoreCase("FIREFOX")) {
            if(propertyReader.getProperty(PropKey.BROWSER_MANAGER.getPropVal()).equalsIgnoreCase("webDriverManager")) {
                WebDriverManager.firefoxdriver().setup();
            }else {
                System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\drivers\\windows\\geckodriver.exe");
            }
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            FirefoxProfile profile = new FirefoxProfile();
            //Accept untrusted certificates
            profile.setAcceptUntrustedCertificates(true);
            profile.setAssumeUntrustedCertificateIssuer(false);
            //Use no proxy settings
            profile.setPreference("network.proxy.type",0);
            //Set firefox profile to capabilities
            firefoxOptions.setCapability(FirefoxDriver.PROFILE, profile);
            driver = new FirefoxDriver(firefoxOptions);

        }else if(propertyReader.getProperty(BROWSER.getPropVal()).equalsIgnoreCase("CHROME")) {
            if(propertyReader.getProperty(PropKey.BROWSER_MANAGER.getPropVal()).equalsIgnoreCase("webDriverManager")) {
                WebDriverManager.chromedriver().setup();
            }else {
                System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\drivers\\windows\\chromedriver.exe");
            }
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--ignore-certificate-errors");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--incognito");
            options.addArguments("--window-size=1920,1080");
            options.setAcceptInsecureCerts(true);
            driver = new ChromeDriver(options);
        }
    }

    @AfterAll
    public static void cleanUp() {
        driver.quit();
    }
}
