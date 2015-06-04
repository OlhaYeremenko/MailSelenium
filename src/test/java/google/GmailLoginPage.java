package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import xPathLlibrary.Library.gmailLoginLibrary;
import xPathLlibrary.Library.yandexLoginLibrary;
import adstractElements.AbstractPage;
import adstractElements.ILoginPage;

public class GmailLoginPage extends AbstractPage implements ILoginPage {

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

	@FindBy(xpath = gmailLoginLibrary.USERNAME_INPUT_XPATH)
    private WebElement usernameField;

    @FindBy(xpath = gmailLoginLibrary.PASSWORD_INPUT_XPATH)
    private WebElement passwordField;

    @FindBy(xpath = gmailLoginLibrary.SUBMIT_XPATH)
    private WebElement submitBTN;
    
    @FindBy(xpath = gmailLoginLibrary.NEXT_BTN_XPATH)
    private WebElement nextBtn;
    
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
