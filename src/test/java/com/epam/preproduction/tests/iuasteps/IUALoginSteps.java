package com.epam.preproduction.tests.iuasteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import org.openqa.selenium.WebDriver;

import com.epam.preproduction.pages.helper.Waiter;
import com.epam.preproduction.pages.iua.IUALoginPage;
import com.epam.preproduction.pages.iua.IUARecivedPage;
import com.epam.preproduction.pages.iua.IUASentPage;

public class IUALoginSteps {

	IUALoginPage loginPage;
	IUASentPage sentPage;
	IUARecivedPage recivedPage;

	public static final String URL = "http://mail.i.ua/";
	public static final String USERNAME = "seleniumTestAccount@i.ua";
	public static final String PASSWORD = "seleniumTest";
	public static final String USERNAME_INPUT_XPATH = "//input[@name='login']";
	public static final String PASSWORD_INPUT_XPATH = "//input[@name='pass']";
	public static final String COMPOSE_BTN_XPATH = "//p[@class='make_message']/a";

	public IUALoginSteps(WebDriver driver) {

		loginPage = new IUALoginPage(driver);

	}

	public IUASentMailSteps loginAction() {

		loginPage.navigateTo(URL);

		Waiter.waitForElementPresent(loginPage.getDriver(),
				USERNAME_INPUT_XPATH);

		assertThat(loginPage.getDriver().getTitle(), containsString("i.ua"));

		recivedPage = loginPage.inputUserName(USERNAME).inputPassword(PASSWORD)
				.submitLogin();

		Waiter.waitForElementPresent(loginPage.getDriver(), COMPOSE_BTN_XPATH);

		return new IUASentMailSteps(recivedPage);
	}

}
