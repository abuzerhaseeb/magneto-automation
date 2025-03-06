package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage {

	public SignInPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "email")
	private WebElement emailTextBox;

	@FindBy(xpath = "(//input[@id='pass'])[1]")
	private WebElement passwordTextBox;

	@FindBy(css = "fieldset[class='fieldset login'] div[class='primary'] span")
	private WebElement signInButton;

	public void enterEmail(String email) {
		emailTextBox.sendKeys(email);
	}

	public void enterPassword(String password) {
		passwordTextBox.sendKeys(password);
	}

	public void clickSignInButton() {
		signInButton.click();
	}
}
