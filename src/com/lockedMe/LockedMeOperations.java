package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeOperations 
{
	//
	static final String FILE_HANDLING_DIRECTORY = "D:\\BharatSimpliLearn\\Phase1Assessment\\Source Code\\LockedMe\\src\\root";
	static Scanner sc = new Scanner(System.in);
	
	public static List<String> retrieveFileNames()
	{
		//Initializing List and File
		List<String> fileNames = new ArrayList<String>();
		File locFiles = new File(FILE_HANDLING_DIRECTORY);
		
		//Fetch filename and add to List
		for(String file :locFiles.list())
			fileNames.add(file);
		
		return fileNames;
	}
	
	public static boolean addFile(String newFileName, int countOfLines, List<String> dataIntoFile) 
	{
		
		FileWriter fileToWrite = null;
		
		try
		{
			fileToWrite = new FileWriter(FILE_HANDLING_DIRECTORY +"\\" + newFileName);
			
			for(String dataParts: dataIntoFile)
				fileToWrite.write(dataParts);
			
			return true;
			
		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally {
				try 
				{
					if(fileToWrite != null)
						fileToWrite.close();
					//sc.close();
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
	}
	
	public static boolean deleteFile(String fileNameToBeDeleted)
	{
		File fileToDelete = new File(FILE_HANDLING_DIRECTORY + "\\" + fileNameToBeDeleted);
		
		//Delete user specified file
		if(fileToDelete.delete())
			return true;
		else
			return false;
		
	}
	
	public static boolean searchFile(String fileNameToBeSearched)
	{		
		File locFiles = new File(FILE_HANDLING_DIRECTORY + "\\" + fileNameToBeSearched);
		
		if(locFiles.exists())
			return true;
		else
			return false;
	}
}
