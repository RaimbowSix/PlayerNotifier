package com.github.raimbowsix.playernotifier.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import java.util.HashSet;
import java.util.Set;

public class GetEnchants {
    public static Set<String> getEnchantsFromName (String name){
        Set<String> enchantKeys = new HashSet<>();
        if (Minecraft.getMinecraft().theWorld == null) return enchantKeys;
        EntityPlayer player = Minecraft.getMinecraft().theWorld.getPlayerEntityByName(name);
        if (player == null) return enchantKeys;
        ItemStack leggings = player.inventory.armorItemInSlot(1);
        if (leggings == null || !leggings.hasTagCompound()) return enchantKeys;
        NBTTagCompound extraAttributes = leggings.getTagCompound().getCompoundTag("ExtraAttributes");
        if (extraAttributes== null || !extraAttributes.hasKey("CustomEnchants")) return enchantKeys;
        NBTTagList customEnchants = extraAttributes.getTagList("CustomEnchants", 10);
        for (int i = 0; i < customEnchants.tagCount(); i++){
            NBTTagCompound enchant = customEnchants.getCompoundTagAt(i);
            String key = enchant.getString("Key");
            enchantKeys.add(key);
        }
        return enchantKeys;
    }
    public static String getDarkPantsEnchantFromName (String name){
        Set<String> enchantKeys = getEnchantsFromName(name);
        String fallback = null;
        for (String key : enchantKeys) {
            EPitEnchants enchant = EPitEnchants.fromString(key);
            if (enchant == null) continue;
            if (!enchant.toString().toLowerCase().contains("somber")) {
                return enchant.toString();
            }
            fallback = enchant.toString();
        }
        return fallback != null ? fallback : "FRESH";
    }
    public static String getDarkPantsEnchantFromName(EntityPlayer player){
        return getDarkPantsEnchantFromName(player.getName());
    }
}
