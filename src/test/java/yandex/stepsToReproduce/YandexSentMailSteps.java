package yandex.stepsToReproduce;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import helpers.AssertsLibrary;
import helpers.Waiter;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import xPathLlibrary.Library.yandexLoginLibrary;
import xPathLlibrary.Library.yandexMailPageLibrary;
import yandex.DraftsYandexPage;
import yandex.LoginYandexPage;
import yandex.MessageMailPage;
import yandex.RecivedMailPage;
import yandex.SentMailPage;

public class YandexSentMailSteps {
	LoginYandexPage loginPage;
	MessageMailPage messagePage;
	DraftsYandexPage draftsPage;
	RecivedMailPage recivedPage;
	SentMailPage sentPage;
	RecivedMailPage receivedMailPage;

	public YandexSentMailSteps(RecivedMailPage recivedPage) {
		this.recivedPage = recivedPage;
	}

	public YandexSentMailSteps createMailAndSaveToDrafts() {
		AssertsLibrary.assertLoginTitleAndUserName(recivedPage.getDriver());
		
		messagePage = recivedPage.composeMailBtnClick();
		
		Waiter.waitForElementPresent(recivedPage.getDriver(),yandexMailPageLibrary.TO_XPATH);
		
		messagePage.inputSenderReceiver(yandexLoginLibrary.USERNAME).inputSubject(yandexMailPageLibrary.SUBJECT_CONTENT).inputContent(yandexMailPageLibrary.BODY_CONTENT).saveAndExit();
		
		Waiter.waitForElementPresent(recivedPage.getDriver(),yandexMailPageLibrary.COMPOSE_BTN_XPATH);
		
		return this;
		
	}
	 public YandexSentMailSteps openFromDraftsAndSend() {
			AssertsLibrary.assertLoginTitleAndUserName(recivedPage.getDriver());
			
	        draftsPage = recivedPage.draftsMenuItemClick();

	        Waiter.waitForElementPresent(draftsPage.getDriver(), yandexMailPageLibrary.DRAFTS_LINK_VERIFY);

	        messagePage = draftsPage.composeMailBtnClick();
					
	        Waiter.waitForElementPresent(draftsPage.getDriver(), yandexMailPageLibrary.TO_XPATH);
	        
	        AssertsLibrary.assertSentAndDraftLetter(messagePage.getDriver(), messagePage);

	        receivedMailPage =  messagePage.sendMail();



	        sentPage = receivedMailPage.sentMenuItemClick();

	        Waiter.waitForElementPresent(sentPage.getDriver(), yandexMailPageLibrary.COMPOSED_DRAFT_XPATH);

	        return this;
		 
	 }
		public YandexSentMailSteps checkThatLetterSend() {
			   draftsPage = recivedPage.draftsMenuItemClick();
			   
		       Waiter.waitForElementPresent(draftsPage.getDriver(), yandexMailPageLibrary.DRAFTS_LINK_VERIFY);
		       
	       try{
		         String letterBody= draftsPage.getDriver().findElement(By.xpath(yandexMailPageLibrary.VERIFY_BODY_IN_DRAFT)).getText();
	         } catch (NoSuchElementException e) {
	        	 
	           	 sentPage = receivedMailPage.sentMenuItemClick();
		           
	        //  Waiter.waitForElementPresent(sentPage.getDriver(), yandexMailPageLibrary.COMPOSED_DRAFT_XPATH);
			       
			     //  AssertsLibrary.assertThatLetterInSentYandex(sentPage.getDriver(), sentPage);
	         } 
      
       return this;
			}
		
		  public void logOut() {
			  sentPage=sentPage.logoClick();	  
		        //Waiter.waitForElementPresent(sentPage.getDriver(), yandexMailPageLibrary.LOGOUT_BTN_XPATH);
		        loginPage = sentPage.logOutBtnClick();
		     //   Waiter.waitForElementPresent(loginPage.getDriver(), yandexMailPageLibrary.YANDEX_LOGO_XPATH);

		   
		    }

}
