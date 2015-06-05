package com.epam.preproduction.pages.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailPage;

public class SentMailPage extends AbstractPage implements IMailPage {

	public static final String DRAFTS_LINK_VERIFY = "//div[@class='block-messages-title']//label[contains(text(),'Drafts')]";
	public static final String DRAFTS_MENU_XPATH = "//a[contains(@title,'Drafts') and contains(text(),'Drafts') ]";
	public static final String COMPOSE_BTN_XPATH = "//a[contains(@href, 'compose')]/img";
	public static final String SENT_MENU_XPATH = "//div[@class='block-app']//a[contains(@href, 'sent')]";
	public static final String LOGOUT_BTN_XPATH = ".//*[@id='user-dropdown-popup']/div/div/div[11]/a";
	public static final String LOGO_PIC_XPATH = "//span[contains(@class, 'user-pic')]";

	MessageMailPage mailpage;
	DraftsYandexPage draftspage;

	@FindBy(xpath = COMPOSE_BTN_XPATH)
	private WebElement composeBTN;

	@FindBy(xpath = DRAFTS_MENU_XPATH)
	private WebElement draftsMenuItem;

	@FindBy(xpath = SENT_MENU_XPATH)
	private WebElement sentMenuItem;

	@FindBy(xpath = LOGOUT_BTN_XPATH)
	private WebElement logOutBTN;

	@FindBy(xpath = LOGO_PIC_XPATH)
	private WebElement logPicTitle;

	public SentMailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);

	}

	@Override
	public MessageMailPage composeMailBtnClick() {
		composeBTN.click();
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
		return this;
	}

	public SentMailPage logoClick() {
		logPicTitle.click();
		return this;
	}

	@Override
	public LoginYandexPage logOutBtnClick() {

		logOutBTN.click();
		return new LoginYandexPage(driver);
	}

}
