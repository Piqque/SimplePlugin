package br.com.piqque.simpleplugin.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * @author Piqque
 */

public class MainListeners implements Listener {
	
	@EventHandler
	public void asyncPlayerPreLoginEvent(AsyncPlayerPreLoginEvent asyncPlayerPreLoginEvent) throws InterruptedException
	{
		Bukkit.getConsoleSender().sendMessage("§8[§a+1§8] §e" + asyncPlayerPreLoginEvent.getEventName());
		wait(250);
	}
	
	@EventHandler
	public void playerJoinEvent(PlayerJoinEvent playerJoinEvent)
	{
		playerJoinEvent.setJoinMessage(null);
		
		Player player = playerJoinEvent.getPlayer();
		player.sendMessage("§eVerificando sua conexão com o servidor.");
		
		for (Player players : Bukkit.getOnlinePlayers())
		{
			if (player.isOp() == true) 
			{
				players.sendMessage("§8[§a+1§8] §e" + playerJoinEvent.getEventName());
			}
		}
	}
	
	@EventHandler
	public void asyncPlayerChatEvent(AsyncPlayerChatEvent asyncPlayerChatEvent)
	{
		Player player = asyncPlayerChatEvent.getPlayer();
		
		if (player.isOp() == true)
		{
			asyncPlayerChatEvent.setFormat("§c" + player.getName() + " §6-> §f" + asyncPlayerChatEvent.getMessage());
		} else {
			asyncPlayerChatEvent.setFormat("§7" + player.getName() + "§6-> §7" + asyncPlayerChatEvent.getMessage());
		}
	}
	
	@EventHandler
	public void playerQuitEvent(PlayerQuitEvent playerQuitEvent)
	{
		playerQuitEvent.setQuitMessage(null);
		
		Bukkit.getConsoleSender().sendMessage("§8[§c-1§8] §e" + playerQuitEvent.getEventName());
		
		Player player = playerQuitEvent.getPlayer();
		for (Player players : Bukkit.getOnlinePlayers())
		{
			if (player.isOp() == true) 
			{
				players.sendMessage("§8[§c-1§8] §e" + playerQuitEvent.getEventName());
			}
		}
	}
}