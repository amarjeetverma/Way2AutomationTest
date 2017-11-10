package com.pack.common.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;

import com.pack.common.packageObjects.BasePage;
import com.pack.common.packageObjects.indexPage;

public class DragAndDrop {
	private indexPage indexpage;
	private BasePage basepage;
	private WebDriver driver;
	
	public void clkDragable() throws InterruptedException, AWTException{
		System.out.println("Starting the draggable functaionality testing...");
		basepage = new BasePage(driver);
		basepage.testDragFunction();
	}

}
