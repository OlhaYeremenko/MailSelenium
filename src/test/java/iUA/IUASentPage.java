package iUA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;










import xPathLlibrary.Library.iUAPageLibrary;
import xPathLlibrary.Library.yandexMailPageLibrary;
import adstractElements.AbstractPage;
import adstractElements.IMailPage;

public class IUASentPage extends AbstractPage implements IMailPage {


	public IUASentPage(WebDriver driver) {
		super(driver);
	 PageFactory.initElements(driver, this);

	}
      IUAMessagePage mailpage;
      IUADraftsPage draftspage;

      @FindBy(xpath = iUAPageLibrary.COMPOSE_BTN_XPATH)
      private WebElement composeBTN;

    @FindBy(xpath = iUAPageLibrary.DRAFTS_TAB_XPATH)
    private WebElement draftsMenuItem;

    @FindBy(xpath = iUAPageLibrary.MAIN_PAGE_BUTTON_XPATH)
    private WebElement sentMenuItem;
    
   @FindBy(xpath = iUAPageLibrary.LOGOUT_BTN_XPATH)
    private WebElement logOutBTN;
    
    @FindBy(xpath = iUAPageLibrary.SETTING)
    private WebElement logPicTitle;
    
    @Override    
	
	public IUAMessagePage composeMailBtnClick() {
		composeBTN.click();
		return  new IUAMessagePage(driver);
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
