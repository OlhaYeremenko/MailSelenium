package com.epam.preproduction.pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.ILoginPage;

public class GmailLoginPage extends AbstractPage implements ILoginPage {

	public static final String USERNAME_INPUT_XPATH = "//input[@id='Email']";
	public static final String NEXT_BTN_XPATH = "//input[@id='next']";
	public static final String PASSWORD_INPUT_XPATH = "//input[@id='Passwd']";
	public static final String SUBMIT_XPATH = "//input[@id='signIn']";

	@FindBy(xpath = USERNAME_INPUT_XPATH)
	private WebElement usernameField;

	@FindBy(xpath = PASSWORD_INPUT_XPATH)
	private WebElement passwordField;

	@FindBy(xpath = SUBMIT_XPATH)
	private WebElement submitBTN;

	@FindBy(xpath = NEXT_BTN_XPATH)
	private WebElement nextBtn;

	public GmailLoginPage(WebDriver driver) {
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

	public GmailLoginPage nextBtnClick() {
		nextBtn.click();
		return this;
	}

	@Override
	public GmailLoginPage inputUserName(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	@Override
	public GmailLoginPage inputPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	@Override
	public GmailRecivedPage submitLogin() {
		submitBTN.click();
		return new GmailRecivedPage(driver);
	}

}
