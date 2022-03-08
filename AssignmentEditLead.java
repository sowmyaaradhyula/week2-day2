package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssignmentEditLead {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Launch URL
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		// Login
		driver.findElement(By.xpath("//input[@id = 'username']")).sendKeys("Demosalesmanager");
		driver.findElement(By.xpath("//input[@id = 'password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@class = 'decorativeSubmit']")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'CRM/SFA')]")).click();
	    
	    //Find leads
	    
	    driver.findElement(By.xpath("//a[contains(text(),'Leads')]")).click();
	    driver.findElement(By.xpath("//a[contains(text(),'Find Leads')]")).click();
	    driver.findElement(By.xpath("(//div[@class = 'x-form-item x-tab-item']) [2]//input")).sendKeys("test");
	    driver.findElement(By.xpath("//button[contains(text(),'Find Leads')]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])[1]/a")).click(); 
	    driver.findElement(By.xpath("(//div[@class = 'frameSectionExtra'])[2]/a[3]")).click();
	    driver.findElement(By.xpath("//input[@id = 'updateLeadForm_companyName']")).clear();
	    driver.findElement(By.xpath("//input[@id = 'updateLeadForm_companyName']")).sendKeys("new company");
	    driver.findElement(By.xpath("//input[@value = 'Update']")).click();
	    WebElement company = driver.findElement(By.id("viewLead_companyName_sp"));
	    System.out.println(company.getText());
	    driver.close();
	    
	}

}
