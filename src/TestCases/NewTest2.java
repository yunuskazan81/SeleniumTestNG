package TestCases;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import utils.CommonMethods;

public class NewTest2 extends CommonMethods {
	
  @Test
  public void f() throws InterruptedException {
	  
	  String url= "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";
		setUpDriver("chrome", url);
		
		
		driver.findElement(By.cssSelector("input#ctl00_MainContent_username")).sendKeys("Tester");
		driver.findElement(By.cssSelector("input#ctl00_MainContent_password")).sendKeys("test");
		driver.findElement(By.cssSelector("input#ctl00_MainContent_login_button")).click();  //a[text()='Order']
		
		driver.findElement(By.xpath("//a[text()='Order']")).click();
		
		
		
		WebElement alloptions=  driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct"));
		
		Select select= new Select(alloptions);
		
		List<WebElement> dropdown= select.getOptions();
		
		Iterator<WebElement> it= dropdown.iterator();
		
		while(it.hasNext()) {
			
			String options= it.next().getText();
			
			System.out.println(options);	
		}
		
		if(select.isMultiple()) {
		select.selectByVisibleText("ScreenSaver");
		}
		
		driver.findElement(By.cssSelector("input[id*='txtQuantity']")).sendKeys("4");  
		driver.findElement(By.cssSelector("input[id*='txtUnitPrice']")).sendKeys("100");
		driver.findElement(By.cssSelector("input[id*='txtDiscount']")).sendKeys("25");
		driver.findElement(By.cssSelector("input[value*='Calculate']")).click();  
		
	WebElement resetBut=driver.findElement(By.cssSelector("input[value*='Reset']"));
	
	if(resetBut.isDisplayed() & resetBut.isEnabled()) {
		
		resetBut.click();
	}
	
	
	WebElement alloption=  driver.findElement(By.cssSelector("select#ctl00_MainContent_fmwOrder_ddlProduct"));
	
	Select select1= new Select(alloption);
	
	List<WebElement> dropdown1= select1.getOptions();
	
	Iterator<WebElement> It= dropdown1.iterator();
	
	while(it.hasNext()) {
		
		String option= It.next().getText();
		
		System.out.println(option);	
	}
	
	
	if(select1.isMultiple()) {
		select1.selectByVisibleText("ScreenSaver");
		}
		
		driver.findElement(By.cssSelector("input[id*='txtQuantity']")).sendKeys("4");  
		driver.findElement(By.cssSelector("input[id*='txtUnitPrice']")).sendKeys("100");
		driver.findElement(By.cssSelector("input[id*='txtDiscount']")).sendKeys("25");
		driver.findElement(By.cssSelector("input[value*='Calculate']")).click();  
		
		driver.findElement(By.cssSelector("input[id*='txtName']")).sendKeys("Yunus Kazan");
		driver.findElement(By.cssSelector("input[id*='TextBox2']")).sendKeys("4830 mariners way");
		driver.findElement(By.cssSelector("input[id*='TextBox3']")).sendKeys("Coconut Creek");
		driver.findElement(By.cssSelector("input[id*='TextBox4']")).sendKeys("FL");
		driver.findElement(By.cssSelector("input[id*='TextBox5']")).sendKeys("33087");
		
	WebElement ccButton= driver.findElement(By.cssSelector("input[id*='cardList_1']"));
	
	if(ccButton.isEnabled()) {
		
		ccButton.click();
	}
	
		driver.findElement(By.cssSelector("input[id*='TextBox6']")).sendKeys("2504545049453943223");
		
		driver.findElement(By.cssSelector("input[id*='TextBox1']")).sendKeys("09/2025");  //input[value*='Reset']
		
		
		
		WebElement processBut= driver.findElement(By.cssSelector("a[id*='InsertButton']"));// //a[text()='View all orders']
		
		if (processBut.isDisplayed()& processBut.isEnabled()) {
			
			processBut.click();
		}
		
		
		driver.findElement(By.xpath("//a[text()='View all orders']")).click();
	
		
		Thread.sleep(5000);
		driver.quit();
		
  }
}
