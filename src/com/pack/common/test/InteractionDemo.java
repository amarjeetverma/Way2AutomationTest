package com.pack.common.test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.pack.base.TestBaseSetup;
import com.pack.common.packageObjects.BasePage;
import com.pack.common.packageObjects.indexPage;

public class InteractionDemo extends TestBaseSetup{
	
	private WebDriver driver;
	private BasePage basepage;
	private indexPage indexpage;
	
	private By signInLnk = By.xpath("//*[@id='load_box']/form/div/div/p/a");
	private By usrnm = By.xpath("//*[@id='login']/form/fieldset[1]/input");
	private By passwd = By.xpath("//*[@id='login']/form/fieldset[2]/input");
	private By submtbtn = By.xpath("//*[@id='login']/form/div/div[2]/input");
	
	@BeforeClass
	public void setUp(){
		driver= getDriver();
	}
	
	@Test(priority=1)
	public void clckDraggable() throws InterruptedException, AWTException{
		System.out.println("Starting the draggable functaionality testing...");
		basepage = new BasePage(driver);
		basepage.testDragFunction();
	}
	@Test(priority=2)
	public void clckSelectable() throws InterruptedException, AWTException{
		System.out.println("Starting the selectable functionality testing...");
		basepage =new BasePage(driver);
		basepage.testSelectFunctionality();
		
	}
	@Test(priority=3)
	public void clckSortable() throws InterruptedException, AWTException{
		System.out.println("Starting the sortable functionality testing...");
		basepage = new BasePage(driver);
		basepage.testSortableFunctionality();
	}
	
	@Test(priority=4)
	public void clckDatePicker() throws InterruptedException, AWTException{
		System.out.println("Starting the DatePicker functionality testing...");
		basepage = new BasePage(driver);
		basepage.TestDatePickerFunctionality();
	}
	
	@Test(priority=5)
	public void clckAlert() throws InterruptedException, AWTException{
		System.out.println("Starting the Alert functionality testing...");
		basepage = new BasePage(driver);
		basepage.TestAlertFunctionality();
	}
}
