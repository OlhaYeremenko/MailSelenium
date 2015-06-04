
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pageFactory.WebDriverFactory;
import google.stepsToReproduce.GmailLoginSteps;
import google.stepsToReproduce.GmailSentMailSteps;

public class GmailTEST {
	WebDriver driver;
	GmailLoginSteps GmailLoginSteps;
	GmailSentMailSteps gmailSentMailSteps;

	@BeforeClass
	public void beforeClass() {
		String browser = "chrome";
		WebDriverFactory driverFactory = new WebDriverFactory();
		driver = driverFactory.getDriver(browser);
		GmailLoginSteps = new GmailLoginSteps(driver);

	}

	@Test
	public void Gmail() {
		GmailLoginSteps.loginAction().createMailAndSaveToDrafts().openFromDraftsAndSend().logOut();//.checkThatLetterSend()
	}

	@AfterClass
	public void afterClass() {
	}



	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
