package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		//Launch URL
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Login
		
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
		
		//Create Contact
		
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Create Contact")).click();
		
		driver.findElement(By.id("firstNameField")).sendKeys("asdf");
		driver.findElement(By.id("lastNameField")).sendKeys("ghjk");
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("qwer");
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("tyui");
		driver.findElement(By.id("createContactForm_departmentName")).sendKeys("zxcv");
		driver.findElement(By.id("createContactForm_description")).sendKeys("bnm");
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("abcd@gmail.com");
		
		//select from dropdown with visible text
		
		WebElement elementDropdown = driver.findElement(By.id("createContactForm_generalStateProvinceGeoId"));
		Select dd = new Select(elementDropdown);
		dd.selectByVisibleText("New York");
		
		driver.findElement(By.xpath("//input[@class = 'smallSubmit']")).click();
		
		//Edit Contact
		
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateContactForm_description")).clear();
		driver.findElement(By.id("updateContactForm_importantNote")).sendKeys("important");
		driver.findElement(By.xpath("//input[@value = 'Update']")).click();
		System.out.println(driver.getTitle());
		
		
		

	}

}
