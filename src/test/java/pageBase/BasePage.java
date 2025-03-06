package pageBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	private Duration defaultTimeout = Duration.ofSeconds(5);

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void waitForWebElementToAppear(WebElement webElement) {
		waitForWebElementToAppear(webElement, defaultTimeout);
	}

	public void waitForWebElementToAppear(WebElement webElement, Duration timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

}
