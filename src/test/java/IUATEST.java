
import iUA.stepsToReproduce.IUALoginSteps;
import iUA.stepsToReproduce.IUASentMailSteps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import pageFactory.WebDriverFactory;
import yandex.stepsToReproduce.YandexSentMailSteps;
import yandex.stepsToReproduce.YandexLoginSteps;

public class IUATEST {
	WebDriver driver;
	IUALoginSteps LoginSteps;
	IUASentMailSteps sentMailSteps;

	@BeforeClass
	public void beforeClass() {
		String browser = "chrome";//chrome
		WebDriverFactory driverFactory = new WebDriverFactory();
		driver = driverFactory.getDriver(browser);
		LoginSteps = new IUALoginSteps(driver);

	}

	@Test
	public void IUA() {
		LoginSteps.loginAction().createMailAndSaveToDrafts().openFromDraftsAndSend().logOut();
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
