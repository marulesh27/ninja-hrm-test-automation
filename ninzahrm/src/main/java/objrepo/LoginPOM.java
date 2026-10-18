package objrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.ExcelUtility;

public class LoginPOM {
	WebDriver driver;
	public LoginPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	private WebElement uname;
	
	@FindBy(id="inputPassword")
	private WebElement pwd;
	
	@FindBy(xpath="//button[text()='Sign in']")
	public WebElement loginbtn;
	
	public void enterUsername(String value) {
		uname.sendKeys(value);
	}
	public void enterPassword(String value) {
		pwd.sendKeys(value);
	}
	
	public void login() throws Exception {
		ExcelUtility ex= new ExcelUtility();
		enterUsername(ex.getData("sheet1", 1, 0));
		enterPassword(ex.getData("sheet1", 1, 1));
		loginbtn.click();
	}
}
