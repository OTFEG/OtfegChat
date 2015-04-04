package net.otfeg.chat;


import net.milkbowl.vault.chat.Chat;

import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;


public class ChatManager extends JavaPlugin {
	

	private Chat chat;

	@Override
	public void onEnable() {
		saveDefaultConfig();
		setupChat();
		new ChatListener(this);
		
	}
	
	@Override
	public void onDisable() {
		chat = null;
		
	}
	
	private boolean setupChat()
    {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }
	
	Chat getChat(){
		return chat;
	}
        
}
