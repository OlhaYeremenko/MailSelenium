package com.epam.preproduction.pages.gmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailPage;

public class GmailSentPage extends AbstractPage implements IMailPage {

	public static final String COMPOSE_BTN_XPATH = "//div[@role='button' and @gh and contains(@class, 'T')]";
	public static final String SENT_MAIL_TAB_XPATH = ".//a[contains(@href,'#sent')]";
	public static final String DRAFTS_TAB_XPATH = "//a[contains(@href, '#drafts')]";
	public static final String FORM_SAVE_AND_QUITBTN_XPATH = ".//img[3]";
	public static final String USER_LOGO_PIC_XPATH = "//a[contains(@title,'Аккаунт')]";
	public static final String LOGOUT_XPATH = "//div/a[@href='https://mail.google.com/mail/logout?hl=ru']";

	GmailMessagePage mailpage;
	GmailDraftsPage draftspage;

	@FindBy(xpath = COMPOSE_BTN_XPATH)
	private WebElement composeBTN;

	@FindBy(xpath = DRAFTS_TAB_XPATH)
	private WebElement draftsMenuItem;

	@FindBy(xpath = SENT_MAIL_TAB_XPATH)
	private WebElement sentMenuItem;

	@FindBy(xpath = LOGOUT_XPATH)
	private WebElement logOutBTN;

	@FindBy(xpath = USER_LOGO_PIC_XPATH)
	private WebElement logPicTitle;

	public GmailSentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@Override
	public GmailMessagePage composeMailBtnClick() {
		composeBTN.click();
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
		return this;
	}

	public GmailSentPage logoClick() {
		logPicTitle.click();
		return this;
	}

	@Override
	public GmailLoginPage logOutBtnClick() {

		logOutBTN.click();
		return new GmailLoginPage(driver);
	}

}
