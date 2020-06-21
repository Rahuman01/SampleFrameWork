package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.TimeZone;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class utilityClass {
	public static WebDriver driver;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public void getDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Dell\\eclipse-workspace\\abdul\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void geturl(String url) {
		driver.get(url);

	}

	public String generateRandomDate() {
		SimpleDateFormat sf = new SimpleDateFormat("EE_MM_dd_yyyy_hhmmss");
		String format = sf.format(new Date());
		return format;

	}

	public void screenshot() {
		TakesScreenshot tk = (TakesScreenshot) driver;
		File s = tk.getScreenshotAs(OutputType.FILE);
		File d = new File("C:\\Users\\Dell\\eclipse-workspace\\abdul\\Screenshots\\" + generateRandomDate() + ".png");
		try {
			FileUtils.copyFile(s, d);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void extentReport() {
		reporter = new ExtentHtmlReporter("./Extentreport/new.html");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		logger = extent.createTest("cric info page");
		logger.log(Status.INFO, "Login to cric_info page");
		extent.flush();
	}

	public void click(WebElement e) {
		e.click();

	}
	
	public void systemTime() {
		Date d = new Date();
		TimeZone timeZone = TimeZone.getTimeZone("Asia/Kolkata");
		System.out.println("time zone is : " + timeZone);
		System.out.println("date is : " + d);

	}

	public void getText(WebElement e) {
		String text = e.getText();
		System.out.println("Printing " + text);

	}

	public void quit() {
		driver.quit();
	}

	public static String excelRead(String filePath) throws IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook w = new XSSFWorkbook(fis);
		Sheet s = w.getSheet("Sheet1");
		Row r = s.getRow(0);
		Cell c = r.getCell(0); 
		return c.getStringCellValue();
	}

	public static String propertyRead(String key) throws IOException {
		Properties property = new Properties();
		
		File file=new File("C:\\Users\\Dell\\eclipse-workspace\\abdul\\Properties\\data.properties");
		FileInputStream fs = new FileInputStream(file);
		property.load(fs);
		return property.getProperty(key);

	}

}
