package adstractElements;

import org.openqa.selenium.WebDriver;

public abstract class AbstractPage {

	protected final WebDriver driver;

   public WebDriver getDriver() {
		return driver;
	}

protected String title;


	public AbstractPage(WebDriver driver) {
		this.driver = driver;

	}
	 public String getTitle() {
	 return title;
	 }

	public AbstractPage openPage(String url) {
		driver.get(url);
		//title = driver.getTitle();
		return this;
	}

}
