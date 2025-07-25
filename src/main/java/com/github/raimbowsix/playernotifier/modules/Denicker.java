package com.github.raimbowsix.playernotifier.modules;

import com.github.raimbowsix.playernotifier.PlayerNotifier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Denicker {

    public static Minecraft mc = Minecraft.getMinecraft();
    public static Set<String> lastNickedSet = new HashSet<>();

    public static void notifyIfPlayerIsNicked(){
        Set<String> currentNickedSet = new HashSet<>();
        for(NetworkPlayerInfo info : PlayerNotifier.players){
            UUID playerUUID = info.getGameProfile().getId();
            if (playerUUID.version() == 1){
                currentNickedSet.add(info.getGameProfile().getName());
            }
        }
        for (String name : currentNickedSet) {
            if (!lastNickedSet.contains(name)) {
                PlayerNotifier.sendMessage("§7[§6PlayerNotifier§7] §fPotential Nick §8» §b"+name);
            }
        }
        lastNickedSet.clear();
        lastNickedSet.addAll(currentNickedSet);
    }
}