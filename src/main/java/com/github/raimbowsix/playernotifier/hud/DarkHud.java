package com.github.raimbowsix.playernotifier.hud;

import cc.polyfrost.oneconfig.hud.TextHud;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
import com.github.raimbowsix.playernotifier.modules.DarkPants;
import com.github.raimbowsix.playernotifier.util.GetEnchants;
import com.github.raimbowsix.playernotifier.util.PlayerLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import java.util.ArrayList;
import java.util.List;


public class DarkHud extends TextHud {
    public DarkHud(){super(true);}
    @Override
    protected void getLines(List<String> lines, boolean example) {
        if (DarkPants.lastDarkSet.isEmpty()) {
            lines.add("No darks in lobby");
        } else {
            ArrayList<String> Darks = new ArrayList<>();
            if (Minecraft.getMinecraft().theWorld!=null && Minecraft.getMinecraft().theWorld.playerEntities != null)
                Minecraft.getMinecraft().theWorld.playerEntities.stream()
                    .filter(DarkPants::hasDarks)
                    .forEach(p->{
                        Darks.add(p.getDisplayName().getFormattedText()+" "+GetEnchants.getDarkPantsEnchantFromName(p)+
                                PlayerLocation.getPlayerDistance(p.getName(), ConfigOneConfig.darkDistance));
                    });
            lines.add(EnumChatFormatting.DARK_PURPLE + "§5Darks: " + Darks.size());
            lines.addAll(Darks);
        }
    }
}
