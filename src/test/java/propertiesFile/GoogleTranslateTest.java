package propertiesFile;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.Config;

public class GoogleTranslateTest {
	static WebDriver driver;

	@BeforeClass
	public static void setUp() {
		System.setProperty(Config.getProperty("drivertype"), Config.getProperty("driverpath"));
		driver = new ChromeDriver();
		driver.get(Config.getProperty("url"));

	}

	@Test
	public void test() throws InterruptedException {
		System.out.println(Config.getProperty("url"));
		driver.findElement(By.id("gt-tl-gms")).click();
		String toLang = Config.getProperty("toLanguage");

		WebElement toLanguage = driver.findElement(By.xpath("//div[.='" + toLang + "']"));
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(toLanguage));
		toLanguage.click();

		// driver.findElement(By.id(":5k")).click();
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter your text to translate:");
		String userWord = scan.nextLine();
		driver.findElement(By.id("source")).sendKeys(userWord);

		driver.findElement(By.id("gt-submit")).click();
		Thread.sleep(1000);
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// wait.until(ExpectedConditions.);
		String translation = driver.findElement(By.id("gt-res-dir-ctr")).getText();
		if (!userWord.equalsIgnoreCase(translation)) {
			System.out.println("Translation of your word to " + toLang + " is :" + translation);
		} else {
			driver.findElement(By.id("gt-swap")).click();
			Thread.sleep(1000);
			translation = driver.findElement(By.id("gt-res-dir-ctr")).getText();
			System.out.println("Translation of your word to " + toLang + " is :" + translation);
		}

	}

}
