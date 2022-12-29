package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {
//	below is a test method

	@Test
	public void loginTest() {

		System.out.println("Starting loginTest - This test case is developed by Abhishek Kumar");

//		Create Driver (this is used to set on which browser u r going to run the test. eg. CHROME or FIREFOX)
//		what it mean is the driver has to look for chrome driver at this location (/src/main/resources/chromedriver.exe)
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Anoop Kumar\\eclipse-workspace\\selenium-for-begineers\\src\\main\\resources\\chromedriver108.exe"); 
		/*
		getting error with this path as: it(chrome driver was using 109 version /src/main/resources/chromedriver.exe)
		*/
																																	
		WebDriver driver = new ChromeDriver();

		// sleep for 3 seconds
		sleep(3000);

		// maximize browser window
		driver.manage().window().maximize();

//		open test page
		String url = "http://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("Page is opened. -- Comment written to understand the same");

		// sleep for 2 seconds
		sleep(2000);

//		enter username
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		sleep(1000);
		/*
		 * Here u can also use xpath for user name: WebElement username =
		 * driver.findElement(By.ByXPath("/html//input[@id='username']"));
		 * 
		 */

//		enter password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		sleep(3000);

//		click login button
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();
		sleep(5000);
		/*
		 * u can also use below code: WebElement logInButton = driver.findElement(By.
		 * xpath("//form[@id='login']//i[@class='fa fa-2x fa-sign-in']"));
		 * 
		 */

		/*
		 * Now we will be starting verification on the URL that comes after you login
		 */

//		verifications:
//		new url
		String expectedUrl = "http://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		// we will compare expectedUrl and actualUrl by using TestNG class: Assert (will
		// import this)
		Assert.assertEquals(actualUrl, expectedUrl, "Actual Page URL is not same as Expected Page URL");

//		logout button is visible
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "Log Out button is not visible");

//		successfull login message
//		WebElement successMessage = driver.findElement(By.cssSelector("#flash"));  
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
//	    Assert.assertEquals(actualMessage, expectedMessage, "Actual Message is not the same as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"Actual Message doesnot conatin expected message.\nActual Message: " + actualMessage
						+ "Expected Message\n" + expectedMessage);

		// close browser
		driver.quit();
		System.out.println("Page is closed -- Comment written to understand the same");

	}

	private void sleep(long n) {
		try {
			Thread.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
