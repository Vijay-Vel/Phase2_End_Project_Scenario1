package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

public class StarHealth002 {
	
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.starhealth.in/");
	}
	@Test(priority = 4)
	public void print_link()
	{
	
		System.out.println("Links in Home Page:");
	String link1=	driver.findElement(By.linkText("Blog")).getAttribute("href");
	System.out.println(link1);
	
	String link2=	driver.findElement(By.xpath("((//div[@class='flex align-center ml-8'])[2])/descendant::a[1]")).getAttribute("href");
	System.out.println(link2);
	
	String link3=	driver.findElement(By.xpath("((//div[@class='flex align-center ml-8'])[2])/descendant::a[2]")).getAttribute("href");
	System.out.println(link3);
	
	String link4=	driver.findElement(By.linkText("Renew")).getAttribute("href");
	System.out.println(link4);
	
	WebElement e1 = driver.findElement(By.xpath("(//div[@class='Header_lang-icon__DgerT'])[1]/descendant::img"));
	
	Actions a = new Actions(driver);
	
	a.moveToElement(e1).perform();
	
	String link5=	driver.findElement(By.linkText("Tamil")).getAttribute("href");
	System.out.println(link5);
	
	String link6=	driver.findElement(By.linkText("Hindi")).getAttribute("href");
	System.out.println(link6);
	
	String link7=	driver.findElement(By.linkText("Marathi")).getAttribute("href");
	System.out.println(link7);
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
	}

}
