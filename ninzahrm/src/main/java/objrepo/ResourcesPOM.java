package objrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ResourcesPOM {
	WebDriver driver;
	public ResourcesPOM(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[text()='Resources']")
	private WebElement resource;
	
	@FindBy(xpath="//span[text()='Upload File']")
	private WebElement upload;
	
	@FindBy(id="upload-file")
	private WebElement choose;
	
	@FindBy(xpath="//button[@type='submit' and text()='Upload File']")
	private WebElement updbutton;
	
	@FindBy(xpath="//a[@class='delete']")
	private WebElement delete;
	
	@FindBy(xpath="//select[@class='form-control']")
	private WebElement searchdd;
	
	@FindBy(xpath="//input[@class='form-control']")
	private WebElement searchtf;
	
	@FindBy(xpath="//input[@type='button' and @value='Delete']")
	private WebElement confirmDelete;
	
	public void clickResource() {
		resource.click();
	}
	public void clickUpload() {
		upload.click();
	}
	public void chooseFile(String path) {
		choose.sendKeys(path);
	}
	public void uploadButton() {
		updbutton.click();
	}
	public void clickDelete() {
		delete.click();
	}
	
	public void searchBy(String option) {
	    Select s = new Select(searchdd);
	    s.selectByVisibleText(option);
	}
	public void searchfield(String value) {
		searchtf.sendKeys(value);
	}
	public void confirmDelete() {
	    confirmDelete.click();
	}
	public boolean isFileNotSelected() {
	    return choose.getAttribute("value").isEmpty();
	}
	public boolean isResourcesPageDisplayed() {
	    return upload.isDisplayed();
	}
	
}

