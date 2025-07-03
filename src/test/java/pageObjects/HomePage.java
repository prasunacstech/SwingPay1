package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage extends BasePage{
	
	public HomePage(WebDriver driver) {

		super(driver);
	}
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement lnkLogin;

	@FindBy(xpath = "//a[text()='Try It For Free']")
	WebElement lnkregisterPage;
	
	
	public void clickOnLoginLink() {
		lnkLogin.click();
	}

	public void clickTryItForFree() {
		lnkregisterPage.click();
	}
	
	
}
