package com.gmail.sharpcastle33.sov.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.sharpcastle33.sov.util.FileManager;

public class Main extends JavaPlugin{

	@Override
	public void onEnable(){
		FileManager.checkFiles();
		FileManager.loadFiles();
	}
	@Override
	public void onDisable(){
		FileManager.saveFiles();
	}
}
