package iUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import xPathLlibrary.Library.iUALoginLibrary;
import adstractElements.AbstractPage;
import adstractElements.ILoginPage;

public class IUALoginPage extends AbstractPage implements ILoginPage {

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

	@FindBy(xpath = iUALoginLibrary.USERNAME_INPUT_XPATH)
    private WebElement usernameField;

    @FindBy(xpath = iUALoginLibrary.PASSWORD_INPUT_XPATH)
    private WebElement passwordField;

    @FindBy(xpath = iUALoginLibrary.SUBMIT_XPATH)
    private WebElement submitBTN;
    
    
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
