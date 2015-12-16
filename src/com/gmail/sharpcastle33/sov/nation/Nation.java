package com.gmail.sharpcastle33.sov.nation;

import java.util.ArrayList;
import java.util.UUID;

import com.gmail.sharpcastle33.sov.sovereignty.Sovereignty;

public class Nation {

//+====+
//|DATA|
//+====+

ArrayList<UUID> members;
ArrayList<UUID> leaders;
ArrayList<Sovereignty> sov;
String name;
		
//+============+
//|CONSTRUCTION|
//+============+

public Nation(){
	
}
		
//+=======+
//|METHODS|
//+=======+

//+=======+
//|GET/SET|
//+=======+

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
