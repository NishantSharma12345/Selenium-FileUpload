package Automation.FileUpload;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadSendKeys 
{
	public static void main(String args[])
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.manage().window().maximize();
		
		WebElement element = driver.findElement(By.xpath("//span[text()='Select WORD files']"));
		element.sendKeys("/home/users/nishant.sharma/Update Product page || All features of our apps.docx");
        
        driver.findElement(By.cssSelector("#processTaskTextBtn")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pickfiles")));
		
        driver.findElement(By.cssSelector("#pickfiles")).click();
		
	}
}
