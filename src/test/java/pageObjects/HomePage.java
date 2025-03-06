package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

public class HomePage extends BasePage {

	private Faker faker;
	private JavascriptExecutor js;

	@FindBy(xpath = "//div[@class='panel header']//a[normalize-space()='Create an Account']")
	private WebElement createAnAccountOption;

	@FindBy(id = "firstname")
	private WebElement firstNameTextBox;

	@FindBy(id = "lastname")
	private WebElement lastNameTextBox;

	@FindBy(id = "email_address")
	private WebElement emailAddressTextBox;

	@FindBy(id = "password")
	private WebElement passwordTextBox;

	@FindBy(id = "password-confirmation")
	private WebElement confirmPasswordTextBox;

	@FindBy(css = "button[title='Create an Account'] span")
	private WebElement createAnAccountButton;

	public HomePage(WebDriver driver) {
		super(driver);
		this.faker = new Faker();
		this.js = (JavascriptExecutor) driver;
	}

	public void clickCreateAnAccountOption() {
		createAnAccountOption.click();
	}

	public String enterFirstName() {
		String firstName = faker.name().firstName();
		firstNameTextBox.sendKeys(firstName);
		return firstName;
	}

	public String enterLastName() {
		String lastName = faker.name().lastName();
		lastNameTextBox.sendKeys(lastName);
		return lastName;
	}

	public String enterEmailAddress() {
		String email = faker.internet().emailAddress();
		emailAddressTextBox.sendKeys(email);
		return email;
	}

	public String enterPassword() {
		String password = faker.internet().password(8, 16, true, true, true);
		passwordTextBox.sendKeys(password);
		confirmPasswordTextBox.sendKeys(password);
		return password;
	}

	public void clickCreateAnAccountButton() {
		createAnAccountButton.click();
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
