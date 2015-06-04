package yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import xPathLlibrary.Library.yandexMailPageLibrary;
import adstractElements.AbstractPage;
import adstractElements.IMailPage;

public class DraftsYandexPage  extends AbstractPage implements IMailPage{

	public DraftsYandexPage(WebDriver driver) {
		super(driver);
		   PageFactory.initElements(driver, this);
	}

	   @FindBy(xpath = yandexMailPageLibrary.COMPOSE_BTN_XPATH)
	    private WebElement composeBTN;

	   @FindBy(xpath = yandexMailPageLibrary.DRAFTS_MENU_XPATH)
		private WebElement draftsMenuItem;

		@FindBy(xpath = yandexMailPageLibrary.SENT_MENU_XPATH)
		private WebElement sentMenuItem;

	    @FindBy(xpath = yandexMailPageLibrary.COMPOSED_DRAFT_XPATH)
	    private WebElement composedDraft;

	    @FindBy(xpath = yandexMailPageLibrary.LOGOUT_BTN_XPATH)
		private WebElement logOutBTN;
	
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
