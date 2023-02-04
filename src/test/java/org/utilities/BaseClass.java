package org.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	static private WebDriver driver;
	static private File file;
	static private Workbook w ;
	static private Sheet sheet;
	public static File getFile() {
		return file;
	}
	public static Workbook getW() {
		return w;
	}
	public static Sheet getSheet() {
		return sheet;
	}
	static public WebDriver getDriver() {
		return driver;	
	}
	static private Actions action() {
		return new Actions(driver);
	}
	static public void launchChromeBrowser() {
		ChromeOptions options = new ChromeOptions();
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	static public void launchEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
		driver.manage().window().maximize();
	}
	static public void launchFirefoxBrowser() {		
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	static public void launchURL(String Url) {
		driver.get(Url);
	}
	static public void switchFrame(String Frame) {
		driver.switchTo().frame(Frame);
	}
	static public void switchFrame(WebElement Frame) {
		driver.switchTo().frame(Frame);
	}
	static public void switchFrame(int index) {
		driver.switchTo().frame(index);
	}
	static public String getCurrentWindowid() {
		return driver.getWindowHandle();	
	}
	static public Set<String> getAllWindowid() {
		return driver.getWindowHandles();	
	}
	static public void switchWindow(String value) {
		driver.switchTo().window(value);
	}
	static public void implicitWaitSeconds(long sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
	}
	static public void explictWaitTitle(WebElement ele,long sec) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	static public String pageTitle() {
		return driver.getTitle();
	}
	static public String pageURL() {
		return driver.getCurrentUrl();
	}
	static public void closeTab() {
		driver.close();
	}
	static public void closeWindow() {
		driver.quit();
	}
	static public void setValues(WebElement e,String value) {
		e.clear();
		e.sendKeys(value);
	}
	static public void clickElement(WebElement e) {
		e.click();
	}
	static public String getValue(WebElement e, String name) {
		return e.getAttribute(name);
	}
	static public String getValue(WebElement e) {
		return e.getText();
	}
	static public void moveMouseTo(WebElement e) {
		action().moveToElement(e).perform();
	}
	static public Select getDropDown(WebElement e) {
		return new Select(e);
	}
	static public void selectOption(Select s,String text) {
		s.selectByVisibleText(text);
	}
	static public void jsScrollDown(WebElement e) {
		JavascriptExecutor J=(JavascriptExecutor) driver;
		J.executeScript("arguments[0].scrollIntoView(true)",e);
	}
	static public void jsScrollUp(WebElement e) {
		JavascriptExecutor J=(JavascriptExecutor) driver;
		J.executeScript("arguments[0].scrollIntoView(false)",e);
	}
	static public void setSheet(String loc,String Sheet) throws IOException {
		file=new File(loc);
		FileInputStream fin= new FileInputStream(file);
		w=new XSSFWorkbook(fin);
		sheet= w.getSheet(Sheet);
	}
	static public int getNoOfRows(Sheet s) {
		return sheet.getPhysicalNumberOfRows();
	}
	static public Row getRowValue(int no) {
		return sheet.getRow(no);
	}
	static public int getNoOfCells(Row r) {
		return r.getPhysicalNumberOfCells();
	}
	static public String getData(int row,int column) {
		String value="";
		Row r = sheet.getRow(row);
		Cell c = r.getCell(column);
		if (c.getCellType()==0) {
			if(DateUtil.isCellDateFormatted(c)) {
				Date date = c.getDateCellValue();
				SimpleDateFormat d=new SimpleDateFormat("MM/dd/YY");
				value=d.format(date);
			}else {
				long v=(long) c.getNumericCellValue();
				value=String.valueOf(v);
			}
		} else {
			value=c.getStringCellValue();
		}
		return value;
		
	}
	static public Row newRow(int no) {
		return sheet.createRow(no);
	}
	static public Cell newcell(Row r,int no) {
		return r.createCell(no);
		
	}
	static public void writeData(Cell cell,String value) throws IOException {
		cell.setCellValue(value);
	}
	static public void writeData() throws IOException {
		FileOutputStream fout =new FileOutputStream(file);
		w.write(fout);
	}
	static public void screenShot(String name) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File s=ts.getScreenshotAs(OutputType.FILE);
		String loc=System.getProperty("user.dir")+"\\target\\Screenshots\\"+name+".png";
		File d=new File(loc);
		FileUtils.copyFile(s, d);
	}
	static public byte[] ScreenShot() throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		return ts.getScreenshotAs(OutputType.BYTES);
	}
}