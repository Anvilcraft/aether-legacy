package com.gildedgames.the_aether.blocks.decorative;

import com.gildedgames.the_aether.Aether;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.IBlockAccess;

public class BlockZanite extends Block {
    public BlockZanite() {
        super(Material.iron);

        this.setHardness(3F);
        this.setStepSound(soundTypeMetal);
        this.setHarvestLevel("pickaxe", 1);
        this.setBlockTextureName(Aether.find("zanite_block"));
    }

    @Override
    public boolean isBeaconBase(
        IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ
    ) {
        return true;
    }
}