package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.LEDFloorLampBlock;
import net.nhatjs.js_furniture_mod.blockentity.LampBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class LampRenderer implements BlockEntityRenderer<LampBlockEntity, LampRenderState> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel ledFloorLampOnEmissive;
    private final BlockStateModel ledFloorLampRGBOnEmissive;
    private final BlockStateModel ledFloorLampRGBOn2Emissive;
    private final BlockStateModel ledRGBTrianglePanelOnEmissive;
    private final BlockStateModel studioLightOnEmissive;

    public LampRenderer(BlockEntityRendererFactory.Context ctx) {
        ledFloorLampOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LED_FLOOR_LAMP_ON_EMISSIVE_ID);
        ledFloorLampRGBOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LED_FLOOR_LAMP_RGB_ON_EMISSIVE_ID);
        ledFloorLampRGBOn2Emissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LED_FLOOR_LAMP_RGB_ON_2_EMISSIVE_ID);
        ledRGBTrianglePanelOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LED_RGB_TRIANGLE_PANEL_ON_EMISSIVE_ID);
        studioLightOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.STUDIO_LIGHT_ON_EMISSIVE_ID);
    }

    @Override
    public LampRenderState createRenderState() {
        return new LampRenderState();
    }

    @Override
    public void updateRenderState(LampBlockEntity blockEntity, LampRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        World world = blockEntity.getWorld();
        if (world == null) return;

        state.blockState = blockEntity.getCachedState();
        state.yaw = switch (state.blockState.get(LEDFloorLampBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        state.powered = blockEntity.isPowered();
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(LampRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        RenderLayer cutout = RenderLayers.cutout();
        
        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.translate(-0.5, 0, -0.5);
        if (state.powered) {
            if (state.blockState.getBlock() == ModBlocks.LED_FLOOR_LAMP) {
                queue.submitBlockStateModel(matrices, cutout, ledFloorLampOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.LED_FLOOR_LAMP_RGB_OFF) {
                queue.submitBlockStateModel(matrices, cutout, ledFloorLampRGBOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.LED_FLOOR_LAMP_RGB_OFF_2) {
                queue.submitBlockStateModel(matrices, cutout, ledFloorLampRGBOn2Emissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.LED_RGB_TRIANGLE_PANEL) {
                queue.submitBlockStateModel(matrices, cutout, ledRGBTrianglePanelOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.STUDIO_LIGHT) {
                queue.submitBlockStateModel(matrices, cutout, studioLightOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
        }
        matrices.pop();
    }
}
