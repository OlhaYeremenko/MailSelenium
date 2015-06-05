package com.epam.preproduction.tests.yandexsteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.epam.preproduction.pages.helper.Waiter;
import com.epam.preproduction.pages.yandex.DraftsYandexPage;
import com.epam.preproduction.pages.yandex.LoginYandexPage;
import com.epam.preproduction.pages.yandex.MessageMailPage;
import com.epam.preproduction.pages.yandex.RecivedMailPage;
import com.epam.preproduction.pages.yandex.SentMailPage;

public class YandexSentMailSteps {
	LoginYandexPage loginPage;
	MessageMailPage messagePage;
	DraftsYandexPage draftsPage;
	RecivedMailPage recivedPage;
	SentMailPage sentPage;
	RecivedMailPage receivedMailPage;

	public static final String USERNAME = "seleniumTestAccount@yandex.com";
	public static final String SUBJECT_CONTENT = "my subject is :" + USERNAME;
	public static final String BODY_CONTENT = "body is :" + USERNAME;
	public static final String COMPOSED_DRAFT_XPATH = "//div[@class='b-messages']/div[1]//span/span[contains(@class, 'firstline-wrapper')]";
	public static final String VERIFY_BODY_IN_DRAFT = " //div[@class='b-messages']/div[1]//span/span[contains(@class, 'firstline-wrapper')]/span[@class='b-messages__firstline']";
	public static final String VERIFY_SUBJECT_IN_SENT = "//span[@class='b-messages__subject']";
	public static final String LOGIN_TITLE_XPATH = "//span[contains(@class, 'header-user-name')]";
	public static final String SENT_LINK_VERIFY = "//div[@class='block-messages-title']//label[contains(text(),'Sent')]";
	public static final String DRAFTS_LINK_VERIFY = "//div[@class='block-messages-title']//label[contains(text(),'Drafts')]";
	public static final String DRAFTS_MENU_XPATH = "//a[contains(@title,'Drafts') and contains(text(),'Drafts') ]";
	public static final String COMPOSE_BTN_XPATH = "//a[contains(@href, 'compose')]/img";
	public static final String SENT_MENU_XPATH = "//div[@class='block-app']//a[contains(@href, 'sent')]";
	public static final String TO_XPATH = ".//*[@class='b-mail-input_yabbles__focus']";
	public static final String TO_SEND_XPATH = ".//*[@class='b-yabble__text__content']";


	public YandexSentMailSteps(RecivedMailPage recivedPage) {
		this.recivedPage = recivedPage;
	}

	public YandexSentMailSteps createMailAndSaveToDrafts() {
		
		assertThat(
				recivedPage.getDriver()
						.findElement(By.xpath(LOGIN_TITLE_XPATH)).getText(),
				containsString(USERNAME));

		messagePage = recivedPage.composeMailBtnClick();

		Waiter.waitForElementPresent(recivedPage.getDriver(), TO_XPATH);

		messagePage.inputSenderReceiver(USERNAME).inputSubject(SUBJECT_CONTENT)
				.inputContent(BODY_CONTENT).saveAndExit();

		Waiter.waitForElementPresent(recivedPage.getDriver(), COMPOSE_BTN_XPATH);

		return this;

	}

	public YandexSentMailSteps openFromDraftsAndSend() {
	
		draftsPage = recivedPage.draftsMenuItemClick();

		Waiter.waitForElementPresent(draftsPage.getDriver(), DRAFTS_LINK_VERIFY);

		messagePage = draftsPage.composeMailBtnClick();

		Waiter.waitForElementPresent(draftsPage.getDriver(), TO_XPATH);

		assertThat(
				messagePage.getDriver()
						.findElement(By.xpath(TO_SEND_XPATH))
						.getText(), containsString(USERNAME));

		assertThat(messagePage.getSubjectField().getAttribute("value"),
				containsString(SUBJECT_CONTENT));

		assertThat(messagePage.getTextField().getAttribute("value"),
				containsString(BODY_CONTENT));

		receivedMailPage = messagePage.sendMail();

		sentPage = receivedMailPage.sentMenuItemClick();

		Waiter.waitForElementPresent(sentPage.getDriver(), COMPOSED_DRAFT_XPATH);

		return this;

	}

	public YandexSentMailSteps checkThatLetterSend() {
		draftsPage = recivedPage.draftsMenuItemClick();

		Waiter.waitForElementPresent(draftsPage.getDriver(), DRAFTS_LINK_VERIFY);

		try {
			draftsPage.getDriver().findElement(By.xpath(VERIFY_BODY_IN_DRAFT))
					.getText();
		} catch (NoSuchElementException e) {

			sentPage = receivedMailPage.sentMenuItemClick();

		}

		return this;
	}

	public void logOut() {
		sentPage = sentPage.logoClick();
		
		loginPage = sentPage.logOutBtnClick();


	}

}
