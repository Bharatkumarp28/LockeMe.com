package com.lockedMe;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//2. Class which returns all the file operations
public class LockedMeOperations 
{
	//Class variables
	//Get the current directory path
	static Path dirFullPath = Paths.get("");
	
	//path to create a root directory
	static final String FILE_HANDLING_DIRECTORY = (dirFullPath.toAbsolutePath().toString()
													+ "\\root");
	
	//Scanner
	static Scanner sc = new Scanner(System.in);
	
	/**
	 * method to create directory
	 */
	public static void makeDirectory()
	{
		//Initializing file object
		File createDirectory = new File(FILE_HANDLING_DIRECTORY);
		
		//Exceptional handling
		try
		{
			//Make directory logic
			if(!createDirectory.exists()) 
			{
				createDirectory.mkdir();
				System.out.println("Created root folder for Application Operations at: \n"
				+ "***" + FILE_HANDLING_DIRECTORY+ "***\n");
			}	
		}
		catch(Exception ex)
		{
			System.out.println("\t***Error: An unexpected error occured*** "
								+ "\nPlease contact Admin@CompanyLockers.in");
		}
	}
	
	/**
	 * method return list of files in the directory
	 * @return List<String>
	 */
	public static List<String> retrieveFileNames()
	{
		//Initializing List to store filenames
		List<String> fileNames = new ArrayList<String>();
		
		//Initializing file with directory path
		File locFiles = new File(FILE_HANDLING_DIRECTORY);
		
		//Fetch filename and add to List
		for(String file :locFiles.list())
			fileNames.add(file);
		
		return fileNames;
	}
	

	/**
	 * method to return files are added into the directory or not
	 * @param newFileName
	 * @param countOfLines
	 * @param dataIntoFile
	 * @return true(if added)
	 */
	public static boolean addFile(String newFileName, int countOfLines, 
								  List<String> dataIntoFile) 
	{
		//Declaring FileWriter
		FileWriter fileToWrite = null;
		
		//Exceptional handling
		try
		{			
			//Initialize location to add file
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
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
	}
	

	/**
	 * method to return if file is deleted from the directory or not
	 * @param fileNameToBeDeleted
	 * @return true(if deleted)
	 */
	public static boolean deleteFile(String fileNameToBeDeleted)
	{
		//Initialize location to delete file
		File fileToDelete = new File(FILE_HANDLING_DIRECTORY 
				                     + "\\" + fileNameToBeDeleted);
		
		//Delete user specified file
		if(fileToDelete.delete())
			return true;
		else
			return false;
		
	}
	

	/**
	 * method return file found in a directory or not
	 * @param fileNameToBeSearched
	 * @return true(if file found)
	 */
	public static boolean searchFile(String fileNameToBeSearched)
	{		
		//Initialize location to search file
		File locFiles = new File(FILE_HANDLING_DIRECTORY + "\\" + fileNameToBeSearched);
		
		//check if file exist in the location or not
		if(locFiles.exists())
			return true;
		else
			return false;
	}
}
