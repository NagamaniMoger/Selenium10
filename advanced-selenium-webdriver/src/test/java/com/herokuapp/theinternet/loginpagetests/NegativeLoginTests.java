package com.herokuapp.theinternet.loginpagetests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;

public class NegativeLoginTests extends TestUtilities {

	@Parameters({ "username", "password", "expectedMessage" })
	@Test(priority = 2, groups = { "negativeTests", "smokeTests" })
	public void negativeLoginTest(String username, String password, String expectedErrorMessage) {

		//System.out.println("negativeLoginTest Started" + username + "and" + password);
		log.info("negativeLoginTest Started" + username + "and" + password);
		
		//open main page
		String url = "https://the-internet.herokuapp.com/";
		driver.get(url);
		//System.out.println("Main page is opened.");
		log.info("Main page is opened.");
		
		// Click on Form Authentication link
		driver.findElement(By.linkText("Form Authentication")).click();
		
		// enter username and password
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		
		sleep(3000);
		
		// push log in button
		driver.findElement(By.className("radius")).click();

		// Verification
		String actualErrorMessage = driver.findElement(By.id("flash")).getText();
		Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),
				"actualErrorMessage does not contain expectedErrorMessage\nexpectedErrorMessage: "
						+ expectedErrorMessage + "\nactualErrorMessage: " + actualErrorMessage);


	}


}
