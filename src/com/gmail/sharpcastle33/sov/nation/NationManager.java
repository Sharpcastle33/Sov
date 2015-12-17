package com.gmail.sharpcastle33.sov.nation;

import java.util.ArrayList;
import java.util.Properties;
import java.util.UUID;

import com.gmail.sharpcastle33.sov.util.FileManager;

public class NationManager {
	Properties nations;
	ArrayList<String> nationNames;
	
	public void init(){
		nations = FileManager.nations;
	}
	
	public void loadNations(){
		
	}
	
	public void saveNations(){
		FileManager.save(nations,"nations.properties");
	}
	
	public Nation getNation(String name){
		Nation n = null;
		
		if(nations.getProperty(name+".members") == "" ||  nations.getProperty(name+".members") == null){
			return null;
		}
		ArrayList<UUID> members = new ArrayList<UUID>();
		ArrayList<UUID> leaders = new ArrayList<UUID>();
		
		String adding = "";
		String mem = nations.getProperty(name+".members");
		char[] m = mem.toCharArray();
		for(char c : m){
			String ch = ""+c;
			if(ch == ","){
				if(adding.startsWith("*")){
					adding.substring(1);
					leaders.add(new UUID(adding));
				}else{
					members.add(new UUID(adding));
				}
				adding = "";
			}
			adding+=c;

		}
		n.setMembers(members);
		n.setLeaders(leaders);
		return n;
	}
}
