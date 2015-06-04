package iUA.stepsToReproduce;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import helpers.Waiter;
import iUA.IUADraftsPage;
import iUA.IUALoginPage;
import iUA.IUAMessagePage;
import iUA.IUARecivedPage;
import iUA.IUASentPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import xPathLlibrary.Library.gmailLoginLibrary;
import xPathLlibrary.Library.gmailPageLibrary;
import xPathLlibrary.Library.iUALoginLibrary;
import xPathLlibrary.Library.iUAPageLibrary;

public class IUASentMailSteps {
	IUALoginPage loginPage;
	IUASentPage sentPage;
	IUARecivedPage recivedPage;
	IUAMessagePage messagePage;
	IUADraftsPage draftsPage;
	IUARecivedPage receivedMailPage;

	public IUASentMailSteps(IUARecivedPage recivedPage) {
		this.recivedPage = recivedPage;
	}
	
	  public IUASentMailSteps createMailAndSaveToDrafts() {
		   assertThat(recivedPage.getDriver().getTitle(), containsString("I.UA"));


		   recivedPage.composeMailBtnClick().inputSenderReceiver(iUALoginLibrary.USERNAME)
	                .inputSubject(iUAPageLibrary.FORM_SUBJ)
	                .inputContent(iUAPageLibrary.FORM_TEXT)
	                .saveAndExit();

	        Waiter.waitForElementPresent(recivedPage.getDriver(), iUAPageLibrary.COMPOSE_BTN_XPATH);

	 
	 
	        return this;
	    }

		 public IUASentMailSteps openFromDraftsAndSend() {
			        

				 assertThat(recivedPage.getDriver().getTitle(), containsString("I.UA"));
			        draftsPage = recivedPage.draftsMenuItemClick();

			        
		        Waiter.waitForElementPresent(draftsPage.getDriver(),iUAPageLibrary.DRAFT_XPATH);

		        messagePage = draftsPage.composeMailBtnClick();

		        //aassertThat(messagePage.getDriver().findElement(By.xpath(gmailPageLibrary.DRAFT_FORM_TO_FIELD)).getText(), containsString(iUAPageLibrary.USERNAME));
		        assertThat(messagePage.getSubjectField().getAttribute("value"), containsString(iUAPageLibrary.FORM_SUBJ));
		        assertThat(messagePage.getTextField().getText(), containsString(iUAPageLibrary.FORM_TEXT));

		        receivedMailPage =  messagePage.sendMail();

		        Waiter.waitForElementPresent(receivedMailPage.getDriver(), iUAPageLibrary.SENT_MAIL_TAB_XPATH);

		        sentPage = receivedMailPage.sentMenuItemClick();

		        Waiter.waitForElementPresent(sentPage.getDriver(), iUAPageLibrary.DRAFTS_TAB_XPATH);

		        return this;

			 			 
		 }
		 
		    public IUASentMailSteps logOut() {
		    	
		    	sentPage =  sentPage.sentMenuItemClick(); 
//
//		        Waiter.waitForElementPresent(sentPage.getDriver(), iUAPageLibrary.LOGOUT_BTN_XPATH);
//
//		        loginPage = sentPage.logOutBtnClick();
//
//		        Waiter.waitForElementPresent(loginPage.getDriver(), iUAPageLibrary.IUA_LOGO);
		       return this;
		    }
		}

