package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage 
{
	//WebDriver
	WebDriver driver;
	WebElement element;
	
	//Locators
	By loginHeader = By.cssSelector("h1[class='text-white text-center text-3xl p-3 m-3']");
	By usernameField = By.xpath("//input[@name='username']");
	By passwordField = By.xpath("//input[@name='password']");
	By sendButton = By.xpath("//button[@type='submit']");
	
	//Constructor
	public LoginPage(WebDriver driver) 
	{
		this.driver = driver;
	}
	
	//Methods
	public void verifyLoginPageHeader()
	{
		element = driver.findElement(loginHeader);
		String getHeaderText = element.getText().trim();
		System.out.println(getHeaderText);
		Assert.assertEquals("Log in", getHeaderText);
	}
	
	public void fillUsernameField(String username)
	{
		element = driver.findElement(usernameField);
		element.clear();
		element.sendKeys(username);
	}
	
	public void fillPasswordFied(String password)
	{
		element = driver.findElement(passwordField);
		element.clear();
		element.sendKeys(password);
	}
	
	public void clickSendButton()
	{
		WebElement element = driver.findElement(sendButton);
		element.click();
	}
}
