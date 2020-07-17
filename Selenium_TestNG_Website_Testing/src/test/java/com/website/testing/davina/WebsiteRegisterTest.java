package com.website.testing.davina;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;




public class WebsiteRegisterTest {
	
	
	WebDriver driver;
	
	@BeforeSuite()
	public void setUpMethod() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Vincent Pinto\\Desktop\\JAVA SOFTWARE\\tools\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("http://automationpractice.com/");
//		System.out.println("In setup");
		
	}
	
	@Test(priority = 1)
	@Parameters({"userEmail"})
	public void websiteRegisterTest(String userEmail) throws InterruptedException {
		
		
		driver.findElement(By.className("login")).click();
//		System.out.println("into sign-in");
		Thread.sleep(100);
		
		driver.findElement(By.id("email_create")).sendKeys(userEmail);
		driver.findElement(By.id("SubmitCreate")).click();
		
		
		
		try {
		
		String actual_error = driver.findElement(By.xpath("//*[@id=\"create_account_error\"]/ol/li")).getText();
		
		String expected_error1 ="Invalid email address.";
		String expected_error2 ="An account using this email address has already been registered. Please enter a valid password or request a new one. ";
		
		
		if(actual_error.equals(expected_error1)) {
			Assert.assertEquals(actual_error, expected_error1);
			System.out.println("Error:"+actual_error);
			tearDown();
			
		}else if(actual_error.equals(expected_error2)) {
			Assert.assertEquals(actual_error, expected_error2);
			System.out.println("Error:"+actual_error);
		}
		
		
		
		}catch(NoSuchElementException e) {
			System.out.println("Email Id accepted for registration");
		}
		
	}
	
	@Test(priority = 2)
	@Parameters({"userPassword"})
	public void createAccountTest(String userPassword) throws InterruptedException {
		
		try {
		//Title
		WebElement radio = driver.findElement(By.id("id_gender2"));//will set title as MRS. if you want to set title as MR put id_gender1
		radio.click();
		//firstname
		driver.findElement(By.id("customer_firstname")).sendKeys("Tania");
		
		//lastname
		driver.findElement(By.id("customer_lastname")).sendKeys("Libermen");
		
		//password
		driver.findElement(By.id("passwd")).sendKeys(userPassword);
		
		//day
		Select day = new Select(driver.findElement(By.name("days")));
		day.selectByValue("1");
		
		//month
		Select month = new Select(driver.findElement(By.name("months")));
		month.selectByValue("2");
				
		//year
		Select year = new Select(driver.findElement(By.name("years")));
		year.selectByValue("1995");
		
		
		//address details
		//firstname
		driver.findElement(By.id("firstname")).sendKeys("Tania");
		//lastname
		driver.findElement(By.id("lastname")).sendKeys("Libermen");
		//company
		driver.findElement(By.id("company")).sendKeys("Newmen");
		//address1
		driver.findElement(By.id("address1")).sendKeys("Ralf Street");
		//city
		driver.findElement(By.id("city")).sendKeys("LA");
		//state
		Select state = new Select(driver.findElement(By.name("id_state")));
		state.selectByVisibleText("Illinois");
		
		//postalcode
		driver.findElement(By.id("postcode")).sendKeys("10000");
		
		//Country
		Select country = new Select(driver.findElement(By.name("id_country")));
		country.selectByVisibleText("United States");
		
		//mobile
		driver.findElement(By.id("phone_mobile")).sendKeys("9992551376");
		
		//address alias
		driver.findElement(By.name("alias")).sendKeys("Address");
		
		//register button
		driver.findElement(By.id("submitAccount")).click();
		
		
		Thread.sleep(1000);
		
		try {
			
			String actual_error =driver.findElement(By.xpath("//*[@id=\"center_column\"]/div/ol/li")).getText();
			String e1 ="You must register at least one phone number.";
			String e2 ="lastname is required.";
			String e3 ="firstname is required.";
			String e4 ="passwd is required.";
			String e5 ="id_country is required.";
			String e6 ="address1 is required.";
			String e7 ="city is required.";
			String e8 ="Country cannot be loaded with address->id_country";
			String e9 ="Country is invalid";
			
			if(actual_error.equals(e1)){
				Assert.assertEquals(actual_error, e1);
			}
			if(actual_error.equals(e2)){
				Assert.assertEquals(actual_error, e2);
			}
			if(actual_error.equals(e3)){
				Assert.assertEquals(actual_error, e3);
			}
			if(actual_error.equals(e4)){
				Assert.assertEquals(actual_error, e4);
			}
			if(actual_error.equals(e5)){
				Assert.assertEquals(actual_error, e5);
			}
			if(actual_error.equals(e6)){
				Assert.assertEquals(actual_error, e6);
			}
			if(actual_error.equals(e7)){
				Assert.assertEquals(actual_error, e7);
			}
			if(actual_error.equals(e8)){
				Assert.assertEquals(actual_error, e8);
			}
			if(actual_error.equals(e9)){
				Assert.assertEquals(actual_error, e9);
			}
			
			System.out.println("Error:"+actual_error);
			tearDown();
			
			
		}catch (NoSuchElementException e) {
			System.out.println("Account Registered successfully");
		}
		
		
		//logout
		driver.findElement(By.className("logout")).click();
		
		}catch(NoSuchElementException e) {
			System.out.println("Account already registered");
		}
		
	}

	


		
	 		
	@AfterSuite
	public void tearDown() throws InterruptedException {
//		System.out.println("In tearDown");
		Thread.sleep(1000);
		driver.quit();
	}
		
	

}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  

