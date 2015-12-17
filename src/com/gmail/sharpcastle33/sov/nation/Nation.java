package com.gmail.sharpcastle33.sov.nation;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

import com.gmail.sharpcastle33.sov.sovereignty.Sovereignty;

public class Nation {

//+====+
//|DATA|
//+====+

ArrayList<UUID> members;
ArrayList<UUID> leaders;
String name;
		
//+============+
//|CONSTRUCTION|
//+============+

public Nation(UUID u, String name){
	this.name = name;
	members.add(u);
}

public Nation(String name, ArrayList<UUID>members, ArrayList<UUID>leaders){
	this.name = name;
	this.members = members;
	this.leaders = leaders;
}
		
//+=======+
//|METHODS|
//+=======+

	public String getMembersChatFriendly(){
		String returning = "";
		for(UUID u : members){
			if(leaders.contains(u)){
				returning+=ChatColor.GOLD;
			}
			returning += Bukkit.getServer().getPlayer(u).getDisplayName();
			returning+=", ";
			if(leaders.contains(u)){
				returning+=ChatColor.WHITE;
			}
		}
		return returning;
	}

//+=======+
//|GET/SET|
//+=======+
	
	public String getName(){
		return this.name;
	}
	
	public ArrayList<UUID> getMembers(){
		return this.members;
	}
	
	public ArrayList<UUID> getLeaders(){
		return this.leaders;
	}
	
	public void setMembers(ArrayList<UUID> l){
		this.members = l;
	}
	
	public void addMember(UUID u){
		this.members.add(u);
	}
	
	public void addLeader(UUID u){
		this.leaders.add(u);
	}
	
	public void removeMember(UUID u){
		if(this.members.contains(u)){
			this.members.remove(u);
		}
	}
	
	public void removeLeader(UUID u){
		if(this.leaders.contains(u)){
			this.leaders.remove(u);
		}
	}
	
	public void setLeaders(ArrayList<UUID> l){
		this.leaders = l;
	}


}
