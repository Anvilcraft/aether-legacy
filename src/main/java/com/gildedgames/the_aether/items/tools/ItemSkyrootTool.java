package com.gildedgames.the_aether.items.tools;

import com.gildedgames.the_aether.blocks.BlocksAether;
import com.gildedgames.the_aether.items.util.EnumAetherToolType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemSkyrootTool extends ItemAetherTool {
    public ItemSkyrootTool(float damage, EnumAetherToolType toolType) {
        super(damage, ToolMaterial.WOOD, toolType);
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return repair.getItem() == Item.getItemFromBlock(BlocksAether.skyroot_planks);
    }
}