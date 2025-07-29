package com.github.raimbowsix.playernotifier.modules;

import java.util.Objects;
import java.util.regex.*;
import com.github.raimbowsix.playernotifier.PlayerNotifier;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
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
    public static String extractBounty(String input) {
        String pattern = "§6§l(\\d+)g";
        Matcher m = Pattern.compile(pattern).matcher(input);
        if (m.find()) {
            return m.group(1);
        }
        return null;
    }
    public static boolean hasMinimumBounty(String bountyString){
        int bounty = Integer.parseInt(bountyString);
        return bounty>=ConfigOneConfig.bountyMinPosition;
    }

    public static Set<String> lastBountiedSet = new HashSet<>();
    public static void detectIfPlayerHasBounty(){
        Set<String> currentBountiedSet = new HashSet<>();
        Minecraft mc=Minecraft.getMinecraft();
        for (EntityPlayer player : PlayerNotifier.playerEntities){
            if (hasBounty(player) && hasMinimumBounty(extractBounty(player.getDisplayName().getFormattedText()))){
                currentBountiedSet.add(player.getName());
            }
        }
        lastBountiedSet.clear();
        lastBountiedSet.addAll(currentBountiedSet);
    }
}
