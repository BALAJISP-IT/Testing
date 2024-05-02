package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    WebDriver driver;
    /**
     * Rigorous Test :-)
     */
    @BeforeMethod
    public void bm()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

    }
    @Test
    public void test1() throws InterruptedException
    {
        driver.get("https://www.ixigo.com");
        driver.manage().window().maximize();
       // driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[1]/div[1]/div/button[2]")).click();
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    JavascriptExecutor js=(JavascriptExecutor)driver;
    WebElement e1=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div/div")));
    e1.click();
    WebElement e2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div/div/div[2]/input")));
    e2.sendKeys("IDP-Independence");
    WebElement e31=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[1]/div")));
    e31.click();
    WebElement e3=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[1]/div[2]/div[2]/div/div/div[2]/input")));
    e3.sendKeys("DEL-New Delhi");
    //Thread.sleep(3000);
    WebElement e4=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div")));
    e4.click();
    WebElement e5=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[1]/div/div/div/div/p[2]")));
    js.executeScript("arguments[0].innerText=arguments[1]",e5,"24 Oct,Tue");
    driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div")).click();
    WebElement e6=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/div/p[2]")));
    js.executeScript("arguments[0].innerText=arguments[1]",e6,"25 Oct, Wed");
    WebElement e7=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/div[3]/div/div/div/div/p[2]")));
    js.executeScript("arguments[0].innerText=arguments[1]",e7,"4 Passengers, Business");
   driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div[3]/div[2]/button")).click();
    }
}
