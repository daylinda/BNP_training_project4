package com.website.testing.davina;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebsiteLoginTest extends WebsiteRegisterTest {
			
	
	  @Test(priority = 3)
	  @Parameters({"userEmail","userPassword"})
	  public void websiteLogin(String userEmail,String userPassword) throws InterruptedException {
		   
		  		  
		  driver.findElement(By.className("login")).click();
//		  System.out.println("into websiteLogin");
		  
		 
		  driver.findElement(By.id("email")).sendKeys(userEmail);
		  driver.findElement(By.id("passwd")).sendKeys(userPassword);
		  
		  driver.findElement(By.id("SubmitLogin")).click();
		  
		  
		  try {
			  
			  String actual_error = driver.findElement(By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li")).getText();
			  String expected_error1 = "An email address required.";
			  String expected_error2 = "Password is required.";
			  String expected_error3 = "Authentication failed.";
			  if(actual_error.equals(expected_error1)){
					Assert.assertEquals(actual_error, expected_error1);
					System.out.println("Error: "+actual_error);
					
				}else if(actual_error.equals(expected_error2)){
					Assert.assertEquals(actual_error, expected_error2);
					System.out.println("Error: "+actual_error);
					
				}else if(actual_error.equals(expected_error3)){
					Assert.assertEquals(actual_error, expected_error3);
					System.out.println("Error: "+actual_error+" Please enter valid email address and password");
					
				}
			  tearDown();
		  }catch (NoSuchElementException e) {
			  System.out.println("Login done");
			  driver.findElement(By.linkText("Home")).click();
		}
		  
		  
	  }
	  
	  @Test(priority = 6)
	  public void logout() throws InterruptedException {
		//logout
			driver.findElement(By.className("logout")).click();
			Thread.sleep(1000);
	  }
	  
	  
}
