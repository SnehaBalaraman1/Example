package package1;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	
	ChromeDriver driver;
	String baseurl="https://www.facebook.com/";
	ExtentHtmlReporter reporter;
	ExtentTest test;
	ExtentReports extent;
	@BeforeTest
	public void btest()
	{
		reporter=new ExtentHtmlReporter("./Reports1/myreport1.html");
		reporter.config().setDocumentTitle("Automation Report");
		reporter.config().setReportName("Functional Test");
		reporter.config().setTheme(Theme.DARK);
		
		
		extent = new ExtentReports();
	    extent.attachReporter(reporter);
		extent.setSystemInfo("hostname","localhost");
		extent.setSystemInfo("OS","Windows11");
		extent.setSystemInfo("tester name","Sneha");
		extent.setSystemInfo("Browser name","Chrome");
		
		driver = new ChromeDriver();
		
	}
	@BeforeMethod
	public void setup()
	{
		driver.get(baseurl);
	}
	
	@Test
	public void fbtitleverification()
	{
		//ExtentTest class
		test= extent.createTest("fbtitleverification");
		String exp = "facebook";
		String actual = driver.getTitle();
		//Assert.assertEquals(exp,actual);
	}
	
	@Test
	public void fbbuttontest()
	{
		test= extent.createTest("fbbuttontest");
		String buttontest = driver.findElement(By.xpath("//*[@name=\"login\"]")).getText();
		
		Assert.assertEquals(buttontest,"Log in");
	}
	
	@Test
	public void fblogotest()
	{
		test= extent.createTest("fblogotest");
		boolean b =driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void browserclose(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			test.log(Status.FAIL,"test case failed is "+result.getName());
			test.log(Status.FAIL,"test case failed is "+result.getThrowable());		
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			test.log(Status.SKIP,"test case skipped is "+result.getName());
		}
		
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			test.log(Status.PASS,"test case passed is "+result.getName());
		}
	}
	
	@AfterTest
	public void teardown()
	{
		extent.flush(); //to write test info to reporter
	}
	


}
