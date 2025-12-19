package net.nhatjs.js_furniture_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.loading.v1.ExtraModelKey;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.SimpleUnbakedExtraModel;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.blockentity.ModBlockEntities;
import net.nhatjs.js_furniture_mod.blockentity.renderer.CeilingFanRenderer;
import net.nhatjs.js_furniture_mod.blockentity.renderer.CoffeeTableRenderer;
import net.nhatjs.js_furniture_mod.entity.ModEntities;
import net.nhatjs.js_furniture_mod.entity.renderer.SeatRenderer;

public class NhatJSFurnitureModClient implements ClientModInitializer {
    public static final Identifier CEILING_FAN_BLADES = Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/ceiling_fan_blades");
    public static final ExtraModelKey<BlockStateModel> CEILING_FAN_BLADES_ID = ExtraModelKey.<BlockStateModel>create(CEILING_FAN_BLADES::toString);
    public static final Identifier CEILING_FAN_BLADES_B = Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/ceiling_fan_blades_b");
    public static final ExtraModelKey<BlockStateModel> CEILING_FAN_BLADES_B_ID = ExtraModelKey.<BlockStateModel>create(CEILING_FAN_BLADES_B::toString);

    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_CHAIR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_CHAIR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MODERN_CHAIR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.SOFA, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_LIGHT_TABLE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_TABLE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_TABLE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_COFFEE_TABLE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_COFFEE_TABLE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_DESK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_DESK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_STANDING_DESK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_STANDING_DESK_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_STANDING_DESK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_STANDING_DESK_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_STANDING_DESK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_STANDING_DESK_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_3_DRAWER_DRESSER, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_3_DRAWER_DRESSER, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_LIGHT_TV_STAND, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_TV_STAND, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_DRAWERS, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_DRAWERS_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_TOP, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KITCHEN_CABINET_TOP_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_STRIPED_WALL, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_MIRROR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.VERTICAL_BLINDS, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.SOCKET, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.TV, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.FLOOR_STANDING_SPEAKER, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MODERN_CLOCK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MODERN_LIGHT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.LED_FLOOR_LAMP, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.LED_FLOOR_LAMP_RGB_OFF, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.LED_RGB_TRIANGLE_PANEL, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.STUDIO_LIGHT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MONITOR_SETUP, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MONITOR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.KEYBOARD, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.COMPUTER_MOUSE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_RGB1_OFF, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.LAPTOP, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PORTABLE_LAPTOP_STAND, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX_3, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.COOKTOP, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.FRIDGE_A, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.FRIDGE_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MODERN_BATHROOM_SINK_STORAGE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MODERN_BATHROOM_MIRROR_SHELF, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.SHOWER, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WASHING_MACHINE_AI, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PLANT_POT, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BOOKS, BlockRenderLayer.CUTOUT_MIPPED);

        BlockRenderLayerMap.putBlock(ModBlocks.PC_TOWER_GLASS, BlockRenderLayer.TRANSLUCENT);

        EntityRendererRegistry.register(ModEntities.CHAIR, SeatRenderer::new);
        EntityRendererRegistry.register(ModEntities.SOFA, SeatRenderer::new);

        //1.0.2 update
        BlockRenderLayerMap.putBlock(ModBlocks.CEILING_FAN, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_GAMING_CHAIR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WHITE_GAMING_CHAIR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockEntityRendererFactories.register(ModBlockEntities.CEILING_FAN, CeilingFanRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.COFFEE_TABLE, CoffeeTableRenderer::new);
        //end

        //1.0.3 update
        BlockRenderLayerMap.putBlock(ModBlocks.TOILET, BlockRenderLayer.CUTOUT_MIPPED);
        //end

        //1.0.4 update
        BlockRenderLayerMap.putBlock(ModBlocks.CEILING_FAN_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.BLACK_SOFA, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.MIDI_KEYBOARD_CONTROLLER, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_TV_STAND, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_CHAIR, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_COFFEE_TABLE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_DESK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_STANDING_DESK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_STANDING_DESK_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_STRIPED_WALL, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_TABLE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B, BlockRenderLayer.CUTOUT_MIPPED);
        //end

        //1.0.5 update
        BlockRenderLayerMap.putBlock(ModBlocks.COMPUTER_CASE, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_1, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_2, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_3, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_4, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_5, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_6, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_7, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_8, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_9, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_10, BlockRenderLayer.CUTOUT_MIPPED);
        BlockRenderLayerMap.putBlock(ModBlocks.PC_ADDED_11, BlockRenderLayer.CUTOUT_MIPPED);
        //end

        ModelLoadingPlugin.register(ctx -> {
            ctx.addModel(CEILING_FAN_BLADES_ID, SimpleUnbakedExtraModel.blockStateModel(CEILING_FAN_BLADES));
            ctx.addModel(CEILING_FAN_BLADES_B_ID, SimpleUnbakedExtraModel.blockStateModel(CEILING_FAN_BLADES_B));
        });
    }
}
