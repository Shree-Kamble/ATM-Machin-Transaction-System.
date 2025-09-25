package com.ATM;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DB_Modules 
{
	
	  // Data to be inserted
  String[] cname = {"shree kamble", "Mahesh pole", "datta upade"};
  String[] accounttype = {"saving", "saving", "saving"};
  int[] balance = {100000, 100000,100000};
  String[] accno = {"935688", "801053", "935683"};
  String[] pin = {"3580", "9774", "8274"};
 
	public void DB_Connection()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");		// loading Driver Class
 			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","3580");
			
			Statement smt=con.createStatement();					// Connection Creating 
			smt.executeUpdate("create table customers(cname varchar2(20),accounttype varchar2(8),balance number,accno number,pin number)");
			
		    // Data insertion in the database ...... 
	        String sql = "INSERT INTO customers(cname, accounttype, balance, accno, pin) VALUES (?, ?, ?, ?, ?)";
        
			PreparedStatement psmt=con.prepareStatement(sql);
	
			for (int i = 0; i < cname.length; i++) 
			{
				psmt.setString(1, cname[i]);
				psmt.setString(2, accounttype[i]);
				psmt.setInt(3, balance[i]);
				psmt.setString(4, accno[i]);
				psmt.setString(5, pin[i]);
				psmt.executeUpdate();				
			}
					
			System.out.println("data inserted successfully ");
			
			String selectQuery = "SELECT balance FROM customers WHERE pin= ?";
			
			System.out.println("for withdrowl money please enter =1.");
			System.out.println("to check bank balence please enter =2.");
					 
			Scanner sc=new Scanner(System.in);	

			long  request=sc.nextInt();		// to select one operation ..(1/2) 
			if (request==1)			// condition for withdrawal money 
			{
				   				
				System.out.println("enter Amount to withdrawal =");		// how many amount user want to withdrawal 
				long amount=sc.nextInt();								// amount input .
				
		        //String sqlUpdate = "UPDATE customers SET balance = ? WHERE pin=3580";
				
				System.out.println("please enter your pin ....");
				int pin=sc.nextInt();
				
				if(pin==3580)											// shree balance withdrawal module.
				{
					
					int update=smt.executeUpdate("update customers set balance=");
				}
				else if(pin==9774)										// mahesh pole withdrawal module .
				{
					
				}
				else if(pin==8274)										// datta upade withdrawal module.
				{
					
				}
			}
			else if(request==2)
			{
				System.out.println("please enter your pin ....");	// modules to check bank balance .
				int pin=sc.nextInt();
				if(pin==3580)											// shrikant kamble bank balance ........
				{
					PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
				    preparedStatement.setLong(1, pin);
				              
				    ResultSet resultSet = preparedStatement.executeQuery();
				    {
				    if (resultSet.next()) 
				    { 													// Retrieve the balance from the result set
				        long balance = resultSet.getInt("balance");
				        System.out.println("your current balance is = " + balance);
				     } 
				 }		             
			}
			else if(pin==9774)											// mahesh pole bank balance 
			{
				PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
				preparedStatement.setLong(1, pin);			                
				ResultSet resultSet = preparedStatement.executeQuery();
				{
				if (resultSet.next()) 
				{
					int balance = resultSet.getInt("balance");
				    System.out.println("your current balance is = " + balance);
				} 
			}
		}
		else if(pin==8274)													// Datta upade  bank balance ..
		{
			PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
			preparedStatement.setLong(1, pin);
				                
			ResultSet resultSet = preparedStatement.executeQuery();
			{
				if (resultSet.next()) 
				{
					int balance = resultSet.getInt("balance");
				    System.out.println("your current balance is = " + balance);
				} 
			}
		}
		else
		{
			System.out.println("invalid choice , please enter valid choice...");
		}
	}
	smt.close();
	con.close();
	}
		catch(Exception e)
		{
			System.out.println("Exception is occured "+e);	
		}															// "desc tbl_name" command to select record in the database .....
	}	
}
	