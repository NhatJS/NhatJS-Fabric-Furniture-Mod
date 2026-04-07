package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.LEDFloorLampBlock;
import net.nhatjs.js_furniture_mod.blockentity.LampBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;

public class LampRenderer implements BlockEntityRenderer<LampBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BakedModel ledFloorLampOnEmissive;
    private final BakedModel ledFloorLampRGBOnEmissive;
    private final BakedModel ledFloorLampRGBOn2Emissive;
    private final BakedModel ledRGBTrianglePanelOnEmissive;
    private final BakedModel studioLightOnEmissive;

    public LampRenderer(BlockEntityRendererFactory.Context ctx) {
        ledFloorLampOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LED_FLOOR_LAMP_ON_EMISSIVE);
        ledFloorLampRGBOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LED_FLOOR_LAMP_RGB_ON_EMISSIVE);
        ledFloorLampRGBOn2Emissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LED_FLOOR_LAMP_RGB_ON_2_EMISSIVE);
        ledRGBTrianglePanelOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LED_RGB_TRIANGLE_PANEL_ON_EMISSIVE);
        studioLightOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.STUDIO_LIGHT_ON_EMISSIVE);
    }

    @Override
    public void render(LampBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockPos pos = entity.getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        Block blockState = (world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock();

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(LEDFloorLampBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
        boolean powered = entity.isPowered();

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, 0, -0.5);
        if (powered) {
            if (blockState == ModBlocks.LED_FLOOR_LAMP) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, ledFloorLampOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.LED_FLOOR_LAMP_RGB_OFF) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, ledFloorLampRGBOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.LED_FLOOR_LAMP_RGB_OFF_2) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, ledFloorLampRGBOn2Emissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.LED_RGB_TRIANGLE_PANEL) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, ledRGBTrianglePanelOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.STUDIO_LIGHT) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, studioLightOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
        }
        matrices.pop();
    }
}
