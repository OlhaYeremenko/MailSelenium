package yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




import xPathLlibrary.Library.yandexMailPageLibrary;
import adstractElements.AbstractPage;
import adstractElements.IMailPage;

public class SentMailPage extends AbstractPage implements IMailPage {


	public SentMailPage(WebDriver driver) {
		super(driver);
	 PageFactory.initElements(driver, this);

	}
      MessageMailPage mailpage;
      DraftsYandexPage draftspage;
      
//	@FindBy(xpath = yandexMailPageLibrary.COMPOSE_BTN_XPATH)
//    @FindBy(xpath = "//a[contains(@title, 'Compose (w, c)')]")
      @FindBy(xpath = "//a[contains(@href, 'compose')]/img")
      private WebElement composeBTN;

    @FindBy(xpath = yandexMailPageLibrary.DRAFTS_MENU_XPATH)
    private WebElement draftsMenuItem;

    @FindBy(xpath = yandexMailPageLibrary.SENT_MENU_XPATH)
    private WebElement sentMenuItem;
    
//    @FindBy(xpath = yandexMailPageLibrary.LOGOUT_BTN_XPATH)
    @FindBy(xpath = ".//*[@id='user-dropdown-popup']/div/div/div[11]/a") 
    private WebElement logOutBTN;
    
    @FindBy(xpath = yandexMailPageLibrary.LOGO_PIC_XPATH)
    private WebElement logPicTitle;
    
    
	@Override
	public MessageMailPage composeMailBtnClick() {
		composeBTN.click();
		return  new MessageMailPage(driver);
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
