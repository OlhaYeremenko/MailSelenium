package com.epam.preproduction.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.helper.Waiter;
import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailInputForm;

public class MessageMailPage extends AbstractPage implements IMailInputForm {

	public static final String TO_XPATH = ".//*[@id='js-page']//form/table/tbody/tr[3]/td[2]//input[@type='text']";// ".//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div[2]/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div";//"//*[@id='js-page']/div/div[5]/div/div[3]/div/div[3]/div/div/div/div/div/div/form/table/tbody/tr[3]/td[2]/div[2]/div/div/input";
	public static final String SUBJECT_XPATH = ".//input[@id='compose-subj']";
	public static final String BODY_XPATH = "//textarea[@id='compose-send']";
	public static final String SEND_BTN_XPATH = "//*[@id='compose-submit']";
	public static final String CANCEL_BTN_XPATH = "//div[contains(@class, 'message__left')]//button[contains(@data-action, 'close')]";
	public static final String SAVE_AND_QUIT_BTN_XPATH = "//button[contains(@data-action, 'dialog.save')]";

	@FindBy(xpath = SUBJECT_XPATH)
	private WebElement subjectField;

	@FindBy(xpath = BODY_XPATH)
	private WebElement textField;

	@FindBy(xpath = SEND_BTN_XPATH)
	private WebElement sendBTN;

	@FindBy(xpath = SAVE_AND_QUIT_BTN_XPATH)
	private WebElement saveAndQuitBTN;
	@FindBy(xpath = CANCEL_BTN_XPATH)
	private WebElement cancelBNT;

	public MessageMailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = TO_XPATH)
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
		Waiter.waitForElementPresent(this.getDriver(), SAVE_AND_QUIT_BTN_XPATH);
		saveAndQuitBTN.click();
		return new RecivedMailPage(driver);
	}

	@Override
	public RecivedMailPage sendMail() {
		sendBTN.submit();
		return new RecivedMailPage(driver);
	}

}
