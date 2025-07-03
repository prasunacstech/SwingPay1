package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;


public class TC002_LoginTest extends BaseClass {
	
	@Test(groups= {"Sanity" , "Master"})
	public void ValidLoginTest() {
	
	logger.info(" ************* Starting TC002_LOGINTest ************ ");
	
	HomePage hp = new HomePage(driver);

	logger.info(" ** Clicked on login Link **");
     
	hp.clickOnLoginLink();
	
	LoginPage lp = new LoginPage(driver);
	
	logger.info(" ** Provide all the details **");
    lp.verifyLoginPage();
	lp.enterUsername(prop.getProperty("username"));
	lp.enterPassword(prop.getProperty("password"));
	lp.clickLoginBtn();
	
	
	logger.info(" ** Validating expected result **");
	
	boolean targetPage =lp.verifyPage();
	Assert.assertEquals(targetPage, true, "Login Failed");
	
	logger.info(" ************* Completed TC002_LoginTest ************ ");

	
	
	}
}
