package net.nhatjs.js_furniture_mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.loading.v1.ExtraModelKey;
import net.fabricmc.fabric.api.client.model.loading.v1.ModelLoadingPlugin;
import net.fabricmc.fabric.api.client.model.loading.v1.SimpleUnbakedExtraModel;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
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
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_CHAIR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_CHAIR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_CHAIR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOFA, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_TABLE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_TABLE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_TABLE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_COFFEE_TABLE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_COFFEE_TABLE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_DESK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_DESK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_STANDING_DESK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_STANDING_DESK_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_STANDING_DESK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_STANDING_DESK_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_STANDING_DESK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_STANDING_DESK_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_3_DRAWER_DRESSER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_3_DRAWER_DRESSER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_LIGHT_TV_STAND, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_TV_STAND, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_BOTTOM_B_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_DRAWERS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_DRAWERS_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KITCHEN_CABINET_TOP_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_STRIPED_WALL, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_MIRROR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VERTICAL_BLINDS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SOCKET, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TV, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FLOOR_STANDING_SPEAKER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_CLOCK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_LIGHT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LED_FLOOR_LAMP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LED_FLOOR_LAMP_RGB_OFF, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LED_RGB_TRIANGLE_PANEL, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STUDIO_LIGHT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR_SETUP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MONITOR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.KEYBOARD, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COMPUTER_MOUSE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_RGB1_OFF, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAPTOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PORTABLE_LAPTOP_STAND, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDI_STANDALONE_GROOVEBOX_3, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.COOKTOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRIDGE_A, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FRIDGE_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_BATHROOM_SINK_STORAGE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MODERN_BATHROOM_MIRROR_SHELF, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SHOWER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WASHING_MACHINE_AI, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PLANT_POT, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BOOKS, RenderLayer.getCutoutMipped());

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PC_TOWER_GLASS, RenderLayer.getTranslucent());

        EntityRendererRegistry.register(ModEntities.CHAIR, SeatRenderer::new);
        EntityRendererRegistry.register(ModEntities.SOFA, SeatRenderer::new);

        //1.0.2 update
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CEILING_FAN, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_GAMING_CHAIR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WHITE_GAMING_CHAIR, RenderLayer.getCutoutMipped());
        BlockEntityRendererFactories.register(ModBlockEntities.CEILING_FAN, CeilingFanRenderer::new);
        BlockEntityRendererFactories.register(ModBlockEntities.COFFEE_TABLE, CoffeeTableRenderer::new);
        //end

        //1.0.3 update
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOILET, RenderLayer.getCutoutMipped());
        //end

        //1.0.4 update
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CEILING_FAN_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.BLACK_SOFA, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MIDI_KEYBOARD_CONTROLLER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_TV_STAND, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_CHAIR, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_COFFEE_TABLE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_DESK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_STANDING_DESK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_STANDING_DESK_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_STRIPED_WALL, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_TABLE, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP, RenderLayer.getCutoutMipped());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B, RenderLayer.getCutoutMipped());
        //end

        ModelLoadingPlugin.register(ctx -> {
            ctx.addModel(CEILING_FAN_BLADES_ID, SimpleUnbakedExtraModel.blockStateModel(CEILING_FAN_BLADES));
            ctx.addModel(CEILING_FAN_BLADES_B_ID, SimpleUnbakedExtraModel.blockStateModel(CEILING_FAN_BLADES_B));
        });
    }
}
