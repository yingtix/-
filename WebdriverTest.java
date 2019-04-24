package lab2;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import org.openqa.selenium.firefox.*;
import org.openqa.selenium.*;

@RunWith(Parameterized.class)
public class WebdriverTest {

	private WebDriver driver;
	private String baseUrl;
	
	private boolean acceptNextAlert = true;
	//private StringBuffer verificationErrors = new StringBuffer();
	  
	String answer;
	String input;
	
	@Before
	public void setUp() throws Exception {
	  System.setProperty("webdriver.gecko.driver", "G:\\Users\\ying\\selenium-java-3.9.0\\geckodriver.exe");
	  driver = new FirefoxDriver();
	  baseUrl = "http://121.193.130.195:8800/";
	  driver.get(baseUrl);
	  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	
	@Parameters
	public static Collection<Object[]> initTestData(){
		
		Collection<Object[]> a = new ArrayList<>();
		File excelFile = new File("G:\\Users\\ying\\1.xlsx");
		XSSFWorkbook wb = null;
        try {
            wb = new XSSFWorkbook(new FileInputStream(excelFile));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
		XSSFSheet sheet = wb.getSheetAt(0);
		XSSFRow row;
		Cell cell;
		for (int i = sheet.getFirstRowNum()+2; i < sheet.getPhysicalNumberOfRows(); i++) {  
            row = sheet.getRow(i);  
            cell = row.getCell(1);
            cell.setCellType(CellType.STRING);
            String str_id = cell.toString();
            
            cell = row.getCell(2);
            cell.setCellType(CellType.STRING);
            String str_name = cell.toString();
            
            cell = row.getCell(3);
            cell.setCellType(CellType.STRING);
            String str_git = cell.toString();
            String[] b = {str_id+'|'+str_name+'|'+str_git, str_id};
            a.add(b);
        } 
		
		try {
			wb.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public WebdriverTest(String output, String input)
	{
		this.answer = output;
		this.input = input;
	}
	@Test
	//²âÊÔjudge·½·¨
	public void testJudge() {
		Assert.assertEquals(answer, new Webdriver().test(input, driver));
	}
	@After
	public void testFinish() {
		driver.close();
	}
	
	@SuppressWarnings("unused")
	private boolean isElementPresent(By by) {
		    try {
		      driver.findElement(by);
		      return true;
		    } catch (NoSuchElementException e) {
		      return false;
		    }
	}
	@SuppressWarnings("unused")
	private boolean isAlertPresent() {
		    try {
		      driver.switchTo().alert();
		      return true;
		    } catch (NoAlertPresentException e) {
		      return false;
		    }
	}

	@SuppressWarnings("unused")
	private String closeAlertAndGetItsText() {
		    try {
		      Alert alert = driver.switchTo().alert();
		      String alertText = alert.getText();
		      if (acceptNextAlert) {
		        alert.accept();
		      } else {
		        alert.dismiss();
		      }
		      return alertText;
		    } finally {
		      acceptNextAlert = true;
		    }
	}
}
