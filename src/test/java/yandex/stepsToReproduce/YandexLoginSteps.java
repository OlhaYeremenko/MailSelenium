package yandex.stepsToReproduce;

import helpers.AssertsLibrary;
import helpers.Waiter;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import xPathLlibrary.Library.yandexLoginLibrary;
import xPathLlibrary.Library.yandexMailPageLibrary;
import yandex.LoginYandexPage;
import yandex.SentMailPage;
import yandex.RecivedMailPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class YandexLoginSteps {

	LoginYandexPage loginPage;
	SentMailPage personalPage;
	RecivedMailPage recivedPage;
	@FindBy(xpath = yandexMailPageLibrary.LOGIN_TITLE_XPATH)
    private WebElement loginTitle;
	
	
	public YandexLoginSteps(WebDriver driver) {
		loginPage=new LoginYandexPage(driver);
 	}
	
	public YandexSentMailSteps loginAction() {
		loginPage.openPage(yandexLoginLibrary.URL);	
		
    	AssertsLibrary.assertYandexMailTitle(loginPage.getDriver());
    	
	    recivedPage=loginPage.inputUserName(yandexLoginLibrary.USERNAME).inputPassword(yandexLoginLibrary.PASSWORD).submitLogin();
	  
	    Waiter.waitForElementPresent(loginPage.getDriver(), yandexLoginLibrary.INBOX_MENU_XPATH );	   
	    AssertsLibrary.assertYandexMailTitle(loginPage.getDriver());
	  
	    return new YandexSentMailSteps(recivedPage);	
	   	}
	
	
	
	
}
