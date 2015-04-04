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
		getLogger().info(String.format("%s (version %s) has started successfully", getDescription().getName(), getDescription().getVersion()));
	}
	
	@Override
	public void onDisable() {
		chat = null;
		getLogger().info(String.format("%s (version %s) has stopped successfully", getDescription().getName(), getDescription().getVersion()));
	}
	
	private boolean setupChat() {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }
	
	public Chat getChat() {
		return chat;
	}
}
