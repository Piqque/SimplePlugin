package br.com.piqque.simpleplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import br.com.piqque.simpleplugin.listeners.MainListeners;

/**
 * @author Piqque
 */

public class MainManager {
	
	public static Plugin instance;
	public static Plugin getInstance()
	{
		return instance;
	}
	
	public static void registerListener() 
	{
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new MainListeners(), getInstance());
	}
}
