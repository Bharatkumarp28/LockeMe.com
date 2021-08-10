package com.lockedMe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeMenuOptions 
{
	static Scanner sc = new Scanner(System.in);
	public static void mainMenuOptions()
	{
		//Declaring variables
		int mMenuvalue;
		boolean menuFlag;
		final char OPTIONS_LABLE = 'M';
		int gotInp;
		
		//do-while loop to repeat if input is numeric value other then menu options.
		do 
		{
			menuFlag = false;
			
			//Try-catch to handle exceptions
			try 
			{
				//Main Menu Options
				System.out.println("*****************************************************");
				System.out.println("\t\tMain Menu Options");
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
						System.out.println("Files retriev from the folder path: \n"
											+ LockedMeOperations.FILE_HANDLING_DIRECTORY + " are:");
						
						//Calling getFiles method to fetch all files in ascending order
						getFiles();
						gotInp = afterFileOperations(OPTIONS_LABLE);
						if(gotInp == 1)
							menuFlag = true;
						else if(gotInp == 2)
							mMenuvalue = 3;
						break;
					case 2:
						//Calling file operation method to entered into file options menu
						fileOperations();
						break;
					case 3:
						System.out.println("Thank you, closing the Application");
						sc.close();
						System.exit(0);
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
	
	public static void getFiles() 
	{
		//Retrieving the file names in an ascending order
		List<String> filesInDirectory = LockedMeOperations.retrieveFileNames();
		for(String file : filesInDirectory)
			System.out.println("- "+ file);
	}
	
	public static void addFile()
	{
		//
		List<String> allDataCollected = new ArrayList<String>();
		//Getting the new File name
		System.out.println("Enter the name of the File: ");
		String newFileName = sc.nextLine();
		
		
		//
		System.out.println("How many line you want to write into file: ");
		int countOfLines = Integer.parseInt(sc.nextLine());
		
		//
		for(int i = 1; i <= countOfLines; i++) 
		{
			System.out.println("Enter the text for line " + i + ":");
			String dataIntoFile = sc.nextLine() + "\n";
			allDataCollected.add(dataIntoFile);
		}
				
		//Addition of files and data
		boolean isAdded = LockedMeOperations.addFile(newFileName,countOfLines,allDataCollected);
		if(isAdded)
			System.out.println("File added successfully!");
		else
			System.out.println("File not added");
	}
	
	public static void removeFile()
	{
		//Get user specified file
		System.out.println("Enter name of the File to delete: ");
		String fileNameToBeDeleted = sc.nextLine();
				
		//Delete user specified file
		boolean isDeleted = LockedMeOperations.deleteFile(fileNameToBeDeleted);
		if(isDeleted)
			System.out.println("File is succesfully deleted!");
		else
			System.out.println("File does not exist in the path to delete!");
	}
	
	public static void searchForFile()
	{
		System.out.println("Enter name of the File to search: ");
		String fileNameToBeSearched = sc.nextLine();
		
		//Search user specified file
		boolean isFound = LockedMeOperations.searchFile(fileNameToBeSearched);
		
		if(isFound)
			System.out.println("File found in the location");
		else
			System.out.println("File not found!");
	}
	
	public static int afterFileOperations(char gotLable)
	{
		int inputOption = 0;
		boolean flag = false;
		do
		{
			if(gotLable == 'F')
				System.out.println("\nDo you want \n"
									+ "1. File Opertions Menu \n"
									+ "2. Exit Application\n"
									+ "Enter your choice: ");
			else if(gotLable == 'M')
				System.out.println("\nDo you want \n"
									+ "1. Menu Options \n"
									+ "2. Exit Application\n"
									+ "Enter your choice: ");
			try 
			{
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
		boolean fMenuFlag;
		int userInputOption;
		final char OPTIONS_LABLE = 'F';
		int gotInp;
		
		do
		{
			fMenuFlag = false;
			
			//Try-catch to handle exceptions
			try 
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
				System.out.println("*****************************************************");
				System.out.println("Enter your choice: ");
				userInputOption = Integer.parseInt(sc.nextLine());			
				
				switch(userInputOption)
				{
				case 1:
					System.out.println("Add File");
					addFile();
					gotInp = afterFileOperations(OPTIONS_LABLE);
					if(gotInp == 1)
						fMenuFlag = true;
					else if(gotInp == 2)
						userInputOption = 5;
					break;
					
				case 2:
					System.out.println("delete file");
					removeFile();
					gotInp = afterFileOperations(OPTIONS_LABLE);
					if(gotInp == 1)
						fMenuFlag = true;
					else if(gotInp == 2)
						userInputOption = 5;
					break;
					
				case 3:
					System.out.println("search file");
					searchForFile();
					gotInp = afterFileOperations(OPTIONS_LABLE);
					if(gotInp == 1)
						fMenuFlag = true;
					else if(gotInp == 2)
						userInputOption = 5;
					break;
					
				case 4:
					System.out.println("main menu");
					mainMenuOptions();
					break;
					
				case 5:
					System.out.println("Thank you, closing the Application");
					sc.close();
					System.exit(0);
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
