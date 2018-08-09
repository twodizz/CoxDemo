import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
 

public class Purchase {
  @Test
  public void f() {
	//Firefox Driver
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\tajvo\\eclipse-workspace\\Sample\\src\\geckodriver.exe");
	  //Chrome Driver 
	  //System.setProperty("webdriver.chrome.driver", "C:\\Users\\tajvo\\eclipse-workspace\\Sample\\src\\chromedriver.exe");

  }
  @BeforeMethod
  public void beforeMethod() {
	// Create a new instance of the Firefox driver
    driver = new FirefoxDriver();
    //Put a Implicit wait, this means that any search for elements on the page could take the time the implicit wait is set for before throwing exception
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //Launch the Online Store Website
  	driver.URL("https://lexus.roimotors.com/new/LEXUS/2018-LEXUS-GS+350-9478ae060a0a00f93a13f68a2e7fb412.htm");
  }

  @AfterMethod
  public void afterMethod() {
	  //Close the driver
	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @Test
  public void quote_Purchase() {
	// Complete Purchase Transaction
	//Purchase Price
	driver.findElement(By.id ("finance-input-offer")).sendKeys("$51,000");
	//Down Payment
	driver.findElement(By.id ("finance-cash-down")).sendKeys("$2500");
	//Credit Score
	driver.findElement(By.id ("finance-credit-tier")).click("tier_2");
	driver.findElement(By.id ("send-my-offer")).click();
	//Customer Zip
	driver.findElement(By.id ("input-shopper-zip")).sendKeys("30080");
	Thread.sleep(1000);
	driver.findElement(By.id("dr_update_zip_continue")).click();
	//Customer Contact Information
	driver.findElement(By.id("sp_shopper_firstname")).sendKeys("Taj");
	driver.findElement(By.id("sp_shopper_lastname")).sendKeys("Void");
	driver.findElement(By.id("sp_shopper_email")).sendKeys("TajVoid@gmail.com");
	driver.findElement(By.id("sp_shopper_phone")).sendKeys("4242027023");
	driver.findElement(By.id("sp_shopper_message")).sendKeys("Hello");
	//Submit request
	driver.findElement(By.className("btn btn-primary")).click();
	Thread.sleep(1000);
	//Verify the customer request
	boolean enabled = driver.findElement(By.className("offer-details-container")).isEnabled();
	softAssert.assertTrue(enabled);
  }
}
