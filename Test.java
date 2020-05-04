package introduction;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	public static void main(String[] args) {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);

		String FirstName = "Alankrita";
		String Lastname = "Phi";
		String EmailID = FirstName+Lastname+rand_int1+"@gmail.com";
		String Password = "qwerty123";
		String URL = "http://elab-stg.labyrinthelab.com/create_learner_account.php";
		String errorURL = "https://www.labyrinthelab.com/?error=00101";


		System.setProperty("webdriver.chrome.driver" , "C:\\Alankrita\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
        driver.get("http://elab-stg.labyrinthelab.com/create_learner_account.php");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='fname']")).sendKeys(FirstName);
        driver.findElement(By.xpath("//input[@id='lname']")).sendKeys(Lastname);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(EmailID);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@type='checkbox']")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.findElement(By.id("createAccount")).click();

        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        WebDriverWait wait = new WebDriverWait(driver, 60);

        wait.until(ExpectedConditions.titleContains("Labyrinth eLab: Home"));

        String actualURL = driver.getCurrentUrl();

        if (actualURL.equals(errorURL))
        	{
        	System.out.println("Invalid Username or Password Page");
        	}
        else
        {
        	System.out.println("Account Creation Failed");
        }
	}
}
