package testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import commonfunctions.commonfunctions;
import pageobjects.Accountspage;
import pageobjects.Applauncherpage;

import pageobjects.Login_page;

public class Contact extends commonfunctions {
	static Logger logger = Logger.getLogger(Contact.class);

	public void login() {
		testcase= extentReport.createTest("Verify login page");
		testcase.log(Status.INFO, "Navigating to login page");
		logger.info("Logging in to application");
		PageFactory.initElements(driver,Login_page.class);
		Login_page.username.sendKeys(username);
		Login_page.password.sendKeys(password);
		Login_page.loginbutton.click();
		testcase.log(Status.INFO, "logged into application");
	}
	
	public void newacc() throws InterruptedException {
		testcase= extentReport.createTest("Verify account page");
		testcase.log(Status.INFO, "Navigating to Account");
		
		testcase.log(Status.INFO, "Creating new Account");
		logger.info("Creating new contact");
		PageFactory.initElements(driver,Applauncherpage.class);
		Applauncherpage.applauncher.click();
		Applauncherpage.viewall.click();
		Applauncherpage.sales.click();
		PageFactory.initElements(driver,Accountspage.class);
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", (Accountspage.accounts));
		Thread.sleep(2000);
		Accountspage.newbutton.click();
		Thread.sleep(2000);
	}

	public void accform() throws InterruptedException {
		
		Accountspage.accname.sendKeys(accname);
		js.executeScript("arguments[0].click();", (Accountspage.ownership));
		Accountspage.ownershippublic.click();
		Accountspage.savebutton1.click();
	
	}
	@Test
	public void verifyingaccount() throws InterruptedException {
		login();
		newacc() ;
		accform();
	
		logger.info("Getting the contact details");
		String attribute = Accountspage.title1.getAttribute("title");
		
		logger.	info("verification");
		if (attribute.contains(accname)) {
			testcase.log(Status.PASS, "Account created");
			
		} else {
			testcase.log(Status.FAIL, "contact not created");
			
		}
		logger.	info("End of Contact test case ");
		
		testcase.log(Status.INFO, "End of Account test case");
	}

}


