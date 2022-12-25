package Automation.FileUpload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FileUploadRobotClass 
{
	public static void main(String args[]) throws AWTException, InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.ilovepdf.com/word_to_pdf");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//span[text()='Select WORD files']")).click();
		
		Robot robot = new Robot();
		
		Thread.sleep(2000);
		
		robot.mouseMove(630, 750);
		robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
		robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
		robot.delay(1500);
		robot.keyPress(KeyEvent.VK_ENTER);	
        robot.keyRelease(KeyEvent.VK_ENTER);
        
        Thread.sleep(2000);
        
        driver.findElement(By.cssSelector("#processTaskTextBtn")).click();
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#pickfiles")));
		
        driver.findElement(By.cssSelector("#pickfiles")).click();
		
	}
}
