package com.epam.preproduction.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.preproduction.tests.yandexsteps.YandexLoginSteps;
import com.epam.preproduction.tests.yandexsteps.YandexSentMailSteps;

public class YandexMailBoxTest extends MailBoxSuite {

	YandexLoginSteps LoginSteps;
	YandexSentMailSteps sentMailSteps;

	@BeforeClass
	public void beforeClass() {

		LoginSteps = new YandexLoginSteps(driver);

	}

	@Test
	public void Yandex() {
		LoginSteps.loginAction().createMailAndSaveToDrafts()
				.openFromDraftsAndSend().checkThatLetterSend().logOut();
	}

	@AfterClass
	public void afterClass() {
		LoginSteps = null;
	}

}
