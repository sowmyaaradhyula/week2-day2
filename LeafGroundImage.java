package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundImage {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Image.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		Thread.sleep(20);
		driver.findElement(By.xpath("//img[@src='images/image.png']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//img[@src='../images/abcd.jpg']")).click();
		Thread.sleep(100);
		driver.findElement(By.xpath("//img[@src='../images/keyboard.png']")).click();
		
	}

}
