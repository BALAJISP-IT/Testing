package com.example;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.hpsf.Property;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.reactivex.rxjava3.functions.Action;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;
    Logger logger=Logger.getLogger(getClass());
    @BeforeMethod
    public void bm()
    {
        PropertyConfigurator.configure("D:\\log_properties\\log4j2.properties");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("D:\\ExtentHtmlReporter\\report.html");
        reports = new ExtentReports();
        reports.attachReporter(sparkReporter);
        test = reports.createTest("testname", "testdescription");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
        driver = new ChromeDriver(chromeOptions);
    }
    @Test(dataProvider = "dat1")
    public void test1(String name)
    {
        logger.info("Starting test1...");
        SoftAssert assert1=new SoftAssert();
        driver.get("https://www.barnesandnoble.com/");
        logger.trace("Navigated to barnesandnoble.com");
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[1]/a")).click();
      logger.trace("all clicked");
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        logger.trace("books clicked");
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys(name);
        logger.trace(name+" entered");
        driver.findElement(By.xpath("//*[@id=\"rhf_header_element\"]/nav/div/div[3]/form/div/span/button")).click();
        logger.trace("searched");
       
assert1.assertTrue(driver.findElement(By.xpath("//*[@id=\"searchGrid\"]/div/section[1]/section[1]/div/div[1]/div[1]/h1/span")).getText().contains("Chetan Bhagat"));
assert1.assertAll();
    }
    @Test
    public void test2()
    {
        SoftAssert assert1=new SoftAssert();
        logger.info("starting test2");
        driver.manage().window().maximize();
        driver.get("https://www.barnesandnoble.com/");
        logger.trace("navigated barnesandnoble.com");
        Actions actions=new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div/ul/li[5]"))).build().perform();
        logger.trace("hovered over audiobooks");
        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/div/ul/li[5]/div/div/div[1]/div/div[2]/div[1]/dd/a[1]")).click();
        logger.trace("Clicked Audiobooks top 100");
        WebDriverWait wait1=new WebDriverWait(driver,Duration.ofSeconds(20));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/div[2]/div[1]/div/div[2]/div/div[2]/section[2]/ol/li[1]/div/div[2]/div[5]/div[2]/div/div/form/input[11]")));
        driver.findElement(By.xpath("/html/body/main/div[2]/div[1]/div/div[2]/div/div[2]/section[2]/ol/li[1]/div/div[2]/div[5]/div[2]/div/div/form/input[11]")).submit();
        logger.trace("added to cart");
        assert1.assertAll();
    }
    @Test
    public void test3() throws InterruptedException
    {
        logger.info("starting testcase 3...");
        SoftAssert assert1=new SoftAssert();
        driver.manage().window().maximize();
        driver.get("https://www.barnesandnoble.com/");
        logger.trace("navigated barnesandnoble.com");
        WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[7]/div[2]/div/div[2]/button")));
            driver.findElement(By.xpath("/html/body/div[7]/div[2]/div/div[2]/button")).click();
            
        } catch (Exception e) {
            // TODO: handle exception
        }
        wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[3]/div[3]/div/section/div/div/div/div/div/a[1]")));
        driver.findElement(By.xpath("/html/body/main/div[3]/div[3]/div/section/div/div/div/div/div/a[1]")).click();
        logger.trace("b&m clicked");
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/main/section/div[1]/div[2]/div/div/div[2]/div/div[73]/div/div[1]")));
        driver.findElement(By.xpath("/html/body/main/section/div[1]/div[2]/div/div/div[2]/div/div[73]/div/div[1]")).click();
        logger.trace("clicked on free join rewards");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[6]/div/iframe")));
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/div[6]/div/iframe")));
        WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div")));
        assert1.assertTrue(driver.findElement(By.xpath("/html/body/div[2]/div/h2")).getText().contains("Sign in"));
        logger.trace("sign in detected");
        assert1.assertAll();
    }
    @AfterMethod
    public void am(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, "Testcase failed: " + result.getName());
            test.log(Status.FAIL, "Test case failed reason: " + result.getThrowable());
            File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String path = "D:\\" + result.getName() + ".png"; 
            FileUtils.copyFile(file, new File(path));
            test.addScreenCaptureFromPath(path);
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, "Test case passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.log(Status.SKIP, "Test case Skipped: " + result.getName());
        }
        reports.flush(); 
       driver.quit(); 
    }
    @DataProvider(name="dat1")
public Object[][] dp1() throws IOException
{
    FileInputStream fs=new FileInputStream("D:\\Excel data\\cc2.xlsx");
    XSSFWorkbook workbook=new XSSFWorkbook(fs);
    XSSFSheet sheet=workbook.getSheetAt(0);
    int rowCount=sheet.getLastRowNum();
    int colCount=sheet.getRow(0).getLastCellNum();
    Object[][] arr=new Object[rowCount][colCount];
     for(int i=0;i<rowCount;i++)
     {
        Row row=sheet.getRow(i+1);
        for(int j=0;j<colCount;j++)
        {
             arr[i][j]=row.getCell(j).getStringCellValue();
        }
     }

    return arr;
}
}
