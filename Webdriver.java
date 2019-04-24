package lab2;

import org.openqa.selenium.*;

public class Webdriver {
	public String test(String id, WebDriver wd) {
		String pw = id.substring(4);
		WebElement input_id = wd.findElement(By.name("id"));
		WebElement btn_login = wd.findElement(By.id("btn_login"));
		WebElement input_pw = wd.findElement(By.name("password"));
		input_id.sendKeys(id);
		input_pw.sendKeys(pw);
		btn_login.click();
		
		WebElement txt_id = wd.findElement(By.id("student-id"));
		WebElement txt_name = wd.findElement(By.id("student-name"));
		WebElement txt_git = wd.findElement(By.id("student-git"));
		String str_id = txt_id.getText();
		String str_name = txt_name.getText();
		String str_git = txt_git.getText();
		//System.out.println(str_id+str_name+str_git);
		WebElement btn_logout = wd.findElement(By.id("btn_logout"));
		btn_logout.click();
		WebElement btn_ret = wd.findElement(By.id("btn_return"));
		btn_ret.click();
		
		return str_id+'|'+str_name+'|'+str_git;
	}
}
