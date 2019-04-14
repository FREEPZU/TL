package com.ramblertester.webdriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RamblerTest {

	@Test
	public void ramblerCorrectInputt() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\work\\selenium\\eclipse\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://id.rambler.ru/account/registration");
		
		Assert.assertTrue("title should start", driver.getTitle().startsWith("Регистрация"));
		
		WebElement email = driver.findElement(By.name("login"));
		email.sendKeys("ithinkthisemailiscool");
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        WebElement newPassword = driver.findElement(By.name("newPassword"));
		newPassword.sendKeys("MySuperPa66word");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		confirmPassword.sendKeys("MySuperPa66word");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.quit();
	}
	
	@Test
	public void ramblerIncorrectInput() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\work\\selenium\\eclipse\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://id.rambler.ru/account/registration");
		
		Assert.assertTrue("title should start", driver.getTitle().startsWith("Регистрация"));
		
		WebElement email = driver.findElement(By.name("login"));
		email.sendKeys("ithinkthisemailiscool");
        
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        
        WebElement newPassword = driver.findElement(By.name("newPassword"));
		newPassword.sendKeys("MySuperPa66word");
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebElement confirmPassword = driver.findElement(By.name("confirmPassword"));
		confirmPassword.sendKeys("MySuperPa66word1");
		
		driver.findElement(By.id("root")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		String actualResult = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/form/section[5]/div/div/div[2]")).getText();
		String expectResult = "Пароли не совпадают";
		Assert.assertEquals(actualResult, expectResult);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.quit();
	}
	
	
	@Test
	public void ramblerLogination() {
		
		System.setProperty("webdriver.chrome.driver", "D:\\work\\selenium\\eclipse\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("https://id.rambler.ru/login-20/login");
		driver.manage().window().maximize();
		
		WebElement email = driver.findElement(By.id("login"));
		email.sendKeys("awesome-team@rambler.ru");
        
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("awesome-teamQ1");
        
        WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/article/form/button"));
        loginButton.submit();
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div/div/div[1]/a[1]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        List<WebElement> unreadLetters = driver.findElements(By.className("AutoMaillistItem-unseen-ad"));
        if (unreadLetters.size() > 0)
        {
        	System.out.println("Количество не прочитанных писем: " + unreadLetters.size());
        	driver.quit();
        } else {
        	driver.quit();
        }
        
	}
	
}
