package stepdefinitions;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebDriver;

import config.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.RequestDemoPage;
import util.WebDriverObject;

import java.util.List;

public class RequestDemoSteps {
	
	private WebDriver driver = null;
	private RequestDemoPage requestDemoPage = null;
	
	@Before()
	public void init() {
		driver = WebDriverObject.getInstance();
		requestDemoPage = new RequestDemoPage(driver);
	}
	
	@Given("user is on Request a Demo page")
	public void getRequestDemoPage() {
		driver.get(ConfigReader.getUrl());
		driver.manage().window().maximize();
	}

	public void getGooglePage() {
		driver.get("https://www.google.ca");
	}
	
	@When("User enters all the required random data on request demo page")
	public void enterDataInTheForm() {
		requestDemoPage.enterRandomDataInForm();
	}
	@When("User can right click on an element on the page")
	public void reloadPageViaContextMenu() {

		requestDemoPage.rightClickOnElement();
	}

	@And("User clicks Request a Demo Today button")
	public void clickRequestDemoTodayButton() {
		requestDemoPage.clickRequestADemoTodayButton();
	}

	@When("user enters correct credentials on the login page")
	public void enterCorrectCredentials(DataTable dataTable) {
		List<String> credentials = dataTable.asList();
		for (String temp : credentials) {
			String username = credentials.get(0);
			String password = credentials.get(1);
			System.out.println("VVVVVV " + username + " " + password);
		}
		String username = credentials.get(0);
		String password = credentials.get(1);

		requestDemoPage.enterRandomDataInForm();
	}

	
	@Then("User should remain on the Request a Demo page")
	public void verifyRequestDemoPage() {
		requestDemoPage.verifyRequestDemoUrl();
	}
	
	@After
	public void tearDown() {
		WebDriverObject.closeDriver();
	}
}
