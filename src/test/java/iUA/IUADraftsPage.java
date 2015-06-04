package iUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import xPathLlibrary.Library.iUAPageLibrary;
import adstractElements.AbstractPage;
import adstractElements.IMailPage;

public class IUADraftsPage  extends AbstractPage implements IMailPage{

	public IUADraftsPage(WebDriver driver) {
		super(driver);
		   PageFactory.initElements(driver, this);
	}

	   @FindBy(xpath = iUAPageLibrary.COMPOSE_BTN_XPATH)
	    private WebElement composeBTN;

	   @FindBy(xpath = iUAPageLibrary.DRAFTS_TAB_XPATH)
		private WebElement draftsMenuItem;

		@FindBy(xpath = iUAPageLibrary.SENT_MAIL_TAB_XPATH)
		private WebElement sentMenuItem;

	    @FindBy(xpath = iUAPageLibrary.DRAFT_XPATH)
	    private WebElement composedDraft;

	    @FindBy(xpath = iUAPageLibrary.LOGOUT_BTN_XPATH)
		private WebElement logOutBTN;
	
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
