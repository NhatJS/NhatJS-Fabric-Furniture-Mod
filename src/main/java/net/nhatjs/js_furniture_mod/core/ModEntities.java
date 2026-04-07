package net.nhatjs.js_furniture_mod.core;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.entity.SeatBlockEntity;

public class ModEntities {
    public static final EntityType<SeatBlockEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "chair_entity"),
            EntityType.Builder.create(SeatBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.675f).build());

    public static final EntityType<SeatBlockEntity> SOFA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "sofa_entity"),
            EntityType.Builder.create(SeatBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.475f).build());

    public static final EntityType<SeatBlockEntity> GAMING_CHAIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "gaming_chair_entity"),
            EntityType.Builder.create(SeatBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.675f).build());

    public static void registerModEntities() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSFurnitureMod.MOD_ID);
    }
}