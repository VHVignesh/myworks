package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Applauncherpage {
	
	@FindBy(xpath = "//div[@class='slds-icon-waffle']")
	public static WebElement applauncher;
	
	@FindBy(xpath = "//button[text()='View All']")
	public static WebElement viewall;
	
	@FindBy(xpath = "//p[text()='Sales']")
	public static WebElement sales;
	

}
