package iUA.stepsToReproduce;


import iUA.IUALoginPage;
import iUA.IUARecivedPage;
import iUA.IUASentPage;
import helpers.AssertsLibrary;
import helpers.Waiter;

import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;

import xPathLlibrary.Library.gmailLoginLibrary;
import xPathLlibrary.Library.gmailPageLibrary;
import xPathLlibrary.Library.iUALoginLibrary;
import xPathLlibrary.Library.iUAPageLibrary;


public class IUALoginSteps {

		IUALoginPage loginPage;
		IUASentPage sentPage;
		IUARecivedPage recivedPage;
	
		
		
		public IUALoginSteps(WebDriver driver) {
			loginPage=new IUALoginPage(driver);
	 	}
		
		public IUASentMailSteps loginAction() {
			
			loginPage.openPage(iUALoginLibrary.URL);	
			
			Waiter.waitForElementPresent(loginPage.getDriver(), iUALoginLibrary.USERNAME_INPUT_XPATH);	
			 
	    	AssertsLibrary.assertIUAMailTitle(loginPage.getDriver());
	    	

		    recivedPage=loginPage.inputUserName(iUALoginLibrary.USERNAME).inputPassword(iUALoginLibrary.PASSWORD).submitLogin();
		  

		    
		    
		    Waiter.waitForElementPresent(loginPage.getDriver(), iUAPageLibrary.COMPOSE_BTN_XPATH );	   
		  
		    return new IUASentMailSteps(recivedPage);	
		   	}
		
		
		
		
	}


