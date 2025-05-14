import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SalesforceLoginTest {
	public static void main(String args[]) throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<>();
		prefs.put("profile.default_content_setting_values.notifications", 2); // 1=Allow, 2=Block
		options.setExperimentalOption("prefs", prefs);

		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("Tester@cloudf.com");
		driver.findElement(By.id("password")).sendKeys("Salesforce@123");
		driver.findElement(By.id("Login")).submit();
		String ExpectedTitle = "Home | Salesforce";
		String ActualTitle = "";
		Thread.sleep(2000);
		ActualTitle = driver.getTitle();
		System.out.println("ActualTitle::" + ActualTitle);
		if (ActualTitle.contains(ExpectedTitle)) {
			System.out.println(ActualTitle);
		} else {
			System.out.println("Log in failed");
		}
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement appLauncher = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='slds-r6']")));
		appLauncher.click();
		WebElement searchInput = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@placeholder='Search apps and items...']")));
		searchInput.click();
		searchInput.sendKeys("Sales");
		driver.findElement(By.xpath("(//b[contains(text(),'Sales')])[3]")).click();
		Thread.sleep(2000);
		
		// driver.findElement(By.xpath("//a[@title='Accounts']")).click();
		//Thread.sleep(2000);
		WebElement accountsTab = wait.until(ExpectedConditions.visibilityOfElementLocated(
			    By.xpath("//a[@title='Accounts']")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", accountsTab);

	}
}
