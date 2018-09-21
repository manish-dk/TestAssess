package com.qa.Jenkins;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class JenkTest {
	
	WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	
	@BeforeClass
	public static void beforeClass() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\jenkreport.html",true);
	}
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", Constants.driverPath);
		driver = new ChromeDriver();
	}
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
	}
	
	@AfterClass
	public static void afterClass() {
		report.flush();
		report.close();
	}
	
	
	@Test
	public void createUserT() {
		test = report.startTest("Create User");
		driver.get(Constants.websiteURL);
		driver.manage().window().maximize();
		
		AdminLogPage adminLog = PageFactory.initElements(driver, AdminLogPage.class);
		Home homePage = PageFactory.initElements(driver, Home.class);
		Manage managePage = PageFactory.initElements(driver, Manage.class);
		Users userPage = PageFactory.initElements(driver, Users.class);
		CreateUser createPage = PageFactory.initElements(driver, CreateUser.class);
		
		test.log(LogStatus.INFO, "Started test");
		
		test.log(LogStatus.INFO, "Admin Logging in");
		adminLog.getAdminName().sendKeys(Constants.adminName);
		adminLog.getAdminPass().sendKeys(Constants.adminPass);
		adminLog.getAdminPass().submit();
		
		homePage.getManageUsers().click();
		test.log(LogStatus.INFO, "Navigating to Manage Users");
		
		managePage.getmanageUsers().click();
		test.log(LogStatus.INFO, "Navigating to users page");
		
		userPage.getcreateUser().click();
		test.log(LogStatus.INFO, "Navigating to create user page");
		
		createPage.getUserName().sendKeys("testuser");
		createPage.getPassword().sendKeys("testpassword");
		createPage.getConPassword().sendKeys("testpassword");
		createPage.getFullName().sendKeys("Mr Tester");
		
		test.log(LogStatus.INFO, "Creating User");
		
		report.endTest(test);
		
		
	}

}
