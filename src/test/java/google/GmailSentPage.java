package google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;











import xPathLlibrary.Library.gmailLoginLibrary;
import xPathLlibrary.Library.gmailPageLibrary;
import xPathLlibrary.Library.yandexMailPageLibrary;
import adstractElements.AbstractPage;
import adstractElements.IMailPage;

public class GmailSentPage extends AbstractPage implements IMailPage {


	public GmailSentPage(WebDriver driver) {
		super(driver);
	 PageFactory.initElements(driver, this);

	}
      GmailMessagePage mailpage;
      GmailDraftsPage draftspage;
      

      @FindBy(xpath = gmailPageLibrary.COMPOSE_BTN_XPATH)
      private WebElement composeBTN;

    @FindBy(xpath = gmailPageLibrary.DRAFTS_TAB_XPATH)
    private WebElement draftsMenuItem;

    @FindBy(xpath = gmailPageLibrary.SENT_MAIL_TAB_XPATH)
    private WebElement sentMenuItem;
    

    @FindBy(xpath = gmailPageLibrary.LOGOUT_XPATH)     
    private WebElement logOutBTN;
    
    @FindBy(xpath = gmailPageLibrary.USER_LOGO_PIC_XPATH)
    private WebElement logPicTitle;
    
    
    @Override
	public GmailMessagePage composeMailBtnClick() {
		composeBTN.click();
		return  new GmailMessagePage(driver);
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
