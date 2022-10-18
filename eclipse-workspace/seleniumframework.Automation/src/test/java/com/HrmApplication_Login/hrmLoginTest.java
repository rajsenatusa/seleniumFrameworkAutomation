package com.HrmApplication_Login;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class hrmLoginTest {

	public static void main(String[] args) throws Throwable {
		
//		Step 1: Calling Web Driver Using setProperty Method. 
//      System.setProperty("webdriver.chrome.driver", "C:\\Users\\Owner\\eclipse-workspace\\seleniumframework.Automation\\Drivers\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver ();
//		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
//  	Step 2: Calling Web driver using WebDriver Manager
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();		
		//WebDriver driver = WebDriverManager.firefoxdriver().create();
		//WebDriver driver = WebDriverManager.iedriver().create();
		WebDriver driver = WebDriverManager.chromedriver().create();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");		
		System.out.println(	"Application with Url Launched Successfully : " +driver.getCurrentUrl());
		
		login(driver);
		loginValidation(driver); 		// Verification Point
		logout(driver);	
		closeAllBrowser(driver);
		
		driver.quit(); //close all the browsers
		
	}

	public static void closeAllBrowser(WebDriver driver) {
		driver.quit();
	}


	public static void logout(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement userUrl = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/span/p"));
		userUrl.click();
		
		WebElement logOut = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/header/div[1]/div[2]/ul/li/ul/li[4]/a"));
		logOut.click();		
	}

	public static void loginValidation(WebDriver driver) {
		
		String act_Title =driver.getTitle();
		String exp_Title = "OrangeHRM";
		
		if (act_Title.equals(exp_Title)) {
			
			System.out.println("Login Test Passed");
		} else {
			
			System.out.println("Login Test Failed");
		}		
	}

	public static void login(WebDriver driver) {
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		WebElement enterUserName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/div[2]/input"));
		enterUserName.sendKeys("Admin");
		
		WebElement enterPassword = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[2]/div/div[2]/input"));
		enterPassword.sendKeys("admin123");
		
		WebElement clickLogin =  driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[3]/button"));
		clickLogin.click();
	}
	
	

}
