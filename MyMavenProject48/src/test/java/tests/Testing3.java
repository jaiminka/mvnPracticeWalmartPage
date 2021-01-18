package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testing3 {
	
	SoftAssert softassert = new SoftAssert();
	
	@Test(priority = 1)  //create user
	public void createUser() {
		System.out.println("i am in home test");
		System.out.println("before assertion");
		Assert.assertTrue(20>5, "Verifying element");
		System.out.println("after assertion");
		Assert.assertEquals("abc", "abc");
	}
	
	@Test(priority = 2, dependsOnMethods = "createUser", groups = "Smoke")  //Edit user
	public void editUser() {
		
		System.out.println("i am in home test");
		System.out.println("before assertion");
		softassert.assertTrue(20>5, "Verifying element");
		System.out.println("after assertion");
		softassert.assertEquals("abc", "abc");
		softassert.assertAll();    //similar to error collector in Junit.
	}
	
	@Test(priority = 3, dependsOnMethods = "editUser", groups = {"Smoke","Sanity"})  //delete user
	public void deleteUser() {
		
		System.out.println("i am in home test");
		System.out.println("before assertion");
		softassert.assertTrue(20>5, "Verifying element");
		System.out.println("after assertion");
		softassert.assertEquals("abc", "abc");
		softassert.assertAll();
	}
	

}
