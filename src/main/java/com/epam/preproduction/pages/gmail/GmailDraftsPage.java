package com.epam.preproduction.pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailPage;

public class GmailDraftsPage extends AbstractPage implements IMailPage {

	public static final String COMPOSE_BTN_XPATH = "//div[@role='button' and @gh and contains(@class, 'T')]";
	public static final String DRAFTS_LETTER_XPATH = "//span[contains(text(),'my subject is :')]";
	public static final String SENT_MAIL_TAB_XPATH = ".//a[contains(@href,'#sent')]";// "//a[contains(@href, 'https://mail.google.com/mail/?pli=1#sent')]";
	public static final String DRAFTS_TAB_XPATH = "//a[contains(@href, '#drafts')]";// "//a[contains(@href, 'https://mail.google.com/mail/?pli=1#drafts')]";
	public static final String LOGOUT_BTN_XPATH = "//a[contains(@href, 'logout')]";

	@FindBy(xpath = COMPOSE_BTN_XPATH)
	private WebElement composeBTN;

	@FindBy(xpath = DRAFTS_TAB_XPATH)
	private WebElement draftsMenuItem;

	@FindBy(xpath = SENT_MAIL_TAB_XPATH)
	private WebElement sentMenuItem;

	@FindBy(xpath = DRAFTS_LETTER_XPATH)
	private WebElement composedDraft;

	@FindBy(xpath = LOGOUT_BTN_XPATH)
	private WebElement logOutBTN;

	public GmailDraftsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public GmailMessagePage composeMailBtnClick() {
		composedDraft.click();
		return new GmailMessagePage(driver);
	}

	@Override
	public GmailDraftsPage draftsMenuItemClick() {
		draftsMenuItem.click();
		return new GmailDraftsPage(driver);
	}

	@Override
	public GmailSentPage sentMenuItemClick() {
		sentMenuItem.click();
		return new GmailSentPage(driver);
	}

	@Override
	public GmailLoginPage logOutBtnClick() {
		logOutBTN.click();
		return new GmailLoginPage(driver);
	}

}
