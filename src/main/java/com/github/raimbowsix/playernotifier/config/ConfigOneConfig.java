package com.github.raimbowsix.playernotifier.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import com.github.raimbowsix.playernotifier.PlayerNotifier;
//hud
import com.github.raimbowsix.playernotifier.hud.*;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;


public class ConfigOneConfig extends Config {
    //categories
    private static final transient String GENERAL = "General";
    private static final transient String ENEMIES = "Enemies";
    private static final transient String DARK = "Darks";
    private static final transient String DENICKER = "Denicker";
    private static final transient String BOUNTIES = "Bounties";

    private static final transient String ENEMIESOPTIONAL = "Optional";
    private static final transient String DARKOPTIONAL = "Optional";
    private static final transient String DENICKEROPTIONAL = "Optional";
    private static final transient String BOUNTIESOPTIONAL = "Optional";

    //PlayerNotifierHud
    @HUD(
            name = "Player Notifier HUD",
            category = GENERAL
    )
    public static PlayerNotifierHud playerNotifierHud = new PlayerNotifierHud();
    //Bountied Players
    @HUD(
            name = "Bountied Players HUD",
            category = BOUNTIES
    )
    public static BountiesHud bountiesHud = new BountiesHud();
    @Switch(
            name = "Display Distance",
            category = BOUNTIES,
            subcategory = BOUNTIESOPTIONAL
    )
    public static boolean bountyDistance = true;
    @Switch(
            name = "Display Position",
            category = BOUNTIES,
            subcategory = BOUNTIESOPTIONAL
    )
    public static boolean bountyPosition = true;
    //Dark Pants
    @HUD(
            name = "Dark Pants HUD",
            category = DARK
    )

    public static DarkHud darkHud = new DarkHud();
    @Switch(
            name = "Display Distance",
            size = OptionSize.SINGLE,
            category = DARK,
            subcategory = DARKOPTIONAL
    )
    public static boolean darkDistance = true;
    @Switch(
            name = "Display Position",
            size = OptionSize.SINGLE,
            category = DARK,
            subcategory = DARKOPTIONAL
    )
    public static boolean darkPosition = true;

    //Nicked Players

    @HUD(
            name = "Nicked Players HUD",
            category = DENICKER
    )
    public static NickedHud nickedHud = new NickedHud();

    @Switch(
            name = "Display Distance",
            size = OptionSize.SINGLE,
            category = DENICKER,
            subcategory = DENICKEROPTIONAL
    )
    public static boolean nickedDistance = true;
    @Switch(
            name = "Display Position",
            size = OptionSize.SINGLE,
            category = DENICKER,
            subcategory = DENICKEROPTIONAL
    )
    public static boolean nickedPosition = true;
    @Switch(
            name = "Chat Notification",
            description = "sends chat message when a nicked player joins",
            size = OptionSize.SINGLE,
            category = DENICKER,
            subcategory = DENICKEROPTIONAL
    )
    public static boolean nickedChatNotification = true;

    //Enemy Players
    @HUD(
            name = "Enemies HUD",
            category = ENEMIES
    )
    public static EnemiesHud enemiesHud = new EnemiesHud();

    @Switch(
            name = "Display Distance",
            size = OptionSize.SINGLE,
            category = ENEMIES,
            subcategory = ENEMIESOPTIONAL
    )
    public static boolean enemyDistance = true;
    @Switch(
            name = "Display Position",
            size = OptionSize.SINGLE,
            category = ENEMIES,
            subcategory = ENEMIESOPTIONAL
    )
    public static boolean enemyPosition = true;
    @Switch(
            name = "Chat Notification",
            description = "sends chat message when an enemy player joins",
            size = OptionSize.SINGLE,
            category = ENEMIES,
            subcategory = ENEMIESOPTIONAL
    )
    public static boolean enemyChatNotification = true;

    public ConfigOneConfig() {
        super(new Mod(PlayerNotifier.NAME, ModType.UTIL_QOL), PlayerNotifier.MODID + ".json");
        initialize();
    }
}