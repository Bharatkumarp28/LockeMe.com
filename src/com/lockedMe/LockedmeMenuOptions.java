package com.lockedMe;

import java.util.List;
import java.util.Scanner;

public class LockedMeMenuOptions 
{
	public static void mainMenuOptions()
	{
		//Main Menu Options
		System.out.println("*****************************************************");
		System.out.println("\t\tMain Menu Options");
		System.out.println("*****************************************************");
		System.out.println("1. Retrieving the file names");
		System.out.println("2. Display options for file operations");
		System.out.println("3. Close the application");
		
		//Declaring variables
		int mMenuvalue;
		boolean menuFlag;
		
		//do-while loop to repeat if input is numeric value other then menu options.
		do 
		{
			Scanner sc = new Scanner(System.in);
			menuFlag = false;
			
			//Try-catch to handle exceptions
			try 
			{
				//User input option
				System.out.println("*****************************************************");
				System.out.println("Enter you choice: ");
				mMenuvalue = Integer.parseInt(sc.nextLine());
				
				//Switch case to enter into logic of menu options
				switch(mMenuvalue) 
				{
					case 1:
						System.out.println("Files retriev from the folder path: \n"+ LockedMeOperations.FILE_HANDLING_DIRECTORY + " are:");
						getFiles();
						break;
					case 2:
						System.out.println("Entered into file options");
						fileOperations();
						break;
					case 3:
						System.out.println("Exit the application");
						break;
					default:
						System.out.println("invalid option, Try again!");
						menuFlag = true;
				}
			}
			catch(Exception ex) {
				System.out.println("Error: Enter a numeric value from the given Menu!");
				sc.close();
			}
				
		}while(menuFlag);
	}
	
	public static void getFiles() 
	{
		//Retrieving the file names in an ascending order
		List<String> filesInDirectory = LockedMeOperations.retrieveFileNames();
		for(String file : filesInDirectory)
			System.out.println("- "+ file);
	}
	
	public static void fileOperations() 
	{
		//File Options Menu
		System.out.println("*****************************************************");
		System.out.println("\t\tFile Opertions Menu");
		System.out.println("*****************************************************");
		System.out.println("1. Add a user specified file to the application");
		System.out.println("2. Delete a user specified file from the application");
		System.out.println("3. Search a user specified file from the application");
		System.out.println("4. Go to Main Menu");
		System.out.println("5. Close the application");
		
		boolean fMenuFlag;
		int userInputOption;
		Scanner sc = new Scanner(System.in);
		do
		{
			fMenuFlag = false;
			System.out.println("*****************************************************");
			System.out.println("Enter you choice: ");
			userInputOption = Integer.parseInt(sc.nextLine());			
			
			switch(userInputOption)
			{
			case 1:
				System.out.println("Add File");
				break;
			case 2:
				System.out.println("delete file");
				break;
			case 3:
				System.out.println("search file");
				break;
			case 4:
				System.out.println("main menu");
				mainMenuOptions();
				break;
			case 5:
				System.out.println("Exit application");
				break;
			default:
				System.out.println("Enter a valid input, Try again!");
				fMenuFlag = true;
			}
			
		}while(fMenuFlag);
	}
}
