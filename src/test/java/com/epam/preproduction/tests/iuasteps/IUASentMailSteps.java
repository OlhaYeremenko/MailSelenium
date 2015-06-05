package com.epam.preproduction.tests.iuasteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import com.epam.preproduction.pages.helper.Waiter;
import com.epam.preproduction.pages.iua.IUADraftsPage;
import com.epam.preproduction.pages.iua.IUALoginPage;
import com.epam.preproduction.pages.iua.IUAMessagePage;
import com.epam.preproduction.pages.iua.IUARecivedPage;
import com.epam.preproduction.pages.iua.IUASentPage;

public class IUASentMailSteps {
	IUALoginPage loginPage;
	IUASentPage sentPage;
	IUARecivedPage recivedPage;
	IUAMessagePage messagePage;
	IUADraftsPage draftsPage;
	IUARecivedPage receivedMailPage;

	public static final String LOGOUT_BTN_XPATH = "//a[contains (@href , 'logout') ]";
	public static final String IUA_LOGO = "//img[@alt = 'I.UA']";
	public static final String USERNAME = "seleniumTestAccount@i.ua";
	public static final String FORM_SUBJ = "my subject is :" + USERNAME;
	public static final String FORM_TEXT = "body is :" + USERNAME;
	public static final String COMPOSE_BTN_XPATH = "//p[@class='make_message']/a";
	public static final String DRAFT_XPATH = ".//*[@id='mesgList']//div[1]//span[3]/span";
	public static final String SENT_MAIL_TAB_XPATH = "//a[contains(@href, 'sent-mail')]";
	public static final String DRAFTS_TAB_XPATH = "//a[contains(@href, 'drafts')]";

	public IUASentMailSteps(IUARecivedPage recivedPage) {
		this.recivedPage = recivedPage;
	}

	public IUASentMailSteps createMailAndSaveToDrafts() {
		assertThat(recivedPage.getDriver().getTitle(), containsString("I.UA"));

		recivedPage.composeMailBtnClick().inputSenderReceiver(USERNAME)
				.inputSubject(FORM_SUBJ).inputContent(FORM_TEXT).saveAndExit();

		Waiter.waitForElementPresent(recivedPage.getDriver(), COMPOSE_BTN_XPATH);

		return this;
	}

	public IUASentMailSteps openFromDraftsAndSend() {

		assertThat(recivedPage.getDriver().getTitle(), containsString("I.UA"));
		draftsPage = recivedPage.draftsMenuItemClick();

		Waiter.waitForElementPresent(draftsPage.getDriver(), DRAFT_XPATH);

		messagePage = draftsPage.composeMailBtnClick();

		assertThat(messagePage.getSubjectField().getAttribute("value"),
				containsString(FORM_SUBJ));

		assertThat(messagePage.getTextField().getText(),
				containsString(FORM_TEXT));

		receivedMailPage = messagePage.sendMail();

		Waiter.waitForElementPresent(receivedMailPage.getDriver(),
				SENT_MAIL_TAB_XPATH);

		sentPage = receivedMailPage.sentMenuItemClick();

		Waiter.waitForElementPresent(sentPage.getDriver(), DRAFTS_TAB_XPATH);

		return this;

	}

	public IUASentMailSteps logOut() {

		sentPage = sentPage.sentMenuItemClick();

		Waiter.waitForElementPresent(sentPage.getDriver(), LOGOUT_BTN_XPATH);

		loginPage = sentPage.logOutBtnClick();

		Waiter.waitForElementPresent(loginPage.getDriver(), IUA_LOGO);
		return this;
	}
}
