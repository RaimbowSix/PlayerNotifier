package com.github.raimbowsix.playernotifier.hud;

import cc.polyfrost.oneconfig.hud.TextHud;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
<<<<<<< HEAD
import com.github.raimbowsix.playernotifier.modules.Enemies;
import com.github.raimbowsix.playernotifier.util.PlayerLocation;
import net.minecraft.client.Minecraft;
=======
import com.github.raimbowsix.playernotifier.modules.DarkPants;
import com.github.raimbowsix.playernotifier.modules.Enemies;
import com.github.raimbowsix.playernotifier.util.GetEnchants;
import com.github.raimbowsix.playernotifier.util.PlayerLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
>>>>>>> 9894e61267afd7773410df65ad4302406cfe45e7
import java.util.List;

public class EnemiesHud extends TextHud {
    public EnemiesHud() {
        super(true);
    }
    @Override
    protected void getLines(List<String> lines, boolean example) {
        if (Enemies.lastEnemySet.isEmpty()) {
            lines.add("No enemies in lobby");
        } else {
            lines.add("§cEnemies: " + Enemies.lastEnemySet.toArray().length);
            for (final String name : Enemies.lastEnemySet) {
                Minecraft.getMinecraft().theWorld.playerEntities.stream()
                        .filter(player -> player.getName().equalsIgnoreCase(name))
                        .findFirst()
                        .ifPresent(player -> lines.add(player.getDisplayName().getFormattedText()
                                +PlayerLocation.getPlayerDistance(player.getName(), ConfigOneConfig.enemyDistance)));
            }
        }
    }
}
