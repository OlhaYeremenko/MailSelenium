package com.epam.preproduction.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailPage;

public class DraftsYandexPage extends AbstractPage implements IMailPage {

	public static final String COMPOSED_DRAFT_XPATH = "//div[@class='b-messages']/div[1]//span/span[contains(@class, 'firstline-wrapper')]";
	public static final String DRAFTS_MENU_XPATH = "//a[contains(@title,'Drafts') and contains(text(),'Drafts') ]";
	public static final String COMPOSE_BTN_XPATH = "//a[contains(@href, 'compose')]/img";
	public static final String SENT_MENU_XPATH = "//div[@class='block-app']//a[contains(@href, 'sent')]";
	public static final String LOGOUT_BTN_XPATH = "//a[@class='b-mail-dropdown__item__content' and contains(text(), 'Log out')]";

	@FindBy(xpath = COMPOSE_BTN_XPATH)
	private WebElement composeBTN;

	@FindBy(xpath = DRAFTS_MENU_XPATH)
	private WebElement draftsMenuItem;

	@FindBy(xpath = SENT_MENU_XPATH)
	private WebElement sentMenuItem;

	@FindBy(xpath = COMPOSED_DRAFT_XPATH)
	private WebElement composedDraft;

	@FindBy(xpath = LOGOUT_BTN_XPATH)
	private WebElement logOutBTN;

	public DraftsYandexPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public MessageMailPage composeMailBtnClick() {
		composedDraft.click();
		return new MessageMailPage(driver);
	}

	@Override
	public DraftsYandexPage draftsMenuItemClick() {
		draftsMenuItem.click();
		return new DraftsYandexPage(driver);
	}

	@Override
	public SentMailPage sentMenuItemClick() {
		sentMenuItem.click();
		return new SentMailPage(driver);
	}

	@Override
	public LoginYandexPage logOutBtnClick() {
		logOutBTN.click();
		return new LoginYandexPage(driver);
	}

}
