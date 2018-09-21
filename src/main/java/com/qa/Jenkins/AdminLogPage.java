package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AdminLogPage {
	@FindBy(xpath="//*[@id=\"j_username\"]")
	private WebElement adminName;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/div/form/table/tbody/tr[2]/td[2]/input")
	private WebElement adminPass;
	
	public WebElement getAdminName() {
		return adminName;
	}
	
	public WebElement getAdminPass() {
		return adminPass;
	}

}
