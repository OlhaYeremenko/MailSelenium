package com.epam.preproduction.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.ILoginPage;


public class LoginYandexPage extends AbstractPage implements ILoginPage {

	public static final String USERNAME_INPUT_XPATH = "//input[@name='login']";
	public static final String PASSWORD_INPUT_XPATH = "//input[@name='passwd']";
	public static final String SUBMIT_BTN_XPATH = "//div[@class='new-left']//button[@type='submit']";;

	@FindBy(xpath = USERNAME_INPUT_XPATH)
	private WebElement usernameField;

	@FindBy(xpath = PASSWORD_INPUT_XPATH)
	private WebElement passwordField;

	@FindBy(xpath = SUBMIT_BTN_XPATH)
	private WebElement submitBTN;

	public LoginYandexPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	public WebElement getUsernameField() {
		return usernameField;
	}

	public WebElement getPasswordField() {
		return passwordField;
	}

	public WebElement getSubmitBTN() {
		return submitBTN;
	}

	@Override
	public LoginYandexPage inputUserName(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	@Override
	public LoginYandexPage inputPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	@Override
	public RecivedMailPage submitLogin() {
		submitBTN.click();
		return new RecivedMailPage(driver);
	}

}
