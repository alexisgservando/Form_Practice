package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.EvaluationPage;
import pages.LoginPage;

public class Automation_Test {
	
	WebDriver driver;
	LoginPage loginPage;
	EvaluationPage evaluationPage;
	int counter;
	
	@BeforeTest
	public void setUpTest() {
		// Initializing the WebDriver
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get("https://tasks.evalartapp.com/automatization/");
		driver.manage().window().maximize();
	}

	@Test
	public void test1() 
	{
		for(int i = 0; i < 10; i++)
		{
			//Setting variables
			String user = "621826";
			String pass = "10df2f32286b7120Mi00LTYyODEyNg==30e0c83e6c29f1c3";
			String letter = "J";
			String expectedCharacters = "JJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJJ";
			
			try {
				//Login Process
				loginPage = new LoginPage(driver);
				loginPage.verifyLoginPageHeader();
				loginPage.fillUsernameField(user);
				loginPage.fillPasswordFied(pass);
				loginPage.clickSendButton();
			} catch (Exception e) {
				//Evaluation Page - First Grid
				evaluationPage = new EvaluationPage(driver);
				evaluationPage.verifyEvaluationPageHeader();
				WebElement[] numbers = evaluationPage.getNumbersInGrid();
				evaluationPage.multipleEight(numbers);
				
				//Evaluation Page - Second Grid
				evaluationPage.typeLetter88Times(letter, expectedCharacters);
				
				//Evaluation Page - Third Grid
				int resultGrid3 = evaluationPage.solveFirstMathOperation();
				WebElement[] numbers2 = evaluationPage.getNumbersInGrid3();
				evaluationPage.compareNumbersAndClick(numbers2, resultGrid3);
				
				//Evaluation Page - Fourth Grid
				int resultGrid4 = evaluationPage.solveSecondMathOperation();
				evaluationPage.selectResultFromDropdown(resultGrid4);
				
				//Click the Send Button
				evaluationPage.clickSendButton();
				
				// Looking for the error message
				evaluationPage.errorMessageIsPresent(counter);
			}
		}
		System.out.println("------END------");
	}

	@AfterTest
	public void tearDown() {
		//driver.close();
		//driver.quit();
	}
}
