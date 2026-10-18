package objrepo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class EmployeePOM {
	WebDriver driver;
	public EmployeePOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Employees']")
	private WebElement emp;
	
	@FindBy(xpath="//span[text()='Add New Employee']")
	private WebElement addemp;
	
	@FindBy(xpath = "//label[normalize-space()='Name*']/following-sibling::input")
	private WebElement empname;

	@FindBy(xpath = "//label[normalize-space()='Email*']/following-sibling::input")
	private WebElement email;

	@FindBy(xpath = "//label[normalize-space()='Phone*']/following-sibling::input")
	private WebElement phone;

	@FindBy(xpath = "//label[normalize-space()='Username*']/following-sibling::input")
	private WebElement username;

	@FindBy(xpath = "//label[normalize-space()='Designation*']/following-sibling::input")
	private WebElement designation;

	@FindBy(xpath = "//label[normalize-space()='Experience*']/following-sibling::input")
	private WebElement experience;

	@FindBy(xpath = "//label[normalize-space()='Project*']/following-sibling::select")
	private WebElement project;

	@FindBy(xpath = "//input[@type='submit' and @value='Add']")
	private WebElement addbtn;

	@FindBy(xpath = "//button[normalize-space()='Cancel']")
	private WebElement cancelbtn;

	@FindBy(xpath="//input[@type='button' and @value='Delete' and @data-dismiss='modal']")
	private WebElement confirmDelete;
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement search;
	
	@FindBy(xpath="//input[@class='form-control' and @placeholder='Search by Employee Name']")
	private WebElement srchfield;
		
	public void searchBy(String opt) {
		Select s= new Select(search);
		s.selectByVisibleText(opt);
	}
	public void enterSearch(String value) {
		srchfield.sendKeys(value);
	}
	public void clickEmp() {
		emp.click();
	}
	public void addEmp() {
		addemp.click();
	}
	public void selectProject(String projectname) {
        Select s = new Select(project);
        s.selectByVisibleText(projectname);
    }

    public String selProject() {
        Select s = new Select(project);
        return s.getFirstSelectedOption().getText();
    }
	
	public void getEmpname(String value) {
	    empname.sendKeys(value);
	}

	public void getEmail(String value) {
	    email.sendKeys(value);
	}
    public void getPhone(String value) {
       phone.sendKeys(value);
    }
    public void getUsername(String value) {
        username.sendKeys(value);
    }
    public void getDesignation(String value) {
        designation.sendKeys(value);
    }
    public void getExperience(String value) {
       experience.sendKeys(value);
    }
    public int getEmployeeCount() {
        return driver.findElements(By.cssSelector("table.table tbody tr")).size();
    }
    
    public void getAddbtn() {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", addbtn);
    }
    public void getCancelbtn() {
        cancelbtn.click();
    }
    
    public void selectandDeleteEmployee(String username) {
        WebElement row = driver.findElement(By.xpath("//tr[td[text()='" + username + "']]"));
        row.findElement(By.cssSelector("span.custom-checkbox")).click();
        driver.findElement(By.xpath("//span[text()='Delete']")).click();
        confirmDelete.click();
    }
}
	

