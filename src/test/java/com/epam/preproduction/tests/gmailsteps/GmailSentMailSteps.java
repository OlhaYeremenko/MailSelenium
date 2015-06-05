package com.epam.preproduction.tests.gmailsteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.preproduction.pages.gmail.GmailDraftsPage;
import com.epam.preproduction.pages.gmail.GmailLoginPage;
import com.epam.preproduction.pages.gmail.GmailMessagePage;
import com.epam.preproduction.pages.gmail.GmailRecivedPage;
import com.epam.preproduction.pages.gmail.GmailSentPage;
import com.epam.preproduction.pages.helper.Waiter;

public class GmailSentMailSteps {
	GmailLoginPage loginPage;
	GmailSentPage sentPage;
	GmailRecivedPage recivedPage;
	GmailMessagePage messagePage;
	GmailDraftsPage draftsPage;
	GmailRecivedPage receivedMailPage;

	public static final String USERNAME = "seleniumyeremenko@gmail.com";
	public static final String FORM_SUBJ = "my subject is :" + USERNAME;
	public static final String FORM_TEXT = "body is :" + USERNAME;
	public static final String COMPOSE_BTN_XPATH = "//div[@role='button' and @gh and contains(@class, 'T')]";
	public static final String DRAFTS_LETTER_XPATH = "//span[contains(text(),'my subject is :')]";
	public static final String SENT_MAIL_TAB_XPATH = ".//a[contains(@href,'#sent')]";
	public static final String FORM_TO_XPATH = "//textarea[@name='to']";
	public static final String FORM_SAVE_AND_QUITBTN_XPATH = ".//img[3]";
	public static final String DRAFT_FORM_TO_FIELD = "//form/div/div/span";
	public static final String USER_LOGO_PIC_XPATH = "//a[contains(@title,'Аккаунт')]";
	public static final String LOGOUT_BTN_XPATH = "//a[contains(@href, 'logout')]";
	public static final String LOGOUT_XPATH = "//div/a[@href='https://mail.google.com/mail/logout?hl=ru']";

	public GmailSentMailSteps(GmailRecivedPage recivedPage) {
		this.recivedPage = recivedPage;
	}

	public GmailSentMailSteps createMailAndSaveToDrafts() {

		(new WebDriverWait(recivedPage.getDriver(), 10))
				.until(ExpectedConditions.elementToBeClickable(By
						.xpath(COMPOSE_BTN_XPATH)));

		assertThat(recivedPage.getDriver().getTitle(), containsString(USERNAME));

		messagePage = recivedPage.composeMailBtnClick();

		Waiter.waitForElementPresent(messagePage.getDriver(), FORM_TO_XPATH);

		messagePage.inputSenderReceiver(USERNAME).inputSubject(FORM_SUBJ)
				.inputContent(FORM_TEXT).saveAndExit();

		Waiter.waitForElementPresent(recivedPage.getDriver(), COMPOSE_BTN_XPATH);

		return this;
	}

	public GmailSentMailSteps openFromDraftsAndSend() {

		assertThat(recivedPage.getDriver().getTitle(), containsString(USERNAME));

		recivedPage.getDriver().manage().window().maximize();

		draftsPage = recivedPage.draftsMenuItemClick();

		Waiter.waitForElementPresent(draftsPage.getDriver(),
				DRAFTS_LETTER_XPATH);

		messagePage = draftsPage.composeMailBtnClick();

		Waiter.waitForElementPresent(draftsPage.getDriver(),
				DRAFT_FORM_TO_FIELD);

		assertThat(messagePage.getSubjectField().getAttribute("value"),
				containsString(FORM_SUBJ));

		assertThat(messagePage.getTextField().getText(),
				containsString(FORM_TEXT));

		receivedMailPage = messagePage.sendMail();

		Waiter.waitForElementPresent(receivedMailPage.getDriver(),
				SENT_MAIL_TAB_XPATH);

		sentPage = receivedMailPage.sentMenuItemClick();

		return this;
	}

	public GmailSentMailSteps checkThatLetterSend() {

		Waiter.waitForElementPresent(receivedMailPage.getDriver(),
				SENT_MAIL_TAB_XPATH);

		sentPage = receivedMailPage.sentMenuItemClick();

		return this;
	}

	public GmailSentMailSteps logOut() {

		sentPage = sentPage.logoClick();

		try {

			loginPage = sentPage.logOutBtnClick();

		} catch (UnhandledAlertException e) {

			Actions action = new Actions(sentPage.getDriver());
			action.sendKeys(Keys.ENTER).build().perform();

		}

		return this;
	}

}
