package data;

import utilities.Xls_Reader;

public class DataFile {
	Xls_Reader d = new Xls_Reader(System.getProperty("user.dir")+"\\src\\main\\java\\resource\\walmart.xlsx");
	
	public String Firtname = d.getCellData("data1", 1, 3);
	public String Lastname = d.getCellData("data1", 1, 4);
	public String Email = d.getCellData("data1", 1, 5);
	public String Password= d.getCellData("data1", 1, 6);
	public String wrongEmail= d.getCellData("data1", 1, 7);
	public String FirstNameErr = d.getCellData("data1", 1, 8);
	public String LastNameErr= d.getCellData("data1", 1, 9);
	public String EmailErr= d.getCellData("data1", 1, 10);
	public String WrongEmailErr = d.getCellData("data1", 1, 11);
	public String PasswordErr = d.getCellData("data1", 1, 12);
}
