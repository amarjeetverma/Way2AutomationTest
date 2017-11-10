package com.pack.common.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.pack.common.packageObjects.BasePage;
import com.pack.common.packageObjects.indexPage;

class SortingTabsByDrag {

	private BasePage basepage;
	private indexPage indexpage;
	private WebDriver driver;
	
	public void clckSortable() throws InterruptedException, AWTException{
		System.out.println("Starting the sortable functionality testing...");
		basepage = new BasePage(driver);
		basepage.testSortableFunctionality();
	}
}
