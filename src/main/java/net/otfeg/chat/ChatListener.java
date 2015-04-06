package net.otfeg.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.ChatColor;

public class ChatListener implements Listener{

	private final ChatManager chatManager;

	public ChatListener(ChatManager chatManager) {
		this.chatManager = chatManager;
		chatManager.getServer().getPluginManager().registerEvents(this, chatManager);
	}
	
	@EventHandler
	void chat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		String format = chatManager.getConfig().getString("global.chatformat");
		format = format.replace("{WORLD}", player.getWorld().getName());
		format = format.replace("{DISPLAYNAME}", player.getName());
		format = format.replace("{GROUP}", chatManager.getChat().getPrimaryGroup((player)));
		format = format.replace("{SUFFIX}", chatManager.getChat().getPlayerSuffix(player));
		format = format.replace("{PREFIX}", chatManager.getChat().getPlayerPrefix(player));
		format = format.replace("{GROUPPREFIX}", getGroupsPrefixes(player));
		format = format.replace("{GROUPSUFFIX}", getGroupsSuffixes(player));
		if (event.getPlayer().hasPermission("chat.colours"))
			event.setMessage(ChatColor.translateAlternateColorCodes('&', event.getMessage()));
		format = format.replace("{MESSAGE}", event.getMessage());
		event.setFormat(ChatColor.translateAlternateColorCodes('&', format));
		
	}
	String getGroupsSuffixes(Player player){
		String[] groups = chatManager.getChat().getGroups();
		String suffixes = "";
		for (String group:groups) {
			suffixes += chatManager.getChat().getGroupSuffix(player.getWorld(), group);
			
		}
		return suffixes;
	}
	
	String getGroupsPrefixes(Player player){
		String[] groups = chatManager.getChat().getGroups();
		String prefixes = "";
		for (String group:groups) {
			prefixes += chatManager.getChat().getGroupPrefix(player.getWorld(), group);
		}
		return prefixes;
	}
}
