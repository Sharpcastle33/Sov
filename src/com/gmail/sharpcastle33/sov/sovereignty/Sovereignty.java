package com.gmail.sharpcastle33.sov.sovereignty;

import org.apache.commons.lang3.tuple.Pair;

import com.gmail.sharpcastle33.sov.nation.Nation;

public class Sovereignty {

//+====+
//|DATA|
//+====+
	
	Nation sovereign;
	Pair coordinate;
	
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
		
	}
	
}
