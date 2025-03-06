package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.CreateAccountPage;
import pageObjects.HomePage;
import testBase.BaseTest;

public class TC_001_CreatingAnAccount extends BaseTest {

	private HomePage homePage;
	private CreateAccountPage createAccountPage;
	public static String registeredEmail;
	public static String registeredPassword;

	@BeforeMethod(alwaysRun = true)
	public void setUpPages() {
		homePage = new HomePage(driver);
		createAccountPage = new CreateAccountPage(driver);
	}

	@Test(groups = { "regression", "master" })
	public void creatingAnAccount() {

		try {
			String expectedBrowser = "Chrome";

			Assert.assertTrue(homePage.getBrowserName().contains(expectedBrowser),
					"The browser is not " + expectedBrowser);
			Assert.assertEquals(homePage.getTitle(), "Home Page", "Title does not match");
			Assert.assertEquals(homePage.getUrl(), "https://magento.softwaretestingboard.com/", "URL does not match");

			homePage.clickCreateAnAccountOption();

			String firstName = createAccountPage.enterFirstName();
			String lastName = createAccountPage.enterLastName();
			registeredEmail = createAccountPage.enterEmailAddress();
			registeredPassword = createAccountPage.enterPassword();
			createAccountPage.clickCreateAnAccountButton();

		} catch (AssertionError e) {
			throw e;
		} catch (Exception e) {
			Assert.fail("An unexpected error occurred: " + e.getMessage());
		}
	}
}
