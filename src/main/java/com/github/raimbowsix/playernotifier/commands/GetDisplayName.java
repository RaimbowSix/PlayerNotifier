package com.github.raimbowsix.playernotifier.commands;

import com.github.raimbowsix.playernotifier.PlayerNotifier;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;

import java.util.Arrays;
import java.util.List;

public class GetDisplayName extends CommandBase {
    @Override
    public String getCommandName() {
        return "getdisplayname";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/getdisplayname player";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {
        if (args.length==1){
            String playerName = args[0];
            for (EntityPlayer info : mc.theWorld.playerEntities){
                if (info.getName().equalsIgnoreCase(playerName)){
                    PlayerNotifier.sendMessage(info.getDisplayName().getFormattedText());
                    System.out.println(info.getDisplayName().getFormattedText());
                }
            }
        }
        else PlayerNotifier.sendMessage("");
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public List<String> getCommandAliases() {
        return Arrays.asList("gdn");
    }
    public Minecraft mc = Minecraft.getMinecraft();
}
