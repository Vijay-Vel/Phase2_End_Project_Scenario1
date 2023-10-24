package project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Demo {
	
public void dummy() throws InterruptedException
{
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.starhealth.in/");
	
	Thread.sleep(3000);
	
	WebElement e1 = driver.findElement(By.xpath("//div[@class='Header_nav-link-container__nlUUp dropdown-active flex only-desktop']/descendant::p[1]"));
	
	Actions a = new Actions(driver);
	
	a.moveToElement(e1).perform();
	
	Thread.sleep(9000);
	driver.findElement(By.xpath("((//div[@class='mb-20 flex align-center cursor-pointer menu-links'])[2])/descendant::a")).click();
	
	Thread.sleep(9000);
	driver.findElement(By.xpath("//input[@id='name']")).sendKeys("vijay");
	driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("4508383083");
	driver.findElement(By.xpath("//input[@id='pinCode']")).sendKeys("600078");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//span[text()='Get a quote']")).click();

}
}
