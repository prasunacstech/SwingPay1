package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='LoginUser']")
	WebElement txtLoginUserName;

	@FindBy(xpath = "//input[@id='password-field']")
	WebElement txtLoginPassword;

	@FindBy(id = "Login")
	WebElement btnlogin;

	@FindBy(xpath = "//h1[text()='Dashboard']")
	WebElement dashboard;
	
	@FindBy(xpath = "//i[@class='fa fa-user']")
	WebElement saikumarIcon;

	@FindBy(xpath = "//a[@data-toggle='modal']")
	WebElement logoutBtn;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutPageBtn;


	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement cancelBtn;
	
	public void verifyLoginPage() {
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
		String loginBtnText = btnlogin.getText();
		Assert.assertTrue(loginBtnText.contains("Login"));
	}
	
	public void enterUsername(String loginUserVal) {
		txtLoginUserName.clear();
		txtLoginUserName.sendKeys(loginUserVal);
	}
	
	public void enterPassword(String loginPasswordVal) {
		txtLoginPassword.clear();
		txtLoginPassword.sendKeys(loginPasswordVal);
	}
	
	public void clickLoginBtn() {
		btnlogin.click();
	}
	
	public String getConfirmationMsg() {
		try {
			return dashboard.getText();
		}catch(Exception e){
			return (e.getMessage());
		}
	}
	
	public void clickSaiKumarIcon() {
		saikumarIcon.click();
	}

	public void clickLogoutBtn() {
		logoutBtn.click();
	}

	public void clickLogoutPageBtn() {
		logoutPageBtn.click();
	}

	public boolean verifyPage() {
		try {
			return (dashboard.isDisplayed());
		}catch(Exception e){
			return false;
		}
		
	}

	public void clickCancelBtn() {
		cancelBtn.click();
	}

}
