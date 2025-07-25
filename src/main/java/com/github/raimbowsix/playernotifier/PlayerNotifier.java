package com.github.raimbowsix.playernotifier;

import com.github.raimbowsix.playernotifier.commands.GetNBT;
import com.github.raimbowsix.playernotifier.commands.Watchlist;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
import com.github.raimbowsix.playernotifier.modules.DarkPants;
import com.github.raimbowsix.playernotifier.modules.Denicker;
import com.github.raimbowsix.playernotifier.util.WatchlistManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import com.github.raimbowsix.playernotifier.modules.Enemies;

import java.util.Collection;

@Mod(modid = PlayerNotifier.MODID, name = PlayerNotifier.NAME, version = PlayerNotifier.VERSION, useMetadata = true)
public class PlayerNotifier {
    public static final String MODID = "playernotifier";
    public static final String NAME = "PlayerNotifier";
    public static final String VERSION = "1.1";
    public static ConfigOneConfig config;

    private static final Minecraft mc = Minecraft.getMinecraft();
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        //commands
        ClientCommandHandler.instance.registerCommand(new Watchlist());
        ClientCommandHandler.instance.registerCommand(new GetNBT());

        WatchlistManager.loadWatchlist();
        MinecraftForge.EVENT_BUS.register(this);
        config = new ConfigOneConfig();
        System.out.println("Player Notifier Mod Initialized");
    }
    public static int tickCount = 0;
    public static void sendMessage(String msg) {
        EntityPlayerSP player = mc.thePlayer;
        if (player != null) {
            player.addChatMessage(new ChatComponentText(msg));
        }
    }
    public static Collection<NetworkPlayerInfo> players = null;
    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        tickCount = tickCount+1;
        if (mc.thePlayer != null && mc.theWorld != null && tickCount>=20) {
            players = mc.getNetHandler().getPlayerInfoMap();
            Enemies.notifyIfEnemiesInLobby();
            DarkPants.notifyIfPlayerHasDarkPants();
            Denicker.notifyIfPlayerIsNicked();
        }
    }
}