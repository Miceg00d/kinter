package me.micegood.kinter.items;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class GiveItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        Player player = (Player) sender;

        if (args[0].equalsIgnoreCase("give")) {


            ItemStack itemStack = new ItemStack(Material.APPLE, 15);

            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName("яблоко");
            List<String> list = new ArrayList<>();
            list.add("Очень");
            list.add("Вкусное яблоко");

            itemMeta.setLore(list);


            itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("num"), PersistentDataType.INTEGER, 5);

            itemStack.setItemMeta(itemMeta);
            player.getInventory().addItem(itemStack);
            }

            else if (args[0].equalsIgnoreCase("subtractOne")) {



            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            if (itemInMainHand.getType() != Material.AIR) {

                if (itemInMainHand.getItemMeta().getPersistentDataContainer().get(NamespacedKey.fromString
                        ("num"),
                        PersistentDataType.INTEGER
                ) != null){



                    ItemMeta itemMeta = itemInMainHand.getItemMeta();

                    int num = itemMeta.getPersistentDataContainer().get(NamespacedKey.fromString("num"), PersistentDataType.INTEGER);
                    num = num - 1;

                    if (num >= 0){
                        ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
                        player.getInventory().addItem(diamond);

                        itemMeta.getPersistentDataContainer().set(NamespacedKey.fromString("num"), PersistentDataType.INTEGER, num);

                        itemInMainHand.setItemMeta(itemMeta);

                    }


                }

            }

        }

        return true;
    }
}
