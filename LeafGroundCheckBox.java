package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundCheckBox {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/checkbox.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[contains(text(),'Java')]/input")).click();
		boolean selected = driver.findElement(By.xpath("//div[contains(text(),'Selenium')]/input")).isSelected();
		if(selected ==  true)
		{
			System.out.println("Selenium is checked");
		}else {
			System.out.println("Selenium is not checked");
		}
       
		driver.findElement(By.xpath("//div[contains(text(),'I am Selected')]/input")).click();
		
		driver.findElement(By.xpath("//div[contains(text(),'Option 1')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Option 2')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Option 3')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Option 4')]/input")).click();
		driver.findElement(By.xpath("//div[contains(text(),'Option 5')]/input")).click();
		
	}

}
