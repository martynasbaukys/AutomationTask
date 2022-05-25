package MainPackage;

import java.security.SecureRandom;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoMethods {

	public static void clickElementBy(WebDriver driver, String errorMessage, By by) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			element.click();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(errorMessage + "\n" + ex.toString());
		}
	}

	public static void enterTextBy(WebDriver driver, String errorMessage, By by, String Text) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		try {
			//WebElement element = driver.findElement(by);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			element.sendKeys(Text);
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(errorMessage + "\n" + ex.toString());
		}
	}

	public static void checkElementIsDisplayedBy(WebDriver driver, String errorMessage, By by) throws InterruptedException {
		try {
			WebElement t = driver.findElement(by);
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
			w.until(ExpectedConditions.visibilityOfElementLocated(by));
		} catch (NoSuchElementException ex) {
			Assert.fail(errorMessage + "\n" + ex.toString());
		}
	}

	public static String generatePassword(int length) {
		final String allowedChars = "abcdefghijklmnopqrstuvwABCDEFGHIJKLMNOP0123456789!§$%&?*+#";
		SecureRandom random = new SecureRandom();
		StringBuilder pass = new StringBuilder(length);

		for (int i = 0; i < length; i++) {
			pass.append(allowedChars.charAt(random.nextInt(allowedChars.length())));
		}

		return pass.toString();
	}
}
