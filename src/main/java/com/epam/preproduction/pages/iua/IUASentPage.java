package com.epam.preproduction.pages.iua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailPage;

public class IUASentPage extends AbstractPage implements IMailPage {

	public static final String COMPOSE_BTN_XPATH = "//p[@class='make_message']/a";
	public static final String SETTING = ".//*[contains (@class,'ho_settings')]";
	public static final String DRAFTS_TAB_XPATH = "//a[contains(@href, 'drafts')]";
	public static final String MAIN_PAGE_BUTTON_XPATH = "//li//a[contains (@href,'www.i.ua')]";
	public static final String LOGOUT_BTN_XPATH = "//a[contains (@href , 'logout') ]";// "//li[@class = 'right']/a[contains(@href, 'logout.php')]";

	IUAMessagePage mailpage;
	IUADraftsPage draftspage;

	@FindBy(xpath = COMPOSE_BTN_XPATH)
	private WebElement composeBTN;

	@FindBy(xpath = DRAFTS_TAB_XPATH)
	private WebElement draftsMenuItem;

	@FindBy(xpath = MAIN_PAGE_BUTTON_XPATH)
	private WebElement sentMenuItem;

	@FindBy(xpath = LOGOUT_BTN_XPATH)
	private WebElement logOutBTN;

	@FindBy(xpath = SETTING)
	private WebElement logPicTitle;

	public IUASentPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@Override
	public IUAMessagePage composeMailBtnClick() {
		composeBTN.click();
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
		return this;
	}

	public IUASentPage logoClick() {
		logPicTitle.click();
		return this;
	}

	@Override
	public IUALoginPage logOutBtnClick() {

		logOutBTN.click();
		return new IUALoginPage(driver);
	}

}
