package net.otfeg.chat;

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
		String message = event.getMessage();
		Player player = event.getPlayer();
		String[] groups = chatManager.getChat().getPlayerGroups(player);
		String prefix = chatManager.getChat().getPlayerPrefix(player);
		String suffix = chatManager.getChat().getPlayerSuffix(player);
		event.setFormat(prefix+message+suffix);
	}
}
