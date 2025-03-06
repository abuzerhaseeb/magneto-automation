package testCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.SignInPage;
import testBase.BaseTest;

public class TC_002_SignInTest extends BaseTest {

	private HomePage homePage;
	private SignInPage signInPage;

	@BeforeMethod(alwaysRun = true)
	public void setUpPages() {
		homePage = new HomePage(driver);
		signInPage = new SignInPage(driver);
	}

	@Test(groups = { "regression", "master" }, dependsOnMethods = {
			"testCases.TC_001_CreatingAnAccount.creatingAnAccount" })
	public void signInTest() {

		try {
			String expectedBrowser = "Chrome";

			Assert.assertTrue(homePage.getBrowserName().contains(expectedBrowser),
					"The browser is not " + expectedBrowser);
			Assert.assertEquals(homePage.getTitle(), "Home Page", "Title does not match");
			Assert.assertEquals(homePage.getUrl(), "https://magento.softwaretestingboard.com/", "URL does not match");

			homePage.clickSignInOption();

			signInPage.enterEmail(TC_001_CreatingAnAccount.registeredEmail);
			signInPage.enterPassword(TC_001_CreatingAnAccount.registeredPassword);
			signInPage.clickSignInButton();

		} catch (AssertionError e) {
			throw e;
		} catch (Exception e) {
			Assert.fail("An unexpected error occurred: " + e.getMessage());
		}
	}
}
