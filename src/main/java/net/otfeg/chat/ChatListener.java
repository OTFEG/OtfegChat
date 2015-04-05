package net.otfeg.chat;

import java.util.Arrays;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{

	private final ChatManager chatManager;

	public ChatListener(ChatManager chatManager) {
		this.chatManager = chatManager;
	}
	
	@EventHandler
	void chat(AsyncPlayerChatEvent event){
		Player player = event.getPlayer();
		String format = chatManager.getConfig().getString("global.chatformat");
		format.replace("{WORLD}", player.getWorld().getName());
		format.replace("{DISPLAYNAME}", player.getName());
		format.replace("{MESSAGE}", event.getEventName());
		format.replace("{GROUP}", Arrays.toString(chatManager.getChat().getPlayerGroups(player)));
		format.replace("{SUFFIX}", chatManager.getChat().getPlayerSuffix(player));
		format.replace("{PREFIX}", chatManager.getChat().getPlayerPrefix(player));
		if (event.getPlayer().hasPermission("chat.colours"))
			format.replace("{MESSAGE}", 
ChatColor.translateAlternateColorCodes('&', event.getMessage()));
		event.setFormat(format);
	}
}
