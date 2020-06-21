package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utility.utilityClass;

public class homePage extends utilityClass {

	public homePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Live Scores']")
	private WebElement liveScore;

	public WebElement getLiveScore() {
		return liveScore;
	}

	@FindBy(xpath = "(//img[@alt='ESPNcricinfo'])")
	private WebElement homeElement;

	public WebElement getHomeElement() {
		return homeElement;
	}

	@FindBy(xpath = "(//h5[text()='Top Headlines']//ancestor::div[@class='section-header border-bottom widget-title']//following-sibling::div//ul//li)[1]")
	private WebElement topHeadlines;

	public WebElement getTopHeadlines() {
		return topHeadlines;
	}

	@FindBy(xpath = "(//span[text()='Current Time']//following-sibling::p//span[@id='gmt_time'])")
	private WebElement currentTime;

	public WebElement getCurrentTime() {
		return currentTime;
	}

	@FindBy(xpath = "//a[@data-hover='Week view']")
	private WebElement selectWeekView;
	
	
	public WebElement getSelectWeekView() {
		return selectWeekView;
	}

	@FindBy(xpath="//div[contains(text(), 'Live')]")
	private WebElement liveTab;

	public WebElement getLiveTab() {
		return liveTab;
	}

	@FindBy(xpath = "((//button[text()='Previous'])[2]//following-sibling::div//div//div[@data-index='1']//a)[2]//div//div")
	private WebElement editorsPick;

	public WebElement getEditorsPick() {
		return editorsPick;
	}
}
