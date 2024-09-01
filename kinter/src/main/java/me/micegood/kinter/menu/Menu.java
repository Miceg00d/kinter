package me.micegood.kinter.menu;

import me.micegood.kinter.util.Util;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

public class Menu {

    public static final Menu instance = new Menu();
    public final Inventory inventory = Bukkit.createInventory(null,54, "SAGE");

    Menu(){
        inventory.setItem(11, Util.createItemStack(Material.WATER_BUCKET, "0"));
        inventory.setItem(15, Util.createItemStack(Material.WATER_BUCKET, "0"));

        inventory.setItem(13, Util.createItemStack(Material.OAK_SIGN, "Изменить знак вычисления", Arrays.asList("+")));

        inventory.setItem(28, Util.createItemStack(Material.RED_CONCRETE, "Минус 1"));
        inventory.setItem(29, Util.createItemStack(Material.WHITE_CONCRETE, "Сделать 0"));
        inventory.setItem(30, Util.createItemStack(Material.GREEN_CONCRETE, "Плюс 1"));

        inventory.setItem(32, Util.createItemStack(Material.RED_CONCRETE, "Минус 1"));
        inventory.setItem(33, Util.createItemStack(Material.WHITE_CONCRETE, "Сделать 0"));
        inventory.setItem(34, Util.createItemStack(Material.GREEN_CONCRETE, "Плюс 1"));

        inventory.setItem(49, Util.createItemStack(Material.PAPER, "Получить результат"));

    }
}
