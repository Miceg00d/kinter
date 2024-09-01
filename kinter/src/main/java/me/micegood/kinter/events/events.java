package me.micegood.kinter.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class events implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent event){
        if (event.getEntity() instanceof Zombie){
            Zombie zombie = (Zombie) event.getEntity();

            zombie.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));


        }
    }

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block clickedBlock = event.getClickedBlock();

            event.getPlayer().sendMessage(clickedBlock.getType().name());


        }
    }
}
