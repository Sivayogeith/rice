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
    public static final RegistryKey<Item> RICE_KEY = getRegistryKey("rice");
    public static final RegistryKey<Item> RICEBALL_KEY = getRegistryKey("riceball");
    public static final RegistryKey<Item> RICE_DUST_KEY = getRegistryKey("rice_dust");

    public static final Item RICE = registerItem(new BlockItem(ModBlocks.RICE_CROP, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RICE_KEY)), RICE_KEY);
    public static final Item RICEBALL = registerItem(new RiceballItem(new Item.Settings().maxCount(16).registryKey(RICEBALL_KEY)), RICEBALL_KEY);
    public static final Item RICE_DUST = registerItem(new Item.Settings(), RICE_DUST_KEY);

    private static RegistryKey<Item> getRegistryKey(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Rice.MOD_ID, name));
    }

    private static Item registerItem(Item.Settings itemSettings, RegistryKey<Item> registryKey) {
        return Registry.register(Registries.ITEM, registryKey, new Item(itemSettings.registryKey(registryKey)));
    }

    private static Item registerItem(Item item, RegistryKey<Item> registryKey) {
        return Registry.register(Registries.ITEM, registryKey, item);
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