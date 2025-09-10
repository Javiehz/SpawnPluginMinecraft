package com.Javieh.SpawnPlugin;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnListener implements Listener {

    private final JavaPlugin plugin;


    public SpawnListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPlayedBefore()) {
            Location loc = plugin.getConfig().getLocation("spawn");
            if (loc != null) {
                player.teleport(loc);
                String msg = plugin.getConfig().getString("messages.teleport");
                if (msg != null) {
                    player.sendMessage(msg.replace("&", "§"));
                }
            } else {
                player.sendMessage("§cNo hay un spawn configurado aún.");
            }
        }
    }
}