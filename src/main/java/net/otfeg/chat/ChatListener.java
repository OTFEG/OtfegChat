package net.otfeg.chat;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{
	private ChatManager chatMananger;

	public ChatListener() {
		
	}

	public ChatListener(ChatManager chatManager) {
		this.chatMananger = chatManager;
	}
	
	@EventHandler
	void chat(AsyncPlayerChatEvent event){
		String message = event.getMessage();
		Player player = event.getPlayer();
		String[] groups = chatMananger.getChat().getPlayerGroups(player);
		String prefix = chatMananger.getChat().getPlayerPrefix(player);
		String suffix = chatMananger.getChat().getPlayerSuffix(player);
		event.setFormat(prefix+message+suffix);
	}
}
