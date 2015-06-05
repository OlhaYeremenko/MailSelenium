package com.epam.preproduction.pages.iua;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.preproduction.pages.template.AbstractPage;
import com.epam.preproduction.pages.template.IMailPage;

public class IUARecivedPage extends AbstractPage implements IMailPage {

	public static final String COMPOSE_BTN_XPATH = "//p[@class='make_message']/a";
	public static final String SENT_MAIL_TAB_XPATH = "//a[contains(@href, 'sent-mail')]";
	public static final String DRAFTS_TAB_XPATH = "//a[contains(@href, 'drafts')]";
	public static final String LOGOUT_BTN_XPATH = "//a[contains (@href , 'logout') ]";// "//li[@class = 'right']/a[contains(@href, 'logout.php')]";
	public static final String IUA_LOGO = "//img[@alt = 'I.UA']";

	@FindBy(xpath = COMPOSE_BTN_XPATH)
	private WebElement composeBTN;

	@FindBy(xpath = DRAFTS_TAB_XPATH)
	private WebElement draftsMenuItem;

	@FindBy(xpath = SENT_MAIL_TAB_XPATH)
	private WebElement sentMenuItem;

	@FindBy(xpath = LOGOUT_BTN_XPATH)
	private WebElement userLogo;

	@FindBy(xpath = LOGOUT_BTN_XPATH)
	private WebElement logOutBTN;

	public IUARecivedPage(WebDriver driver) {
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
		return new IUASentPage(driver);
	}

	@Override
	public IUALoginPage logOutBtnClick() {
		logOutBTN.click();
		return new IUALoginPage(driver);
	}

	public IUARecivedPage userLogoClick() {
		userLogo.click();
		return this;
	}

}
