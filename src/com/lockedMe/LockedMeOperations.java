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
	
	public static boolean addFile() 
	{
		
		//Getting the new File name
		System.out.println("Enter the name of the File: ");
		Scanner sc = new Scanner(System.in);
		String newFileName = sc.nextLine();
		
		
		//
		System.out.println("How many line you want to write into file: ");
		int countOfLines = Integer.parseInt(sc.nextLine());
		FileWriter fileToWrite = null;
		
		try
		{
			fileToWrite = new FileWriter(FILE_HANDLING_DIRECTORY +"\\" + newFileName);
			for(int i = 1; i <= countOfLines; i++) 
			{
				System.out.println("Enter the text for line " + i + ":");
				String dataIntoFile = sc.nextLine() + "\n";
				fileToWrite.write(dataIntoFile);
			}
			
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
					sc.close();
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
		}
	}
	
	public static boolean deleteFile()
	{
		//Get user specified file
		System.out.println("Enter name of the File to delete: ");
		Scanner sc = new Scanner(System.in);
		String fileNameToBeDeleted = sc.nextLine();
		sc.close();
		
		File fileToDelete = new File(FILE_HANDLING_DIRECTORY + "\\" + fileNameToBeDeleted);
		
		//Delete user specified file
		if(fileToDelete.delete())
			return true;
		else
			return false;
		
	}
}
