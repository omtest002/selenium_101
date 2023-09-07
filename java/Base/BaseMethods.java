package Base;

import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseMethods {

	public WebDriver driver;

	private String username = "om.bagade002";

	private String accessKey = "a72S5rHstUsJQwFarnaYgrKXyzV9FAV0P6pFqBCW7yB6mXYcxt";

	private String hub = "@hub.lambdatest.com/wd/hub";

	DesiredCapabilities caps = new DesiredCapabilities();

	@Parameters(value = { "browser", "version", "platform" })
	@BeforeClass

	public void setup(String browser, String version, String platform) {

		caps.setCapability("build", "Selenium_101");

		caps.setCapability("name", "LambdaTest Selenium 101");

		caps.setCapability("browserName", browser);
		caps.setCapability("version", version);
		caps.setCapability("platform", platform);

		caps.setCapability("network", true);

		caps.setCapability("console", true);

		caps.setCapability("visual", true);

		caps.setCapability("video", true);

		try {

			driver = new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + hub), caps);

		} catch (MalformedURLException exc) {

			exc.printStackTrace();

		}

		driver.get("https://www.lambdatest.com/");

	}

	// navigate
	public void go(String url) {
		driver.get(url);
	}

	// println method
	public void print(String string) {
		System.out.println(string);
	}

	// find method
	public WebElement find(String locator) {
		return driver.findElement(By.xpath(locator));
	}

	// click method
	public void click(String locator) {
		find(locator).click();
	}

	// typing method
	public void type(String locator, String string) {
		find(locator).sendKeys(string);
	}

	// hover
	public void hover(String string) {
		Actions action = new Actions(driver);
		action.moveToElement(find(string)).perform();
	}

	// Thread Sleep
	public void sleep(int duration_in_ms) throws InterruptedException {
		Thread.sleep(duration_in_ms);
	}

	// Assert true
	public void asserttrue(boolean condition, String string) {
		Assert.assertTrue(condition, string);
	}

	// Draganddrop
	public void drag(WebElement locator, int x, int y) {
		Actions move = new Actions(driver);
		Action action = (Action) move.dragAndDropBy(locator, x, y).build();
		action.perform();
	}

	// Select by value
	public void select(String locator, String string) {
		Select country = new Select(find(locator));
		country.selectByValue(string);
	}

	@AfterClass
	public void close() throws InterruptedException {

		driver.quit();
	}

}
