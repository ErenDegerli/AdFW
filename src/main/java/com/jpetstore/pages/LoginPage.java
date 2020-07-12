package com.jpetstore.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    private static final String USER_NAME_INPUT = "//*[@id='Catalog']//input[@name='username']";

    private static final String PASSWORD_INPUT = "//*[@id='Catalog']//input[@name='password']";

    private static final String LOGIN_BUTTON = "//*[@id='Catalog']//input[contains(@value,'Login')]";

    private static final String REGISTER_NOW_LINK = "//*[@id='Catalog']//a[contains(text(),'Register Now!')]";

    private static final String INVALID_LOGIN_LABEL = "//*[@id='Content']/ul/li";

    private WebDriver driver = getDriver();

    @FindBy(xpath = LOGIN_BUTTON)
    private WebElement loginBtn;

    public DashBoardPage doLogin(String userName, String password) {
        enterTextIntoTextBox(By.xpath(USER_NAME_INPUT), userName);
        enterTextIntoTextBox(By.xpath(PASSWORD_INPUT), password);
        clickLinkOrBtn(loginBtn);

        return new DashBoardPage(driver);
    }

    public AccountsPage navigateToRegistrationPage() {
        clickLinkOrBtn(By.xpath(REGISTER_NOW_LINK));
        return new AccountsPage(driver);
    }

    public String getMessageOnInvalidLogin() {
        return getTextFromElement(By.xpath(INVALID_LOGIN_LABEL));
    }
}
