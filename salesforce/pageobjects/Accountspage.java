package pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Accountspage {
	
	@FindBy(xpath = "//span[text()='Accounts']")
	public static WebElement accounts;

	@FindBy(xpath = "//div[text()='New']")
	public static WebElement newbutton;

	@FindBy(xpath = "(//input[@class='slds-input'])[2]")
	public static WebElement accname;

	@FindBy(xpath = "(//button[contains(@class,'slds-combobox__input slds-input_faux')])[3]")
	public static WebElement ownership;
	
	@FindBy(xpath = "//span[@class='slds-truncate'][text()='Public']")
	public static WebElement ownershippublic;
	
	@FindBy(xpath = "//button[text()='Save']")
	public static WebElement savebutton1;
	
	@FindBy(xpath = "//span[contains(@class,'toastMessage')]/a")
	public static WebElement title1;
	

}
