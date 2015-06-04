package yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import xPathLlibrary.Library.yandexLoginLibrary;
import adstractElements.AbstractPage;
import adstractElements.ILoginPage;

public class LoginYandexPage extends AbstractPage implements ILoginPage {

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

	@FindBy(xpath = yandexLoginLibrary.USERNAME_INPUT_XPATH)
    private WebElement usernameField;

    @FindBy(xpath = yandexLoginLibrary.PASSWORD_INPUT_XPATH)
    private WebElement passwordField;

    @FindBy(xpath = yandexLoginLibrary.SUBMIT_BTN_XPATH)
    private WebElement submitBTN;
    
    
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
