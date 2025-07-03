package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups= {"Regression" , "Master"})
	public void verifyRegistration() {

		logger.info(" ************* Starting TC001_AccountRegistrationTest ************ ");
		HomePage hp = new HomePage(driver);

		logger.info(" ** Clicked on Register Link **");

		hp.clickTryItForFree();
		RegisterPage rp = new RegisterPage(driver);

		logger.info(" ** Provide all the details **");

		rp.verifyRegisterPage();
		rp.setCompanyName(randomString());
		rp.setFirstName(randomString());
		rp.setLastName(randomString());
		rp.setEmail(randomString() + "@gmail.com");
		rp.setPhone(randomNumber());

		String password = randomAlphaNumeric();
		rp.setPassword(password);
		rp.setConfirmPassword(password);
		rp.selectCountry("United States");
		rp.clickRegister();

		logger.info(" ** Validating expected result **");

		String confirmMsg = rp.getConfirmationMsg();
		Assert.assertEquals(confirmMsg, "Success!");

		logger.info(" ************* Completed TC001_AccountRegistrationTest ************ ");

	}
}