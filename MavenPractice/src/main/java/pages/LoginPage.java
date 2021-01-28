package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

	
public class LoginPage {
	
	WebDriver driver;
	
	
	@FindBy(id = "username")
	public static WebElement Email;
	@FindBy(id = "password")
	public static WebElement Password;
	@FindBy(id= "rememberme")
	public static WebElement KeepMeSignIn;
	@FindBy(xpath = "//button[contains(text(),'Sign in')]")
	public static WebElement SignIn;
	@FindBy(xpath = "//span[@class='css-1lliris erl5ymg3']")
	public static WebElement ErrMsg;
	@FindBy(linkText = "Reset Your Password")
	public static WebElement WrongPasswordErr;
	
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
	public void openWalmartLoginPage() {
		driver.get("https://www.walmart.ca/sign-in?from=%2Fen");
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}	
	public void closeBrowser() {
		driver.close();
	}
	public void enterEmail(String a) {
		Email.sendKeys(a);
	}
	public void enterPassword(String a) {
		Password.sendKeys(a);
	}
	public void keepMeSignInClick() {
		KeepMeSignIn.click();
}
	public void signIn() {
		SignIn.click();
	}
	public String errMsg() {
		String actualErrMsg = ErrMsg.getText();
		return actualErrMsg;
	}
	public String wrongPasswordErr() {
		String actualErrMsg = WrongPasswordErr.getText();
		return actualErrMsg;
	}
	public String getHomePageTitle() {
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
}