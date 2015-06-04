
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pageFactory.WebDriverFactory;

import yandex.stepsToReproduce.YandexSentMailSteps;
import yandex.stepsToReproduce.YandexLoginSteps;

public class YandexTEST {
	WebDriver driver;
	YandexLoginSteps LoginSteps;
	YandexSentMailSteps sentMailSteps;

	@BeforeClass
	public void beforeClass() {
		String browser = "chrome";//firefox
		WebDriverFactory driverFactory = new WebDriverFactory();
		driver = driverFactory.getDriver(browser);
		LoginSteps = new YandexLoginSteps(driver);

	}

	@Test
	public void Yandex() {
		LoginSteps.loginAction().createMailAndSaveToDrafts()
				.openFromDraftsAndSend().checkThatLetterSend().logOut();
	}

	@AfterClass
	public void afterClass() {
	}

	@BeforeTest
	public void beforeTest() {
	}

	@AfterTest
	public void afterTest() {
		driver.quit();

	}

}
