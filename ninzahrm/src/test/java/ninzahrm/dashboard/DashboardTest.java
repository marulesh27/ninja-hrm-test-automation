package ninzahrm.dashboard;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import Base.Baseclass;
import objrepo.LoginPOM;
import objrepo.DashboardPOM;
import objrepo.EmployeePOM;

public class DashboardTest extends Baseclass {
		
    @Test(groups = {"smoke", "functional"})
    public void verifyDashboardLoading() throws Exception {
    	LoginPOM log=new LoginPOM(driver);
    	DashboardPOM dp=new DashboardPOM(driver);
       log.login();
       Assert.assertTrue(dp.getEmployeehdng().isDisplayed(),"Employees heading is not displayed");
        Assert.assertTrue(dp.getProjecthdng().isDisplayed(),"Projects heading is not displayed");
        Reporter.log("Dashboard loaded successfully",true);
	 }
    
    @Test(groups = "functional")
    public void verifyEmployeeChart() throws Exception {
    	LoginPOM log=new LoginPOM(driver);
    	DashboardPOM dp=new DashboardPOM(driver);
        log.login();
        Thread.sleep(2000);
        List<WebElement> categories = dp.getEmpbars();

        Assert.assertFalse(categories.isEmpty(),"No employee chart bars found");
        for (WebElement category : categories) {
            System.out.println("Experience category: "+ category.getAttribute("name"));
        }
        Reporter.log("Employee chart bars are displayed successfully", true);
    }
    
    @Test(groups = "functional")
    public void verifyEmployeeTable() throws Exception {
    	LoginPOM log=new LoginPOM(driver);
    	DashboardPOM dp=new DashboardPOM(driver);
        log.login();
        Assert.assertTrue(dp.isEmployeeTableDisplayed(),"Employee table is not displayed");
        List<WebElement> headers = dp.getEmployeeTableHeaders();
        Assert.assertEquals(headers.size(), 2,"Employee table should contain two columns");
        Assert.assertEquals(headers.get(0).getText(), "Experience","First column header is incorrect");
        Assert.assertEquals(headers.get(1).getText(), "Number of Employees","Second column header is incorrect");
        Assert.assertFalse(dp.getEmployeeTableRows().isEmpty(),"Employee table contains no data rows");
        Reporter.log("Employee table structure and data verified successfully",true);
    }
    
    @Test(groups = "functional")
    public void verifyProjectsTable() throws Exception {    
    	LoginPOM log=new LoginPOM(driver);
    	DashboardPOM dp=new DashboardPOM(driver);
        log.login();
        Assert.assertTrue(dp.getProject().isDisplayed(),"Projects section is not displayed");
        List<WebElement> headers = dp.getProjectTableHeaders();
        Assert.assertEquals(headers.size(), 2,"Projects table should contain two columns");
        Assert.assertEquals(headers.get(0).getText(), "Status","First column header is incorrect");
        Assert.assertEquals(headers.get(1).getText(), "Count","Second column header is incorrect");
        Assert.assertFalse(dp.getProjectTableRows().isEmpty(),"Projects table contains no data rows");
        Reporter.log("Projects section and table verified successfully", true);
    }
    
     @Test(groups = "integration")
    public void verifyDashboardNavigation() throws Exception {  
    	LoginPOM log=new LoginPOM(driver);
     	DashboardPOM dp=new DashboardPOM(driver);
     	EmployeePOM emp=new EmployeePOM(driver);
        log.login();
        emp.clickEmp();
        dp.db.click();
        Assert.assertTrue(dp.getEmployeehdng().isDisplayed(),"Employees heading is not displayed");
        Assert.assertTrue(dp.getProjecthdng().isDisplayed(),"Projects heading is not displayed");
        Reporter.log("Navigation from Employees to Dashboard verified successfully", true);
    }
}


