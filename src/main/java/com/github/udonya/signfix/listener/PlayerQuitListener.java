package com.github.udonya.signfix.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.udonya.signfix.SignFix;

public class PlayerQuitListener implements Listener{
    /**
     * Refs of plugin instance
     */
    private final SignFix plugin;

    /**
     * Constructor
     * @param plugin
     */
    public PlayerQuitListener(SignFix plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    /**
     * Clean up clicked record.
     * @param event
     */
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event){
        String playerName = event.getPlayer().getName();
        if(this.plugin.getClicked().containsKey(playerName)) this.plugin.getClicked().remove(playerName);
    }

}
