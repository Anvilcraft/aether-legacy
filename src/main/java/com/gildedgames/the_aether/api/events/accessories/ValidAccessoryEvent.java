package com.gildedgames.the_aether.api.events.accessories;

import com.gildedgames.the_aether.api.accessories.AetherAccessory;
import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.player.EntityPlayer;

@Cancelable
public class ValidAccessoryEvent extends AetherAccessoryEvent {
    public ValidAccessoryEvent(EntityPlayer player, AetherAccessory accessory) {
        super(accessory);
    }
}