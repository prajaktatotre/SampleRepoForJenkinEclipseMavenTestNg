package pom.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import pom.util.ExtentManager;

public class BaseTest {

	WebDriver driver = null;
	ExtentReports report = ExtentManager.getInstance();
	ExtentTest eTest = null;

	public void initialization() {

		eTest.log(LogStatus.INFO, "Setting propeties of broswer");

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		eTest.log(LogStatus.INFO, "Opening ZOHO url");

		driver.get("https://www.zoho.com/");
	}

	@AfterSuite
	public void tearDown() {
		driver.close();
	}
}