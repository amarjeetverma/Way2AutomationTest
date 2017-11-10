package com.pack.common.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.pack.common.packageObjects.BasePage;
import com.pack.common.packageObjects.indexPage;

public class AlertHandling {

	private BasePage basepage;
	private indexPage indexpage;
	private WebDriver driver;
	
	public void clckAlert() throws InterruptedException, AWTException{
		System.out.println("Starting the Alert functionality testing...");
		basepage = new BasePage(driver);
		basepage.TestAlertFunctionality();
	}
}
