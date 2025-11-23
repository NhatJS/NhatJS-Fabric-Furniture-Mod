package net.nhatjs.js_furniture_mod.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.blockentity.client.CeilingFanBlockEntity;
import net.nhatjs.js_furniture_mod.blockentity.client.CoffeeTableBlockEntity;
import net.nhatjs.js_furniture_mod.blockentity.client.HologramBlockEntity;

public final class ModBlockEntities {
    public static final BlockEntityType<HologramBlockEntity> HOLOGRAM = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "hologram"),
            FabricBlockEntityTypeBuilder.create(HologramBlockEntity::new, ModBlocks.HOLOGRAM).build(null));
//1.0.2 update
    public static final BlockEntityType<CeilingFanBlockEntity> CEILING_FAN = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "ceiling_fan"),
            FabricBlockEntityTypeBuilder.create(CeilingFanBlockEntity::new,
                    ModBlocks.CEILING_FAN,
                    ModBlocks.CEILING_FAN_B).build(null));

    public static final BlockEntityType<CoffeeTableBlockEntity> COFFEE_TABLE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "coffee_table"),
            FabricBlockEntityTypeBuilder.create(CoffeeTableBlockEntity::new,
                    ModBlocks.WHITE_COFFEE_TABLE,
                    ModBlocks.WOOD_COFFEE_TABLE,
                    ModBlocks.WOOD_MEDIUM_COFFEE_TABLE).build(null));
//end
    public static void registerModBlockEntities() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSFurnitureMod.MOD_ID);
    }
}
