package ninzahrm.Negative;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import objrepo.LoginPOM;
import utilities.ExcelUtility;
import utilities.ScreenshotUtility;

public class NegativeLogin extends Baseclass {
	
	@Test
	public void verifyNegLogin() throws Exception {
		LoginPOM log=new LoginPOM(driver);
		ExcelUtility ex= new ExcelUtility();
		ScreenshotUtility su=new ScreenshotUtility();
		
		log.enterUsername(ex.getData("sheet1", 2, 0));
		log.enterPassword(ex.getData("sheet1", 2, 1));
		log.loginbtn.click();
		Thread.sleep(2000);
		Alert alert = driver.switchTo().alert();
		String actualMessage = alert.getText();
		Assert.assertTrue(actualMessage.toLowerCase().contains("invalid credentials"),"Invalid credentials message is not displayed");
		alert.accept();
		su.captureScreenshot(driver, "InvalidLogin");
		
	}
}
