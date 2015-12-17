package com.gmail.sharpcastle33.sov.main;

import java.util.ArrayList;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.gmail.sharpcastle33.sov.nation.Nation;
import com.gmail.sharpcastle33.sov.nation.NationManager;
import com.gmail.sharpcastle33.sov.sovereignty.SovereigntyManager;
import com.gmail.sharpcastle33.sov.util.FileManager;

public class Main extends JavaPlugin{

	public static SovereigntyManager sovman = new SovereigntyManager();
	public static NationManager natman = new NationManager();
	
	public static ArrayList<String> bannedNames;
	
	String h = ChatColor.RED + " [Sov] ";
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
		if(sender instanceof Player){
			Player p = (Player)sender;
			if (cmd.getName().equalsIgnoreCase("sov")) {
				if(args.length == 0){
				
				}
				if(args.length == 1){
					if(args[0] == "help" || args[0] == "?"){
						p.sendMessage(h + "There isn't a help menu yet. Sorry!");
					}
					if(args[0] == "ver" || args[0] == "version" || args[0] == "v"){
						p.sendMessage(h + "Sovereignty version 0.0.1 | Made by Sharpcastle33 (/u/sharpcastle33)");
					}
				}
				
			}  
			
			if(cmd.getName().equalsIgnoreCase("nation")){
				if(args.length == 0){
					if(natman.hasNation(p)){
						Nation n = natman.getNation(p);
						p.sendMessage(h + "You are part of the nation called '" + n.getName() + "'");
					}
				}
				if(args.length == 1){
					if(args[0] == "members"){
						if(natman.hasNation(p));
						Nation n = natman.getNation(p);
						p.sendMessage(h + n.getMembersChatFriendly());
					}
					if(args[0] == "help" || args[0] == "?"){
						p.sendMessage(h + "There isn't a help menu yet. Sorry!");
					}
				}
				if(args.length == 2){
					if(args[0] == "create" || args[0] == "found"){
						if(!(natman.hasNation(p))){
							if(!(natman.getNationNames().contains(args[1]))){
								if(!(bannedNames.contains(args[1]))){
									natman.createNation(args[1],p);
								}else p.sendMessage(h + "Please choose a different name.");
							}else p.sendMessage(h + "Sorry, that nation already exists!");
						}else p.sendMessage(h + "You must leave your current nation before you can found one!");
					}
				}
			}
		}
		return false; 
	}
}
