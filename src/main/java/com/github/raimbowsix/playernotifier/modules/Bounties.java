package com.github.raimbowsix.playernotifier.modules;

import com.github.raimbowsix.playernotifier.PlayerNotifier;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

import java.util.HashSet;
import java.util.Set;

public class Bounties {
    public static boolean hasBounty(EntityPlayer player){
        String name = player.getDisplayName().getFormattedText();
        return name.matches("§r§6\\[.*?]§b [a-zA-Z0-9_]{1,16} §6§l\\d{3,}g§r");
    }
    public static Set<String> currentBountiedSet = new HashSet<>();
    public static Set<String> lastBountiedSet = new HashSet<>();
    public static void detectIfPlayerHasBounty(){
        Minecraft mc=Minecraft.getMinecraft();
        for (EntityPlayer player : PlayerNotifier.playerEntities){
            if (hasBounty(player)){
                currentBountiedSet.add(player.getName());
            }
        }
        lastBountiedSet.clear();
        lastBountiedSet.addAll(currentBountiedSet);
    }
}
