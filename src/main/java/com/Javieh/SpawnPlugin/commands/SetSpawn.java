package com.Javieh.SpawnPlugin.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class SetSpawn implements CommandExecutor {
    private final JavaPlugin plugin;

    public SetSpawn(JavaPlugin plugin) {
        this.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        if(!(commandSender instanceof Player player)){
            commandSender.sendMessage("Este comando solo se puede ejecutar en el juego.");
            return true;
        }

        Location loc = player.getLocation();
        plugin.getConfig().set("spawn", loc);
        plugin.saveConfig();

        player.sendMessage(plugin.getConfig().getString("messages.set").replace("&", "§"));
        return true;
    }
}
