package com.epam.preproduction.pages.iua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailInputForm;

public class IUAMessagePage extends AbstractPage implements IMailInputForm {

	public static final String FORM_TO_XPATH = "//textarea[@id='to']";
	public static final String FORM_SUBJ_XPATH = "//input[@name='subject']";
	public static final String FORM_TEXT_XPATH = "//textarea[@id='text']";
	public static final String FORM_SENDBTN_XPATH = "//div[@class='Left']/p[1]/input[@name='send']";
	public static final String FORM_SAVE_AND_QUITBTN_XPATH = "//div[@class='Left']/p[1]/input[@name='save_in_drafts']";

	@FindBy(xpath = FORM_TO_XPATH)
	private WebElement toField;

	@FindBy(xpath = FORM_SUBJ_XPATH)
	private WebElement subjectField;

	@FindBy(xpath = FORM_TEXT_XPATH)
	private WebElement textField;

	@FindBy(xpath = FORM_SENDBTN_XPATH)
	private WebElement sendBTN;

	@FindBy(xpath = FORM_SAVE_AND_QUITBTN_XPATH)
	private WebElement saveAndQuitBTN;
	
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
		return new IUARecivedPage(driver);
	}

}
