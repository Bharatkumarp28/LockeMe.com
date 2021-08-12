package com.lockedMe;

//1. Class is having main method to execute this project
public class LockedMeApplication 
{

	public static void main(String[] args) 
	{
		//Welcome Page
		System.out.println("-----------------------------------------------------");
		System.out.println("*\t\tLockedMe.com\t\t\t    *");
		System.out.println("*\t---Developed by Bharat Kumar P---\t    *");
		System.out.println("-----------------------------------------------------");
		
		//Create Directory for application operations
		LockedMeOperations.makeDirectory();
		
		//Display Main Menu options
		LockedMeMenuOptions.mainMenuOptions();
	}
	

}
