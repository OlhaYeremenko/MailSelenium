package com.epam.preproduction.tests.gmailsteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.preproduction.pages.gmail.GmailLoginPage;
import com.epam.preproduction.pages.gmail.GmailRecivedPage;
import com.epam.preproduction.pages.gmail.GmailSentPage;
import com.epam.preproduction.pages.helper.Waiter;

public class GmailLoginSteps {

	GmailLoginPage loginPage;
	GmailSentPage sentPage;
	GmailRecivedPage recivedPage;

	public static final String URL = "https://accounts.google.com/ServiceLogin?sacu=1&scc=1&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&hl";
	public static final String USERNAME = "seleniumyeremenko@gmail.com";
	public static final String PASSWORD = "seleniumYeremenko1";
	public static final String USERNAME_INPUT_XPATH = "//input[@id='Email']";
	public static final String PASSWORD_INPUT_XPATH = "//input[@id='Passwd']";
	public static final String COMPOSE_BTN_XPATH = "//div[@role='button' and @gh and contains(@class, 'T')]";

	public GmailLoginSteps(WebDriver driver) {
		loginPage = new GmailLoginPage(driver);
	}

	public GmailSentMailSteps loginAction() {

		loginPage.navigateTo(URL);

		Waiter.waitForElementPresent(loginPage.getDriver(),
				USERNAME_INPUT_XPATH);

		assertThat(loginPage.getDriver().getTitle(), containsString("Google"));

		loginPage = loginPage.inputUserName(USERNAME);

		try {
			loginPage = loginPage.nextBtnClick();

		} catch (NoSuchElementException e) {

		} finally {
			(new WebDriverWait(loginPage.getDriver(), 20))
					.until(ExpectedConditions.elementToBeClickable(By
							.xpath(PASSWORD_INPUT_XPATH)));

			recivedPage = loginPage.inputPassword(PASSWORD).submitLogin();
		}

		Waiter.waitForElementPresent(loginPage.getDriver(), COMPOSE_BTN_XPATH);

		return new GmailSentMailSteps(recivedPage);

	}
}
