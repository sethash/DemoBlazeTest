package DemoBlaze.DemoBlaze;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class BlazeTests {
	
WebDriver driver;
String path= System.getProperty("user.dir");



@BeforeTest
public void launchBrowser()
{

	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	driver.get("https://demoblaze.com/index.html#");
}

@Test
public void PlaceOrder() throws InterruptedException
{
	
	driver.findElement(By.xpath("//*[text()=\"Laptops\"]")).click();
	driver.findElement(By.xpath("//*[text()=\"Sony vaio i5\"]")).click();
	driver.findElement(By.xpath("//*[text()=\"Add to cart\"]")).click();
	WebDriverWait wait = new WebDriverWait(driver, 2);
    wait.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
	
	driver.findElement(By.xpath("//*[text()=\"Home \"]")).click();
	driver.findElement(By.xpath("//*[text()=\"Laptops\"]")).click();
	driver.findElement(By.xpath("//*[text()=\"Dell i7 8gb\"]")).click();
	driver.findElement(By.xpath("//*[text()=\"Add to cart\"]")).click();
	WebDriverWait waits = new WebDriverWait(driver, 2);
    waits.until(ExpectedConditions.alertIsPresent());
	driver.switchTo().alert().accept();
	driver.findElement(By.xpath("//*[text()=\"Cart\"]")).click();
	driver.findElement(By.xpath("(//*[text()=\"Delete\"])[2]")).click();
	Thread.sleep(10000);
	driver.findElement(By.xpath("//*[text()=\"Place Order\"]")).click();
	
	//Fill up the form
	
	driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("ashish");
	driver.findElement(By.xpath("//*[@id=\"card\"]")).sendKeys("12345678");
	driver.findElement(By.xpath("//*[text()=\"Purchase\"]")).click();
	
	String PurchaseLogs = driver.findElement(By.xpath("//*[contains(text(),\"Id\")]")).getText();
	System.out.println(PurchaseLogs);
	
	String[] Details= PurchaseLogs.split(":");
	
	Assert.assertEquals("790", Details[2].split(" ")[1]);
	
	
	
	
	
	
	
}

@AfterTest
public void quit()
{
	driver.quit();
}

}
