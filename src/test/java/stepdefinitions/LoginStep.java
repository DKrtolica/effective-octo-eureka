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
import pages.HomePage;
import pages.LoginPage;
import util.WebDriverObject;

import java.util.List;

public class LoginStep {
	
	private WebDriver driver = null;
	private LoginPage login = null;
	
	@Before()
	public void init() {
		driver = WebDriverObject.getInstance();
		login = new LoginPage(driver);
	}
	
	@Given("user is on login page")
	public void onLoginPage() {
		driver.get(ConfigReader.getUrl());
		driver.manage().window().maximize();
	}
	

	
	@When("user enters correct email and incorrect password {string} on the login page")
	public void enterCredentials(String password) {
		login.enterCredentials(ConfigReader.getUser(), password);
	}
	
	@And("click the sign in button")
	public void clickSignIn() {
		login.clickLoginButton();
	}
	
	@Then("user should not be allowed to login")
	public void verifyTheLoginPage() {
		boolean loginStatus = login.verifyLoginUnsuccessful();
		assertFalse(loginStatus);
	}

	@When("user enters correct username and password on the login page")
	public void enterCorrectCredentials() {
		login.enterCredentials(ConfigReader.getUser(), ConfigReader.getPassword());
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

		login.enterCredentials(ConfigReader.getUser(), ConfigReader.getPassword());
	}
	@And("user clicks on login button")
	public void clickTheLoginButton() {
		login.clickLoginButton();
	}
	
	@Then("user should land on the home page")
	public void verifyHomePage() {
		HomePage homePage = new HomePage(driver);
		homePage.waitForHomePageToLoad();
		assertTrue(homePage.isHomePageDisplayed());
	}
	
	@After
	public void tearDown() {
		WebDriverObject.closeDriver();
	}
}
