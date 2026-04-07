package net.nhatjs.js_furniture_mod.core;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.blockentity.*;

public final class ModBlockEntities {
    public static final BlockEntityType<CeilingFanBlockEntity> CEILING_FAN = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "ceiling_fan"),
            FabricBlockEntityTypeBuilder.create(CeilingFanBlockEntity::new,
                    ModBlocks.CEILING_FAN,
                    ModBlocks.CEILING_FAN_B,
                    ModBlocks.WOOD_LIGHT_CEILING_FAN_BLACK,
                    ModBlocks.WOOD_MEDIUM_CEILING_FAN_BLACK,
                    ModBlocks.BLACK_CEILING_FAN_BLACK,
                    ModBlocks.WHITE_CEILING_FAN_BLACK,
                    ModBlocks.WOOD_LIGHT_CEILING_FAN_WHITE,
                    ModBlocks.WOOD_MEDIUM_CEILING_FAN_WHITE,
                    ModBlocks.BLACK_CEILING_FAN_WHITE,
                    ModBlocks.WHITE_CEILING_FAN_WHITE).build(null));

    public static final BlockEntityType<CoffeeTableBlockEntity> COFFEE_TABLE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "coffee_table"),
            FabricBlockEntityTypeBuilder.create(CoffeeTableBlockEntity::new,
                    ModBlocks.WOOD_COFFEE_TABLE, //will be removed
                    ModBlocks.WOOD_LIGHT_COFFEE_TABLE,
                    ModBlocks.WOOD_MEDIUM_COFFEE_TABLE,
                    ModBlocks.BLACK_COFFEE_TABLE,
                    ModBlocks.WHITE_COFFEE_TABLE).build(null));

    public static final BlockEntityType<WashingMachineBlockEntity> WASHING_MACHINE = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "washing_machine"),
            FabricBlockEntityTypeBuilder.create(WashingMachineBlockEntity::new,
                    ModBlocks.WASHING_MACHINE_AI).build(null));

    public static final BlockEntityType<MirrorBlockEntity> MIRROR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "mirror"),
            FabricBlockEntityTypeBuilder.create(MirrorBlockEntity::new,
                    ModBlocks.BLACK_MIRROR).build(null));

    public static final BlockEntityType<DrawerBlockEntity> DRAWER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "drawer"),
            FabricBlockEntityTypeBuilder.create(DrawerBlockEntity::new,
                    ModBlocks.WOOD_3_DRAWER_DRESSER,
                    ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER,
                    ModBlocks.BLACK_3_DRAWER_DRESSER,
                    ModBlocks.WHITE_3_DRAWER_DRESSER).build(null));

    public static final BlockEntityType<LaptopBlockEntity> LAPTOP = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "laptop"),
            FabricBlockEntityTypeBuilder.create(LaptopBlockEntity::new,
                    ModBlocks.LAPTOP,
                    ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND).build(null));

    public static final BlockEntityType<MonitorBlockEntity> MONITOR = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "monitor"),
            FabricBlockEntityTypeBuilder.create(MonitorBlockEntity::new,
                    ModBlocks.MONITOR,
                    ModBlocks.MONITOR_SETUP).build(null));

    public static final BlockEntityType<LightBlockEntity> LIGHT = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "light"),
            FabricBlockEntityTypeBuilder.create(LightBlockEntity::new,
                    ModBlocks.MODERN_LIGHT).build(null));

    public static final BlockEntityType<DesktopBlockEntity> PC = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "pc"),
            FabricBlockEntityTypeBuilder.create(DesktopBlockEntity::new,
                    ModBlocks.PC,
                    ModBlocks.PC_RGB1_OFF).build(null));

    public static final BlockEntityType<MIDIBlockEntity> MIDI = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "midi"),
            FabricBlockEntityTypeBuilder.create(MIDIBlockEntity::new,
                    ModBlocks.MIDI_STANDALONE_GROOVEBOX,
                    ModBlocks.MIDI_STANDALONE_GROOVEBOX_2,
                    ModBlocks.MIDI_STANDALONE_GROOVEBOX_3,
                    ModBlocks.MIDI_KEYBOARD_CONTROLLER).build(null));

    public static final BlockEntityType<LampBlockEntity> LAMP = Registry.register(Registries.BLOCK_ENTITY_TYPE,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "lamp"),
            FabricBlockEntityTypeBuilder.create(LampBlockEntity::new,
                    ModBlocks.LED_FLOOR_LAMP,
                    ModBlocks.LED_FLOOR_LAMP_RGB_OFF,
                    ModBlocks.LED_FLOOR_LAMP_RGB_OFF_2,
                    ModBlocks.LED_RGB_TRIANGLE_PANEL,
                    ModBlocks.STUDIO_LIGHT).build(null));

    public static void registerModBlockEntities() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Entities for " + NhatJSFurnitureMod.MOD_ID);
    }
}
