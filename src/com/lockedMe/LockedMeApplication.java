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
		*/
		
		//Addition of files and data
		boolean isAdded = LockedMeOperations.addFiles();
		if(isAdded)
			System.out.println("File added succesfully!");
		else
			System.out.println("File not added");

		
	}
	

}
