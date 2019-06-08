package utils;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonMethods {
	
	public static WebDriver driver;

	public static void setUpDriver(String browser, String url) {
		if (browser.equalsIgnoreCase("chrome")) {
			// For mac
			System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver");
			
			// for windows
			// System.setProperty("webdriver.chrome.driver",
			// "src/drivers/chromedriver.exe");
			driver = new ChromeDriver();
			
		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "src/drivers/geckodriver");
			driver = new FirefoxDriver();
		} else {
			System.out.println("browser given is wrong");
		}
		
		driver.manage().window().fullscreen();
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		
	}

	/**
	 * This method will select a specified value from a drop down
	 * @author Syntax 
	 * @param Select element, String text
	 */
	public static void selectValueFromDD(WebElement element, String text) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		boolean isSelected=false;
		for (WebElement option : options) {
			String optionText = option.getText();
			if (optionText.equals(text)) {
				select.selectByVisibleText(text);
				System.out.println("Option with text "+text+" is selected");
				isSelected=true;
				break;
			}
		}
		if(!isSelected) {
			System.out.println("Option with text +"+text+"is not available");
		}
	}

	/**
	 * This method will select a specified value from a drop down by its index
	 * @author Syntax 
	 * @param Select element, int index
	 */
	public static void selectValueFromDD(WebElement element, int index) {
		Select select = new Select(element);
		List<WebElement> options = select.getOptions();
		if (options.size() > index) {
			select.selectByIndex(index);
		} else {
			System.out.println("Invalid index has been passed");
		}
	}

	public static void sendText(WebElement element, String value) {
		element.clear();
		element.sendKeys(value);
	}
/**
 * Method will accept alert
 * @throws NoAlertPresentException if alert is not present
 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
	/**
	 * Method will dismiss alert
	 * @throws NoAlertPresentException if alert is not present
	 */
	public static void dismissAlert() {
		try {
			Alert alert=driver.switchTo().alert();
			alert.dismiss();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
		}
	}
	/**
	 * Method will get text of an alert
	 * @throws NoAlertPresentException if alert is not present
	 * @return String text
	 */
	public static String getAlertText() {
		
		try {
			Alert alert=driver.switchTo().alert();
			return alert.getText();
		}catch (NoAlertPresentException e) {
			System.out.println("Alert was not present");
			return null;
		}
		
	}
	/**
	 * Method that will switch control to the specified frame
	 * @param frame id or frame name
	 */
	public static void switchToFrame(String idOrName) {
		try {
			driver.switchTo().frame(idOrName);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	/**
	 * Method that will switch control to the specified frame
	 * @param frame element
	 */
	public static void switchToFrame(WebElement element) {
		try {
			driver.switchTo().frame(element);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
	/**
	 * Method that will switch control to the specified frame
	 * @param frame index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		}catch(NoSuchFrameException e) {
			System.out.println("Frame is not present");
		}
	}
    
    
   public static void AlertFunction(WebDriver driver, WebElement element, String text ) throws InterruptedException {
	   
	   element.click();
	   
	   Thread.sleep(3000);
	   
	 Alert alert= driver.switchTo().alert();
	    
	    alert.getText();
	      
	    if(alert.getText().equals(text)) {
	    
	    	System.out.println(alert.getText()+" Text is available.");
	
	    	alert.accept();
	    	
	    } else if(!alert.getText().equals(text)) {
	    	
	    	System.out.println(alert.getText()+" Text is NOT available.");
	    	
	    	alert.accept();
	    	
	    }
	    
	 driver.quit();
   }
   
   
   
public static void ConfirmPopupsFunction(WebDriver driver, WebElement element, String text ) throws InterruptedException {
	   
		
		element.click();
		
		Thread.sleep(3000);
		
	    Alert confirmPopup= driver.switchTo().alert();
	   
	    String confirmPopupText=  confirmPopup.getText();
	      
	    if(confirmPopupText.equals(text)) {
	    
	    	System.out.println(confirmPopup.getText()+" Text is available.");
	    	
	    	Thread.sleep(3000);
	    	confirmPopup.accept();
	    	
	    	
	    } else if(!confirmPopupText.equals(text)) {
	    	
	    	System.out.println(confirmPopup.getText()+" Text is NOT available.");
	    	Thread.sleep(3000);
	    	confirmPopup.dismiss();
	    	
	    }else {
	    	
	    	System.out.println(confirmPopup.getText()+" Text is NOT available.");
	    }
	    
	   
   }


public static void PromptPopupsFunction(WebDriver driver, WebElement element, String text ) throws InterruptedException {
	   
		
		element.click();
		
		Thread.sleep(3000);
	   
	    Alert PromptPopup= driver.switchTo().alert();
	   
	    String PromptPopupText=  PromptPopup.getText();
	      
	    if(PromptPopupText.equals(text)) {
	    
	    	System.out.println(PromptPopup.getText()+" Text is available.");
	    	
	    	Thread.sleep(3000);
	    	PromptPopup.accept();
	    	
	    } else if(!PromptPopupText.equals(text)) {
	    	
	    	System.out.println(PromptPopup.getText()+" Text is NOT available.");
	    	
	    	Thread.sleep(3000);
	    	PromptPopup.dismiss();
	    	
	    }else {
	    	
	    	System.out.println(PromptPopup.getText()+" Text is NOT available.");
	    }
	    
	   
}
    
    
    
}
