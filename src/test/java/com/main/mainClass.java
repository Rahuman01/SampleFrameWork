package com.main;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.pages.homePage;
import com.utility.utilityClass;

public class mainClass extends utilityClass {
	homePage hp;
	static Robot robot;
	static Actions action;

	@BeforeClass
	public void beforeClass() throws IOException {
		getDriver();
		// Read Data From Excel
		// String url =
		// excelRead("C:\\Users\\Dell\\eclipse-workspace\\abdul\\Excel\\url.xlsx");
		String url = propertyRead("url");
		geturl(url);
		screenshot();
	}

	@Test(priority = 1)
	public void navigateToLiveScore() throws AWTException {
		hp = new homePage();
		click(hp.getLiveScore());
		screenshot();
		robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		screenshot();
		hp.getHomeElement().click();
		screenshot();

	}

	@Test(priority = 2)
	public void getTopHeadlinesText() throws InterruptedException {
		hp = new homePage();
		Thread.sleep(3000);
		getText(hp.getTopHeadlines());
		screenshot();

	}

	@Test(priority = 3)
	public void getCurrentTime() throws AWTException, InterruptedException {
		hp = new homePage();
		action = new Actions(driver);
		action.moveToElement(hp.getLiveScore()).perform();
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Live Scores']")));
		click(hp.getSelectWeekView());
		screenshot();
		getText(hp.getCurrentTime());
		screenshot();
	}

	@Test(priority = 4)
	private void getEditorsPick() throws IOException, InterruptedException {
		hp = new homePage();
		String url = propertyRead("url");
		geturl(url);
		Thread.sleep(5000);
		getText(hp.getEditorsPick());
		hp.systemTime();
		screenshot();

	}

	@AfterClass
	public void afterClass() {
		extentReport();
		quit();
	}
}
