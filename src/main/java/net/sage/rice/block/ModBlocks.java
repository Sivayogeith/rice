package net.sage.rice.block;

import net.minecraft.block.piston.PistonBehavior;
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

    public static final Block RICE_CROP = registerBlockWithoutBlockItem("rice_crop",
            AbstractBlock.Settings.create().noCollision()
                    .ticksRandomly().breakInstantly().sounds(BlockSoundGroup.CROP).pistonBehavior(PistonBehavior.DESTROY).mapColor(MapColor.DARK_GREEN));


    private static Block registerBlockWithoutBlockItem(String name, AbstractBlock.Settings blockSettings) {
        Identifier id = Identifier.of(Rice.MOD_ID, name);
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, id);
        return Registry.register(Registries.BLOCK, key, new RiceCropBlock(blockSettings.registryKey(key)));
    }

    public static void registerModBlocks() {
        Rice.LOGGER.info("Registering Mod Blocks for " + Rice.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {

        });
    }
}
