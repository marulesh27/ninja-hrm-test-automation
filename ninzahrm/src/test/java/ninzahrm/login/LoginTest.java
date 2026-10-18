package ninzahrm.login;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Baseclass;
import objrepo.DashboardPOM;
import objrepo.LoginPOM;


public class LoginTest extends Baseclass {
	
    @Test(groups = {"smoke", "functional"})
    public void verifyLogin() throws Exception {
        LoginPOM log=new LoginPOM(driver);
        DashboardPOM dp=new DashboardPOM(driver);
        log.login();
        Assert.assertTrue(dp.getEmployeehdng().isDisplayed(),"Employees heading is not displayed");
        Assert.assertTrue(dp.getProjecthdng().isDisplayed(),"Projects heading is not displayed");
        System.out.println("Dashboard loaded successfully");
	    }
    
    
}
