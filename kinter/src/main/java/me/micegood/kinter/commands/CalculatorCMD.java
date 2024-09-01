package me.micegood.kinter.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CalculatorCMD implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        int a,b;
        try {
            a = Integer.parseInt(args[0]);
            b = Integer.parseInt(args[2]);
        }
        catch (NumberFormatException e){
            return false;

        }
         if (args[1].equals("+")){
             sender.sendMessage("Result = " + (a + b));
             return true;
         }

         else if (args[1].equals("-")){
            sender.sendMessage("Result = " + (a - b));
             return true;
        }
        else if (args[1].equals("*")){
            sender.sendMessage("Result = " + (a * b));
             return true;
        }
        else if (args[1].equals("/")){
            sender.sendMessage("Result = " + (a / b));
             return true;
        }



        return false;



    }
}
