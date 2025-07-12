package baseClass;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import genericUtilities.PropertiesFileUtility;
import objectRepository.LoginPage;
import objectRepository.LogoutPage;

public class BaseClass {
	public WebDriver driver;
	public PropertiesFileUtility pfu = new PropertiesFileUtility();
//	public WebDriverUtility wutil = new WebDriverUtility();
	public static WebDriver sDriver = null; //for listeners
	
	@BeforeSuite
	public void configBeforeSuite() {
		Reporter.log("Establish the DB connectivity", true);
	}

	@BeforeTest
	public void configBeforeTest() {
		Reporter.log("Pre-condition", true);
	}

	@BeforeClass
	public void configBeforeClass() throws IOException {
		Reporter.log("Launching the browser", true);
		String BROWSER = pfu.getDataFromPropertiesFile("browser");
		String URL = pfu.getDataFromPropertiesFile("url");

		// CROSS BROWSER TESTING
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
		sDriver = driver; //for listeners
		// Launching the URL
		driver.manage().window().maximize();
//		wutil.waitForPageToLoad(driver);
		driver.get(URL);
	}

	@BeforeMethod
	public void configBeforeMethod() throws IOException {
		Reporter.log("Login action started", true);
		String USERNAME = pfu.getDataFromPropertiesFile("username");
		String PASSWORD = pfu.getDataFromPropertiesFile("password");

		LoginPage lip = new LoginPage(driver);
		lip.Login(USERNAME, PASSWORD);
		Reporter.log("Login successful", true);
	}

	@AfterMethod
	public void configAfterMethod() throws InterruptedException {
		Reporter.log("LogOut action started", true);
		LogoutPage lop = new LogoutPage(driver);
//		wutil.waitForVisibilityOfWebelement(driver, lpg.getLogOut());
		lop.Logout();
		Reporter.log("Logged out successfully", true);
	}

	@AfterClass
	public void configAfterClass() {
		driver.close();
		Reporter.log("Browser closed", true);
	}

	@AfterTest
	public void configAfterTest() {
		Reporter.log("Post-condition", true);
	}

	@AfterSuite
	public void configAfterSuite() {
		Reporter.log("Disconnect DB", true);
	}
}
