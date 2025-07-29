package com.github.raimbowsix.playernotifier.modules;

import java.util.regex.*;
import com.github.raimbowsix.playernotifier.PlayerNotifier;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import java.util.HashSet;
import java.util.Set;

public class Bounties {
    public static boolean match(String input) {
        String pattern = "§l\\d+g";
        Matcher m = Pattern.compile(pattern).matcher(input);
        return m.find();
    }
    public static boolean hasBounty(EntityPlayer player){
        String name = player.getDisplayName().getFormattedText();
        return match(name);
    }

    public static Set<String> lastBountiedSet = new HashSet<>();
    public static void detectIfPlayerHasBounty(){
        Set<String> currentBountiedSet = new HashSet<>();
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
