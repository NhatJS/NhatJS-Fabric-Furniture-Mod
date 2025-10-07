package net.nhatjs.js_furniture_mod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.entity.client.ChairBlockEntity;

public class ModEntities {
    private static final RegistryKey<EntityType<?>> CHAIR_KEY =
            RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(NhatJSFurnitureMod.MOD_ID, "chair_key"));

    public static final EntityType<ChairBlockEntity> CHAIR = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "chair_entity"),
            EntityType.Builder.create(ChairBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.675f).build(CHAIR_KEY));

    public static final EntityType<ChairBlockEntity> SOFA = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "sofa_entity"),
            EntityType.Builder.create(ChairBlockEntity::new, SpawnGroup.MISC)
                    .dimensions(0.5f, 0.475f).build(CHAIR_KEY));

    public static void registerModEntities() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSFurnitureMod.MOD_ID);
    }
}