package Base;

import java.time.Duration;
import org.testng.annotations.Optional;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utilities.PropertiesUtility;

public class Baseclass {
	protected WebDriver driver;
	PropertiesUtility pro;
	
	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Suite Execution Started");
	}
	
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test started");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Class Execution Started");
	}
	@Parameters("browser")
    @BeforeMethod(alwaysRun = true)
    public void setup(@Optional("chrome")String browser) throws Exception {
        pro = new PropertiesUtility();
        //String browser=pro.getProperty("browser");
        String url = pro.getProperty("url");
        if (browser.equalsIgnoreCase("chrome")) {
        	ChromeOptions options = new ChromeOptions();
            options.addArguments("--incognito");
            driver = new ChromeDriver(options);
       }
        else if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        System.out.println("Browser launched");
    }
 
	@AfterMethod(alwaysRun = true)
	public void logout() {
    	if (driver != null) {
        	driver.quit();
        	driver = null;
        	System.out.println("Logout executed");
    	}
	}
   
    @AfterClass
    public void afterClass() {
        System.out.println("Class execution completed");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Test execution completed");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("Suite execution completed");
    }
}
