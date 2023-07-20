package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateApage_page {

	
WebDriver driver;
	
	By create=By.xpath("//*[@id=\"reg_pages_msg\"]/a");
	By start=By.xpath("//*[@id=\"content\"]/div/div[2]/div/div[2]/table/tbody/tr/td[1]/div/div[1]/div[2]/button/div/div");
	
	
	public CreateApage_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}


	public void press()
	{
		driver.findElement(create).click();
		driver.findElement(start).click();
	}
}
