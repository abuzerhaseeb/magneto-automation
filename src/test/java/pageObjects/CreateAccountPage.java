package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.github.javafaker.Faker;

import pageBase.BasePage;

public class CreateAccountPage extends BasePage {

	private Faker faker;

	public CreateAccountPage(WebDriver driver) {
		super(driver);
		this.faker = new Faker();
	}

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
		String emailAddress = faker.internet().emailAddress();
		emailAddressTextBox.sendKeys(emailAddress);
		return emailAddress;
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
}
