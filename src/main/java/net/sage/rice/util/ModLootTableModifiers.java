package net.sage.rice.util;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.sage.rice.item.ModItems;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {
    private static final Identifier SHORT_GRASS_BLOCK_ID
            = Identifier.of("minecraft", "blocks/short_grass");
    private static final Identifier TALL_GRASS_BLOCK_ID
            = Identifier.of("minecraft", "blocks/tall_grass");
    private static final Identifier SHORT_DRY_GRASS_BLOCK_ID
            = Identifier.of("minecraft", "blocks/short_dry_grass");
    private static final Identifier TALL_DRY_GRASS_BLOCK_ID
            = Identifier.of("minecraft", "blocks/tall_dry_grass");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register((key, tableBuilder, source, registry) -> {
            if(SHORT_GRASS_BLOCK_ID.equals(key.getValue()) ||
                    TALL_GRASS_BLOCK_ID.equals(key.getValue()) ||
                    TALL_DRY_GRASS_BLOCK_ID.equals(key.getValue()) ||
                    SHORT_DRY_GRASS_BLOCK_ID.equals(key.getValue())) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(1))
                        .conditionally(RandomChanceLootCondition.builder(0.03f))
                        .with(ItemEntry.builder(ModItems.RICE))
                        .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());

                tableBuilder.pool(poolBuilder.build());
            }

        });
    }
}