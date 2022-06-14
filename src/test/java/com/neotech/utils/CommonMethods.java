package com.neotech.utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.UnexpectedTagNameException;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.neotech.testbase.BaseClass;

public class CommonMethods extends BaseClass {

	/**
	 * This method clears a textbox and sends another text.
	 * 
	 * @param element
	 * @param text
	 */
	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	/**
	 * This method checks if radio/checkbox is enabled and then clicks on the
	 * element that has the value attribute we are looking for.
	 * 
	 * @param listElement
	 * @param value
	 */
	public static void clickRadioOrCheckbox(List<WebElement> listElement, String value) {
		String actualValue;

		for (WebElement el : listElement) {
			actualValue = el.getAttribute("value").trim();

			if (actualValue.equals(value) && el.isEnabled()) {
				el.click();
				break;
			}

		}
	}

	/**
	 * This method allows us to call Thread.sleep() for any amount of seconds
	 * specified.
	 * 
	 * @param seconds
	 */
	public static void wait(int seconds) {

		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method checks whether a visible text is found in a dropdown and selects
	 * it.
	 * 
	 * 
	 * @param element
	 * @param visibleText
	 */
	public static void selectDropdown(WebElement element, String visibleText) {

		try {
			Select sl = new Select(element);

			List<WebElement> options = sl.getOptions();

			for (WebElement el : options) {
				if (el.getText().equals(visibleText)) {
					sl.selectByVisibleText(visibleText);
					break;
				}
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method checks if a given index is valid for the WebElement and only then
	 * selects an element by index.
	 * 
	 * @param element
	 * @param index
	 */
	public static void selectDropdown(WebElement element, int index) {
		try {
			Select select = new Select(element);

			int size = select.getOptions().size();

			if (size > index) {
				select.selectByIndex(index);
			}
		} catch (UnexpectedTagNameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method accepts an Alert and handles NoAlertPresentException if no alert
	 * is present.
	 * 
	 */
	public static void acceptAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will dismiss an alert if it present.
	 * 
	 */
	public static void dismissAlert() {
		try {
			Alert alert = driver.switchTo().alert();
			alert.dismiss();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will get the Alert text. If no alert is present then the
	 * exception is caught and it returns null.
	 * 
	 * @return
	 */
	public static String getAlertText() {
		String alertText = null;

		try {
			Alert alert = driver.switchTo().alert();
			alertText = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

		return alertText;
	}

	/**
	 * This method sends text to the alert if present.
	 * 
	 * 
	 * @param text
	 */
	public static void sendAlertText(String text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(text);
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method switches to a frame using name or id
	 * 
	 * @param nameOrId
	 */
	public static void switchToFrame(String nameOrId) {
		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame using an index
	 * 
	 * @param index
	 */
	public static void switchToFrame(int index) {
		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches to a frame using a WebElement object
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {
		try {

			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method switches focus to a child window.
	 * 
	 */
	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (!window.equals(mainWindow)) {
				driver.switchTo().window(window);
			}
		}

	}

	/**
	 * This method creates a WebDriverWait object and returns it.
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT_TIME));

		return wait;
	}

	/**
	 * 
	 * This method will wait for an element to be clickable.
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForClickability(WebElement element) {
		// create a wait object and then add the expected wait condition

		return getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * This method waits for an element to be visible.
	 * 
	 * @param element
	 * @return
	 */
	public static WebElement waitForVisibility(WebElement element) {

		return getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method waits for an element to be clickable and then clicks on it.
	 * 
	 * @param element
	 */
	public static void click(WebElement element) {
		waitForClickability(element);
		element.click();
	}

	/**
	 * This method casts the driver to JavascriptExecutor and returns it
	 * 
	 * @return JavascriptExecutor
	 */
	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;

		// in one step
		// return (JavascriptExecutor) driver;
	}

	/**
	 * This method will click to the element that is passed using JavascriptExecutor
	 * 
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	/**
	 * This method will scroll the page until the element that is passed becomes
	 * visible
	 * 
	 * @param element
	 */
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * This method will scroll the page down based on the passed pixel parameter
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * This method will scroll the page up based on the passed pixel parameter
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This method will select a date from the calendar
	 * 
	 * @param elements
	 * @param date
	 */
	public static void selectCalendarDate(List<WebElement> elements, String date) {
		for (WebElement day : elements) {
			if (day.isEnabled()) {
				if (day.getText().equals(date)) {
					day.click();
					break;
				}
			} else {
				System.out.println("The date is not enabled!");
				break;
			}
		}
	}

	/**
	 * This method takes a screenshot and saves it with the provided filename
	 * 
	 * @param filename
	 */
	public static String takeScreenshot(String filename) {

		TakesScreenshot ts = (TakesScreenshot) driver;

		File source = ts.getScreenshotAs(OutputType.FILE);

		// we want to create a filename that is unique: for example name+timestamp
		// (validLogin2022_06_07_20_40_40)
		String destination = Constants.SCREENSHOT_FILEPATH + filename + getTimeStamp() + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (IOException e) {
			System.out.println("Cannot take Screenshot!");
		}

		return destination;
	}

	/**
	 * This method returns the timestamp in a String format.
	 * 
	 * @return
	 */
	public static String getTimeStamp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");

		return sdf.format(date);
	}

}
