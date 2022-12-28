package com.herokuapp.theinternet;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PositiveTests {
//	below is a test method
	
	@Test
	public void loginTest() {
		
		System.out.println("Starting loginTest - This test case is developed by Abhishek Kumar");
		
//		Create Driver (this is used to set on which browser u r going to run the test. eg. CHROME or FIREFOX)
//		what it mean is the driver has to look for chrome driver at this location (/src/main/resources/chromedriver.exe)
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anoop Kumar\\eclipse-workspace\\selenium-for-begineers\\src\\main\\resources\\chromedriver108.exe"); // getting error with this path as: it(chrome driver is using 109 version)/src/main/resources/chromedriver.exe
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
//		enter password
//		click login button
//		
//		verification:
//		redirect to new url 
//		logout button is visible
//		successfull login message
		
		
		// close browser
		driver.quit();

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
