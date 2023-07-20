package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Fblogin_page {
	
	WebDriver driver;
	
	//object repository
	By fbemail=By.id("email");
	By fbpassword=By.id("pass");
	By fblogin=By.name("login");
	
	public Fblogin_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public void setvalues(String email,String password)
	{
		
		driver.findElement(fbemail).sendKeys(email);
		driver.findElement(fbpassword).sendKeys(password);
	}
	
	public void login()
	{
		driver.findElement(fblogin).click();
	}

}
