package ninzahrm.resources;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Baseclass;
import objrepo.DashboardPOM;
import objrepo.EmployeePOM;
import objrepo.LoginPOM;
import objrepo.ResourcesPOM;

public class ResourceTest extends Baseclass{
	
	@Test(groups="functional")
	public void verifyResource() throws Exception {
		LoginPOM log=new LoginPOM(driver);
		ResourcesPOM rp=new ResourcesPOM(driver);
		log.login();
		Thread.sleep(2000);
		rp.clickResource();
		rp.clickUpload();
		rp.chooseFile("C:\\Users\\Hp\\Downloads\\Hemant-Java-Dev.pdf");
        Assert.assertFalse(rp.isFileNotSelected(),"File was not selected");
		rp.uploadButton();	
		Thread.sleep(2000);
		rp.searchBy("Search by File Name");
	    rp.searchfield("Hemant-Java-Dev.pdf");
		
		}
	@Test(dependsOnMethods = "verifyResource",groups = "functional")
	public void deleteResource() throws Exception {

	    LoginPOM log = new LoginPOM(driver);
	    ResourcesPOM rp = new ResourcesPOM(driver);
	    log.login();
	    Thread.sleep(2000);
	    rp.clickResource();
	    driver.navigate().refresh();
	    rp.searchBy("Search by File Name");
	    rp.searchfield("Hemant-Java-Dev.pdf");
	    Thread.sleep(2000);
	    rp.clickDelete();
	    Thread.sleep(2000);
	    rp.confirmDelete();
	    Thread.sleep(2000);
	    driver.navigate().refresh();
	    Assert.assertFalse(driver.findElement(By.xpath("//table")).getText().contains("Hemant-Java-Dev.pdf"));
	    Reporter.log("File Deleted Successfully",true);

	}
	@Test(groups = "system")
	public void verifySystemModules() throws Exception {
		LoginPOM log=new LoginPOM(driver);
		DashboardPOM dp=new DashboardPOM(driver);
		EmployeePOM emy=new EmployeePOM(driver);
		ResourcesPOM rp=new ResourcesPOM(driver);
		log.login();
	    Assert.assertTrue(dp.getEmployeehdng().isDisplayed(),"Dashboard is not displayed");
	    Thread.sleep(2000);
	    emy.clickEmp();
	    Assert.assertTrue(emy.getEmployeeCount() > 0,"Employees module is not loaded");
	    rp.clickResource();
	    Assert.assertTrue(rp.isResourcesPageDisplayed(),"Resources module is not loaded");
	    Reporter.log("System modules verified successfully", true);
	}
	   
}

