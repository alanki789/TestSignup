package introduction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver" , "C:\\Alankrita\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
        driver.get("http://elab-stg.labyrinthelab.com/create_learner_account.php");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	    driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("Alankrita");
	    driver.findElement(By.xpath("//input[@id='lname']")).sendKeys("Phillip");
	    driver.findElement(By.xpath("//input[@id='email']")).sendKeys("alanki.alankrita7@gmail.com");
	    driver.findElement(By.xpath("//input[@id='password']")).sendKeys("qwerty123");
	    driver.findElement(By.xpath("//input[@id='cpassword']")).sendKeys("qwerty123");
	    driver.findElement(By.xpath("//input[@type='checkbox']")).click();
	    driver.findElement(By.xpath("//input[@id='createAccount']")).click();

	    //driver.quit();
		// TODO Auto-generated method stub

	}

}
