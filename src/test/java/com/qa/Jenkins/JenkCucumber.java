package com.qa.Jenkins;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class JenkCucumber {
	
	WebDriver driver;
	public static ExtentTest test;
	public static ExtentReports report;
	
	@Before
	public void setup() {
		report = new ExtentReports("C:\\Users\\Admin\\Desktop\\Reports\\jenkcureport.html",false);
		test = report.startTest("test");
		System.setProperty("webdriver.chrome.driver", Constants.driverPath);
		driver= new ChromeDriver();
		driver.get(Constants.websiteURL);
		driver.manage().window().maximize();
	}
	
	@After
	public void teardown() {
		driver.close();
		driver.quit();
		report.flush();
	}
	
	@Given("^that you are on the create UserScreen$")
	public void that_you_are_on_the_create_UserScreen()  {
	    // Write code here that turns the phrase above into concrete actions
		AdminLogPage adminLog = PageFactory.initElements(driver, AdminLogPage.class);
		Home homePage = PageFactory.initElements(driver, Home.class);
		Manage managePage = PageFactory.initElements(driver, Manage.class);
		Users userPage = PageFactory.initElements(driver, Users.class);
		
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
	}

	@When("^the User details are entered on the Create UserScreen$")
	public void the_User_details_are_entered_on_the_Create_UserScreen()  {
	    // Write code here that turns the phrase above into concrete actions
		CreateUser createPage = PageFactory.initElements(driver, CreateUser.class);
		createPage.getUserName().sendKeys("tester");
		createPage.getPassword().sendKeys("testpassword");
		createPage.getConPassword().sendKeys("testpassword");
		createPage.getFullName().sendKeys("Mr Tester");
	}

	@When("^the details are submitted on the Create UserScreen$")
	public void the_details_are_submitted_on_the_Create_UserScreen()  {
	    // Write code here that turns the phrase above into concrete actions
		CreateUser createPage = PageFactory.initElements(driver, CreateUser.class);
		createPage.getCreateBtn().click();
	}

	@Then("^the Username should be visible on the UsersScreen$")
	public void the_Username_should_be_visible_on_the_UsersScreen() throws InterruptedException {
		
		driver.get("http://localhost:8080/securityRealm/");
//	     Write code here that turns the phrase above into concrete actions
		
		
		
//		driver.findElement(By.partialLinkText("M4TT")).click();
		
//		driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr[2]/td[2]/a")).click();
		
		List<WebElement> listOf = driver.findElements(By.id("people"));
		
		System.out.println(listOf);
		
		for(WebElement ele:listOf) {
			
			if(ele.getText().contains("tester Mr Tester")) {
				test.log(LogStatus.PASS, "created user");
			}
			
		}
		
		Thread.sleep(1000);	
	}

	@When("^the User details \"([^\"]*)\" username, \"([^\"]*)\" password, \"([^\"]*)\" confirm Password, \"([^\"]*)\" Fullname and \"([^\"]*)\" EmailAddress are entered on the Create UserScreen$")
	public void the_User_details_username_password_confirm_Password_Fullname_and_EmailAddress_are_entered_on_the_Create_UserScreen(String arg1, String arg2, String arg3, String arg4, String arg5) {
	    // Write code here that turns the phrase above into concrete actions
		CreateUser createPage = PageFactory.initElements(driver, CreateUser.class);
		createPage.getUserName().sendKeys(arg1);
		createPage.getPassword().sendKeys(arg2);
		createPage.getConPassword().sendKeys(arg3);
		createPage.getFullName().sendKeys(arg4);
	}

	@Then("^the \"([^\"]*)\" username should be visible on the UsersScreen$")
	public void the_username_should_be_visible_on_the_UsersScreen(String arg1) {
	    // Write code here that turns the phrase above into concrete actions
		List<WebElement> listOf = driver.findElements(By.id("people"));
		
		System.out.println(listOf);
		
		for(WebElement ele:listOf) {
			
			if(ele.getText().contains(arg1)) {
				test.log(LogStatus.PASS, "created user");
			}
			
		}
	}

	@Given("^the \"([^\"]*)\" username is visible on the UsersScreen$")
	public void the_username_is_visible_on_the_UsersScreen(String arg1) throws Throwable {
		AdminLogPage adminLog = PageFactory.initElements(driver, AdminLogPage.class);
		Home homePage = PageFactory.initElements(driver, Home.class);
		Manage managePage = PageFactory.initElements(driver, Manage.class);
		Users userPage = PageFactory.initElements(driver, Users.class);
		
		test.log(LogStatus.INFO, "Started test");
		
		test.log(LogStatus.INFO, "Admin Logging in");
		adminLog.getAdminName().sendKeys(Constants.adminName);
		adminLog.getAdminPass().sendKeys(Constants.adminPass);
		adminLog.getAdminPass().submit();
		
		homePage.getManageUsers().click();
		test.log(LogStatus.INFO, "Navigating to Manage Users");
		
		managePage.getmanageUsers().click();
		test.log(LogStatus.INFO, "Navigating to users page");
	}

	@When("^the \"([^\"]*)\" username is clicked on the UserScreen$")
	public void the_username_is_clicked_on_the_UserScreen(String arg1) throws InterruptedException {
//		driver.get("http://localhost:8080/securityRealm/");
		Thread.sleep(2000);
		System.out.println("tasdhasjkldhsakdhas");
//	     Write code here that turns the phrase above into concrete actions
//		List<WebElement> eleList = driver.findElements(By.tagName("a"));
//		System.out.println(eleList.size());
//		
//		for(WebElement ele:eleList) {
//			
//			System.out.println(ele.toString());
//			
//			if(ele.getAttribute("href").equals(null)) {
//				continue;
//			}
//			System.out.println(ele.getAttribute("href"));
//			
//			
//			if(ele.getAttribute("href").contains(arg1)) {
//				ele.click();
//				Thread.sleep(2000);
//			}
//			
//			//*[@id="people"]/tbody/tr[3]/td[2]/a
//			//*[@id="people"]/tbody/tr[3]/td[2]/a
//			
//			
//		}
		
		for(int i=0;i<6;i++) {
			System.out.println(driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr["+i+"]/td[2]/a")).getAttribute("href"));
			if(driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr["+i+"]/td[2]/a")).getText().toLowerCase().equals("admin")) {
				driver.findElement(By.xpath("//*[@id=\"people\"]/tbody/tr["+i+"]/td[2]/a")).click();
			}
			
		}
		Thread.sleep(2000);
		
//		WebElement table = driver.findElement(By.id("people"));
		//*[@id="people"]
		//*[@id="people"]/tbody/tr[2]
		//*[@id="people"]/tbody
		
		
				
		
		
	}

	@Then("^the User Profile should display the \"([^\"]*)\" username on the ProfileScreen$")
	public void the_User_Profile_should_display_the_username_on_the_ProfileScreen(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the \"([^\"]*)\" Username's profile page has been loaded$")
	public void the_Username_s_profile_page_has_been_loaded(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^the configure button has been clicked on the profile page$")
	public void the_configure_button_has_been_clicked_on_the_profile_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I change the old email address on the Configure Page to a new email address \"([^\"]*)\"$")
	public void i_change_the_old_email_address_on_the_Configure_Page_to_a_new_email_address(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I save the changes to the Configure Page$")
	public void i_save_the_changes_to_the_Configure_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the Configure Page should show the new email address \"([^\"]*)\"$")
	public void the_Configure_Page_should_show_the_new_email_address(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}
