package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundButton {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Button.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='home']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//img[contains(@src,'images/button.png')]")).click();
		System.out.println("Position is " +driver.findElement(By.xpath("//button[@id='position']")).getLocation());
		System.out.println("Color of the button is " +driver.findElement(By.xpath("//button[@id='color']")).getCssValue("background-color"));
		System.out.println("Size is " +driver.findElement(By.xpath("//button[@id='size']")).getSize());
		
		

	}

}
