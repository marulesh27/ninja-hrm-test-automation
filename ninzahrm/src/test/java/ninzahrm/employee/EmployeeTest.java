package ninzahrm.employee;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.Baseclass;
import objrepo.EmployeePOM;
import objrepo.LoginPOM;
import utilities.ExcelUtility;

public class EmployeeTest extends Baseclass {

       @Test(groups = "functional")
    public void EmployeeDetails() throws Exception {
    	LoginPOM log=new LoginPOM(driver);
    	EmployeePOM emy=new EmployeePOM(driver);
    	ExcelUtility ex=new ExcelUtility();
        log.login();
        emy.clickEmp();
        emy.addEmp();

        emy.getEmpname(ex.getData("sheet2", 1, 0));
        emy.getEmail(ex.getData("sheet2", 1, 1));
        emy.getPhone(ex.getData("sheet2", 1, 2));
        emy.getUsername(ex.getData("sheet2", 1, 3));
        emy.getDesignation(ex.getData("sheet2", 1, 4));
        emy.getExperience(ex.getData("sheet2", 1, 5));
        emy.selectProject(ex.getData("sheet2", 1, 6));
        emy.getAddbtn();
        Reporter.log("Employee added successfully", true);
    }

    @Test(groups = "integration")
    public void verifyEmployeeAfterAdding() throws Exception {
    	LoginPOM log=new LoginPOM(driver);
    	EmployeePOM emy=new EmployeePOM(driver);
    	ExcelUtility ex=new ExcelUtility();
        log.login();
        emy.clickEmp();

        emy.addEmp();
        emy.getEmpname(ex.getData("sheet2", 2, 0));
        emy.getEmail(ex.getData("sheet2", 2, 1));
        emy.getPhone(ex.getData("sheet2", 2, 2));
        emy.getUsername(ex.getData("sheet2", 2, 3));
        emy.getDesignation(ex.getData("sheet2", 2, 4));
        emy.getExperience(ex.getData("sheet2", 2, 5));
        emy.selectProject(ex.getData("sheet2", 2, 6));
        emy.getAddbtn();
        Thread.sleep(3000);
        driver.navigate().refresh();
        emy.searchBy("Search by Name");
        emy.enterSearch(ex.getData("sheet2", 2, 3));

        Assert.assertTrue(driver.findElement(By.xpath("//table//tbody/tr")).getText().contains(ex.getData("sheet2", 2, 0)));
        Reporter.log("New employee verified successfully", true);
    }
    
    @Test(dependsOnMethods = "verifyEmployeeAfterAdding",groups = "functional")
    	public void deleteEmployee() throws Exception {
    	LoginPOM log=new LoginPOM(driver);
    	EmployeePOM emy=new EmployeePOM(driver);
    	ExcelUtility ex=new ExcelUtility();
    	    log.login();
    	    emy.clickEmp();

    	    emy.searchBy("Search by Name");
    	    emy.enterSearch(ex.getData("sheet2", 2, 0));
    	    Thread.sleep(2000);
    	    emy.selectandDeleteEmployee(ex.getData("sheet2", 2, 0));
    	    Thread.sleep(2000);
    	    driver.navigate().refresh();

    	    emy.searchBy("Search by Name");
    	    emy.enterSearch(ex.getData("sheet2", 2, 0));
    	    Assert.assertTrue(driver.findElements(By.xpath("//table//tbody/tr")).isEmpty(),"Deleted employee is still displayed");    	    
    	    Reporter.log("Employee deleted successfully", true);
    	    
    	}
    @Test(groups = {"system"})
    public void verifyEmployeeModule() throws Exception {
    	LoginPOM log=new LoginPOM(driver);
    	EmployeePOM emy=new EmployeePOM(driver);
    	log.login();
        emy.clickEmp();

        Assert.assertTrue(emy.getEmployeeCount() > 0,"Employee list is not displayed");
        Reporter.log("Employee module verified successfully", true);
    }
}