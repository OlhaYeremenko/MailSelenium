package iUA;

import helpers.Waiter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import xPathLlibrary.Library.gmailPageLibrary;
import xPathLlibrary.Library.iUAPageLibrary;
import adstractElements.AbstractPage;
import adstractElements.IMailInputForm;

public class IUAMessagePage extends AbstractPage implements IMailInputForm{

	public IUAMessagePage(WebDriver driver) {
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
	
	@FindBy(xpath = iUAPageLibrary.FORM_TO_XPATH)
    private WebElement toField;

	@FindBy(xpath = iUAPageLibrary.FORM_SUBJ_XPATH)
    private WebElement subjectField;

    @FindBy(xpath = iUAPageLibrary.FORM_TEXT_XPATH)
    private WebElement textField;
    
    @FindBy(xpath = iUAPageLibrary.FORM_SENDBTN_XPATH)
    private WebElement sendBTN;
    
    @FindBy(xpath = iUAPageLibrary.FORM_SAVE_AND_QUITBTN_XPATH)
    private WebElement saveAndQuitBTN;

	
	
    @Override
    public IUAMessagePage inputSenderReceiver(String email) {
		toField.sendKeys(email);
		return this;
	}

	@Override
	public IUAMessagePage inputSubject(String subject) {
    subjectField.sendKeys(subject);
	return this;
	}
	
	@Override
	public IUAMessagePage inputContent(String text) {
		textField.sendKeys(text);
		return this;
	}

	@Override
	public IUARecivedPage saveAndExit() {
		saveAndQuitBTN.click();
		return new IUARecivedPage(driver);
	}

	@Override
	public IUARecivedPage sendMail() {
		sendBTN.click();
		return  new IUARecivedPage(driver);
	}
	

}
