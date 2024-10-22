package com.gildedgames.the_aether.blocks.decorative;

import java.util.Random;

import com.gildedgames.the_aether.Aether;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockBreakable;
import net.minecraft.block.material.Material;

public class BlockQuicksoilGlass extends BlockBreakable {
    public BlockQuicksoilGlass() {
        super(Aether.find("quicksoil_glass"), Material.glass, false);

        this.slipperiness = 1.1F;

        this.setHardness(0.2F);
        this.setLightOpacity(0);
        this.setLightLevel(0.7375F);
        this.setStepSound(soundTypeGlass);
    }

    @Override
    public int quantityDropped(Random random) {
        return 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getRenderBlockPass() {
        return 1;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return true;
    }

    @Override
    protected boolean canSilkHarvest() {
        return true;
    }
}