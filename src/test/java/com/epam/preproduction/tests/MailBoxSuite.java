package com.epam.preproduction.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.epam.preproduction.pages.pagefactory.WebDriverFactory;

public abstract class MailBoxSuite {
public 	WebDriver driver;

	@BeforeSuite
	public void beforeSuite() {
		String browser = "firefox";//chrome
		WebDriverFactory driverFactory = new WebDriverFactory();
		driver = driverFactory.getDriver(browser);

	}

	@AfterSuite
	public void afterTest() {
		driver.quit();

	}
}
