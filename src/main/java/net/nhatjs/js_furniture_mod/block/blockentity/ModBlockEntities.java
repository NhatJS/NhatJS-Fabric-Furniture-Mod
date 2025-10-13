package net.nhatjs.js_furniture_mod.block.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.block.blockentity.client.HologramBlockEntity;

public final class ModBlockEntities {
    public static final BlockEntityType<HologramBlockEntity> HOLOGRAM = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "hologram"),
            FabricBlockEntityTypeBuilder.create(HologramBlockEntity::new, ModBlocks.HOLOGRAM).build(null));

    public static void registerModBlockEntities() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSFurnitureMod.MOD_ID);
    }
}
