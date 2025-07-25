package com.github.raimbowsix.playernotifier.hud;

import cc.polyfrost.oneconfig.hud.TextHud;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
import com.github.raimbowsix.playernotifier.modules.DarkPants;
import com.github.raimbowsix.playernotifier.modules.Denicker;
import com.github.raimbowsix.playernotifier.util.GetEnchants;
import com.github.raimbowsix.playernotifier.util.PlayerLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
import java.util.List;

public class NickedHud extends TextHud {
    public NickedHud() {
        super(true);
    }
    @Override
    protected void getLines(List<String> lines, boolean example) {
        if (Denicker.lastNickedSet.isEmpty()) {
            lines.add("No nicked in lobby");
        } else {
            ArrayList<String> Nicked = new ArrayList<>();
            if (Minecraft.getMinecraft().theWorld!=null && Minecraft.getMinecraft().theWorld.playerEntities != null)
                Minecraft.getMinecraft().theWorld.playerEntities.stream()
                        .filter(DarkPants::hasDarks)
                        .forEach(p->{
                            Nicked.add(p.getDisplayName().getFormattedText()+" "+ GetEnchants.getDarkPantsEnchantFromName(p)+
                                    PlayerLocation.getPlayerDistance(p.getName(), ConfigOneConfig.nickedDistance));
                        });
            lines.add(EnumChatFormatting.DARK_PURPLE + "§bNicked: " + Nicked.size());
            lines.addAll(Nicked);
        }
    }
}