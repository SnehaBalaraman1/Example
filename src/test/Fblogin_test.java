package test;

import org.testng.annotations.Test;

import pages.Fblogin_page;

public class Fblogin_test extends Baseclass {
	
	
	@Test
	public void testlogin()
	{
		Fblogin_page ob=new Fblogin_page(driver);
		ob.setvalues("sneha@gmail.com", "abcd");
		ob.login();
	}

}
