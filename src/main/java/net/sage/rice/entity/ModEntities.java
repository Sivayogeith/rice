package net.sage.rice.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.sage.rice.Rice;
import net.sage.rice.entity.custom.RiceballEntity;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> RICEBALL_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(Rice.MOD_ID, "riceball"));
    public static final EntityType<RiceballEntity> RICEBALL = Registry.register(Registries.ENTITY_TYPE, RICEBALL_KEY,
            EntityType.Builder.<RiceballEntity>create(RiceballEntity::new, SpawnGroup.MISC)
                    .dropsNothing()
                    .dimensions(0.25F, 0.25F)
                    .maxTrackingRange(4)
                    .trackingTickInterval(10)
                    .build(RICEBALL_KEY)
    );

    public static void registerModEntities() {
        Rice.LOGGER.info("Registering Mod Entities for: " + Rice.MOD_ID);
    }
}
