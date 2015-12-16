package com.gmail.sharpcastle33.sov.sovereignty;

import com.gmail.sharpcastle33.sov.util.Pair;

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
		
		
		int x = (int) coordinate.getL();
		int y = (int) coordinate.getR();
		
		if(x < 0){
			returning += "-";
			x*=-1;
		}
		
		char char1 = (char) (int) ((x/26)+65);
		char char2 = (char) (int) ((x%26)+65);
		
		returning+=char1+char2+", "+y;
		return returning;
		
	}
	
//+=======+
//|GET/SET|
//+=======+

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
