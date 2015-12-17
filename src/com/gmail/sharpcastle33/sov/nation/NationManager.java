package com.gmail.sharpcastle33.sov.nation;

import java.util.ArrayList;
import java.util.Properties;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.gmail.sharpcastle33.sov.util.FileManager;

public class NationManager {
	Properties nations;
	
	/*
	 * nationname.members, a,b,*c
	 */
	ArrayList<String> nationNames;
	ArrayList<Nation> nats;
	
	public void init(){
		nations = FileManager.nations;
	}
	
	public void loadNations(){
		String adding = "";
		String mem = nations.getProperty("nationnames");
		char[] m = mem.toCharArray();
		for(char c : m){
			String ch = ""+c;
			if(ch == ","){
				nationNames.add(adding);
				adding = "";
			}
			adding+=c;
		}
		
		for(String n : nationNames){
			nats.add(loadNation(n));
		}
	}
	
	public void saveNations(){
		String temp = "";
		for(String s : nationNames){
			temp+=s+",";
			Nation n = null;
			for(Nation na: nats){
				if(na.getName() == s){
					n=na;
				}
			}
	
			ArrayList<UUID> tempMembers = null;
		
			String membersList = "";

			for(UUID u : n.getMembers()){
				if(!(n.getLeaders().contains(u))){
					membersList+=u.toString();
				}else{
					membersList+="*"+u.toString();
				}
			}
			nations.setProperty(s+".members", membersList);
		}
		nations.setProperty("nationnames",temp);
		FileManager.save(nations,"nations.properties");
	}
	
	public boolean hasNation(Player p){
		Nation n = getNation(p);
		if(n != null){
			return true;
		}else return false;
	}
	
	public Nation getNation(Player p){
		Nation n = null;
		UUID id = p.getUniqueId();
		for(Nation nat : nats){
			if(nat.getMembers().contains(id)){
				return nat;
			}
		}
		return n;
	}
	
	public Nation getNation(String name){
		for(Nation n: nats){
			if(n.getName() == name){
				return n;
			}
		}
		return null;
	}
	
	public Nation loadNation(String name){
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
				UUID add = null;
				if(adding.startsWith("*")){
					adding.substring(1);
					leaders.add(add.fromString(adding));
				}else{
					members.add(add.fromString(adding));
				}
				adding = "";
			}
			adding+=c;

		}
		n.setMembers(members);
		n.setLeaders(leaders);
		return n;
	}
	
	public ArrayList<String> getNationNames(){
		return this.nationNames;
	}
	
	public void createNation(String name, Player p){
		nationNames.add(name);
		nats.add(new Nation(p.getUniqueId(), name));
	}
}
