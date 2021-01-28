package tests;
import org.testng.annotations.Test;
import data.SignInDataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	LoginPage lp = new LoginPage();
	SignInDataFile df = new SignInDataFile();
	
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  
		lp.openBrowser();
	    lp.openWalmartLoginPage();	 
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }
  @Test
  public void loginWithWrongEmail() {
	  lp.enterEmail(df.WrongEmail);
	  lp.enterPassword(df.Password);
	  lp.keepMeSignInClick();
	  lp.signIn();
	  Assert.assertEquals(lp.errMsg(),df.EmailErr);
	
	  
  }
  @Test
  public void loginWithEmptyEmail() {
	  lp.enterPassword(df.Password);
	  lp.keepMeSignInClick();
	  lp.signIn();
	  Assert.assertEquals(lp.errMsg(),df.EmailErr);
  }
  @Test
  public void loginWithWrongPassword() {
	  lp.enterEmail(df.Email);
	  lp.enterPassword(df.WrongPassword);
	  lp.keepMeSignInClick();
	  lp.signIn();
	  Assert.assertEquals(lp.wrongPasswordErr(),df.wrongPasswordErr);
  }
  @Test
  public void loginWithEmptyPassword() {
	  lp.enterEmail(df.Email);
	  lp.keepMeSignInClick();
	  lp.signIn();
	  Assert.assertEquals(lp.errMsg(),df.PasswordErr);
  }
  
  @Test
  public void login() throws InterruptedException {
	  System.out.println(lp.getHomePageTitle());
	  lp.enterEmail(df.Email);
	  lp.enterPassword(df.Password);
	  lp.signIn();
	  System.out.println(lp.getHomePageTitle());
	  
	  
  }
}
