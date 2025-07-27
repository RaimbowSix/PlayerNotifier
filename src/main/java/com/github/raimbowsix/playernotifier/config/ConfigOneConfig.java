package com.github.raimbowsix.playernotifier.config;

import cc.polyfrost.oneconfig.config.annotations.*;
import com.github.raimbowsix.playernotifier.PlayerNotifier;
//hud
import com.github.raimbowsix.playernotifier.hud.DarkHud;
import com.github.raimbowsix.playernotifier.hud.NickedHud;
import com.github.raimbowsix.playernotifier.hud.EnemiesHud;

import cc.polyfrost.oneconfig.config.Config;
import cc.polyfrost.oneconfig.config.data.Mod;
import cc.polyfrost.oneconfig.config.data.ModType;
import cc.polyfrost.oneconfig.config.data.OptionSize;

import javax.swing.text.html.Option;


public class ConfigOneConfig extends Config {
    //categories
    private static final transient String ENEMIES = "Enemies";
    private static final transient String DARK = "Darks";
    private static final transient String DENICKER = "Denicker";
    //subcategories
    private static final transient String ENEMIESOPTIONAL = "Optional";
    private static final transient String DARKOPTIONAL = "Optional";
    private static final transient String DENICKEROPTIONAL = "Optional";

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
            name = "Display Dark Position",
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




    //examples from example mod
    @Switch(
            name = "Example Switch",
            size = OptionSize.SINGLE // Optional
    )
    public static boolean exampleSwitch = false; // The default value for the boolean Switch.

    @Slider(
            name = "Example Slider",
            min = 0f, max = 100f, // Minimum and maximum values for the slider.
            step = 10 // The amount of steps that the slider should have.
    )
    public static float exampleSlider = 50f; // The default value for the float Slider.

    @Dropdown(
            name = "Example Dropdown", // Name of the Dropdown
            options = {"Option 1", "Option 2", "Option 3", "Option 4"} // Options available.
    )
    public static int exampleDropdown = 1; // Default option (in this case "Option 2")

    public ConfigOneConfig() {
        super(new Mod(PlayerNotifier.NAME, ModType.UTIL_QOL), PlayerNotifier.MODID + ".json");
        initialize();
    }
}
