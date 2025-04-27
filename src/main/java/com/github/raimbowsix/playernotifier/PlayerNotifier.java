package com.github.raimbowsix.playernotifier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.event.ClientChatReceivedEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Mod(modid = "playernotifier", name = "Player Notifier", version = "1.0", useMetadata = true)
public class PlayerNotifier {

    private static final Minecraft mc = Minecraft.getMinecraft();
    private final Set<String> lastEnemySet = new HashSet<>();

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        WatchlistManager.loadWatchlist();
        MinecraftForge.EVENT_BUS.register(this);
        System.out.println("Player Notifier Mod Initialized");
    }
    @SubscribeEvent
    public void onChatReceived(ClientChatReceivedEvent event) {
        if (mc.thePlayer != null && mc.theWorld != null) {
            notifyIfEnemiesInLobby();
        }
    }

    private void notifyIfEnemiesInLobby() {
        Collection<NetworkPlayerInfo> players = mc.getNetHandler().getPlayerInfoMap();
        Set<String> currentEnemySet = new HashSet<>();

        for (NetworkPlayerInfo info : players) {
            String name = info.getGameProfile().getName();
            if (WatchlistManager.isEnemy(name)) {
                currentEnemySet.add(name.toLowerCase());
            }
        }

        for (String name : currentEnemySet) {
            if (!lastEnemySet.contains(name)) {
                sendMessage("§1[§bPlayerNotifier§1] §g(+) §4§lEnemy §4\"" + name + "\" §ahas §ajoined §4the lobby!");
            }
        }

        for (String name : lastEnemySet) {
            if (!currentEnemySet.contains(name)) {
                sendMessage("§1[§bPlayerNotifier§1] §g(-) §4§lEnemy §4\"" + name + "\" §ahas §aleft §4the lobby!");
            }
        }

        lastEnemySet.clear();
        lastEnemySet.addAll(currentEnemySet);
    }

    private void sendMessage(String msg) {
        EntityPlayerSP player = mc.thePlayer;
        if (player != null) {
            player.addChatMessage(new ChatComponentText(msg));
        }
    }
}
