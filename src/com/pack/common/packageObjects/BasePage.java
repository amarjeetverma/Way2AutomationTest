package com.pack.common.packageObjects;

import java.util.ArrayList;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class BasePage {

	protected WebDriver driver;
	private By dragableLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[1]/a");
	private By droppableLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[2]/a");
	private By resizableLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[3]/a");
	private By selectableLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[4]/a");
	private By sortableLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[1]/ul/li[5]/a");
	private By accordionLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[1]/a");
	private By autocompleteLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[2]/a");
	private By datepickerLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[3]/a");
	private By menuLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[4]/a");
	private By sliderLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[5]/a");
	private By tabsLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[6]/a");
	private By tooltipLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[2]/ul/li[7]/a");
	private By framesandwindowLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[3]/ul/li[1]/a");
	private By submitbtnclkLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[4]/ul/li[1]/a");
	private By dropdownLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[4]/ul/li[1]/a");
	private By registrationLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[5]/ul/li[1]/a");
	private By alertLnk = By.xpath("//*[@id='wrapper']/div[2]/div[2]/div[6]/ul/li[1]/a");
	private By signInLnk = By.xpath("//*[@id='load_box']/form/div/div/p/a");
	private By usrnm = By.xpath("//*[@id='login']/form/fieldset[1]/input");
	private By passwd = By.xpath("//*[@id='login']/form/fieldset[2]/input");
	private By submtbtn = By.xpath("//*[@id='login']/form/div/div[2]/input");
	
	private By frame1 = By.xpath("//*[@id='example-1-tab-1']/div/iframe"); 
	private By txtinsidebox = By.xpath("//*[@id='droppable']/p");
	private By dragme = By.xpath("//*[@id='draggable'][1]");
	private By drophere = By.xpath("//*[@id='droppable'][1]");
	
	public BasePage(WebDriver driver){
		this.driver = driver;
	}
	
	public void loginToPage(String username,String pass){
		System.out.println("logging in popup..");
		WebElement usenametxtbox = driver.findElement(usrnm);
		WebElement passtxtbox = driver.findElement(passwd);
		WebElement submtLogin = driver.findElement(submtbtn);
		usenametxtbox.sendKeys("test");
		passtxtbox.sendKeys("test");
		submtLogin.click();
	}
	
	public indexPage clickdraggable(){
		WebElement draggable = driver.findElement(dragableLnk);
//		get new window
		String oldTab = driver.getWindowHandle();
		draggable.click();
		ArrayList<String> newTab =new ArrayList<String>(driver.getWindowHandles());
		newTab.remove(oldTab);
//		change focus to new tab
		driver.switchTo().window(newTab.get(0));
		WebElement signIn = driver.findElement(signInLnk);
		signIn.click();
		// Switch back
//	    driver.switchTo().window(windows.iterator().next());
//		Alert alert=driver.switchTo().alert();	
		loginToPage("test","test");
		driver.navigate().refresh();
		WebElement droppable = driver.findElement(droppableLnk);
		droppable.click();
		return new indexPage(driver);
	}
	
	public indexPage testDragFunction() throws InterruptedException{
		
		clickdraggable();
//		switching to iframe
		WebElement iframe1 = driver.findElement(frame1); 
		driver.switchTo().frame(iframe1);
		WebElement beforeDragTxt = driver.findElement(txtinsidebox);
		String dropHere = beforeDragTxt.getText();
		Assert.assertEquals(dropHere, "Drop here");
		WebElement draggPoint = driver.findElement(dragme);
		WebElement dropPoint = driver.findElement(drophere);
		Actions action = new Actions(driver);
		Action dragDrop = action.dragAndDrop(draggPoint, dropPoint).build();
		dragDrop.perform();
		Thread.sleep(5000);
		WebElement afterDragTxt = driver.findElement(txtinsidebox);
		String dropped = afterDragTxt.getText();
		Assert.assertEquals(dropped,"Dropped!");
		System.out.println("Finished!!");
		return new indexPage(driver);
	}
	
	public indexPage testSelectFunctionality(){
		
//		WebElement draggable = driver.findElement(dragableLnk);
////		get new window
//		String oldTab = driver.getWindowHandle();
//		draggable.click();
//		ArrayList<String> newTab =new ArrayList<String>(driver.getWindowHandles());
//		newTab.remove(oldTab);
////		change focus to new tab
//		driver.switchTo().window(newTab.get(0));
//		WebElement signIn = driver.findElement(signInLnk);
//		signIn.click();
//		loginToPage("test","test");
//		driver.navigate().refresh();
		WebElement selectable = driver.findElement(selectableLnk);
		selectable.click();
		
		WebElement iframe1 = driver.findElement(frame1);
		driver.switchTo().frame(iframe1);
		WebElement item2 = driver.findElement(By.xpath("//*[@id='selectable']/li[2]"));
		WebElement item4 = driver.findElement(By.xpath("//*[@id='selectable']/li[4]"));
		WebElement item5 = driver.findElement(By.xpath("//*[@id='selectable']/li[5]"));
//		WebElement items = driver.findElement(By.id("selectable"));
//		WebElement item1 = driver.findElement(By.xpath("//*[@id='selectable']/li[1]"));
//		WebElement item3 = driver.findElement(By.xpath("//*[@id='selectable']/li[3]"));
//		WebElement item6 = driver.findElement(By.xpath("//*[@id='selectable']/li[6]"));
//		WebElement item7 = driver.findElement(By.xpath("//*[@id='selectable']/li[7]"));
		String item2Colorb4 =item2.getCssValue("color");
		String item4Colorb4 =item4.getCssValue("color");
		String item5Colorb4 =item5.getCssValue("color");
		Assert.assertEquals(item2Colorb4, "rgba(34, 34, 34, 1)");
		Assert.assertEquals(item4Colorb4, "rgba(34, 34, 34, 1)");
		Assert.assertEquals(item5Colorb4, "rgba(34, 34, 34, 1)");
		
		Actions action = new Actions(driver);
		item2.click();
		action.keyDown(Keys.LEFT_CONTROL)
		.click(item4)
		.click(item5)
		.keyUp(Keys.LEFT_CONTROL)
		.build()
		.perform();
		String item2Coloraftr =item2.getCssValue("color");
		String item4Coloraftr =item4.getCssValue("color");
		String item5Coloraftr =item5.getCssValue("color");
		Assert.assertEquals(item2Coloraftr, "rgba(255, 255, 255, 1)");
		Assert.assertEquals(item4Coloraftr, "rgba(255, 255, 255, 1)");
		Assert.assertEquals(item5Coloraftr, "rgba(255, 255, 255, 1)");
		
		return new indexPage(driver);
	}
	
	public indexPage testSortableFunctionality(){
		
		WebElement selectable = driver.findElement(sortableLnk);
		selectable.click();
		WebElement iframe1 = driver.findElement(frame1);
		driver.switchTo().frame(iframe1);
		WebElement source = driver.findElement(By.xpath("//*[@id='sortable']/li[1]"));
		WebElement destination  = driver.findElement(By.xpath("//*[@id='sortable']/li[5]"));
		Point srcPoint = source.getLocation();
		Point desPoint = destination.getLocation();
		String itemTxtBeforeAction1 = source.getText();
		Assert.assertEquals(itemTxtBeforeAction1,"Item 1");
		String itemTxtBeforeAction2 = source.getText();
		Assert.assertEquals(itemTxtBeforeAction2,"Item 5");
		Actions action = new Actions(driver);
//		Action dragDrop = action.dragAndDrop(source, destination).build();
		Action dragDrop=action.dragAndDropBy(source, desPoint.getX(), desPoint.getY()).build();
		dragDrop.perform();
		Assert.assertEquals(itemTxtBeforeAction1,"Item 5");
		Assert.assertEquals(itemTxtBeforeAction2,"Item 1");
		return new indexPage(driver);
	}
	
}
