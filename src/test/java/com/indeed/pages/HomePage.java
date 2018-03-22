package com.indeed.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.indeed.utilities.Driver;

public class HomePage {
	private WebDriver driver;

	public HomePage() {
		this.driver = Driver.getDriver();
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//label[@for='text-input-what']")
	public WebElement whatLabel;
	
	@FindBy(xpath="//label[@for='text-input-where']")
	public WebElement whereLabel;
	
	@FindBy(xpath="//input[@id='text-input-what']")
	public WebElement text_input_what;

	@FindBy(xpath="//input[@id='text-input-where']")
	public WebElement text_input_where;
	
	@FindBy(xpath="//button[@class='icl-WhatWhere-button']")
	public WebElement findJobsButton;
	
	public String getTitle() {
		return driver.getTitle().toLowerCase();
	}
	
	
	public boolean verifyTitle(String title) {
		return driver.getTitle().equals(title);
	}
	public boolean verifyURL(String URL) {
		return driver.getCurrentUrl().equals(URL);
	}
	
	
}
