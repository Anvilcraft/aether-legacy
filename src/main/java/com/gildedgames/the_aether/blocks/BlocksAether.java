package com.gildedgames.the_aether.blocks;

import com.gildedgames.the_aether.Aether;
import com.gildedgames.the_aether.blocks.container.BlockEnchanter;
import com.gildedgames.the_aether.blocks.container.BlockFreezer;
import com.gildedgames.the_aether.blocks.container.BlockIncubator;
import com.gildedgames.the_aether.blocks.container.BlockSunAltar;
import com.gildedgames.the_aether.blocks.decorative.BlockAerogel;
import com.gildedgames.the_aether.blocks.decorative.BlockAetherFence;
import com.gildedgames.the_aether.blocks.decorative.BlockAetherFenceGate;
import com.gildedgames.the_aether.blocks.decorative.BlockAetherSlab;
import com.gildedgames.the_aether.blocks.decorative.BlockAetherStairs;
import com.gildedgames.the_aether.blocks.decorative.BlockAetherWall;
import com.gildedgames.the_aether.blocks.decorative.BlockAmbrosiumTorch;
import com.gildedgames.the_aether.blocks.decorative.BlockPresent;
import com.gildedgames.the_aether.blocks.decorative.BlockQuicksoilGlass;
import com.gildedgames.the_aether.blocks.decorative.BlockSkyrootBookshelf;
import com.gildedgames.the_aether.blocks.decorative.BlockSkyrootPlanks;
import com.gildedgames.the_aether.blocks.decorative.BlockZanite;
import com.gildedgames.the_aether.blocks.dungeon.BlockDungeonBase;
import com.gildedgames.the_aether.blocks.dungeon.BlockDungeonTrap;
import com.gildedgames.the_aether.blocks.dungeon.BlockMimicChest;
import com.gildedgames.the_aether.blocks.dungeon.BlockPillar;
import com.gildedgames.the_aether.blocks.dungeon.BlockTreasureChest;
import com.gildedgames.the_aether.blocks.natural.BlockAercloud;
import com.gildedgames.the_aether.blocks.natural.BlockAetherDirt;
import com.gildedgames.the_aether.blocks.natural.BlockAetherFlower;
import com.gildedgames.the_aether.blocks.natural.BlockAetherGrass;
import com.gildedgames.the_aether.blocks.natural.BlockAetherLeaves;
import com.gildedgames.the_aether.blocks.natural.BlockAetherLog;
import com.gildedgames.the_aether.blocks.natural.BlockAetherOre;
import com.gildedgames.the_aether.blocks.natural.BlockBerryBush;
import com.gildedgames.the_aether.blocks.natural.BlockBerryBushStem;
import com.gildedgames.the_aether.blocks.natural.BlockEnchantedAetherGrass;
import com.gildedgames.the_aether.blocks.natural.BlockHolystone;
import com.gildedgames.the_aether.blocks.natural.BlockQuicksoil;
import com.gildedgames.the_aether.blocks.portal.BlockAetherPortal;
import com.gildedgames.the_aether.blocks.util.BlockFloating;
import com.gildedgames.the_aether.items.ItemsAether;
import com.gildedgames.the_aether.items.block.ItemAetherSlab;
import com.gildedgames.the_aether.items.block.ItemBlockEnchanter;
import com.gildedgames.the_aether.items.block.ItemBlockMetadata;
import com.gildedgames.the_aether.items.block.ItemBlockRarity;
import com.gildedgames.the_aether.registry.creative_tabs.AetherCreativeTabs;
import com.gildedgames.the_aether.world.biome.decoration.AetherGenOakTree;
import com.gildedgames.the_aether.world.biome.decoration.AetherGenSkyrootTree;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;

public class BlocksAether {
    public static Block aether_grass, enchanted_aether_grass, aether_dirt;

    public static Block holystone, mossy_holystone, holystone_brick;

    public static Block aercloud, quicksoil, icestone;

    public static Block ambrosium_ore, zanite_ore, gravitite_ore;

    public static Block skyroot_leaves, golden_oak_leaves, skyroot_log, golden_oak_log,
        skyroot_planks;

    public static Block quicksoil_glass, aerogel;

    public static Block enchanted_gravitite, zanite_block;

    public static Block berry_bush, berry_bush_stem;

    public static Block enchanter, freezer, incubator;

    public static Block ambrosium_torch;

    public static Block aether_portal;

    public static Block chest_mimic, treasure_chest;

    public static Block carved_stone, angelic_stone, hellfire_stone;

    public static Block sentry_stone, light_angelic_stone, light_hellfire_stone;

    public static Block locked_carved_stone, locked_angelic_stone, locked_hellfire_stone;

    public static Block locked_sentry_stone, locked_light_angelic_stone,
        locked_light_hellfire_stone;

    public static Block carved_trap, angelic_trap, hellfire_trap;

    public static Block purple_flower, white_flower;

    public static Block skyroot_sapling, golden_oak_sapling;

    public static Block crystal_leaves, crystal_fruit_leaves;

    public static Block pillar, pillar_top;

    public static Block skyroot_fence, skyroot_fence_gate;

    public static Block carved_stairs, angelic_stairs, hellfire_stairs, skyroot_stairs,
        mossy_holystone_stairs, holystone_stairs, holystone_brick_stairs, aerogel_stairs;

    public static Block carved_slab, angelic_slab, hellfire_slab, skyroot_slab,
        holystone_slab, holystone_brick_slab, mossy_holystone_slab, aerogel_slab;

    public static Block carved_double_slab, angelic_double_slab, hellfire_double_slab,
        skyroot_double_slab, holystone_double_slab, holystone_brick_double_slab,
        mossy_holystone_double_slab, aerogel_double_slab;

    public static Block holystone_wall, mossy_holystone_wall, holystone_brick_wall,
        carved_wall, angelic_wall, hellfire_wall, aerogel_wall;

    public static Block holiday_leaves, decorated_holiday_leaves, present;

    public static Block sun_altar;

    public static Block skyroot_bookshelf;

    public static Block skyroot_bed;

    public static void initialization() {
        aether_grass = registerMeta("aether_grass", new BlockAetherGrass());
        enchanted_aether_grass = registerRarity(
            "enchanted_aether_grass", new BlockEnchantedAetherGrass(), EnumRarity.rare
        );
        aether_dirt = registerMeta("aether_dirt", new BlockAetherDirt());
        holystone = registerMeta("holystone", new BlockHolystone());
        mossy_holystone = registerMeta(
            "mossy_holystone",
            new BlockHolystone().setBlockTextureName(Aether.find("mossy_holystone"))
        );
        holystone_brick = register(
            "holystone_brick",
            new BlockAether(Material.rock, Aether.find("holystone_brick"))
                .setHardness(0.5F)
                .setResistance(10.0F)
        );
        aercloud = registerMeta("aercloud", new BlockAercloud());
        aerogel = registerRarity("aerogel", new BlockAerogel(), ItemsAether.aether_loot);
        quicksoil = registerMeta("quicksoil", new BlockQuicksoil());
        icestone = register("icestone", new BlockIcestone());
        ambrosium_ore = register(
            "ambrosium_ore",
            new BlockAetherOre(0).setBlockTextureName(Aether.find("ambrosium_ore"))
        );
        zanite_ore = register(
            "zanite_ore",
            new BlockAetherOre(1).setBlockTextureName(Aether.find("zanite_ore"))
        );
        gravitite_ore = register(
            "gravitite_ore",
            new BlockFloating(Material.rock, false)
                .setHardness(5.0F)
                .setBlockTextureName(Aether.find("gravitite_ore"))
        );
        enchanted_gravitite = registerRarity(
            "enchanted_gravitite",
            new BlockFloating(Material.rock, true)
                .setHardness(5.0F)
                .setBlockTextureName(Aether.find("enchanted_gravitite")),
            EnumRarity.rare
        );
        zanite_block = register("zanite_block", new BlockZanite());
        skyroot_leaves = register(
            "skyroot_leaves",
            new BlockAetherLeaves().setBlockTextureName(Aether.find("skyroot_leaves"))
        );
        golden_oak_leaves = register(
            "golden_oak_leaves",
            new BlockAetherLeaves().setBlockTextureName(Aether.find("golden_oak_leaves"))
        );
        crystal_leaves = register(
            "crystal_leaves",
            new BlockAetherLeaves().setBlockTextureName(Aether.find("crystal_leaves"))
        );
        crystal_fruit_leaves = register(
            "crystal_fruit_leaves",
            new BlockAetherLeaves().setBlockTextureName(Aether.find("crystal_fruit_leaves"
            ))
        );
        holiday_leaves = register(
            "holiday_leaves",
            new BlockAetherLeaves().setBlockTextureName(Aether.find("holiday_leaves"))
        );
        decorated_holiday_leaves = register(
            "decorated_holiday_leaves",
            new BlockAetherLeaves().setBlockTextureName(
                Aether.find("decorated_holiday_leaves")
            )
        );
        present = register("present", new BlockPresent());
        skyroot_log = registerMeta(
            "skyroot_log",
            new BlockAetherLog().setBlockTextureName(Aether.find("skyroot_log"))
        );
        golden_oak_log = registerMeta(
            "golden_oak_log",
            new BlockAetherLog().setBlockTextureName(Aether.find("golden_oak_log"))
        );
        skyroot_planks = register("skyroot_planks", new BlockSkyrootPlanks());
        quicksoil_glass = registerRarity(
            "quicksoil_glass", new BlockQuicksoilGlass(), EnumRarity.rare
        );
        ambrosium_torch = register(
            "ambrosium_torch",
            new BlockAmbrosiumTorch().setBlockTextureName(Aether.find("ambrosium_torch"))
        );
        berry_bush_stem = register("berry_bush_stem", new BlockBerryBushStem());
        berry_bush = register("berry_bush", new BlockBerryBush());
        purple_flower = register(
            "purple_flower",
            new BlockAetherFlower().setBlockTextureName(Aether.find("purple_flower"))
        );
        white_flower = register(
            "white_flower",
            new BlockAetherFlower().setBlockTextureName(Aether.find("white_flower"))
        );
        skyroot_sapling = register(
            "skyroot_sapling",
            new BlockAetherSapling(new AetherGenSkyrootTree(false))
                .setBlockTextureName(Aether.find("skyroot_sapling"))
        );
        golden_oak_sapling = register(
            "golden_oak_sapling",
            new BlockAetherSapling(new AetherGenOakTree())
                .setBlockTextureName(Aether.find("golden_oak_sapling"))
        );
        enchanter = registerEnchanter("enchanter", new BlockEnchanter());
        freezer = registerMeta("freezer", new BlockFreezer());
        incubator = registerMeta("incubator", new BlockIncubator());
        sun_altar = register("sun_altar", new BlockSunAltar());
        chest_mimic = register("chest_mimic", new BlockMimicChest());
        treasure_chest = register("treasure_chest", new BlockTreasureChest());
        aether_portal
            = register("aether_portal", new BlockAetherPortal()).setCreativeTab(null);
        pillar = register("pillar", new BlockPillar("pillar_top", "pillar_side"));
        pillar_top
            = register("pillar_top", new BlockPillar("pillar_top", "pillar_carved"));
        carved_stone = register(
            "carved_stone",
            new BlockDungeonBase(false).setBlockTextureName(Aether.find("carved_stone"))
        );
        sentry_stone = register(
            "sentry_stone",
            new BlockDungeonBase(true).setBlockTextureName(Aether.find("sentry_stone"))
        );
        angelic_stone = register(
            "angelic_stone",
            new BlockDungeonBase(false).setBlockTextureName(Aether.find("angelic_stone"))
        );
        light_angelic_stone = register(
            "light_angelic_stone",
            new BlockDungeonBase(true).setBlockTextureName(
                Aether.find("light_angelic_stone")
            )
        );
        hellfire_stone = register(
            "hellfire_stone",
            new BlockDungeonBase(false).setBlockTextureName(Aether.find("hellfire_stone"))
        );
        light_hellfire_stone = register(
            "light_hellfire_stone",
            new BlockDungeonBase(true).setBlockTextureName(
                Aether.find("light_hellfire_stone")
            )
        );
        locked_carved_stone = register(
                                  "locked_carved_stone",
                                  new BlockDungeonBase(carved_stone, false)
                                      .setBlockTextureName(Aether.find("carved_stone"))
        )
                                  .setCreativeTab(null);
        locked_sentry_stone = register(
                                  "locked_sentry_stone",
                                  new BlockDungeonBase(sentry_stone, true)
                                      .setBlockTextureName(Aether.find("sentry_stone"))
        )
                                  .setCreativeTab(null);
        locked_angelic_stone = register(
                                   "locked_angelic_stone",
                                   new BlockDungeonBase(angelic_stone, false)
                                       .setBlockTextureName(Aether.find("angelic_stone"))
        )
                                   .setCreativeTab(null);
        locked_light_angelic_stone
            = register(
                  "locked_light_angelic_stone",
                  new BlockDungeonBase(light_angelic_stone, true)
                      .setBlockTextureName(Aether.find("light_angelic_stone"))
            )
                  .setCreativeTab(null);
        locked_hellfire_stone
            = register(
                  "locked_hellfire_stone",
                  new BlockDungeonBase(hellfire_stone, false)
                      .setBlockTextureName(Aether.find("hellfire_stone"))
            )
                  .setCreativeTab(null);
        locked_light_hellfire_stone
            = register(
                  "locked_light_hellfire_stone",
                  new BlockDungeonBase(light_hellfire_stone, true)
                      .setBlockTextureName(Aether.find("light_hellfire_stone"))
            )
                  .setCreativeTab(null);
        carved_trap = register(
                          "carved_trap",
                          new BlockDungeonTrap(carved_stone)
                              .setBlockTextureName(Aether.find("carved_stone"))
        )
                          .setCreativeTab(null);
        angelic_trap = register(
                           "angelic_trap",
                           new BlockDungeonTrap(angelic_stone)
                               .setBlockTextureName(Aether.find("angelic_stone"))
        )
                           .setCreativeTab(null);
        hellfire_trap = register(
                            "hellfire_trap",
                            new BlockDungeonTrap(hellfire_stone)
                                .setBlockTextureName(Aether.find("hellfire_stone"))
        )
                            .setCreativeTab(null);
        skyroot_fence = register("skyroot_fence", new BlockAetherFence());
        skyroot_fence_gate = register("skyroot_fence_gate", new BlockAetherFenceGate());
        carved_wall = register("carved_wall", new BlockAetherWall(carved_stone));
        angelic_wall = register("angelic_wall", new BlockAetherWall(angelic_stone));
        hellfire_wall = register("hellfire_wall", new BlockAetherWall(hellfire_stone));
        holystone_wall = register("holystone_wall", new BlockAetherWall(holystone));
        holystone_brick_wall
            = register("holystone_brick_wall", new BlockAetherWall(holystone_brick));
        mossy_holystone_wall
            = register("mossy_holystone_wall", new BlockAetherWall(mossy_holystone));
        aerogel_wall = registerRarity(
            "aerogel_wall", new BlockAetherWall(aerogel), ItemsAether.aether_loot
        );
        carved_stairs = register("carved_stairs", new BlockAetherStairs(carved_stone));
        angelic_stairs = register("angelic_stairs", new BlockAetherStairs(angelic_stone));
        hellfire_stairs
            = register("hellfire_stairs", new BlockAetherStairs(hellfire_stone));
        skyroot_stairs
            = register("skyroot_stairs", new BlockAetherStairs(skyroot_planks));
        holystone_stairs = register("holystone_stairs", new BlockAetherStairs(holystone));
        holystone_brick_stairs
            = register("holystone_brick_stairs", new BlockAetherStairs(holystone_brick));
        mossy_holystone_stairs
            = register("mossy_holystone_stairs", new BlockAetherStairs(mossy_holystone));
        aerogel_stairs = registerRarity(
            "aerogel_stairs", new BlockAetherStairs(aerogel), ItemsAether.aether_loot
        );
        skyroot_double_slab
            = register(
                  "skyroot_double_slab",
                  new BlockAetherSlab("skyroot_double_slab", true, Material.wood)
                      .setBlockTextureName(Aether.find("skyroot_planks"))
                      .setHardness(2.0F)
                      .setResistance(5.0F)
            )
                  .setCreativeTab(null);
        carved_double_slab
            = register(
                  "carved_double_slab",
                  new BlockAetherSlab("carved_double_slab", true, Material.rock)
                      .setBlockTextureName(Aether.find("carved_stone"))
                      .setHardness(2.0F)
                      .setResistance(10.0F)
            )
                  .setCreativeTab(null);
        angelic_double_slab
            = register(
                  "angelic_double_slab",
                  new BlockAetherSlab("angelic_double_slab", true, Material.rock)
                      .setBlockTextureName(Aether.find("angelic_stone"))
                      .setHardness(2.0F)
                      .setResistance(10.0F)
            )
                  .setCreativeTab(null);
        hellfire_double_slab
            = register(
                  "hellfire_double_slab",
                  new BlockAetherSlab("hellfire_double_slab", true, Material.rock)
                      .setBlockTextureName(Aether.find("hellfire_stone"))
                      .setHardness(2.0F)
                      .setResistance(10.0F)
            )
                  .setCreativeTab(null);
        holystone_double_slab
            = register(
                  "holystone_double_slab",
                  new BlockAetherSlab("holystone_double_slab", true, Material.rock)
                      .setBlockTextureName(Aether.find("holystone"))
                      .setHardness(2.0F)
                      .setResistance(10.0F)
            )
                  .setCreativeTab(null);
        mossy_holystone_double_slab
            = register(
                  "mossy_holystone_double_slab",
                  new BlockAetherSlab("mossy_holystone_double_slab", true, Material.rock)
                      .setBlockTextureName(Aether.find("mossy_holystone"))
                      .setHardness(2.0F)
                      .setResistance(10.0F)
            )
                  .setCreativeTab(null);
        holystone_brick_double_slab
            = register(
                  "holystone_brick_double_slab",
                  new BlockAetherSlab("holystone_brick_double_slab", true, Material.rock)
                      .setBlockTextureName(Aether.find("holystone_brick"))
                      .setHardness(2.0F)
                      .setResistance(10.0F)
            )
                  .setCreativeTab(null);
        aerogel_double_slab
            = register(
                  "aerogel_double_slab",
                  new BlockAetherSlab("aerogel_double_slab", true, Material.rock)
                      .setBlockTextureName(Aether.find("aerogel"))
                      .setHardness(2.0F)
                      .setResistance(2000F)
                      .setLightOpacity(3)
                      .setStepSound(Block.soundTypeMetal)
            )
                  .setCreativeTab(null);
        skyroot_slab = registerSlab(
            "skyroot_slab",
            new BlockAetherSlab("skyroot_slab", false, Material.wood)
                .setBlockTextureName(Aether.find("skyroot_planks"))
                .setHardness(2.0F)
                .setResistance(5.0F),
            skyroot_double_slab
        );
        carved_slab = registerSlab(
            "carved_slab",
            new BlockAetherSlab("carved_slab", false, Material.rock)
                .setBlockTextureName(Aether.find("carved_stone"))
                .setHardness(0.5F)
                .setResistance(10.0F),
            carved_double_slab
        );
        angelic_slab = registerSlab(
            "angelic_slab",
            new BlockAetherSlab("angelic_slab", false, Material.rock)
                .setBlockTextureName(Aether.find("angelic_stone"))
                .setHardness(0.5F)
                .setResistance(10.0F),
            angelic_double_slab
        );
        hellfire_slab = registerSlab(
            "hellfire_slab",
            new BlockAetherSlab("hellfire_slab", false, Material.rock)
                .setBlockTextureName(Aether.find("hellfire_stone"))
                .setHardness(0.5F)
                .setResistance(10.0F),
            hellfire_double_slab
        );
        holystone_slab = registerSlab(
            "holystone_slab",
            new BlockAetherSlab("holystone_slab", false, Material.rock)
                .setBlockTextureName(Aether.find("holystone"))
                .setHardness(0.5F)
                .setResistance(10.0F),
            holystone_double_slab
        );
        mossy_holystone_slab = registerSlab(
            "mossy_holystone_slab",
            new BlockAetherSlab("mossy_holystone_slab", false, Material.rock)
                .setBlockTextureName(Aether.find("mossy_holystone"))
                .setHardness(0.5F)
                .setResistance(10.0F),
            mossy_holystone_double_slab
        );
        holystone_brick_slab = registerSlab(
            "holystone_brick_slab",
            new BlockAetherSlab("holystone_brick_slab", false, Material.rock)
                .setBlockTextureName(Aether.find("holystone_brick"))
                .setHardness(0.5F)
                .setResistance(10.0F),
            holystone_brick_double_slab
        );
        aerogel_slab = registerSlab(
            "aerogel_slab",
            new BlockAetherSlab("aerogel_slab", false, Material.rock)
                .setBlockTextureName(Aether.find("aerogel"))
                .setHardness(0.5F)
                .setResistance(2000F)
                .setLightOpacity(3)
                .setStepSound(Block.soundTypeMetal),
            aerogel_double_slab
        );
        skyroot_bookshelf = register("skyroot_bookshelf", new BlockSkyrootBookshelf());
        skyroot_bed = registerBed(
            "skyroot_bed",
            new BlockSkyrootBed().setBlockTextureName(Aether.find("skyroot_bed"))
        );
    }

    public static void initializeHarvestLevels() {
        BlocksAether.aether_grass.setHarvestLevel("shovel", 0);
        BlocksAether.enchanted_aether_grass.setHarvestLevel("shovel", 0);
        BlocksAether.aether_dirt.setHarvestLevel("shovel", 0);
        BlocksAether.holystone.setHarvestLevel("pickaxe", 0);
        BlocksAether.mossy_holystone.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_brick.setHarvestLevel("pickaxe", 0);
        BlocksAether.aercloud.setHarvestLevel("shovel", 0);
        BlocksAether.quicksoil.setHarvestLevel("shovel", 0);
        BlocksAether.icestone.setHarvestLevel("pickaxe", 1);
        BlocksAether.ambrosium_ore.setHarvestLevel("pickaxe", 0);
        BlocksAether.zanite_ore.setHarvestLevel("pickaxe", 1);
        BlocksAether.gravitite_ore.setHarvestLevel("pickaxe", 2);
        BlocksAether.skyroot_log.setHarvestLevel("axe", 0);
        BlocksAether.skyroot_planks.setHarvestLevel("axe", 0);
        BlocksAether.aerogel.setHarvestLevel("pickaxe", 3);
        BlocksAether.enchanted_gravitite.setHarvestLevel("pickaxe", 2);
        BlocksAether.zanite_block.setHarvestLevel("pickaxe", 1);
        BlocksAether.berry_bush_stem.setHarvestLevel("axe", 0);
        BlocksAether.enchanter.setHarvestLevel("pickaxe", 0);
        BlocksAether.freezer.setHarvestLevel("pickaxe", 0);
        BlocksAether.incubator.setHarvestLevel("pickaxe", 0);
        BlocksAether.carved_stone.setHarvestLevel("pickaxe", 0);
        BlocksAether.angelic_stone.setHarvestLevel("pickaxe", 0);
        BlocksAether.hellfire_stone.setHarvestLevel("pickaxe", 0);
        BlocksAether.chest_mimic.setHarvestLevel("axe", 0);
        BlocksAether.pillar.setHarvestLevel("pickaxe", 0);
        BlocksAether.pillar_top.setHarvestLevel("pickaxe", 0);
        BlocksAether.skyroot_fence.setHarvestLevel("axe", 0);
        BlocksAether.skyroot_fence_gate.setHarvestLevel("axe", 0);
        BlocksAether.carved_wall.setHarvestLevel("pickaxe", 0);
        BlocksAether.angelic_wall.setHarvestLevel("pickaxe", 0);
        BlocksAether.angelic_wall.setHarvestLevel("pickaxe", 0);
        BlocksAether.hellfire_wall.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_wall.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_brick_wall.setHarvestLevel("pickaxe", 0);
        BlocksAether.mossy_holystone_wall.setHarvestLevel("pickaxe", 0);
        BlocksAether.aerogel_wall.setHarvestLevel("pickaxe", 0);
        BlocksAether.carved_stairs.setHarvestLevel("pickaxe", 0);
        BlocksAether.angelic_stairs.setHarvestLevel("pickaxe", 0);
        BlocksAether.hellfire_stairs.setHarvestLevel("pickaxe", 0);
        BlocksAether.skyroot_stairs.setHarvestLevel("axe", 0);
        BlocksAether.mossy_holystone_stairs.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_stairs.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_brick_stairs.setHarvestLevel("pickaxe", 0);
        BlocksAether.aerogel_stairs.setHarvestLevel("pickaxe", 0);
        BlocksAether.skyroot_double_slab.setHarvestLevel("axe", 0);
        BlocksAether.carved_double_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.angelic_double_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.hellfire_double_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_double_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.mossy_holystone_double_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_brick_double_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.aerogel_double_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.skyroot_slab.setHarvestLevel("axe", 0);
        BlocksAether.carved_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.angelic_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.hellfire_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.mossy_holystone_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.holystone_brick_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.aerogel_slab.setHarvestLevel("pickaxe", 0);
        BlocksAether.sun_altar.setHarvestLevel("pickaxe", 0);
        BlocksAether.skyroot_bookshelf.setHarvestLevel("axe", 0);
        BlocksAether.skyroot_bed.setHarvestLevel("axe", 0);
    }

    public static boolean isGood(Block block) {
        return block == Blocks.air || block == aercloud;
    }

    public static Block registerSlab(String name, Block slab1, Block slab2) {
        slab1.setBlockName(name);
        slab1.setCreativeTab(AetherCreativeTabs.blocks);

        GameRegistry.registerBlock(
            slab1,
            ItemAetherSlab.class,
            name,
            (BlockAetherSlab) slab1,
            (BlockAetherSlab) slab2,
            false
        );

        return slab1;
    }

    public static Block register(String name, Block block) {
        block.setBlockName(name);
        block.setCreativeTab(AetherCreativeTabs.blocks);

        GameRegistry.registerBlock(block, name);

        return block;
    }

    public static Block registerRarity(String name, Block block, EnumRarity rarity) {
        block.setBlockName(name);
        block.setCreativeTab(AetherCreativeTabs.blocks);

        GameRegistry.registerBlock(block, ItemBlockRarity.class, name, rarity);

        return block;
    }

    public static Block registerMeta(String name, Block block) {
        block.setBlockName(name);
        block.setCreativeTab(AetherCreativeTabs.blocks);

        GameRegistry.registerBlock(block, ItemBlockMetadata.class, name);

        return block;
    }

    public static Block registerBed(String name, Block block) {
        block.setBlockName(name);

        GameRegistry.registerBlock(block, name);

        return block;
    }

    public static Block registerEnchanter(String name, Block block) {
        block.setBlockName(name);
        block.setCreativeTab(AetherCreativeTabs.blocks);

        GameRegistry.registerBlock(block, ItemBlockEnchanter.class, name);

        return block;
    }
}