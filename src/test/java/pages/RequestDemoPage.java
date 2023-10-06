package pages;

import config.ConfigReader;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.interactions.Actions;
import util.HelperSeleniumAction;

public class RequestDemoPage extends BaseClass<RequestDemoPage> {

	private  By firstNameFieldLocator = By.cssSelector("input#FirstName");
	private  By lastNameFieldLocator = By.cssSelector("input#LastName");
	private  By companyFieldLocator = By.cssSelector("input#Company");
	private  By emailFieldLocator = By.cssSelector("input#Email");
	private  By phoneNumberFieldLocator = By.cssSelector("input#Phone");
	private  By commentsFieldLocator = By.cssSelector("textarea#Comments__c");
	private  By fleetSizeFieldLocator = By.cssSelector("input#of_Vehicle_Units__c");
	private  By requestADemoTodayButtonLocator = By.cssSelector("div.mktoButtonRow  button.mktoButton");

	private By webPage = By.cssSelector("body.page-template");

    private	Actions actions = new Actions(driver);


	public RequestDemoPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterRandomDataInForm() {
		enterFirstName(this.getRandomString(10, true, true));
		enterLastName(this.getRandomString(10, true, true));
		enterCompany(this.getRandomString(10, true, true));
		enterEmail(this.getRandomString(5, true, true)  + "@" + this.getRandomString(5, true, true) );
		enterPhoneNumber(this.getRandomString(10, false, true));
		enterComments(this.getRandomString(50, true, true));
		enterFleetSize(this.getRandomString(4, false, true));
		logger.debug("ALl data is entered");
	}

	public void rightClickOnElement() {
           HelperSeleniumAction.rightClickOnElement(driver, firstNameFieldLocator );
		   HelperSeleniumAction.rightClickOnElement(driver, requestADemoTodayButtonLocator );
	}

	private void enterFirstName (String firstName) {
		HelperSeleniumAction.typeText(driver, firstNameFieldLocator, firstName);
	}
	private void enterLastName(String lastName) {
		HelperSeleniumAction.typeText(driver, lastNameFieldLocator, lastName);
	}
	private void enterCompany (String company) {
		HelperSeleniumAction.typeText(driver, companyFieldLocator, company);
	}

	private void enterEmail (String email) {
		HelperSeleniumAction.typeText(driver, emailFieldLocator, email);
	}
	private void enterPhoneNumber (String phone) {
		HelperSeleniumAction.typeText(driver, phoneNumberFieldLocator, phone);
	}
	private void enterComments (String comments) {
		HelperSeleniumAction.typeText(driver, commentsFieldLocator, comments);
	}
	private void enterFleetSize (String fleetSize) {
		HelperSeleniumAction.typeText(driver, fleetSizeFieldLocator, fleetSize);
	}

	public void clickRequestADemoTodayButton() {
		HelperSeleniumAction.click(driver, requestADemoTodayButtonLocator);
	}
	
	public void verifyRequestDemoUrl() {
		String expectedUrl = ConfigReader.getUrl();
		String actualUrl = driver.getCurrentUrl();
		Assert.assertTrue(expectedUrl.equals(actualUrl));
	}



private String getRandomString(int length, boolean letters, boolean numbers) {
	return  RandomStringUtils.random(length, letters, numbers);

	}

}
