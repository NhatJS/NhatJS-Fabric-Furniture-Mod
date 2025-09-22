package net.nhatjs.js_furniture_mod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.entity.client.ChairBlockEntity;

public class ModEntities {
    public static final EntityType<ChairBlockEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "chair_entity"),
            EntityType.Builder.create(ChairBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.675f).build());

    public static final EntityType<ChairBlockEntity> SOFA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "sofa_entity"),
            EntityType.Builder.create(ChairBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.475f).build());

    public static void registerModEntities() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSFurnitureMod.MOD_ID);
    }
}