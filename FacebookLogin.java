package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FacebookLogin {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//launch URL
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Create New Account
		driver.findElement(By.xpath("//a[@data-testid = 'open-registration-form-button']")).click();
		driver.findElement(By.xpath("//input[@name= 'firstname']")).sendKeys("Sowmya");
		driver.findElement(By.xpath("//input[@name= 'lastname']")).sendKeys("kurakula");
		
		//enter id and password
		
		driver.findElement(By.xpath("//input[@name = 'reg_email__']")).sendKeys("abc@gmail.com");
		driver.findElement(By.id("password_step_input")).sendKeys("welcometofacebook");
		
		//Select date of birth 
		
		WebElement elementDropdown = driver.findElement(By.id("day"));
		Select day = new Select(elementDropdown);
		day.selectByIndex(10);
		WebElement elementDropdownMonth = driver.findElement(By.id("month"));
		Select month = new Select(elementDropdownMonth);
		month.selectByValue("10");
		WebElement elementDropdownYear = driver.findElement(By.id("year"));
		Select year = new Select(elementDropdownYear);
		year.selectByVisibleText("1995");
		
		driver.findElement(By.xpath("//label[contains(text(),'Female')]")).click();
				

	}

}
