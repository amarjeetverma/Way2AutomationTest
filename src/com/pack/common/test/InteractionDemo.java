package com.pack.common.test;

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
	@Test
	public void clckDraggable() throws InterruptedException{
		System.out.println("Starting the draggable functaionality testing...");
		basepage = new BasePage(driver);
//		basepage.clickdraggable();
		basepage.testDragFunction();
	}
//	@Test
	public void clckSelectable(){
		System.out.println("Starting the selectable functionality testing...");
		driver.navigate().back();
		basepage =new BasePage(driver);
		basepage.testSelectFunctionality();
		
	}
	@Test
	public void clckSortable(){
		System.out.println("Starting the sortable functionality testing...");
		driver.navigate().back();
		basepage = new BasePage(driver);
		basepage.testSortableFunctionality();
	}
}
