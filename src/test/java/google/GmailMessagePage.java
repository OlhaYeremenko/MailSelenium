package google;

import helpers.Waiter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import xPathLlibrary.Library.gmailPageLibrary;
import adstractElements.AbstractPage;
import adstractElements.IMailInputForm;

public class GmailMessagePage extends AbstractPage implements IMailInputForm{

	public GmailMessagePage(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, this);
	
	}



    public WebElement getToField() {
		return toField;
	}

	public WebElement getSubjectField() {
		return subjectField;
	}

	public WebElement getTextField() {
		return textField;
	}
	
	@FindBy(xpath = gmailPageLibrary.FORM_TO_XPATH)
    private WebElement toField;

	@FindBy(xpath = gmailPageLibrary.FORM_SUBJ_XPATH)
    private WebElement subjectField;

    @FindBy(xpath = gmailPageLibrary.FORM_TEXT_XPATH)
    private WebElement textField;
    
    @FindBy(xpath = gmailPageLibrary.FORM_SENDBTN_XPATH)
    private WebElement sendBTN;
    
    @FindBy(xpath = gmailPageLibrary.FORM_SAVE_AND_QUITBTN_XPATH)
    private WebElement saveAndQuitBTN;

	
    @Override
	public GmailMessagePage inputSenderReceiver(String email) {
		toField.sendKeys(email);
		return this;
	}

    @Override
	public GmailMessagePage inputSubject(String subject) {
    subjectField.sendKeys(subject);
	return this;
	}

    @Override
	public GmailMessagePage inputContent(String text) {
		textField.sendKeys(text);
		return this;
	}
	@Override

	public GmailRecivedPage saveAndExit() {
		saveAndQuitBTN.click();
		return new GmailRecivedPage(driver);
	}

	@Override
	public GmailRecivedPage sendMail() {
		sendBTN.click();
		return  new GmailRecivedPage(driver);
	}
	

}
