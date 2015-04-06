package net.otfeg.chat;



import net.milkbowl.vault.chat.Chat;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
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
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		if(command.getName().equalsIgnoreCase("otfegchat")){
			//otfegchat reload
			if(args.length==1 && args[0].equalsIgnoreCase("reload")){
				reloadConfig();
				sender.sendMessage("Reloaded OtfegChat config file");
			}
		}
		return true;		
	}
}
