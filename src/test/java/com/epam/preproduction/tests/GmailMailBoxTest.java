package com.epam.preproduction.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.epam.preproduction.tests.gmailsteps.GmailLoginSteps;
import com.epam.preproduction.tests.gmailsteps.GmailSentMailSteps;

public class GmailMailBoxTest extends MailBoxSuite {

	GmailLoginSteps GmailLoginSteps;
	GmailSentMailSteps gmailSentMailSteps;

	@BeforeClass
	public void beforeClass() {

		GmailLoginSteps = new GmailLoginSteps(driver);

	}

	@Test
	public void Gmail() {
		GmailLoginSteps.loginAction().createMailAndSaveToDrafts()
				.openFromDraftsAndSend().checkThatLetterSend().logOut();//
	}

	@AfterClass
	public void afterClass() {
		GmailLoginSteps = null;
	}

}
