package com.github.raimbowsix.playernotifier.modules;

import com.github.raimbowsix.playernotifier.PlayerNotifier;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Denicker {

    public static Minecraft mc = Minecraft.getMinecraft();
    public static Set<String> lastNickedSet = new HashSet<>();
    public static boolean isNicked(UUID playerUUID){
        return playerUUID.version() == 1;
    }
    public static boolean isNicked(EntityPlayer playerEntity){
        return isNicked(playerEntity.getGameProfile().getId());
    }
    public static void detectIfPlayerIsNicked(){
        Set<String> currentNickedSet = new HashSet<>();
        for(NetworkPlayerInfo info : PlayerNotifier.players){
            UUID playerUUID = info.getGameProfile().getId();
            if (isNicked(playerUUID)){
                currentNickedSet.add(info.getGameProfile().getName());
            }
        }
        for (String name : currentNickedSet) {
            if (ConfigOneConfig.nickedChatNotification){
                if (!lastNickedSet.contains(name)) {
                PlayerNotifier.sendMessage("§7[§6PlayerNotifier§7] §fPotential Nick §8» §b"+name);
                }
            }
        }
        lastNickedSet.clear();
        lastNickedSet.addAll(currentNickedSet);
    }
}