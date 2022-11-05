package commonfunctions;

import java.io.FileInputStream;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import org.apache.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;

public class commonfunctions {
	
	public static Properties  prop=null;
	public static WebDriver driver;
	public static JavascriptExecutor js;
	public static String accname;
	public static	String opportunityname;
	public static	String subject;
	public static	String username;
	public static	String password;
	static Logger logger = Logger.getLogger(commonfunctions.class);
	
	public static	 ExtentReports extentReport;
	
	public static		ExtentHtmlReporter htmlReporter;
	
	public static		ExtentTest testcase;
	
	public Properties loadpropertyfile() throws IOException {
		
		FileInputStream fileinput = new FileInputStream("config.properties");
		prop = new Properties();
		prop.load(fileinput);
		return prop;
	}
     @BeforeSuite
	public void launchbrowser() throws IOException {
		
		PropertyConfigurator.configure("salesforcelog4j.properties");
		logger.info("Salesforce applicaion testing begins");
		logger.info("Loading the property file");
		
		extentReport = new ExtentReports();
		htmlReporter = new ExtentHtmlReporter("F:/salesforcereport.html");
		extentReport.attachReporter(htmlReporter);
		
		
		loadpropertyfile();
		String browser = prop.getProperty("browser");
		String URL = prop.getProperty("url");
		accname= prop.getProperty("accountname");
		opportunityname=prop.getProperty("opportunityname");
		subject=prop.getProperty("subject");
		username= prop.getProperty("username");
		password= prop.getProperty("password");
		testcase= extentReport.createTest("Verify browser opened");
		if (browser.equalsIgnoreCase("chrome"))	{
			
		testcase.log(Status.INFO, "Navigating to Chrome");
			WebDriverManager.chromedriver().setup();
			logger.info("Launching Chrome browser");
			ChromeOptions ch = new ChromeOptions();
			ch.addArguments("--disable-notifications");
			driver = new ChromeDriver(ch);
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			testcase.log(Status.INFO, "Navigating to Firefox");
			WebDriverManager.firefoxdriver().setup();
			logger.info("Launching Firefox browser");
			FirefoxOptions options = new FirefoxOptions();
			options.setProfile(new FirefoxProfile());
			options.addPreference("dom.webnotifications.enabled", false);

			driver = new FirefoxDriver(options);
		}
			
		driver.manage().window().maximize();
		logger.info("Navigating to Application");
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		js= (JavascriptExecutor)driver;
	}
	@AfterSuite
	public void closebrowser() {
		testcase= extentReport.createTest("Verify browser closed");
		logger.info("Execution done. closing the browser");
		testcase.log(Status.INFO, "browser closed");
		
		driver.quit();
		extentReport.flush();
	}
}
