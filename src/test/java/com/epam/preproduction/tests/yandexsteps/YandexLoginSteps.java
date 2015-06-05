package com.epam.preproduction.tests.yandexsteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.WebDriver;

import com.epam.preproduction.pages.helper.Waiter;
import com.epam.preproduction.pages.yandex.LoginYandexPage;
import com.epam.preproduction.pages.yandex.RecivedMailPage;
import com.epam.preproduction.pages.yandex.SentMailPage;

public class YandexLoginSteps {

	LoginYandexPage loginPage;
	SentMailPage personalPage;
	RecivedMailPage recivedPage;

	public static final String URL = "https://mail.yandex.com/";
	public static final String USERNAME = "seleniumTestAccount@yandex.com";
	public static final String PASSWORD = "seleniumTestAccount1";
	public static final String INBOX_MENU_XPATH = "//div[@class='block-messages-title']//label[contains(text(),'Inbox')]";

	public YandexLoginSteps(WebDriver driver) {
		loginPage = new LoginYandexPage(driver);
	}

	public YandexSentMailSteps loginAction() {
	
		loginPage.navigateTo(URL);
		
		assertThat(loginPage.getDriver().getTitle(), containsString("Yandex.Mail"));

		recivedPage = loginPage.inputUserName(USERNAME).inputPassword(PASSWORD)
				.submitLogin();

		Waiter.waitForElementPresent(loginPage.getDriver(), INBOX_MENU_XPATH);

		return new YandexSentMailSteps(recivedPage);
	}

}
