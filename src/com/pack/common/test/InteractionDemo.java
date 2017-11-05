package com.pack.common.test;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.common.packageObjects.BasePage;
import com.pack.common.packageObjects.indexPage;

public class InteractionDemo extends TestBaseSetup{
	
	private WebDriver driver;
	private BasePage basepage;
	private indexPage indexpage;
	
	@BeforeClass
	public void setUp(){
		driver= getDriver();
	}
//	@Test
	public void clckDraggable() throws InterruptedException, AWTException{
		System.out.println("Starting the draggable functaionality testing...");
		basepage = new BasePage(driver);
		basepage.testDragFunction();
	}
//	@Test
	public void clckSelectable() throws InterruptedException, AWTException{
		System.out.println("Starting the selectable functionality testing...");
		basepage =new BasePage(driver);
		basepage.testSelectFunctionality();
		
	}
	@Test
	public void clckSortable() throws InterruptedException, AWTException{
		System.out.println("Starting the sortable functionality testing...");
		basepage = new BasePage(driver);
		basepage.testSortableFunctionality();
	}
}
