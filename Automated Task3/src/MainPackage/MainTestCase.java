package MainPackage;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTestCase {

	WebDriver driver = null;

	@Before
	public void beforetest() {
		System.setProperty("webdriver.gecko.driver", ".\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void test() throws InterruptedException {

		driver.get("https://www.hostinger.com/cpanel-login");

		By acceptCookies = By.xpath("//button[contains(@id,'cookie_consent-accept')]");
		AutoMethods.clickElementBy(driver, "Accept cookies button", acceptCookies);

		//note that normally I think it would be best to have login as a separate method, but for easier read, I left it in here(same with page navigation)

		By emailField = By.xpath("//div[@id='user-login-form-2021']//input[@type='email']");
		AutoMethods.enterTextBy(driver, "Email field in login page not found", emailField, "joriyow189@mtlcz.com");

		By passwordField = By.xpath("//div[@id='user-login-form-2021']//input[@type='password']");
		AutoMethods.enterTextBy(driver, "Password field in login page not found", passwordField, "Candidate!12");

		By loginButton = By.xpath("//div[contains(@id,'login-form')]//input[@type='submit']");
		AutoMethods.clickElementBy(driver, "Login button", loginButton);

		By hostingTopMenu = By.xpath("//div[contains(@class,'header-menu')]//span[@data-msgid='Hosting']");
		AutoMethods.clickElementBy(driver, "Hosting menu button at the top. Main hPanel view", hostingTopMenu);

		By addWebsite = By.xpath("//h3[contains(text(),'wordpresstest66.lt')]//ancestor::div[@class='h-portlet']//button[contains(@id,'add_website')]");
		AutoMethods.clickElementBy(driver, "Add Website button on hosting page", addWebsite);

		By domainNameInput = By.xpath("//div[@class='dashboard']//input[contains(@id,'domain-input')]");
		Random rand = new Random();
		String domainNameText = "addonas-website-" + rand.nextInt(10) + rand.nextInt(10) + rand.nextInt(10) + ".xyz";
		AutoMethods.enterTextBy(driver, "Domain name field in `Add Website` page`", domainNameInput, domainNameText);

		String password = AutoMethods.generatePassword(8);
		passwordField = By.xpath("//div[@class='dashboard']//input[@type='password']");
		AutoMethods.enterTextBy(driver, "Password field in `Add Website` page`", passwordField, password);

		By addWebsiteButton = By.xpath("//div[@class='h-portlet']//button[contains(@id,'add_website-submit_button')]");
		AutoMethods.clickElementBy(driver, "Add website button on `Add website` page", addWebsiteButton);

		By newWebsideDomain = By.xpath("//div[@class='h-portlet']//div[contains(@class,'data-table')]//td[contains(text(),'" + domainNameText + "')]");
		AutoMethods.checkElementIsDisplayedBy(driver, "Specified domain in `List of Websites' in `Add website` view", newWebsideDomain);
	}

	@After
	public void aftertest() {
		driver.quit();

	}

}
