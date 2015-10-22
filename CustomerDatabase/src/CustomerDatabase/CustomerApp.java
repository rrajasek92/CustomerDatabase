package CustomerDatabase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class CustomerApp {

	public static void main(String[] args) {
		String in="1";
		Scanner s = new Scanner (System.in);
		in=Validator.getString(s,"Press (1) to search for a customer or press (2) to Edit the customer's address. (0) for quit");
		
		while(!in.equals("0")){
			
			
			if(in.equals("1")){
				String a = Validator.getString(s, "Last Name: ");
		printInfo(a);
			}
			if(in.equals("2")){
				String f = Validator.getString(s,"Customer ID: ");
				String b = Validator.getString(s,"Street: ");
				String c = Validator.getString(s,"City: ");
				String d = Validator.getString(s,"State: ");
				int g = Validator.getInt(s, "Zipcode: ");
				updateInfo(f,b,c,d,g);
			}
		
			in=Validator.getString(s,"Press (1) to search for a customer or press (2) to Edit the customer's address. (0) for quit");
		}
		System.out.println("\n\nClosing program......");
	}



public static void printInfo(String scanned) 
{ 
	try 
{ 
//URL of Oracle database server 
		String url = "jdbc:oracle:thin:system/password@localhost"; 
 
		//properties for creating connection to Oracle database 
		Properties props = new Properties(); 
		props.setProperty("user", "TestUserDB"); 
		props.setProperty("password", "password"); 
 
 //creating connection to Oracle database using JDBC 
		Connection conn = DriverManager.getConnection(url,props); 
 
		String sql ="select customerid,title,fullname,streetaddress,city,state,zipcode,emailaddress,position,company from customers where lastname = '" + scanned + "'"; 
 
 //creating PreparedStatement object to execute query 
		PreparedStatement preStatement = conn.prepareStatement(sql); 
 
		ResultSet result = preStatement.executeQuery(); 
		
	System.out.println(); 
	while(result.next()){ 
		System.out.println("Customer number: " + result.getString("customerid") + "\n" + result.getString("title") + " " + result.getString("fullname") + "\n" + result.getString("streetaddress") + "\n" + result.getString("city") + " " + result.getString("state") + " " + result.getString("zipcode") + "\n" + result.getString("emailaddress") + "\n" + result.getString("position") +" at " + result.getString("company"));
		System.out.println(); 
	} 
	conn.close(); 
	}catch(SQLException e) 
	{ 
		System.out.println(e.getMessage()); 
		e.printStackTrace(); 
	}}

public static void updateInfo(String custID, String street, String city, String state, int zip) 
{ 
	try 
{ 
//URL of Oracle database server 
		String url = "jdbc:oracle:thin:system/password@localhost"; 
 
		//properties for creating connection to Oracle database 
		Properties props = new Properties(); 
		props.setProperty("user", "TestUserDB"); 
		props.setProperty("password", "password"); 
 
 //creating connection to Oracle database using JDBC 
		Connection conn = DriverManager.getConnection(url,props); 
 
		String sql ="update customers set streetaddress = '"+ street + "', city = '" + city + "',state = '" + state + "',zipcode = " + zip + "where customerid = " + custID;
 
 //creating PreparedStatement object to execute query 
		PreparedStatement preStatement = conn.prepareStatement(sql); 
 
		ResultSet result = preStatement.executeQuery(); 
		
	System.out.println(); 
	//while(result.next()){ 
	//	System.out.println("Customer number: " + result.getString("customerid") + "\n " + result.getString("title") + " " + result.getString("fullname") + "\n" + result.getString("streetaddress") + "\n" + result.getString("city") + " " + result.getString("state") + " " + result.getString("zipcode") + "\n" + result.getString("emailaddress") + "\n" + result.getString("position") +" at " + result.getString("company"));
	//	System.out.println(); 
	//} 
	conn.close(); 
	}catch(SQLException e) 
	{ 
		System.out.println(e.getMessage()); 
		e.printStackTrace(); 
	}}
} 
