package com.github.raimbowsix.playernotifier.hud;

import cc.polyfrost.oneconfig.hud.TextHud;
import net.minecraft.client.Minecraft;
import java.util.List;

public class PlayerNotifierHud extends TextHud {
    public PlayerNotifierHud() {
        super(true);
    }
    @Override
    protected void getLines(List<String> lines, boolean example) {
        lines.add("§7[§6PlayerNotifier§7] §81.1.0§r "+Minecraft.getDebugFPS()+" fps");
    }
}