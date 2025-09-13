package net.sage.rice.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.sage.rice.Rice;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.sage.rice.block.ModBlocks;
import net.sage.rice.item.custom.RiceballItem;

public class ModItems {
    public static final Item RICE = registerBlockItem("rice", new Item.Settings().useBlockPrefixedTranslationKey(), ModBlocks.RICE_CROP);
    public static final Item RICEBALL = registerRiceballItem("riceball", new Item.Settings().maxCount(16));
    public static final Item RICE_DUST = registerItem("rice_dust", new Item.Settings());

    private static Item registerBlockItem(String name, Item.Settings itemSettings, Block block) {
        Identifier id = Identifier.of(Rice.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return Registry.register(Registries.ITEM, key, new BlockItem(block, itemSettings.registryKey(key)));
    }

    private static Item registerRiceballItem(String name, Item.Settings itemSettings) {
        Identifier id = Identifier.of(Rice.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return Registry.register(Registries.ITEM, key, new RiceballItem(itemSettings.registryKey(key)));
    }

    private static Item registerItem(String name, Item.Settings itemSettings) {
        Identifier id = Identifier.of(Rice.MOD_ID, name);
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, id);
        return Registry.register(Registries.ITEM, key, new Item(itemSettings.registryKey(key)));
    }

    public static void registerModItems() {
        Rice.LOGGER.info("Registering Mod Items for " + Rice.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(RICE);
            entries.add(RICEBALL);
            entries.add(RICE_DUST);
        });
    }
}