package com.lockedMe;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LockedMeOperations 
{
	private static final String FILE_HANDLING_DIRECTORY = "D:\\BharatSimpliLearn\\Phase1Assessment\\LockedMeFiles";
	private static File locFiles = new File(FILE_HANDLING_DIRECTORY);
	
	public static List<String> retrieveFileNames()
	{
		//Initializing List and File
		List<String> fileNames = new ArrayList<String>();
		//File locFiles = new File(FILE_HANDLING_DIRECTORY);
		
		//Fetch filename and add to List
		for(String file :locFiles.list())
			fileNames.add(file);
		
		return fileNames;
	}
	
}
