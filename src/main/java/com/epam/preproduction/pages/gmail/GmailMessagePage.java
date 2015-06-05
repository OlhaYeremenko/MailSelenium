package com.epam.preproduction.pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailInputForm;

public class GmailMessagePage extends AbstractPage implements IMailInputForm {

	public static final String FORM_TO_XPATH = "//textarea[@name='to']";
	public static final String FORM_SUBJ_XPATH = "//input[@name='subjectbox']";
	public static final String FORM_TEXT_XPATH = "//div[@role='textbox']";
	public static final String FORM_SENDBTN_XPATH = "//tbody//div[count(div) = 2]/div[@role='button' and @data-tooltip]";// "//div[contains(@aria-label,'Отпра')]";//
	public static final String FORM_SAVE_AND_QUITBTN_XPATH = ".//img[3]";

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
		return new GmailRecivedPage(driver);
	}

}
