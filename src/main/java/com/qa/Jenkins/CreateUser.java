package com.qa.Jenkins;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUser {
	@FindBy(xpath="//*[@id=\"username\"]")
	private WebElement userName;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[2]/td[2]/input")
	private WebElement password;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[3]/td[2]/input")
	private WebElement conPassword;
	
	@FindBy(xpath="//*[@id=\"main-panel\"]/form/div[1]/table/tbody/tr[4]/td[2]/input")
	private WebElement fullName;
	
	@FindBy(xpath="//*[@id=\"yui-gen3-button\"]")
	private WebElement createButton;
	
	public WebElement getUserName() {
		return userName;
		
	}
	
	public WebElement getPassword() {
		return password;
		
	}

	public WebElement getConPassword() {
		return conPassword;
	
	}
	
	public WebElement getFullName() {
		return fullName;
		
	}
	
	public WebElement getCreateBtn() {
		return createButton;
		
	}

}
