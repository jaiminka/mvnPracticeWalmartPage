package data;

import utilities.Xls_Reader;
	
public class SignInDataFile {
	String path = System.getProperty("user.dir");
	Xls_Reader d = new Xls_Reader(path+"\\src\\main\\java\\resource\\walmart.xlsx");
	
	
	public String Email = d.getCellData("data1", 4, 3);
	public String Password = d.getCellData("data1", 4, 4);
	public String WrongPassword = d.getCellData("data1", 4, 5);
	public String WrongEmail = d.getCellData("data1", 4, 6);
	public String EmailErr = d.getCellData("data1", 4, 7);
	public String PasswordErr = d.getCellData("data1", 4, 9);
	public String wrongPasswordErr = d.getCellData("data1", 4, 10);
}
