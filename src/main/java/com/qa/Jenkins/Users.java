package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Users {
	@FindBy(xpath=("//*[@id=\"tasks\"]/div[3]/a[2]"))
	private WebElement createUser;
	
	
	public WebElement getcreateUser() {
		return createUser;
	}
}
