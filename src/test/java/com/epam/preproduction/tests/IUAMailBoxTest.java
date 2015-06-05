package com.epam.preproduction.tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import com.epam.preproduction.tests.iuasteps.IUALoginSteps;
import com.epam.preproduction.tests.iuasteps.IUASentMailSteps;

public class IUAMailBoxTest extends MailBoxSuite {
	IUALoginSteps LoginSteps;
	IUASentMailSteps sentMailSteps;

	@BeforeClass
	public void beforeClass() {
		LoginSteps = new IUALoginSteps(driver);
	}

	@Test
	public void IUA() {
		LoginSteps.loginAction().createMailAndSaveToDrafts()
				.openFromDraftsAndSend().logOut();
	}

	@AfterClass
	public void afterClass() {
		LoginSteps = null;

	}

}
