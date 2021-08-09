package com.lockedMe;

import java.util.List;

public class LockedMeApplication 
{

	public static void main(String[] args) 
	{
		/*
		//Retrieving the file names in an ascending order
		List<String> filesInDirectory = LockedMeOperations.retrieveFileNames();
		for(String file : filesInDirectory)
			System.out.println(file);
		
		
		//Addition of files and data
		boolean isAdded = LockedMeOperations.addFile();
		if(isAdded)
			System.out.println("File added successfully!");
		else
			System.out.println("File not added");
		
		
		
		//Delete user specified file
		boolean isDeleted = LockedMeOperations.deleteFile();
		if(isDeleted)
			System.out.println("File is succesfully deleted!");
		else
			System.out.println("File does not exist in the path to delete!");
		*/
		//Display Main Menu options
		LockedMeMenuOptions.mainMenuOptions();
	}
	

}
