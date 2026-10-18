package ninzahrm.Negative;

import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import objrepo.LoginPOM;
import objrepo.ResourcesPOM;

import utilities.ScreenshotUtility;

public class NegativeResources extends Baseclass {

	@Test
	public void verifyUploadWithoutFile() throws Exception {
	    LoginPOM log = new LoginPOM(driver);
	    ResourcesPOM rp = new ResourcesPOM(driver);
		ScreenshotUtility su=new ScreenshotUtility();

	    log.login();
	    Thread.sleep(2000);
	    rp.clickResource();
	    rp.clickUpload();
	    Assert.assertTrue(rp.isFileNotSelected(),"File should not be selected");
	    rp.uploadButton();
	    su.captureScreenshot(driver, "InvalidResource");
	}
}

