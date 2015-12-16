package com.gmail.sharpcastle33.sov.sovereignty;

import java.util.ArrayList;
import java.util.Properties;

import com.gmail.sharpcastle33.sov.util.Pair;
import org.bukkit.Location;

import com.gmail.sharpcastle33.sov.main.Main;
import com.gmail.sharpcastle33.sov.util.FileManager;
import com.gmail.sharpcastle33.sov.util.References;

public class SovereigntyManager {
	
	static Properties sov; 
	
	/*
	 * 1,1 - nation 
	 */
	
	ArrayList<Sovereignty>sovList;
	
	public void init(){
		sov = FileManager.sov;
		loadSov();
	}
	
	public void loadSov(){
		for(int i = (References.MAX_SOV/2)*-1; i < References.MAX_SOV/2; i++){
			for(int j = (References.MAX_SOV/2)*-1; j < References.MAX_SOV/2; j++){
				String name = i+","+j;
				Sovereignty s = new Sovereignty(Main.natman.getNation(sov.getProperty(name)), new Pair(i,j));
				sovList.add(s);
			}
		}
		
		if(sovList.size() == 0){
			for(int i = (References.MAX_SOV/2)*-1; i < References.MAX_SOV/2; i++){
				for(int j = (References.MAX_SOV/2)*-1; j < References.MAX_SOV/2; j++){
					String name = i+","+j;
					Sovereignty s = new Sovereignty(null, new Pair(i,j));
					sovList.add(s);
				}
			}
		}
	}
	
	public void saveSov(){
		FileManager.save(sov,"sov.properties");
	}
	
	public Sovereignty getSov(Location loc){
		return null; //TODO fix this
	}
	
	public Sovereignty getSov(Pair p){
		return null;
	}
	
	public Sovereignty getSov(int x, int y){
		return null;
	}

}
