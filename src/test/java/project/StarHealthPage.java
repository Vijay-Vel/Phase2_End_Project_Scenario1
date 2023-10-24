package project;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class StarHealthPage {

WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.starhealth.in/");
	}
	
	@Test(priority='1')
	public void Validate_title()
	{
		System.out.println("The title of the page: "+ driver.getTitle());
		String ExpectedTitle = "Star Health Insurance: Medical, Accident and Travel insurance policies";
		String ActualTitle = driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle , "The title is not valid");
	}
	

	@Parameters({"name","mobile","email" })
	@Test(priority='2')
	public void Test_Header_plan(String name, String mobile, String email) throws InterruptedException
	{
		WebElement e1 = driver.findElement(By.xpath("//div[@class='Header_nav-link-container__nlUUp dropdown-active flex only-desktop']/descendant::p[1]"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(e1).perform();
		driver.findElement(By.xpath("((//div[@class='mb-20 flex align-center cursor-pointer menu-links'])[2])/descendant::a")).click();
		driver.findElement(By.xpath("((//div[@class='get-quote-form_request-quote__WudJV '])//descendant::input)[1]")).sendKeys("vijay");
		driver.findElement(By.xpath("((//div[@class='get-quote-form_request-quote__WudJV '])//descendant::input)[2]")).sendKeys("4508383083");
		driver.findElement(By.xpath("((//div[@class='get-quote-form_request-quote__WudJV '])//descendant::input)[3]")).sendKeys("600078");
		driver.findElement(By.xpath("((//div[@class='get-quote-form_request-quote__WudJV '])//descendant::span[10])")).click();
		
		Thread.sleep(2000);
		boolean selection = driver.findElement(By.xpath("(//span[@class='jss260'])[6]/descendant::input")).isSelected();
		Assert.assertTrue(selection); // check if the Authorize checkbox is slected or not
		
		WebElement a1 = driver.findElement(By.xpath("//input[@id='name']"));
		a1.clear();
		a1.sendKeys(name);
		
		WebElement a2 = driver.findElement(By.xpath("//input[@id='mobile']"));
		a2.clear();
		a2.sendKeys(mobile);
		
		WebElement a3 = driver.findElement(By.xpath("//input[@id='email']"));
		a3.clear();
		a3.sendKeys(email);
		
	}
	
	@Test(priority='3')
	public void Clickontwitter() throws InterruptedException
	{
		System.out.println("Twitter Link title check");
		driver.findElement(By.xpath("(//a[@class='mr-4 mr-10-xs'])[4]")).click();
		
		String ExpectedTitle = "Star Health & Allied Insurance Co Ltd (@StarHealthIns) / X";
		Thread.sleep(4000);
		String ActualTitle = driver.getTitle();
		assertEquals(ActualTitle, ExpectedTitle , "The title is not valid");
		
	}
	
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}
}
