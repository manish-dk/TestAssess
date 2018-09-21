package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Manage {
	@FindBy(xpath="//*[@id=\"management-links\"]/tbody/tr[15]/td[2]/div[1]/a")
	private WebElement manageUsers;
	
	public WebElement getmanageUsers() {
		return manageUsers;
	}

}
