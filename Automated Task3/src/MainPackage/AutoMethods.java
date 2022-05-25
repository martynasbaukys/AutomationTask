package MainPackage;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Random;

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
			//WebElement element = driver.findElement(by);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
			element.click();
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail(errorMessage + "\n" + ex.toString());
			driver.close();
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
			driver.close();
		}
	}

	public static void checkElementIsDisplayedBy(WebDriver driver, String errorMessage, By by) throws InterruptedException {

		try {

			WebElement t = driver.findElement(by);
			WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
			w.until(ExpectedConditions.visibilityOfElementLocated(by));
			System.out.println("Element is visible");
		} catch (NoSuchElementException ex) {
			Assert.fail(errorMessage + "\n" + ex.toString());
		}
	}

	public static String generatePassword(int length) {
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";
		String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		Random random = new Random();
		char[] password = new char[length];

		password[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		password[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		password[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		password[3] = numbers.charAt(random.nextInt(numbers.length()));

		String finalPass = "";

		for (int i = 4; i < length; i++) {
			finalPass += combinedChars.charAt(random.nextInt(combinedChars.length()));
		}
		return finalPass;
	}
}
