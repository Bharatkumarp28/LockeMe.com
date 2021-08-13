package com.lockedMe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//3. Class which display menu options for user to work on.
public class LockedMeMenuOptions 
{
	//Scanner
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * Display main menu Options
	 */
	public static void mainMenuOptions()
	{
		//Declaring variables
		int mMenuvalue;
		boolean menuFlag;
		int gotInp;
		
		//Initializing flag for Menu options
		final char OPTIONS_LABLE = 'M';
		
		//do-while loop to repeat if input is numeric value other then menu options.
		do 
		{
			menuFlag = false;
			
			//Try-catch to handle exceptions
			try 
			{
				//Main Menu Options
				System.out.println("\n   @Main Menu Options");
				System.out.println("*****************************************************");
				System.out.println("1. Retrieving the file names");
				System.out.println("2. Display options for file operations");
				System.out.println("3. Close the application");
				
				//User input option
				System.out.println("*****************************************************");
				System.out.println("Enter your choice: ");
				mMenuvalue = Integer.parseInt(sc.nextLine());
				
				//Switch case to enter into logic of menu options
				switch(mMenuvalue) 
				{
					case 1:
						System.out.println("Files retrieve from the folder path: \n"
											+ LockedMeOperations.FILE_HANDLING_DIRECTORY + " are:");
						
						//Calling getFiles method to fetch all files.
						getFiles();
						
						//Calling method to display option after file actions
						gotInp = afterFileOperations(OPTIONS_LABLE);
						
						//Menu to exit or return to main menu
						if(gotInp == 1)
							menuFlag = true;
						else if(gotInp == 2)
							exitApp();
						break;
					case 2:
						//Calling file operation method to entered into file options menu
						fileOperations();
						break;
					case 3:
						//Close the application
						exitApp();
						break;
					default:
						System.out.println("invalid option, Try again!");
						menuFlag = true;
				}
			}
			catch(NumberFormatException nfex)
			{
				System.out.println("\t***Error: You must enter a numeric value***\n"
						+ "\t\t***Please try again***\n");
				menuFlag = true;
			}
			catch(Exception ex) 
			{
				System.out.println("\t***Error: An unexpected error occured*** \nPlease contact Admin@CompanyLockers.in");
			}
				
		}while(menuFlag);
	}
	
	/**
	 * method to close the application
	 */
	public static void exitApp()
	{
		//Display output to user
		System.out.println("Thank you, closing the Application");
		sc.close();
		System.exit(0);
	}
	
	/**
	 * method to display all files in the directory
	 */
	public static void getFiles() 
	{
		//Get file names in a list
		List<String> filesInDirectory = LockedMeOperations.retrieveFileNames();
		
		//logic to retrieve files and display Null if no files
		if(filesInDirectory.size() == 0)
			System.out.println("No files in the folder!");
		
		//Display output to user
		for(String file : filesInDirectory)
			System.out.println("- "+ file);
	}
	
	/**
	 * method to add file into the directory
	 */
	public static void addFile()
	{
		//List to collect data enter by user in String
		List<String> allDataCollected = new ArrayList<String>();
		
		//Getting the new File name from user
		System.out.println("Enter the name of the File: ");
		String newFileName = sc.nextLine();
		
		
		//Getting input from user to know how many lines of data to enter
		System.out.println("How many line you want to write into file: ");
		int countOfLines = Integer.parseInt(sc.nextLine());
		
		//logic to take data from users and push into list
		for(int i = 1; i <= countOfLines; i++) 
		{
			System.out.println("Enter the text for line " + i + ":");
			String dataIntoFile = sc.nextLine() + "\n";
			allDataCollected.add(dataIntoFile);
		}
				
		//Add data to file using the above List
		boolean isAdded = LockedMeOperations.addFile(newFileName,countOfLines,allDataCollected);
		
		//Display output to user
		if(isAdded)
			System.out.println("File added successfully!");
		else
			System.out.println("File not added");
	}
	
	/**
	 * method to show if file is removed from the directory
	 */
	public static void removeFile()
	{
		//Get user specified file
		System.out.println("Enter name of the File to delete: ");
		String fileNameToBeDeleted = sc.nextLine();
				
		//Delete user specified file
		boolean isDeleted = LockedMeOperations.deleteFile(fileNameToBeDeleted);
		
		//Display output to user
		if(isDeleted)
			System.out.println("File is succesfully deleted!");
		else
			System.out.println("File does not exist in the path to delete!");
	}
	
	/**
	 * method to display searched file found in the directory
	 */
	public static void searchForFile()
	{
		//Get user specified file to search
		System.out.println("Enter name of the File to search: ");
		String fileNameToBeSearched = sc.nextLine();
		
		//Search user specified file
		boolean isFound = LockedMeOperations.searchFile(fileNameToBeSearched);
		
		//Display output to user
		if(isFound)
			System.out.println("File found in the location");
		else
			System.out.println("File not found!");
	}
	
	/**
	 * User input after performing file actions
	 * @param gotLable
	 * @return Option enter by user
	 */
	public static int afterFileOperations(char gotLable)
	{
		//Declaring variables
		int inputOption = 0;
		boolean flag;
		
		//do-while loop to repeat options for user.
		do
		{
			flag = false;
			
			//Try-catch to handle exceptions
			try
			{
				//Option for user after file/menu operations
				if(gotLable == 'F')
					System.out.println("\nDo you want \n"
										+ "1. File Operations Menu \n"
										+ "2. Exit Application\n"
										+ "Enter your choice: ");
				else if(gotLable == 'M')
					System.out.println("\nDo you want \n"
										+ "1. Menu Options \n"
										+ "2. Exit Application\n"
										+ "Enter your choice: ");
			    //Input from user
				inputOption = Integer.parseInt(sc.nextLine());
			}
			catch(NumberFormatException nfex)
			{
				System.out.println("\t***Error: You must enter a numeric value***\n"
						+ "\t\t***Please try again***\n");
				flag = true;
			}
			catch(Exception ex)
			{
				System.out.println("\tError: Please contact Admin@CompanyLockers.in");
			}
		}while(flag);
		
		return inputOption;
		
	}
	public static void fileOperations() 
	{
		//Declaring variables
		boolean fMenuFlag;
		int userInputOption;
		int gotInp;
		
		//Initializing flag for file operations menu
		final char OPTIONS_LABLE = 'F';
		
		//do-while loop to repeat if input is numeric value other then menu options.
		do
		{
			fMenuFlag = false;
			
			//Try-catch to handle exceptions
			try 
			{
				//File Options Menu
				System.out.println("\n   @File Opertions Menu");
				System.out.println("*****************************************************");
				System.out.println("1. Add a user specified file to the application");
				System.out.println("2. Delete a user specified file from the application");
				System.out.println("3. Search a user specified file from the application");
				System.out.println("4. Go to Main Menu");
				System.out.println("5. Close the application");
				System.out.println("*****************************************************");
				System.out.println("Enter your choice: ");
				
				//Input from user
				userInputOption = Integer.parseInt(sc.nextLine());			
				
				//Switch case to go to the user given input operation
				switch(userInputOption)
				{
				case 1:
					//Option to Add File for user
					addFile();
					
					//Calling method to display option after file actions
					gotInp = afterFileOperations(OPTIONS_LABLE);
					
					//Menu to exit or return to file operation menu
					if(gotInp == 1)
						fMenuFlag = true;
					else if(gotInp == 2)
						exitApp();
					break;
					
				case 2:
					//Option to delete file
					removeFile();
					
					//Calling method to display option after file actions
					gotInp = afterFileOperations(OPTIONS_LABLE);
					
					//Menu to exit or return to file operation menu
					if(gotInp == 1)
						fMenuFlag = true;
					else if(gotInp == 2)
						exitApp();
					break;
					
				case 3:
					//Option to search file
					searchForFile();
					
					//Calling method to display option after file actions
					gotInp = afterFileOperations(OPTIONS_LABLE);
					
					//Menu to exit or return to file operation menu
					if(gotInp == 1)
						fMenuFlag = true;
					else if(gotInp == 2)
						exitApp();
					break;
					
				case 4:
					//Display option to user
					System.out.println("main menu");
					
					//Go back to main menu
					mainMenuOptions();
					break;
					
				case 5:
					//Close the Application
					exitApp();
					break;
					
				default:
					System.out.println("Enter a valid input, Try again!");
					fMenuFlag = true;
				}
			}
			catch(NumberFormatException nfex)
			{
				System.out.println("\t***Error: You must enter a numeric value***\n"
						+ "\t\t***Please try again***\n");
				fMenuFlag = true;
			}
			catch(Exception ex) 
			{
				System.out.println("\tError: Please contact Admin@CompanyLockers.in");
			}
			
		}while(fMenuFlag);
	}
}
