package com.gildedgames.the_aether;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {
    public static int berryBushRenderID;

    public static int treasureChestRenderID;

    public static int aetherFlowerRenderID;

    public void init() {}

    public void openSunAltar() {}

    public void sendMessage(EntityPlayer player, String text) {}

    public EntityPlayer getPlayer() {
        return null;
    }

    public static void registerEvent(Object event) {
        FMLCommonHandler.instance().bus().register(event);
        MinecraftForge.EVENT_BUS.register(event);
    }
}