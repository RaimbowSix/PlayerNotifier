package com.github.raimbowsix.playernotifier.modules;

import com.github.raimbowsix.playernotifier.PlayerNotifier;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
import com.github.raimbowsix.playernotifier.util.WatchlistManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import java.util.HashSet;
import java.util.Set;

public class Enemies {

    private static final Minecraft mc = Minecraft.getMinecraft();
    public static Set<String> lastEnemySet = new HashSet<>();
    public static boolean isEnemy (EntityPlayer player){
        return WatchlistManager.isEnemy(player.getName());
    }
    public static void detectIfEnemiesInLobby() {
        Set<String> currentEnemySet = new HashSet<>();
        for (NetworkPlayerInfo info : PlayerNotifier.players) {
            String name = info.getGameProfile().getName();
            if (WatchlistManager.isEnemy(name)) {
                currentEnemySet.add(name.toLowerCase());
            }
        }
        if (ConfigOneConfig.enemyChatNotification){
            for (String name : currentEnemySet) {
            if (!lastEnemySet.contains(name)) {
                PlayerNotifier.sendMessage("§8[§a+§8] §7[§6PlayerNotifier§7] §4Enemy §8» §c" + name + " §fhas joined the lobby!");
            }
        }
            for (String name : lastEnemySet) {
                if (!currentEnemySet.contains(name)) {
                    PlayerNotifier.sendMessage("§8[§c-§8] §7[§6PlayerNotifier§7] §4Enemy §8» §c" + name + " §fhas left the lobby!");
                }
            }
        }

        lastEnemySet.clear();
        lastEnemySet.addAll(currentEnemySet);
    }
}
