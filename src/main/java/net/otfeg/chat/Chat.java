package net.otfeg.chat;

import org.bukkit.plugin.java.JavaPlugin;

public class Chat extends JavaPlugin {
	@Override
	public void onEnable() {
		saveDefaultConfig();
		new ChatListener(this);
	}
	
	@Override
	public void onDisable() {
	}
}
