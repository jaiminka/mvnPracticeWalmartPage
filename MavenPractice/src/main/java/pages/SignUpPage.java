package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	
	WebDriver driver;
	@FindBy(id ="firstName")
	public static WebElement firstName;
	@FindBy(id ="lastName")
	public static WebElement lastName;
	@FindBy(id ="email")
	public static WebElement email;
	@FindBy(id ="password")
	public static WebElement password;
	@FindBy(id ="TAndC")
	public static WebElement tearmsButtonClick;
	@FindBy(xpath ="//button[@class='css-1i45fk4 edzik9p0']")
	public static WebElement createAccount;
	@FindBy(xpath ="//span[@class='css-1lliris erl5ymg3']")
	public static WebElement ErrMsg;
	
	public void openBrowser() throws IOException {
		FileInputStream walmart = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\walmart.properties");
		Properties prop = new Properties();
		prop.load(walmart);
		String browser = prop.getProperty("browser");
		if(browser.equals("Firefox")) {
			 System.setProperty("webdriver.gecko.driver", "D:\\SeleniumJars\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}else {
			System.setProperty("webdriver.chrome.driver", "D:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		 PageFactory.initElements(driver, this);
		
	}
	public void openWalmart() {
		driver.get("https://www.walmart.ca/create-account");
		 driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	public void closeBrowser() {
		 driver.quit();
	}
	public void enterFirstName(String a) {
		 firstName.sendKeys(a);
		
	}
	public void enterLastName(String a) {
		lastName.sendKeys(a);	  
	}
	public void enterEmail(String a) {
		email.sendKeys(a);
	}
	public void enterPassword(String a) {
		password.sendKeys(a);
		
	}
	public void tearmsButtonClick() {
		tearmsButtonClick.click();		
	}
	public void createAccount() {
		createAccount.click();	
	}
	public String ErrMsg() {
		String actualErrMsg= ErrMsg.getText();
		return actualErrMsg;
	}
	
		
		
	
	
	
}
