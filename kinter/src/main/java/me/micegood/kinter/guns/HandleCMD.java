package me.micegood.kinter.guns;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HandleCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(args.length == 0){
            player.sendMessage("Укажи имя оружия");
            return true;
        }
        try {
            Gun gun = Gun.valueOf(args[0]);
            ArmsHandler.handle(gun, player);
            player.sendMessage("Выдано");
            return true;
        }
        catch (IllegalArgumentException e){
            player.sendMessage("Неверное имя оружия");
            return true;
        }

    }
}
