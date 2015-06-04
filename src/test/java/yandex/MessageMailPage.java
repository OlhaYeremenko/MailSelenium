package yandex;

import helpers.Waiter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import xPathLlibrary.Library.yandexMailPageLibrary;
import adstractElements.AbstractPage;
import adstractElements.IMailInputForm;

public class MessageMailPage extends AbstractPage implements IMailInputForm{

	public MessageMailPage(WebDriver driver) {
		super(driver);
	    PageFactory.initElements(driver, this);
	
	}

	
	@FindBy(xpath = yandexMailPageLibrary.TO_XPATH)
	
    private WebElement toField;

    public WebElement getToField() {
		return toField;
	}

	public WebElement getSubjectField() {
		return subjectField;
	}

	public WebElement getTextField() {
		return textField;
	}


	@FindBy(xpath = yandexMailPageLibrary.SUBJECT_XPATH)
    private WebElement subjectField;

    @FindBy(xpath = yandexMailPageLibrary.BODY_XPATH)
    private WebElement textField;
    
    @FindBy(xpath = yandexMailPageLibrary.SEND_BTN_XPATH)
    private WebElement sendBTN;
    
    @FindBy(xpath = yandexMailPageLibrary.SAVE_AND_QUIT_BTN_XPATH)
    private WebElement saveAndQuitBTN;
    @FindBy(xpath = yandexMailPageLibrary.CANCEL_BTN_XPATH)
    private WebElement cancelBNT;
	
	@Override
	public MessageMailPage inputSenderReceiver(String email) {
		toField.sendKeys(email);
		return this;
	}

	@Override
	public MessageMailPage inputSubject(String subject) {
    subjectField.sendKeys(subject);
	return this;
	}

	@Override
	public MessageMailPage inputContent(String text) {
		textField.sendKeys(text);
		return this;
	}

	@Override
	public RecivedMailPage saveAndExit() {
		cancelBNT.click();
		Waiter.waitForElementPresent(this.getDriver(),yandexMailPageLibrary.SAVE_AND_QUIT_BTN_XPATH);
		saveAndQuitBTN.click();
		return new RecivedMailPage(driver);
	}

	@Override
	public RecivedMailPage sendMail() {
		sendBTN.submit();
		return  new RecivedMailPage(driver);
	}
	

}
