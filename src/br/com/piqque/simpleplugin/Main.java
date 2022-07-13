package br.com.piqque.simpleplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * @author Piqque
 */

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable()
	{
		Bukkit.getConsoleSender().sendMessage("§eLigando o servidor.");
		MainManager.registerListener();
	}
	
	@Override
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage("§cDesligando o servidor.");
	}

}
