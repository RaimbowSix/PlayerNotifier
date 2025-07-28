package com.github.raimbowsix.playernotifier.hud;

import cc.polyfrost.oneconfig.hud.TextHud;
import com.github.raimbowsix.playernotifier.config.ConfigOneConfig;
<<<<<<< HEAD
import com.github.raimbowsix.playernotifier.modules.Denicker;
import com.github.raimbowsix.playernotifier.util.PlayerLocation;
import net.minecraft.client.Minecraft;
=======
import com.github.raimbowsix.playernotifier.modules.DarkPants;
import com.github.raimbowsix.playernotifier.modules.Denicker;
import com.github.raimbowsix.playernotifier.util.GetEnchants;
import com.github.raimbowsix.playernotifier.util.PlayerLocation;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;

import java.util.ArrayList;
>>>>>>> 9894e61267afd7773410df65ad4302406cfe45e7
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
            lines.add("§bNicked: " + Denicker.lastNickedSet.toArray().length);
            for (final String name : Denicker.lastNickedSet) {
                Minecraft.getMinecraft().theWorld.playerEntities.stream()
                        .filter(player -> player.getName().equalsIgnoreCase(name))
                        .findFirst()
                        .ifPresent(player -> lines.add(player.getDisplayName().getFormattedText()
                                +PlayerLocation.getPlayerDistance(player.getName(), ConfigOneConfig.nickedDistance)));
            }
        }
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> 9894e61267afd7773410df65ad4302406cfe45e7
