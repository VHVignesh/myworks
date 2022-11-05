package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import org.apache.log4j.Logger;
import commonfunctions.commonfunctions;
import pageobjects.taskpage;

public class Task extends commonfunctions {
   
static	Logger logger = Logger.getLogger(commonfunctions.class);
	public void newtask() throws InterruptedException {
		testcase= extentReport.createTest("Verify Task page");
		testcase.log(Status.INFO, "Navigating to Task page");
		testcase.log(Status.INFO, "Creating new Task");
		logger.info("Navigating to task page");
		PageFactory.initElements(driver, taskpage.class);
		js.executeScript("arguments[0].click();", (taskpage.task));
		Thread.sleep(2000);
		taskpage.task1.click();
		taskpage.task2.click();
		logger.info("Creating new Task");
		taskpage.subject.sendKeys(subject);
		taskpage.status.click();
		taskpage.status1.click();
		Thread.sleep(2000);
		taskpage.savebutton3.click();
		Thread.sleep(2000);
	}
	@Test
	public void Verifyingnewtask() throws InterruptedException {
		newtask() ;
	
		logger.info("Getting the task details");
		String attribute3 = taskpage.title3.getAttribute("title");
		logger.	info("verification");
		if (attribute3.contains(subject)) {
			testcase.log(Status.PASS, "Task created");
			
		} else {
			testcase.log(Status.FAIL, "Task not created");
		

	}
		logger.	info("End of Task test case ");
		testcase.log(Status.INFO, "End of Account test case");
	}}
