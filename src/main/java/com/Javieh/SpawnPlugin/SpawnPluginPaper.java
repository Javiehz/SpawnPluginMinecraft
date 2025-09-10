package com.Javieh.SpawnPlugin;

import com.Javieh.SpawnPlugin.commands.SetSpawn;
import com.Javieh.SpawnPlugin.commands.Spawn;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class SpawnPluginPaper extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();

        getCommand("setspawn").setExecutor(new SetSpawn(this));
        getCommand("spawn").setExecutor(new Spawn(this));

        getServer().getPluginManager().registerEvents(new SpawnListener(this), this);

        getLogger().info("¡SpawnPluginJavieh Activado!");

    }

    public void onDisable(){
        getLogger().info("¡SpawnPluginJavieh Desactivado!");
    }
}
