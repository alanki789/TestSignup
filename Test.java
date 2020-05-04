package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		String FirstName = "Alankrita";
		String Lastname = "Alankrita";
		String EmailID = "alanki.alankrita7@gmail.com";
		String Password = "qwerty123"
		String URL = "http://elab-stg.labyrinthelab.com/create_learner_account.php";
		String errorURL = "https://www.labyrinthelab.com/?error=00101"
			
		System.setProperty("webdriver.chrome.driver" , "C:\\Alankrita\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
        	driver.get("http://elab-stg.labyrinthelab.com/create_learner_account.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	    	driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(FirstName);
	    	driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(Lastname);
	    	driver.findElement(By.xpath("//input[@id='email']")).sendKeys("alanki.alankrita7@gmail.com");
	    	driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
	    	driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys(Password);
	    	driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    	driver.findElement(By.id("createAccount")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		String actualURL = driver.getCurrentURL();
		
		if (actualURL.equals(errorURL))
		{
			System.out.println("Invalid Username or Password Page");
		}
		else
		{
			System.out.println("Account Creation Failed");
		}
		
	    driver.quit();
	}
}
