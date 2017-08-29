package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Config;
import utilities.Driver;

public class GoogleSearchStepDefinition {
	WebDriver driver;

	@Given("^On Google search result page$")
	public void on_Google_search_result_page() throws Throwable {
		driver = Driver.getDriver();
		driver.get(Config.getProperty("searchURL"));
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}

	@When("^I enter search item java and click search buttom$")
	public void i_enter_search_item_java_and_click_search_buttom() throws Throwable {
		System.out.println("searching for java");
		driver.findElement(By.id("lst-ib")).sendKeys(Config.getProperty("searchWord") + Keys.ENTER);
	}

	@Then("^Search result page for java should be displayed$")
	public void search_result_page_for_java_should_be_displayed() throws Throwable {

		System.out.println("Im in search result page");
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("resultStats"))));
		String title = driver.getTitle();
		Assert.assertEquals(title, Config.getProperty("searchWord")+" - Google Search");
	}
}
