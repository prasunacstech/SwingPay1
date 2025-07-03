package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDriven extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups= "Datadriven")
	public void ValidLoginTest(String username, String password, String exp) throws InterruptedException {
		logger.info(" ************* Starting TC002_LOGINTest ************ ");

		HomePage hp = new HomePage(driver);

		logger.info(" ** Clicked on login Link **");

		hp.clickOnLoginLink();
		

		LoginPage lp = new LoginPage(driver);

		logger.info(" ** Provide all the details **");
	
		lp.verifyLoginPage();
		lp.enterUsername(username);
		lp.enterPassword(password);
		lp.clickLoginBtn();

		logger.info(" ** Validating expected result **");

		boolean targetPage = lp.verifyPage();

		if (exp.equalsIgnoreCase("Valid")) {
			if (targetPage == true) {
				Thread.sleep(3000);
				lp.clickSaiKumarIcon();
				lp.clickLogoutBtn();
				lp.clickLogoutPageBtn();
				Assert.assertTrue(true);
			}

			else {

				Assert.assertTrue(false);
			}
		}

		if (exp.equalsIgnoreCase("Invalid")) {
			if (targetPage == true) {
//				lp.clickSaiKumarIcon();
//				lp.clickLogoutBtn();
//				lp.clickLogoutPageBtn();
				Assert.assertTrue(false);

			}

			else {

				Assert.assertTrue(true);
			}
		}
		Thread.sleep(3000);
		logger.info(" ************* Completed TC003_LoginTest ************ ");

	}

}
