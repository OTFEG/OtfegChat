package net.otfeg.chat;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener{
	private Chat chat;

	public ChatListener() {
		
	}

	public ChatListener(Chat chat) {
		this.chat = chat;
	}
	
	@EventHandler
	void chat(AsyncPlayerChatEvent event){
		
	}
}
