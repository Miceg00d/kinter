package me.micegood.kinter;

import me.micegood.kinter.commands.CalculatorCMD;
import me.micegood.kinter.commands.MessageCMD;
import me.micegood.kinter.commands.MessageCompleter;
import me.micegood.kinter.entity.SpawnCommand;
import me.micegood.kinter.events.events;
import me.micegood.kinter.guns.GunEvents;
import me.micegood.kinter.guns.HandleCMD;
import me.micegood.kinter.items.GiveItem;
import me.micegood.kinter.menu.MenuEvents;
import me.micegood.kinter.menu.command;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;

public final class Kinter extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Привет");

        getCommand("calculator").setExecutor(new CalculatorCMD());

        getCommand("message").setExecutor(new MessageCMD());

        getCommand("message").setTabCompleter(new MessageCompleter());

        getCommand("spawnEntity").setExecutor(new SpawnCommand());

        getCommand("giveItem").setExecutor(new GiveItem());

        Bukkit.getPluginManager().registerEvents(new events(), this);

        getServer().getPluginManager().registerEvents(new GunEvents(), this);

        getCommand("giveGun").setExecutor((new HandleCMD()));

        getCommand("menu").setExecutor(new command());

        getServer().getPluginManager().registerEvents(new MenuEvents(), this);
        // Plugin startup logicx

    }

    @Override
    public void onDisable() {
        System.out.println("Пока");
        // Plugin shutdown logic
    }
}
