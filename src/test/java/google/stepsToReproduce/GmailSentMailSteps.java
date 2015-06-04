package google.stepsToReproduce;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import google.GmailDraftsPage;
import google.GmailLoginPage;
import google.GmailMessagePage;
import google.GmailRecivedPage;
import google.GmailSentPage;
import helpers.AssertsLibrary;
import helpers.Waiter;
import xPathLlibrary.Library.gmailLoginLibrary;
import xPathLlibrary.Library.gmailPageLibrary;
import xPathLlibrary.Library.yandexLoginLibrary;
import xPathLlibrary.Library.yandexMailPageLibrary;

public class GmailSentMailSteps {
	GmailLoginPage loginPage;
	GmailSentPage sentPage;
	GmailRecivedPage recivedPage;
	GmailMessagePage messagePage;
	GmailDraftsPage draftsPage;
	GmailRecivedPage receivedMailPage;

	public GmailSentMailSteps(GmailRecivedPage recivedPage) {
		this.recivedPage = recivedPage;
	}

	public GmailSentMailSteps createMailAndSaveToDrafts() {

		(new WebDriverWait(recivedPage.getDriver(), 10))
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath(gmailPageLibrary.COMPOSE_BTN_XPATH)));

		assertThat(recivedPage.getDriver().getTitle(),
				containsString(gmailLoginLibrary.USERNAME));

		messagePage = recivedPage.composeMailBtnClick();

		Waiter.waitForElementPresent(messagePage.getDriver(),
				gmailPageLibrary.FORM_TO_XPATH);

		messagePage.inputSenderReceiver(gmailLoginLibrary.USERNAME)
				.inputSubject(gmailPageLibrary.FORM_SUBJ)
				.inputContent(gmailPageLibrary.FORM_TEXT).saveAndExit();

		Waiter.waitForElementPresent(recivedPage.getDriver(),
				gmailPageLibrary.COMPOSE_BTN_XPATH);

		return this;
	}

	public GmailSentMailSteps openFromDraftsAndSend() {

		assertThat(recivedPage.getDriver().getTitle(),
				containsString(gmailLoginLibrary.USERNAME));

		recivedPage.getDriver().manage().window().maximize();
		draftsPage = recivedPage.draftsMenuItemClick();

		Waiter.waitForElementPresent(draftsPage.getDriver(),
				gmailPageLibrary.DRAFTS_LETTER_XPATH);

		messagePage = draftsPage.composeMailBtnClick();

		Waiter.waitForElementPresent(draftsPage.getDriver(),
				gmailPageLibrary.DRAFT_FORM_TO_FIELD);

		// assertThat(messagePage.getDriver().findElement(By.xpath(gmailPageLibrary.DRAFT_FORM_TO_FIELD)).getText(),
		// containsString(gmailLoginLibrary.USERNAME));
		assertThat(messagePage.getSubjectField().getAttribute("value"),
				containsString(gmailPageLibrary.FORM_SUBJ));
		assertThat(messagePage.getTextField().getText(),
				containsString(gmailPageLibrary.FORM_TEXT));

		receivedMailPage = messagePage.sendMail();
		draftsPage.getDriver().findElement(
				By.xpath(gmailPageLibrary.DRAFTS_LETTER_XPATH));

		// Waiter.waitForElementPresent(receivedMailPage.getDriver(),
		// gmailPageLibrary.SENT_MAIL_TAB_XPATH);
		//
		// sentPage = receivedMailPage.sentMenuItemClick();
		//
		// AssertsLibrary.assertThatLetterInSentGmail(sentPage.getDriver(),sentPage);

		return this;
	}

	public GmailSentMailSteps checkThatLetterSend() {
		Waiter.waitForElementPresent(receivedMailPage.getDriver(),
				gmailPageLibrary.SENT_MAIL_TAB_XPATH);

		sentPage = receivedMailPage.sentMenuItemClick();

		AssertsLibrary.assertThatLetterInSentGmail(sentPage.getDriver(),
				sentPage);

		return this;

	}

	public GmailSentMailSteps logOut() {
	           ///lang.NullPointerException --- не могу понять, почему sentPage is null
//	sentPage = sentPage.logoClick();
//
//		try {
//
//			loginPage = sentPage.logOutBtnClick();
//
//		} catch (UnhandledAlertException e) {
//
//			Actions action = new Actions(sentPage.getDriver());
//			action.sendKeys(Keys.ENTER).build().perform();
//
//		}
//
//		Waiter.waitForElementPresent(loginPage.getDriver(),
//				gmailLoginLibrary.PASSWORD_INPUT_XPATH);

		return this;
	}

}
