package com.gmail.sharpcastle33.sov.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

public class FileManager {
	
	static Properties sov = new Properties();
	static Properties nations = new Properties();
	
	public static void checkFiles(){
		
		try{
		sov.load(new FileInputStream("sov.properties"));
		}catch(FileNotFoundException e){
		System.out.println("sov.properties doesn't exist!");
		}catch(Exception e1){
		e1.printStackTrace();
		}
		
		try{
		nations.load(new FileInputStream("nations.properties"));
		}catch(FileNotFoundException e){
		System.out.println("nations.properties doesn't exist!");
		}catch(Exception e1){
		e1.printStackTrace();
		}
		
	}
	
	public static void loadFiles(){
		
	}
	
	public static void saveFiles(){
		
	}

}
