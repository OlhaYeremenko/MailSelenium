package google.stepsToReproduce;

import google.GmailLoginPage;
import google.GmailRecivedPage;
import google.GmailSentPage;
import helpers.AssertsLibrary;
import helpers.Waiter;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import xPathLlibrary.Library.gmailLoginLibrary;
import xPathLlibrary.Library.gmailPageLibrary;


public class GmailLoginSteps {

		GmailLoginPage loginPage;
		GmailSentPage sentPage;
		GmailRecivedPage recivedPage;
	
		
		
		public GmailLoginSteps(WebDriver driver) {
			loginPage=new GmailLoginPage(driver);
	 	}
		
		public GmailSentMailSteps loginAction() {
			
			loginPage.openPage(gmailLoginLibrary.URL);	
			
			Waiter.waitForElementPresent(loginPage.getDriver(), gmailLoginLibrary.USERNAME_INPUT_XPATH);	
			 
	    	AssertsLibrary.assertGmailMailTitle(loginPage.getDriver());   	
           
	    	  loginPage = loginPage.inputUserName(gmailLoginLibrary.USERNAME);
	    	  
               //if  2 variant of login
            try {
                loginPage = loginPage.nextBtnClick();

            } catch (NoSuchElementException e) {
                //there is 1 variant of login
            } finally {

                (new WebDriverWait(loginPage.getDriver(), 20)).until(ExpectedConditions.elementToBeClickable(By.xpath(gmailLoginLibrary.PASSWORD_INPUT_XPATH)));
//but we always type password
                recivedPage = loginPage.inputPassword(gmailLoginLibrary.PASSWORD)
                                            .submitLogin();
                   }

		
	    Waiter.waitForElementPresent(loginPage.getDriver(), gmailPageLibrary.COMPOSE_BTN_XPATH );	   
		  
	    return new GmailSentMailSteps(recivedPage);	
		
		}
	}


