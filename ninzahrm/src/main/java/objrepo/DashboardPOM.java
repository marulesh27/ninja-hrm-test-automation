
package objrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPOM {

    WebDriver driver;

    public DashboardPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Dashboard']")
    public WebElement db;

    @FindBy(xpath = "//h2[text()='Employees']")
    private WebElement employeehdng;

    @FindBy(xpath = "//h2[text()='Projects']")
    private WebElement projecthdng;

    @FindBy(css = "div.table-container")
    private WebElement empdetails;

    @FindBy(css = "div.chart-card-right")
    private WebElement project;

    @FindBy(css = "div.chart-card-left .recharts-bar-rectangle path")
    private List<WebElement> empbars;

    public List<WebElement> getEmpbars() {
        return empbars;
    }

    public boolean isEmployeeTableDisplayed() {
        return empdetails.isDisplayed();
    }

    public WebElement getEmployeehdng() {
        return employeehdng;
    }

    public WebElement getProjecthdng() {
        return projecthdng;
    }

    public WebElement getProject() {
        return project;
    }

    public List<WebElement> getEmployeeTableHeaders() {
        return empdetails.findElements(By.cssSelector("thead th"));
    }

    public List<WebElement> getEmployeeTableRows() {
        return empdetails.findElements(By.cssSelector("tbody tr"));
    }

    public List<WebElement> getProjectTableHeaders() {
        return project.findElements(By.cssSelector("thead th"));
    }

    public List<WebElement> getProjectTableRows() {
        return project.findElements(By.cssSelector("tbody tr"));
    }
}
