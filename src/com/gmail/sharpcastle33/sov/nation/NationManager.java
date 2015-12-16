package com.gmail.sharpcastle33.sov.nation;

import java.util.Properties;

import com.gmail.sharpcastle33.sov.util.FileManager;

public class NationManager {
	Properties nations;
	public void init(){
		nations = FileManager.nations;
	}
	
	public void loadNations(){
		
	}
	
	public void saveNations(){
		FileManager.save(nations,"nations.properties");
	}
	
	public Nation getNation(String name){
		return null;
	}
}
