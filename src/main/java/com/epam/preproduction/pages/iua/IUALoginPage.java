package com.epam.preproduction.pages.iua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.ILoginPage;

public class IUALoginPage extends AbstractPage implements ILoginPage {

	public static final String USERNAME_INPUT_XPATH = "//input[@name='login']";
	public static final String PASSWORD_INPUT_XPATH = "//input[@name='pass']";
	public static final String SUBMIT_XPATH = "//div[@class='Right']//input[@type='submit']";

	
	@FindBy(xpath = USERNAME_INPUT_XPATH)
	private WebElement usernameField;

	@FindBy(xpath = PASSWORD_INPUT_XPATH)
	private WebElement passwordField;

	@FindBy(xpath = SUBMIT_XPATH)
	private WebElement submitBTN;
	
	public IUALoginPage(WebDriver driver) {
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
	public IUALoginPage inputUserName(String username) {
		usernameField.sendKeys(username);
		return this;
	}

	@Override
	public IUALoginPage inputPassword(String password) {
		passwordField.sendKeys(password);
		return this;
	}

	@Override
	public IUARecivedPage submitLogin() {
		submitBTN.click();
		return new IUARecivedPage(driver);
	}

}
