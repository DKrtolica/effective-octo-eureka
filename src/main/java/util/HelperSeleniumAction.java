package util;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class HelperSeleniumAction {

	public static void click(WebDriver driver, By element) {
		HelperWait.waitForElementClickable(driver,element,4);
		driver.findElement(element).click();
	}
	
	public static void typeText(WebDriver driver, By element, String text) {
		HelperWait.waitForElementClickable(driver,element,4);
		driver.findElement(element).click();
		driver.findElement(element).sendKeys(text);
	}

	public WebElement getElement(WebDriver driver, By locator) {
		return  driver.findElement(locator);
	}



	public static void rightClickOnElement (WebDriver driver, By locator) {
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(locator);
		HelperWait.waitForElementClickable(driver,element,4);
    	actions.contextClick(element).build().perform();
		System.out.println("something to print");

	}
}
