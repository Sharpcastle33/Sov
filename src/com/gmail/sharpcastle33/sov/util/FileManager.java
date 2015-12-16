package com.gmail.sharpcastle33.sov.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import com.gmail.sharpcastle33.sov.main.Main;

public class FileManager {
	
	public static Properties sov = new Properties();
	public static Properties nations = new Properties();
	public static Properties config = new Properties();

	
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
		
		try{
		config.load(new FileInputStream("config.properties"));
		}catch(FileNotFoundException e){
		System.out.println("config.properties doesn't exist!");
		}catch(Exception e1){
		e1.printStackTrace();
		}
		
	}
	
	public static void loadFiles(){
		
	}
	
	public static void saveFiles(){
		//save(nations,"nations.properties");
		//save(sov,"sov.properties");
		Main.sovman.saveSov();
		Main.natman.saveNations();
	}
	
	public String read(Properties p, String key){
		String s = p.getProperty(key);
		return s;
	}
	
	public void write(Properties p, String key, String s){
		p.setProperty(key,s);
	}
	
	public static void save(Properties p, String s){
		try{
			p.store(new FileOutputStream(s), null);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
