package net.sage.rice.block;

import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.sage.rice.Rice;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sage.rice.block.custom.RiceCropBlock;

public class ModBlocks {
    public static final RegistryKey<Block> RICE_CROP_KEY = getRegistryKey("rice_crop");

    public static final Block RICE_CROP = registerBlockWithoutBlockItem(
            new RiceCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.DARK_GREEN)
                    .registryKey(RICE_CROP_KEY)), RICE_CROP_KEY
    );

    private static RegistryKey<Block> getRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Rice.MOD_ID, name));
    }

    private static Block registerBlockWithoutBlockItem(Block block, RegistryKey<Block> key) {
        return Registry.register(Registries.BLOCK, key, block);
    }

    public static void registerModBlocks() {
        Rice.LOGGER.info("Registering Mod Blocks for " + Rice.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {

        });
    }
}
