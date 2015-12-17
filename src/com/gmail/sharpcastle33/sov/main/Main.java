package com.gmail.sharpcastle33.sov.main;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.sharpcastle33.sov.nation.NationManager;
import com.gmail.sharpcastle33.sov.sovereignty.SovereigntyManager;
import com.gmail.sharpcastle33.sov.util.FileManager;

public class Main extends JavaPlugin{

	public static SovereigntyManager sovman = new SovereigntyManager();
	public static NationManager natman = new NationManager();
	
	String h = " [Sov] ";
	@Override
	public void onEnable(){
		getLogger().info(h+"Loading Sovereignty...");
		getLogger().info(h+"Initiating FileManager!");
		FileManager.checkFiles();
		getLogger().info(h+"FileManager initiated! Loading files.");
		FileManager.loadFiles();
		getLogger().info(h+"Files loaded. Initiating SovereigntyManager and NationManager.");
		sovman.init();
		getLogger().info("[SovMan]: 'Hey NatMan, who's the most irrelevant nation?'");
		natman.init();
		getLogger().info("[NatMan]: 'Hmm... I think... erhm... yes of course! That would be the ancient city-state of Arcestir!' Quite a pompous bunch they are.");
		getLogger().info(h+"Loading Complete.");
	}
	@Override
	public void onDisable(){
		getLogger().info(h+"+============+" + "\n" + h +
				           "|SAVING FILES|" + "\n" + h +
				           "+============+");
		FileManager.saveFiles();
		getLogger().info(h + "Files successfully saved.");
		Bukkit.getServer().broadcastMessage(h+"Sovereignty files successfully saved. Batten down the hatches, folks.");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("basic")) { // If the player typed /basic then do the following...
			// doSomething
			return true;
		} //If this has happened the function will return true. 
	        // If this hasn't happened the value of false will be returned.
		return false; 
	}
}
