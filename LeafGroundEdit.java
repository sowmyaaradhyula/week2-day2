package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundEdit {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Edit.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
		WebElement append = driver.findElement(By.xpath("//input[@value = 'Append ']"));
		append.sendKeys("sowmya",Keys.TAB);		
		String text = driver.findElement(By.xpath("//input[@value = 'TestLeaf']")).getAttribute("value");
		System.out.println("Default enterd text is "+text);
		driver.findElement(By.xpath("//input[@value = 'Clear me!!']")).clear();
		boolean enabled = driver.findElement(By.xpath("//input[@disabled = 'true']")).isEnabled();
		if(enabled == false)
		{
			System.out.println("Field is disabled");
		}
		
		

	}

}
