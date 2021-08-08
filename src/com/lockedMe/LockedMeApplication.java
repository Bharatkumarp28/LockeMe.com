package com.lockedMe;

import java.util.List;

public class LockedMeApplication 
{

	public static void main(String[] args) 
	{
		//Retrieving the file names in an ascending order
		List<String> filesInDirectory = LockedMeOperations.retrieveFileNames();
		for(String file : filesInDirectory)
			System.out.println(file);
		
	}
	

}
