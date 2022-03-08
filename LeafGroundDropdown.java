package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundDropdown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Dropdown.html");
		driver.manage().window().maximize();
		
		WebElement dropDown1 = driver.findElement(By.id("dropdown1"));
		Select dd1 = new Select(dropDown1);
		dd1.selectByIndex(2);
		
		WebElement dropDown2 = driver.findElement(By.name("dropdown2"));
		Select dd2 = new Select(dropDown2);
		dd2.selectByVisibleText("Loadrunner");
		
		WebElement dropDown3 = driver.findElement(By.name("dropdown3"));
		Select dd3 = new Select(dropDown3);
		dd3.selectByValue("2");
		
		WebElement dropDown4 = driver.findElement(By.xpath("//select[@class = 'dropdown']"));
		Select dd4 = new Select(dropDown4);
		List<WebElement> options = dd4.getOptions();
	    System.out.println("Number Of Options are " + options.size());
	    
	    driver.findElement(By.xpath("(//div[@class = 'example'])[5]/select")).sendKeys("Selenium");
		
	    WebElement dropDown5 = driver.findElement(By.xpath("(//div[@class = 'example'])[6]/select"));
		Select dd5 = new Select(dropDown5);
		dd5.selectByVisibleText("Loadrunner");
			    
	    
	}

}
