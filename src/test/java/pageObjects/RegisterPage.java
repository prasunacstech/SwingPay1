package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegisterPage extends BasePage {

	public RegisterPage(WebDriver driver) {

		super(driver);
	}

	@FindBy(xpath = "//input[@id='CompanyName']")
	WebElement txtCompanyName;

	@FindBy(xpath = "//input[@id = 'FirstName']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id = 'LastName']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id = 'Email']")
	WebElement txtEmail;

	@FindBy(xpath = "//input[@id = 'Contact']")
	WebElement txtPhone;

	@FindBy(xpath = "//input[@id = 'password-field']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id = 'con-password-field']")
	WebElement txtConfirmPassword;

	@FindBy(xpath = "//select[@id = 'countryList']")
	WebElement selCountry;

	@FindBy(xpath = "//input[@value = 'Register']")
	WebElement btnRegister;

	@FindBy(xpath = "//h1[text()='Sign Up']")
	WebElement btnSignup;

	@FindBy(xpath = "//h2/strong[text()='Success!']")
	WebElement verifyMsg;

	public void verifyRegisterPage() {
		// Get the window handles (IDs)
		String mainWindowHandle = driver.getWindowHandle();
		String newWindowHandle = "";

		// Iterate through all open windows
		for (String handle : driver.getWindowHandles()) {
			if (!handle.equals(mainWindowHandle)) {
				newWindowHandle = handle;
				break;
			}
		}

		// Switch to the new window
		driver.switchTo().window(newWindowHandle);
		String registerBtnText = btnSignup.getText();
		Assert.assertTrue(registerBtnText.contains("Sign Up"));
	}

	public void setCompanyName(String cname) {
		txtCompanyName.sendKeys(cname);
	}

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setPhone(String phone) {
		txtPhone.sendKeys(phone);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setConfirmPassword(String cpassword) {
		txtConfirmPassword.sendKeys(cpassword);
	}

	public void selectCountry(String country) {
		Select select = new Select(selCountry);
		select.selectByContainsVisibleText(country);
	}
	
	public void clickRegister() {
		btnRegister.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return verifyMsg.getText();
		}catch(Exception e){
			return (e.getMessage());
		}
	}
}
