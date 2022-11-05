package pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class taskpage {
	
	@FindBy(xpath = "//span[text()='Tasks']")
	public static WebElement task;
	
	@FindBy(xpath = "//a[@title='Show one more action']")
	public static WebElement task1;
	
	@FindBy(linkText  = "New Task")
	public static WebElement task2;

	@FindBy(xpath = "(//input[@role='combobox'])[2]")
	public static WebElement subject;
	
	@FindBy(xpath = "(//a[@class='select'])[1]")
	public static WebElement status;
	
	@FindBy(xpath = "//a[@title='Waiting on someone else']")
	public static WebElement status1;
	
	@FindBy(xpath = "//button[@title='Save']//span[1]")
	public static WebElement savebutton3;
	
	@FindBy(xpath = "//span[contains(@class,'toastMessage')]/a")
	public static WebElement title3;
	
	

}
