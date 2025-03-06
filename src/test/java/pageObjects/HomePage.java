package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	private JavascriptExecutor js;

	public HomePage(WebDriver driver) {
		super(driver);
		this.js = (JavascriptExecutor) driver;
	}

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	private WebElement signInOption;

	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	private WebElement createAnAccountOption;

	public void clickSignInOption() {
		signInOption.click();
	}

	public void clickCreateAnAccountOption() {
		createAnAccountOption.click();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public String getUrl() {
		return driver.getCurrentUrl();
	}

	public String getBrowserName() {
		return (String) js.executeScript("return navigator.userAgent;");
	}
}
