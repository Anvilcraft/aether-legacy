package mods.battlegear2.api.core;

import cpw.mods.fml.common.eventhandler.EventBus;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

/**
 * Store commonly used method, mostly for the {@link EntityPlayer} {@link ItemStack}s
 * management
 */
public class BattlegearUtils {
    /**
     * Event bus to which {@link mods.battlegear2.api.RenderPlayerEventChild} events are
     * post to
     */
    public static final EventBus RENDER_BUS = new EventBus();
}