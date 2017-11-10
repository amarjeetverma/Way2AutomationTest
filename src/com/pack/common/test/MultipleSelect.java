package com.pack.common.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.pack.common.packageObjects.BasePage;
import com.pack.common.packageObjects.indexPage;

public class MultipleSelect {

	private BasePage basepage;
	private indexPage indexpage;
	private WebDriver driver;
	
	public void clckSelectable() throws InterruptedException, AWTException{
		System.out.println("Starting the selectable functionality testing...");
		basepage =new BasePage(driver);
		basepage.testSelectFunctionality();
	}
}