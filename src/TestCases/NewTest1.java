package TestCases;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class NewTest1 extends CommonMethods{
  @Test
  public void f() throws InterruptedException {
	  
	  String url="http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Default.aspx";
		
           setUpDriver("Chrome", url);
		
		//login to the application
		sendText(driver.findElement(By.cssSelector("input[id$='username']")), "Tester");
		sendText(driver.findElement(By.cssSelector("input[id*='password']")), "test");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		//get number of rows and cols
		List<WebElement> rows=driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr"));
		List<WebElement> cols=driver.findElements(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr[1]/th"));
		
		//Click on the checkbox next to "Susan McLaren"
		String expectedValue="Canada";
		
		for (int i=1; i<=rows.size(); i++) {
			String rowText=driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr["+i+"]")).getText();
		
			if(rowText.contains(expectedValue)) {
				driver.findElement(By.xpath("//table[contains(@id, 'orderGrid')]/tbody/tr["+i+"]/td[1]")).click();
			}
		}
		
		Thread.sleep(5000);
		driver.quit();
  }
}