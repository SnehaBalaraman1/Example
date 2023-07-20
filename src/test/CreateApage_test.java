package test;

import org.testng.annotations.Test;

import pages.CreateApage_page;

public class CreateApage_test extends Baseclass {

	@Test
	public void testing()
	{
		CreateApage_page ob1=new CreateApage_page(driver);
		ob1.press();
	}
	
	

}
