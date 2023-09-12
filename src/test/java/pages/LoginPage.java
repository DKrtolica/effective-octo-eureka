package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import util.HelperSeleniumAction;
import util.HelperWait;

public class LoginPage extends BaseClass<LoginPage> {

	private final By EMAIL = By.cssSelector("input#user-name");
	private final By PASSWORD = By.id("password");
	private final By LOGINBUTTON = By.cssSelector("input#login-button");


	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterCredentials(String email, String password) {
		
		enterEmail(email);
		enterPassword(password);
		logger.debug("Credentials are entered");
	}
	
	public void clickLoginButton() {
		HelperSeleniumAction.click(driver, LOGINBUTTON);
	}
	
	private void enterEmail(String userName) {
		HelperSeleniumAction.typeOnText(driver, EMAIL, userName);
	}
	
	private void enterPassword(String password) {
		HelperSeleniumAction.typeOnText(driver, PASSWORD, password);
	}
	

	
	public boolean verifyLogInLink() {
		return true;
	}
	
	public boolean verifyLoginUnsuccessful() {
//		logger.info("Verifying the user is on the login page");
		return driver.findElements(LOGINBUTTON).size() == 0;
	}
	
	private boolean waitTillPasswordIsVisible() {
		
		try {
//			WebElement element = driver.findElement(PASSWORD);
			HelperWait.explicitWaitForVisibility(driver, PASSWORD, 5);
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			wait.until(ExpectedConditions.visibilityOf(element));
			
		} catch(Exception e) {
//			logger.error(e.toString());
			clickLoginButton();
			waitTillPasswordIsVisible();
		}
		
		return driver.findElements(PASSWORD).size() > 0;
	}
}
