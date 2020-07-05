package com.jpetstore.driver;

import com.jpetstore.util.PropKey;
import com.jpetstore.util.PropertyReader;
import com.jpetstore.util.TimeUtil;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static com.jpetstore.util.TimeUtil.getImplicitWait;

public class DriverFactory {

    public static PropertyReader prop;
    protected static WebDriver driver = null;
    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    /**
     * Method to get webdriver
     * @return
     */
    public static WebDriver getDriver() {

        if(driver == null) {
            driverThreadLocal.set(getBrowser().getWebDriver());
        }
        driverThreadLocal.get().manage().timeouts().implicitlyWait(getImplicitWait(), TimeUnit.SECONDS);
        return driverThreadLocal.get();
    }

    /**
     * Method to quit webdriver
     */
    public static void quitDriver() {
        driverThreadLocal.get().quit();
    }


    /**
     * determine browser
     * @return
     */
    private static BrowserType getBrowser() {
        if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("CHROME")) {
            return BrowserType.CHROME;
        }else if(prop.getProperty(PropKey.BROWSER.getPropVal()).equalsIgnoreCase("FIREFOX")) {
            return BrowserType.FIREFOX;
        } else {
            return BrowserType.FIREFOX;
        }
    }
}
