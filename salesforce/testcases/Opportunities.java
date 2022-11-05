package testcases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import commonfunctions.commonfunctions;
import pageobjects.Opportunitiespage;

public class Opportunities extends commonfunctions {
	
	static Logger logger = Logger.getLogger(Opportunities.class);
	
	public void newopportunities() throws InterruptedException {
		testcase= extentReport.createTest("Verify opportunity page");
		testcase.log(Status.INFO, "Navigating to Opportunity page");
		
		logger.info("Navigating to opportunity page");
		PageFactory.initElements(driver, Opportunitiespage.class);
		js.executeScript("arguments[0].click();", (Opportunitiespage.opportunitiesbutton));
		Thread.sleep(2000);
		Opportunitiespage.newopportunities.click();
		
	}
	public void opportunityform() throws InterruptedException {
	
		logger.info("Creating new Opportunity");
		testcase.log(Status.INFO, "Creating new opportunity");
		Opportunitiespage.opportunitiesname.sendKeys(opportunityname);
		Thread.sleep(2000);
		Opportunitiespage.accname.sendKeys(accname);
		Opportunitiespage.acname1.click();
		Opportunitiespage.closedate.sendKeys("11/4/2022");
		js.executeScript("arguments[0].click();",(Opportunitiespage.stage));
		Opportunitiespage.stage1.click();
		js.executeScript("arguments[0].click();",(Opportunitiespage.savebutton2));
		Thread.sleep(2000);	
		
	}
	@Test
	public void oppverification() throws InterruptedException {
		newopportunities();
		opportunityform();
		logger.info("Getting the Opportunity details");
		String attribute = Opportunitiespage.title2.getAttribute("title");
	
		logger.	info("verification");
		if (attribute.contains(opportunityname)) {
			testcase.log(Status.PASS, "Opportunities created");
			
		} else {
			testcase.log(Status.FAIL, "Opportunities not created");
		}
		
		logger.	info("End of Opportunities test case ");
		testcase.log(Status.INFO, "End of Opportunities test case");
	}

}
