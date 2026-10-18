package ninzahrm.Negative;

import org.testng.annotations.Test;
import Base.Baseclass;
import objrepo.EmployeePOM;
import objrepo.LoginPOM;
import utilities.ExcelUtility;
import utilities.ScreenshotUtility;

public class NegativeEmployee extends Baseclass {
	
	@Test
	public void verifyInvalidEmployee() throws Exception {
		LoginPOM log=new LoginPOM(driver);
		EmployeePOM emp=new EmployeePOM(driver);
		ExcelUtility ex=new ExcelUtility();
		ScreenshotUtility su=new ScreenshotUtility();

		log.login();
		Thread.sleep(2000);
		emp.clickEmp();
		emp.addEmp();
		emp.getEmpname(ex.getData("sheet2", 3, 0));
		emp.getEmail(ex.getData("sheet2", 3, 1));
		emp.getUsername(ex.getData("sheet2", 3, 3));
		emp.getDesignation(ex.getData("sheet2", 3, 4));
		emp.getExperience(ex.getData("sheet2", 3, 5));
		emp.selectProject(ex.getData("sheet2", 3, 6));
		emp.getAddbtn();
		su.captureScreenshot(driver, "InvalidEmployee");
	}

}
