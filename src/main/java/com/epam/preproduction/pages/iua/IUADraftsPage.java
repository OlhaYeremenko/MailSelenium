package com.epam.preproduction.pages.iua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailPage;

public class IUADraftsPage extends AbstractPage implements IMailPage {

	public static final String DRAFTS_TAB_XPATH = "//a[contains(@href, '#drafts')]";
	public static final String SENT_MAIL_TAB_XPATH = "//a[contains(@href, 'sent-mail')]";
	public static final String DRAFT_XPATH = ".//*[@id='mesgList']//div[1]//span[3]/span";
	public static final String LOGOUT_BTN_XPATH = "//a[contains (@href , 'logout') ]";
	public static final String COMPOSE_BTN_XPATH = "//p[@class='make_message']/a";


	@FindBy(xpath = COMPOSE_BTN_XPATH)
	private WebElement composeBTN;

	@FindBy(xpath = DRAFTS_TAB_XPATH)
	private WebElement draftsMenuItem;

	@FindBy(xpath = SENT_MAIL_TAB_XPATH)
	private WebElement sentMenuItem;

	@FindBy(xpath = DRAFT_XPATH)
	private WebElement composedDraft;

	@FindBy(xpath = LOGOUT_BTN_XPATH)
	private WebElement logOutBTN;
	
	public IUADraftsPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public IUAMessagePage composeMailBtnClick() {
		composedDraft.click();
		return new IUAMessagePage(driver);
	}

	@Override
	public IUADraftsPage draftsMenuItemClick() {
		draftsMenuItem.click();
		return new IUADraftsPage(driver);
	}

	@Override
	public IUASentPage sentMenuItemClick() {
		sentMenuItem.click();
		return new IUASentPage(driver);
	}

	@Override
	public IUALoginPage logOutBtnClick() {
		logOutBTN.click();
		return new IUALoginPage(driver);
	}

}
