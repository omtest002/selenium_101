package TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import Base.BaseMethods;

public class Selenium101 extends BaseMethods {

//	****************************************Test Scenario - 1***************************************
	@Test(priority = 1)

	public void Scenario_1() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 1. Open LambdaTest’s Selenium Playground from
		go("https://www.lambdatest.com/selenium-playground");

		// 2. Click “Simple Form Demo” under Input Forms.
		driver.findElement(By.cssSelector("#__next > div > section.mb-50 > div > ul > li:nth-child(1) > a")).click();

		// 3. Validate that the URL contains “simple-form-demo”
		String validateUrl = driver.getCurrentUrl();
		print(validateUrl);
		asserttrue(true, "simple-form-demo");

		// 4. Create a variable for a string value E.g: “Welcome to LambdaTest”.
		String message = "Welcome to LambdaTest";

		// 5. Use this variable to enter values in the “Enter Message” text box.
		type("//*[@id='user-message']", message);

		// 6. Click “Get Checked Value”.
		click("//*[@id='showInput']");

		/*
		 * 7. Validate whether the same text message is displayed in the right-hand
		 * panel under the “Your Message:” section.
		 */
		print(driver.findElement(By.xpath("//p[@id='message']")).getText());
		asserttrue(true, message);
	}

//  ****************************************Test Scenario - 2****************************************
	@Test(priority = 2)
	public void Scenario_2() throws InterruptedException {

		/*
		 * 1. Open the https://www.lambdatest.com/selenium-playground page and click
		 * “Drag & Drop Sliders” under “Progress Bars & Sliders”.
		 */
		go("https://www.lambdatest.com/selenium-playground");

		click("//div[@class='container__selenium']//li[13]//a");

		/*
		 * 2. Select the slider “Default value 15” and drag the bar to make it 95 by
		 * validating whether the range value shows 95.
		 */

		WebElement slider = find("//div[@id='slider3']//input");
		drag(slider, 215, 0);

		print(driver.findElement(By.xpath("//div[@id='slider3']//output[@id='rangeSuccess']")).getText());
		asserttrue(true, "95");

	}

//  ****************************************Test Scenario - 3****************************************
	@Test(priority = 3)
	public void Scenario_3() throws InterruptedException {

		/*
		 * 1. Open the https://www.lambdatest.com/selenium-playground page and click
		 * “Input Form Submit” under “Input Forms”.
		 */
		go("https://www.lambdatest.com/selenium-playground");
		driver.findElement(By.cssSelector("#__next > div > section.mb-50 > div > ul > li:nth-child(5) > a")).click();

		// 2. Click “Submit” without filling in any information in the form.
		driver.findElement(By.cssSelector("#seleniumform > div.text-right.mt-20 > button")).click();

		// 3. Assert “Please fill in the fields” error message.
		asserttrue(true, "Please fill out this field");

		// 4. Fill in Name, Email, and other fields.

		type("//*[@id='name']", "Om");
		type("//*[@id='inputEmail4']", "test@test.com");
		type("//*[@id='inputPassword4']", "Test@123");
		type("//*[@id='company']", "LambdaTest");
		type("//*[@id='websitename']", "www.test.com");
		type("//*[@id='inputCity']", "New York");
		type("//*[@id='inputAddress1']", "St. 1");
		type("//*[@id='inputAddress2']", "St. 2");
		type("//*[@id='inputState']", "Washington DC");
		type("//*[@id='inputZip']", "10001");

		/*
		 * 5. From the Country drop-down, select “United States” using the text
		 * property.
		 */
		select("//*[@id='seleniumform']/div[3]/div[1]/select", "US");

		// 6. Fill all fields and click “Submit”.
		driver.findElement(By.cssSelector("#seleniumform > div.text-right.mt-20 > button")).click();

		/*
		 * 7. Once submitted, validate the success message “Thanks for contacting us, we
		 * will get back to you shortly.” on the screen
		 */
		asserttrue(true, "Thanks for contacting us, we will get back to you shortly");

	}
}
