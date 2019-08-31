package Servex.AutomatizacionGoogle;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
     {
    
	// 1.llamar
	private WebDriver driver;
	
	
	// 2. Pre antes del test
	@BeforeMethod
	public void setUp() {
		DesiredCapabilities capabilities =new DesiredCapabilities();
		System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().window().maximize();
	 driver.navigate().to("http://www.google.com.co/");
	 try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO: handle exception
		e.printStackTrace();
	  }
		

	}
	

	@test
	
	public void pruebabuscar() {
		driver.findElement(By.name("q")).sendKeys("buscar");
		driver.findElement(By.name("btnk")).click();
	     
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		// xpath para identificar el texto de Google.
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"fprs\"]/span[1]")).getText().contains("pruebas"));
	    
		driver.findElement(By.xpath("//*[@id=\"fprsl\"]/b/i")).click();
	}
	
      @AfterMethod
      public void teardown() {
    	  
    	  driver.close();
      }
   
	
	
}
