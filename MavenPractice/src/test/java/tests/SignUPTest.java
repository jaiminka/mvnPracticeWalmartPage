package tests;
import org.testng.annotations.Test;
import data.DataFile;
import net.bytebuddy.build.ToStringPlugin.Exclude;
import pages.SignUpPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class SignUPTest {
	WebDriver driver;
	SignUpPage sp = new SignUpPage();
	DataFile df = new DataFile();
 
  @BeforeMethod
  public void beforeMethod() throws IOException {  
	sp.openBrowser();
	sp.openWalmart();
  }
  
  @AfterMethod
  public void afterMethod() {
	  sp.closeBrowser();
  }
 
  @Test
  public void signUpWithoutFirstName() {
	  sp.enterLastName(df.Lastname);
	  sp.enterEmail(df.Email);
	  sp.enterPassword(df.Password);
	  sp.tearmsButtonClick();
	  sp.createAccount();
	  Assert.assertEquals(sp.ErrMsg(), df.FirstNameErr);
  }
  @Test
  public void signUpWithoutLastName() {
	  														//signup with out entering firstname
	  sp.enterFirstName(df.Firtname);
	  sp.enterEmail(df.Email);
	  sp.enterPassword(df.Password);
	  sp.tearmsButtonClick();
	  sp.createAccount();
	  Assert.assertEquals(sp.ErrMsg(), df.LastNameErr);
  }
 
  @Test
  public void signUpWithoutEmail() {
	  														//signup with out entering email
	  sp.enterFirstName(df.Firtname);
	  sp.enterLastName(df.Lastname);
	  sp.enterPassword(df.Password);
	  sp.tearmsButtonClick();
	  sp.createAccount();
	  Assert.assertEquals(sp.ErrMsg(), df.EmailErr);
  }
  @Test
  public void signUpWithWrongEmail() {
	  														//signup with out entering wrong email
	  sp.enterFirstName(df.Firtname);
	  sp.enterLastName(df.Lastname);
	  sp.enterEmail(df.wrongEmail);
	  sp.enterPassword(df.Password);
	  sp.tearmsButtonClick();
	  sp.createAccount();
	  Assert.assertEquals(sp.ErrMsg(), df.EmailErr);
  }
  @Test
  public void signUpWithoutPassword() {
	  														//signup with out entering wrong email
	  sp.enterFirstName(df.Firtname);
	  sp.enterLastName(df.Lastname);
	  sp.enterEmail(df.Email);
	  sp.tearmsButtonClick();
	  sp.createAccount();
	  Assert.assertEquals(sp.ErrMsg(), df.PasswordErr);
  }
  
}
