package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundLink {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leafground.com/pages/Link.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[1]")).click();
		Thread.sleep(200);
		driver.findElement(By.xpath("(//img[@class='wp-categories-icon svg-image'])[3]")).click();
		System.out.println(driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href"));
	    System.out.println(driver.findElement(By.linkText("Verify am I broken?")).getAttribute("href"));
	    System.out.println(driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[2]")).getAttribute("href"));
	    System.out.println(driver.findElement(By.xpath("//a[contains(text(),'How many links are available in this page?')]")).getAttribute("href"));
	}

}
