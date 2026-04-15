package net.nhatjs.js_furniture_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.blockentity.renderer.*;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.core.ModBlockEntities;
import net.nhatjs.js_furniture_mod.core.ModEntities;
import net.nhatjs.js_furniture_mod.entity.renderer.SeatRenderer;

public class NhatJSFurnitureModClient implements ClientModInitializer {
    public static final Identifier CEILING_FAN_BLADES_ID = Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/ceiling_fan_blades");
    public static final Identifier CEILING_FAN_BLADES_B_ID = Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/ceiling_fan_blades_b");
    public static final Identifier WASHING_MACHINE_AI_SCREEN = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/washing_machine_ai_screen");
    public static final Identifier MIRROR_BLACK = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/mirror_black");
    public static final Identifier WOOD_LIGHT_CEILING_FAN_BLADES_BLACK = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/wood_light_ceiling_fan_blades_black");
    public static final Identifier WOOD_MEDIUM_CEILING_FAN_BLADES_BLACK = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/wood_medium_ceiling_fan_blades_black");
    public static final Identifier BLACK_CEILING_FAN_BLADES_BLACK = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/black_ceiling_fan_blades_black");
    public static final Identifier WHITE_CEILING_FAN_BLADES_BLACK = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/white_ceiling_fan_blades_black");
    public static final Identifier WOOD_LIGHT_CEILING_FAN_BLADES_WHITE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/wood_light_ceiling_fan_blades_white");
    public static final Identifier WOOD_MEDIUM_CEILING_FAN_BLADES_WHITE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/wood_medium_ceiling_fan_blades_white");
    public static final Identifier BLACK_CEILING_FAN_BLADES_WHITE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/black_ceiling_fan_blades_white");
    public static final Identifier WHITE_CEILING_FAN_BLADES_WHITE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/white_ceiling_fan_blades_white");
    public static final Identifier LAPTOP_OPENED_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/laptop_opened_on_emissive");
    public static final Identifier LAPTOP_OPENED_ON_PORTABLE_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/laptop_opened_on_portable_emissive");
    public static final Identifier MONITOR_SETUP_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_setup_on_emissive");
    public static final Identifier MODERN_LIGHT_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/modern_light_emissive");
    public static final Identifier PC_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/pc_emissive");
    public static final Identifier PC_RGB1_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/pc_rgb1_emissive");
    public static final Identifier MIDI_STANDALONE_GROOVEBOX_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/midi_standalone_groovebox_on_emissive");
    public static final Identifier MIDI_STANDALONE_GROOVEBOX_2_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/midi_standalone_groovebox_2_on_emissive");
    public static final Identifier MIDI_STANDALONE_GROOVEBOX_3_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/midi_standalone_groovebox_3_on_emissive");
    public static final Identifier MIDI_KEYBOARD_CONTROLLER_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/midi_keyboard_controller_on_emissive");
    public static final Identifier LED_FLOOR_LAMP_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/led_floor_lamp_on_emissive");
    public static final Identifier LED_FLOOR_LAMP_RGB_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/led_floor_lamp_rgb_on_emissive");
    public static final Identifier LED_FLOOR_LAMP_RGB_ON_2_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/led_floor_lamp_rgb_on_2_emissive");
    public static final Identifier LED_RGB_TRIANGLE_PANEL_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/led_rgb_triangle_panel_on_emissive");
    public static final Identifier STUDIO_LIGHT_ON_EMISSIVE = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/studio_light_on_emissive");

    public static final Identifier MONITOR_SCREEN_BACK_1 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_screen_back_1");
    public static final Identifier MONITOR_SCREEN_BACK_2 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_screen_back_2");
    public static final Identifier MONITOR_SCREEN_BACK_3 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_screen_back_3");
    public static final Identifier MONITOR_SCREEN_BACK_4 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_screen_back_4");
    public static final Identifier MONITOR_STAND_MAIN_CENTER = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_main_center");
    public static final Identifier MONITOR_STAND_MAIN_LEFT = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_main_left");
    public static final Identifier MONITOR_STAND_MAIN_RIGHT = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_main_right");
    public static final Identifier MONITOR_STAND_PART_1 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_1");
    public static final Identifier MONITOR_STAND_PART_2 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_2");
    public static final Identifier MONITOR_STAND_PART_3 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_3");
    public static final Identifier MONITOR_STAND_PART_4 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_4");
    public static final Identifier MONITOR_STAND_PART_5 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_5");
    public static final Identifier MONITOR_STAND_PART_6 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_6");
    public static final Identifier MONITOR_STAND_PART_7 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_7");
    public static final Identifier MONITOR_STAND_PART_8 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_8");
    public static final Identifier MONITOR_STAND_PART_9 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_stand_part_9");
    public static final Identifier MONITOR_ARM_PART_1 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_1");
    public static final Identifier MONITOR_ARM_PART_2 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_2");
    public static final Identifier MONITOR_ARM_PART_3 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_3");
    public static final Identifier MONITOR_ARM_PART_4A = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_4a");
    public static final Identifier MONITOR_ARM_PART_4B = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_4b");
    public static final Identifier MONITOR_ARM_PART_5A = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_5a");
    public static final Identifier MONITOR_ARM_PART_5B = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_5b");
    public static final Identifier MONITOR_ARM_PART_6A = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_6a");
    public static final Identifier MONITOR_ARM_PART_6B = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_6b");
    public static final Identifier MONITOR_ARM_PART_7A = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_7a");
    public static final Identifier MONITOR_ARM_PART_7B = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_7b");
    public static final Identifier MONITOR_ARM_PART_8 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_8");
    public static final Identifier MONITOR_ARM_PART_9 = Identifier.of(NhatJSFurnitureMod.MOD_ID, "extra/monitor_parts/monitor_arm_part_9");

    @Override
    public void onInitializeClient() {
        RenderLayer cutout = RenderLayer.getCutout();
        
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_CHAIR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CHAIR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_CHAIR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_COFFEE_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_COFFEE_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_STANDING_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_STANDING_DESK_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_STANDING_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_STANDING_DESK_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_STANDING_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_STANDING_DESK_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_3_DRAWER_DRESSER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_3_DRAWER_DRESSER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_TV_STAND, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_TV_STAND, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_2, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B_2, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_DRAWERS, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_DRAWERS_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_TOP, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_TOP_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_MIRROR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERTICAL_BLINDS, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOCKET, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TV, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOOR_STANDING_SPEAKER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_CLOCK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_LIGHT, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LED_FLOOR_LAMP, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LED_FLOOR_LAMP_RGB_OFF, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LED_RGB_TRIANGLE_PANEL, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STUDIO_LIGHT, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR_SETUP, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEYBOARD, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COMPUTER_MOUSE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_RGB1_OFF, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAPTOP, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PORTABLE_LAPTOP_STAND, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX_2, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX_3, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COOKTOP, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRIDGE_A, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRIDGE_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_BATHROOM_SINK_STORAGE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_BATHROOM_MIRROR_SHELF, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHOWER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WASHING_MACHINE_AI, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLANT_POT, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOOKS, cutout);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_TOWER_GLASS, RenderLayer.getTranslucent());

        EntityRendererRegistry.register(ModEntities.CHAIR, SeatRenderer::new);
        EntityRendererRegistry.register(ModEntities.SOFA, SeatRenderer::new);
        EntityRendererRegistry.register(ModEntities.GAMING_CHAIR, SeatRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_GAMING_CHAIR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_GAMING_CHAIR, cutout);
        BlockEntityRendererFactories.register(ModBlockEntities.CEILING_FAN, CeilingFanRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.COFFEE_TABLE, CoffeeTableRenderer::new);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOILET, cutout);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_SOFA, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDI_KEYBOARD_CONTROLLER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_TV_STAND, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_CHAIR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_COFFEE_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_STANDING_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_STANDING_DESK_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B, cutout);

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COMPUTER_CASE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_1, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_2, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_3, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_4, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_5, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_6, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_7, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_8, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_9, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_10, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_ADDED_11, cutout);

        BlockEntityRendererFactories.register(ModBlockEntities.WASHING_MACHINE, WashingMachineRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MIRROR, MirrorRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.LAPTOP, LaptopRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MONITOR, MonitorRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MONITOR, MonitorSetupRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.LIGHT, ModernLightRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.PC, DesktopRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.MIDI, MIDIRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.LAMP, LampRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_CHAIR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_COFFEE_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_3_DRAWER_DRESSER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_DRAWER_SINGLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_DRAWER_SINGLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_DRAWER_SINGLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_DRAWER_SINGLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_DESK_COLUMN, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_DESK_COLUMN, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_VERTICAL_BLINDS, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_CEILING_FAN_BLACK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_CEILING_FAN_BLACK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_CEILING_FAN_BLACK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CEILING_FAN_BLACK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_CEILING_FAN_WHITE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_CEILING_FAN_WHITE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_CEILING_FAN_WHITE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CEILING_FAN_WHITE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_SOFA, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_COMPARTMENT_STORAGE_CABINET, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_COMPARTMENT_STORAGE_CABINET, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_COMPARTMENT_STORAGE_CABINET, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_COMPARTMENT_STORAGE_CABINET, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_VERTICAL_BLINDS, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_3_DRAWER_DRESSER, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_CHAIR, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_COFFEE_TABLE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_STANDING_DESK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_STANDING_DESK_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_WITH_SINK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2_EXTRA, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_WITH_SINK, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_2, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_DRAWERS, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_DRAWERS_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_TOP, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_TOP_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_COMPUTER_MOUSE, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_KEYBOARD, cutout);

        ModelLoadingPlugin.register(ctx -> ctx.addModels(
                CEILING_FAN_BLADES_ID,
                CEILING_FAN_BLADES_B_ID,
                WASHING_MACHINE_AI_SCREEN,
                MIRROR_BLACK,
                WOOD_LIGHT_CEILING_FAN_BLADES_BLACK,
                WOOD_MEDIUM_CEILING_FAN_BLADES_BLACK,
                BLACK_CEILING_FAN_BLADES_BLACK,
                WHITE_CEILING_FAN_BLADES_BLACK,
                WOOD_LIGHT_CEILING_FAN_BLADES_WHITE,
                WOOD_MEDIUM_CEILING_FAN_BLADES_WHITE,
                BLACK_CEILING_FAN_BLADES_WHITE,
                WHITE_CEILING_FAN_BLADES_WHITE,
                LAPTOP_OPENED_ON_EMISSIVE,
                LAPTOP_OPENED_ON_PORTABLE_EMISSIVE,
                MONITOR_SETUP_ON_EMISSIVE,
                MODERN_LIGHT_EMISSIVE,
                PC_EMISSIVE,
                PC_RGB1_EMISSIVE,
                MIDI_STANDALONE_GROOVEBOX_ON_EMISSIVE,
                MIDI_STANDALONE_GROOVEBOX_2_ON_EMISSIVE,
                MIDI_STANDALONE_GROOVEBOX_3_ON_EMISSIVE,
                MIDI_KEYBOARD_CONTROLLER_ON_EMISSIVE,
                LED_FLOOR_LAMP_ON_EMISSIVE,
                LED_FLOOR_LAMP_RGB_ON_EMISSIVE,
                LED_FLOOR_LAMP_RGB_ON_2_EMISSIVE,
                LED_RGB_TRIANGLE_PANEL_ON_EMISSIVE,
                STUDIO_LIGHT_ON_EMISSIVE,

                MONITOR_SCREEN_BACK_1,
                MONITOR_SCREEN_BACK_2,
                MONITOR_SCREEN_BACK_3,
                MONITOR_SCREEN_BACK_4,
                MONITOR_STAND_MAIN_CENTER,
                MONITOR_STAND_MAIN_LEFT,
                MONITOR_STAND_MAIN_RIGHT,
                MONITOR_STAND_PART_1,
                MONITOR_STAND_PART_2,
                MONITOR_STAND_PART_3,
                MONITOR_STAND_PART_4,
                MONITOR_STAND_PART_5,
                MONITOR_STAND_PART_6,
                MONITOR_STAND_PART_7,
                MONITOR_STAND_PART_8,
                MONITOR_STAND_PART_9,
                MONITOR_ARM_PART_1,
                MONITOR_ARM_PART_2,
                MONITOR_ARM_PART_3,
                MONITOR_ARM_PART_4A,
                MONITOR_ARM_PART_4B,
                MONITOR_ARM_PART_5A,
                MONITOR_ARM_PART_5B,
                MONITOR_ARM_PART_6A,
                MONITOR_ARM_PART_6B,
                MONITOR_ARM_PART_7A,
                MONITOR_ARM_PART_7B,
                MONITOR_ARM_PART_8,
                MONITOR_ARM_PART_9));

        //unused from now
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CEILING_FAN, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CEILING_FAN_B, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOFA, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_STRIPED_WALL, cutout);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_STRIPED_WALL, cutout);
    }
}
