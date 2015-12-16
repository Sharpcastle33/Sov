package com.gmail.sharpcastle33.sov.sovereignty;

import org.apache.commons.lang3.tuple.Pair;

import com.gmail.sharpcastle33.sov.nation.Nation;

public class Sovereignty {

//+====+
//|DATA|
//+====+
	
	Nation sovereign;
	final Pair coordinate;
	
//+============+
//|CONSTRUCTION|
//+============+
	
	public Sovereignty(Nation n, Pair coord){
		sovereign = n;
		coordinate = coord;
	}
	
//+=======+
//|METHODS|
//+=======+

	public String getChatFriendlyCoordinate(){
		String returning = "";
		
		
		int x = (int) coordinate.getLeft();
		int y = (int) coordinate.getRight();
		
		if(x < 0){
			returning += "-";
			x*=-1;
		}
		
		char char1 = (char) (x/26+64);
		char char2 = (char) (x%26+64);
		
		returning+=char1+char2+", "+y;
		return returning;
		
	}
	
//+=======+
//|GET/SET|
//+=======+
	//HI BRYAN
	public Nation getSovereign(){
		return this.sovereign;
	}
	
	public void setSovereign(Nation n){
		this.sovereign = n;
	}
	
	public Pair getCoord(){
		return this.coordinate;
	}
	
	
	
}
