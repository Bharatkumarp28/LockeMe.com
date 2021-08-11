package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LockedMeOperations 
{
	//Get the current directory path
	static Path dirFullPath = Paths.get("");
	
	//path to create a folder
	static final String FILE_HANDLING_DIRECTORY = (dirFullPath.toAbsolutePath().toString()
													+ "\\root");
	
	//Scanner
	static Scanner sc = new Scanner(System.in);
	
	public static void makeDirectory()
	{
		File createDirectory = new File(FILE_HANDLING_DIRECTORY);
		try
		{
			if(!createDirectory.exists()) 
			{
				createDirectory.mkdir();
				System.out.println("Created root folder for Application Operations at: \n"
				+ "***" + FILE_HANDLING_DIRECTORY+ "***");
			}	
		}
		catch(Exception ex)
		{
			System.out.println("\t***Error: An unexpected error occured*** "
								+ "\nPlease contact Admin@CompanyLockers.in");
		}
	}
	
	public static List<String> retrieveFileNames()
	{
		//Initializing List and File
		List<String> fileNames = new ArrayList<String>();
		
		//Create a root directory if not exist
		makeDirectory();
		
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
			//Create a root directory if not exist
			makeDirectory();
			
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
		//Create a root directory if not exist
		makeDirectory();
		
		File fileToDelete = new File(FILE_HANDLING_DIRECTORY + "\\" + fileNameToBeDeleted);
		
		//Delete user specified file
		if(fileToDelete.delete())
			return true;
		else
			return false;
		
	}
	
	public static boolean searchFile(String fileNameToBeSearched)
	{		
		//Create a root directory if not exist
		makeDirectory();
				
		File locFiles = new File(FILE_HANDLING_DIRECTORY + "\\" + fileNameToBeSearched);
		
		if(locFiles.exists())
			return true;
		else
			return false;
	}
}
