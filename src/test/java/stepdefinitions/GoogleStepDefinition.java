package stepdefinitions;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utilities.Config;
import utilities.Driver;

public class GoogleStepDefinition {
	WebDriver driver;
	String userWord, toLang;
	@Given("^On Google translate page$")
	public void on_Google_translate_page() throws Throwable {
//		System.setProperty(Config.getProperty("drivertype"), Config.getProperty("driverpath"));
//		driver = new ChromeDriver();
		driver=Driver.getDriver();
		driver.get(Config.getProperty("url"));
	}

	@When("^I choose source language$")
	public void i_choose_source_language() throws Throwable {
		System.out.println("as a source language has been choosen English ");

	}

	@When("^I choose target language$")
	public void i_choose_target_language() throws Throwable {
		driver.findElement(By.id("gt-tl-gms")).click();
	    toLang=Config.getProperty("toLanguage");
		
		WebElement toLanguage = driver.findElement(By.xpath("//div[.='"+toLang +"']"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(toLanguage));
		toLanguage.click();
		
		
	}

	@When("^I type a word into source field$")
	public void i_type_a_word_into_source_field() throws Throwable {
		//Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your text to translate:");
	   // userWord = scan.nextLine();
		userWord="hello";
		driver.findElement(By.id("source")).sendKeys(userWord);

		

	}

	@When("^I click on translate$")
	public void i_click_on_translate() throws Throwable {
		driver.findElement(By.id("gt-submit")).click();
		Thread.sleep(1000);
	}

	@Then("^Translation is displayed$")
	public void translation_is_displayed() throws Throwable {
		String translation = driver.findElement(By.id("gt-res-dir-ctr")).getText();
		if(!userWord.equalsIgnoreCase(translation)){
		System.out.println("Translation of your word to "+toLang+" is :" + translation);
		}else{
			driver.findElement(By.id("gt-swap")).click();
			Thread.sleep(1000);
			translation = driver.findElement(By.id("gt-res-dir-ctr")).getText();
			System.out.println("Translation of your word to "+toLang+" is :" + translation);
	}

}
	


}
