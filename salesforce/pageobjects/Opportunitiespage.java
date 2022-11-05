package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Opportunitiespage {
	
	@FindBy(xpath = "//a[@title='Opportunities']")
	public static WebElement opportunitiesbutton;
	

	@FindBy(xpath = "//div[@title='New']")
	public static WebElement newopportunities;
	

	@FindBy(xpath = "//label[text()='Opportunity Name']/following::input")
	public static WebElement opportunitiesname;
	
	@FindBy(xpath ="(//input[@role='combobox'])[1]")
	public static WebElement accname;
	
	@FindBy(xpath = "//lightning-base-combobox-formatted-text [@title='Vignesh']")
	public static WebElement acname1;
	
	@FindBy(xpath = "(//input[@class='slds-input'])[3]")
	public static WebElement closedate;
	
	@FindBy(xpath = "//button[contains(@class,'slds-combobox__input slds-input_faux')]")
	public static WebElement stage;
	
	@FindBy(xpath ="//span[@title= 'Needs Analysis']")
	public static WebElement stage1;
	
	@FindBy(xpath ="//button[@class='slds-button slds-button_brand']")
	public static WebElement savebutton2;
	
	@FindBy(xpath ="//span[contains(@class,'toastMessage')]/a")
	public static WebElement title2;
	
	

}
