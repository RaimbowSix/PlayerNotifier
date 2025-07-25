package com.github.raimbowsix.playernotifier.hud;

import cc.polyfrost.oneconfig.hud.TextHud;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
import com.github.raimbowsix.playernotifier.modules.DarkPants;
import com.github.raimbowsix.playernotifier.modules.Enemies;
import com.github.raimbowsix.playernotifier.util.GetEnchants;
import com.github.raimbowsix.playernotifier.util.PlayerLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
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
            ArrayList<String> Enemies = new ArrayList<>();
            if (Minecraft.getMinecraft().theWorld!=null && Minecraft.getMinecraft().theWorld.playerEntities != null)
                Minecraft.getMinecraft().theWorld.playerEntities.stream()
                        .filter(DarkPants::hasDarks)
                        .forEach(p->{
                            Enemies.add(p.getDisplayName().getFormattedText()+" "+ GetEnchants.getDarkPantsEnchantFromName(p)+
                                    PlayerLocation.getPlayerDistance(p.getName(), ConfigOneConfig.enemyDistance));
                        });
            lines.add(EnumChatFormatting.DARK_PURPLE + "§cEnemies: " + Enemies.size());
            lines.addAll(Enemies);
        }
    }
}
