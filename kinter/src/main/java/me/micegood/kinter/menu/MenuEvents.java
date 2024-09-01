package me.micegood.kinter.menu;

import me.micegood.kinter.util.Util;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class MenuEvents implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory() == Menu.instance.inventory) {
            event.setCancelled(true);

            if (event.getCurrentItem() != null) {
                String itemname = event.getCurrentItem().getItemMeta().getDisplayName();

                ItemStack firstNum = event.getInventory().getItem(11);
                ItemStack secondNum = event.getInventory().getItem(15);

                if (itemname.equals("Сделать 0")) {
                    if (event.getSlot() == 29) {
                        event.getInventory().setItem(11, Util.createItemStack(firstNum.getType(), "0"));
                    } else if (event.getSlot() == 33) {
                        event.getInventory().setItem(15, Util.createItemStack(secondNum.getType(), "0"));
                    }
                } else if (itemname.equals("Плюс 1")) {
                    if (event.getSlot() == 30) {
                        int num = Integer.parseInt(firstNum.getItemMeta().getDisplayName());

                        event.getInventory().setItem(11, Util.createItemStack(firstNum.getType(), String.valueOf(num + 1)));
                    } else if (event.getSlot() == 34) {
                        int num = Integer.parseInt(secondNum.getItemMeta().getDisplayName());

                        event.getInventory().setItem(15, Util.createItemStack(secondNum.getType(), String.valueOf(num + 1)));
                    }
                } else if (itemname.equals("Минус 1")) {
                    if (event.getSlot() == 28) {
                        int num = Integer.parseInt(firstNum.getItemMeta().getDisplayName());
                        event.getInventory().setItem(11, Util.createItemStack(firstNum.getType(), String.valueOf(num - 1)));
                    } else if (event.getSlot() == 32) {
                        int num = Integer.parseInt(secondNum.getItemMeta().getDisplayName());
                        event.getInventory().setItem(15, Util.createItemStack(secondNum.getType(), String.valueOf(num - 1)));
                    }
                }
                else if (itemname.equals("Измененить знак вычисления")) {
                    ItemMeta meta = event.getCurrentItem().getItemMeta();
                    List<String> lore = meta.getLore();


                        if (lore.get(0).equals("+")) {
                            event.getInventory().setItem(13, Util.createItemStack(Material.OAK_SIGN, "Изменить знак вычисления", Arrays.asList("-")));

                        } else if (lore.get(0).equals("-")) {
                            event.getInventory().setItem(13, Util.createItemStack(Material.OAK_SIGN, "Изменить знак вычисления", Arrays.asList("*")));

                        } else if (lore.get(0).equals("*")) {
                            event.getInventory().setItem(13, Util.createItemStack(Material.OAK_SIGN, "Изменить знак вычисления", Arrays.asList("/")));

                        } else if (lore.get(0).equals("/")) {
                            event.getInventory().setItem(13, Util.createItemStack(Material.OAK_SIGN, "Изменить знак вычисления", Arrays.asList("+")));
                        }
                    }
                else if (itemname.equals("Получить результат")) {
                        int num1 = Integer.parseInt(event.getInventory().getItem(11).getItemMeta().getDisplayName());
                        int num2 = Integer.parseInt(event.getInventory().getItem(15).getItemMeta().getDisplayName());

                        ItemStack signItem = event.getInventory().getItem(13);
                        String sign = signItem.getItemMeta().getLore().get(0);

                        if (sign.equals("+")) {
                            event.getWhoClicked().sendMessage("Результат - " + (num1 + num2));

                        } else if (sign.equals("-")) {
                            event.getWhoClicked().sendMessage("Результат -" + (num1 - num2));
                        } else if (sign.equals("*")) {
                            event.getWhoClicked().sendMessage("Результат -" + (num1 * num2));
                        } else if (sign.equals("/")) {
                            event.getWhoClicked().sendMessage("Результат -" + (num1 / num2));
                        }
                    }
                }
            }
        }
    }
