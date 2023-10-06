package util;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelperWait {


	public static void implicitWait(WebDriver driver, long seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
	}
	
	public static void explicitWaitForVisibility(WebDriver driver, By element, long seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
	}

	public static void waitForElementVisible(WebDriver driver, By element, long seconds) {
		Wait wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(Exception.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public static void waitForElementClickable(WebDriver driver, By element, long seconds) {
		 Wait wait = new FluentWait<WebDriver>(driver)
				 .withTimeout(Duration.ofSeconds(5))
				 .pollingEvery(Duration.ofMillis(200))
				 .ignoring(Exception.class);
		 wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitForElementClickable(WebDriver driver, WebElement element, long seconds) {
		Wait wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(5))
				.pollingEvery(Duration.ofMillis(200))
				.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
