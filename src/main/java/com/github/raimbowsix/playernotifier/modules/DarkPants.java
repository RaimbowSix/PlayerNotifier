package com.github.raimbowsix.playernotifier.modules;

import com.github.raimbowsix.playernotifier.PlayerNotifier;
<<<<<<< HEAD
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

=======
import com.github.raimbowsix.playernotifier.util.EPitEnchants;
import net.minecraft.client.Minecraft;
import net.minecraft.client.network.NetworkPlayerInfo;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants;
>>>>>>> 9894e61267afd7773410df65ad4302406cfe45e7

import java.util.HashSet;
import java.util.Set;

public class DarkPants {

    public static Minecraft mc = Minecraft.getMinecraft();

    public static boolean hasDarks(final EntityPlayer player) {
        if (player == null) return false;
        ItemStack leggings = player.inventory.armorItemInSlot(1);
        if (leggings == null || !leggings.hasDisplayName()) return false;
        return leggings.getDisplayName().toLowerCase().contains("dark pants");
    }


    public static Set<String> lastDarkSet = new HashSet<>();
<<<<<<< HEAD
    public static void detectIfPlayerHasDarkPants() {
        Set<String> currentDarkSet = new HashSet<>();
        for (EntityPlayer player : PlayerNotifier.playerEntities) {
=======
    public static void notifyIfPlayerHasDarkPants() {
        Set<String> currentDarkSet = new HashSet<>();
        for (EntityPlayer player : Minecraft.getMinecraft().theWorld.playerEntities) {
>>>>>>> 9894e61267afd7773410df65ad4302406cfe45e7
            String name = player.getName();
            if (hasDarks(player)) {
                currentDarkSet.add(name.toLowerCase());
            }
        }
        lastDarkSet.clear();
        lastDarkSet.addAll(currentDarkSet);
    }
}
