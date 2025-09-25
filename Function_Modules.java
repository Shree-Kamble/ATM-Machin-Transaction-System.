package com.ATM;

import java.util.Scanner;

public class Function_Modules extends DB_Modules
{
	int request;	int Pinno;
	
	void Login()			// this is the first module of this program ...........
	{
		// CUSTOMER LOGIN MODULE................
		
		Scanner no=new Scanner(System.in);
		System.out.println("Please Enter Account no ....");
		int Accno=no.nextInt();
		System.out.println("please Enter your PIN .....");
		Pinno=no.nextInt();
		
		if(Accno==935688 && Pinno==3580)	// FIRST USER ACCOUNT NO AND PASSWORD .
		{
			System.out.println("Successfylly Loged in !");
			Firstmessage();
		}
		else if(Accno==801053 && Pinno==9774)	//SECOND USER ACCOUNT NO AND PASSWORD .
		{
			System.out.println("Successfylly Loged in !");
			Firstmessage();
		}
		else
		{
			System.out.println("something is wrong please try again .........\n ");
			
		}
		this.Login();
	}
//----------------------------------------------------------------------------------------------	
	 void Firstmessage()
	 {
		 //COSTOMER TRANSECTION MODULE...................
		 
		 System.out.println("              Please select your operation ..!\n");
		 Scanner sc=new Scanner(System.in);
		
		 DB_Connection();	 
	 }
}
