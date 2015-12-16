package com.gmail.sharpcastle33.sov.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.sharpcastle33.sov.nation.NationManager;
import com.gmail.sharpcastle33.sov.sovereignty.SovereigntyManager;
import com.gmail.sharpcastle33.sov.util.FileManager;

public class Main extends JavaPlugin{

	public static SovereigntyManager sovman = new SovereigntyManager();
	public static NationManager natman = new NationManager();
	
	@Override
	public void onEnable(){
		FileManager.checkFiles();
		FileManager.loadFiles();
		sovman.init();
		natman.init();
		
	}
	@Override
	public void onDisable(){
		FileManager.saveFiles();
	}
}
