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
import net.nhatjs.js_furniture_mod.block.MonitorSetupBlock;
import net.nhatjs.js_furniture_mod.blockentity.MonitorBlockEntity;
import org.jetbrains.annotations.Nullable;

public class MonitorSetupRenderer implements BlockEntityRenderer<MonitorBlockEntity, MonitorSetupRenderState> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel monitorSetupOnEmissive;

    public MonitorSetupRenderer(BlockEntityRendererFactory.Context ctx) {
        monitorSetupOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SETUP_ON_EMISSIVE_ID);
    }

    @Override
    public MonitorSetupRenderState createRenderState() {
        return new MonitorSetupRenderState();
    }

    @Override
    public void updateRenderState(MonitorBlockEntity blockEntity, MonitorSetupRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        World world = blockEntity.getWorld();
        if (world == null) return;

        state.blockState = blockEntity.getCachedState();
        state.yaw = switch (state.blockState.get(MonitorSetupBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        state.powered = blockEntity.isPowered();
        state.light = WorldRenderer.getLightmapCoordinates(world, state.pos);
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(MonitorSetupRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        RenderLayer cutout = RenderLayers.cutout();

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.translate(-0.5, 0, -0.5);
        if (state.powered) {
            matrices.push();
            matrices.translate(0.5, 0, 0.5);
            matrices.translate(-0.5, 0, -0.5);
            queue.submitBlockStateModel(matrices, cutout, monitorSetupOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            matrices.pop();
        }
        matrices.pop();
    }
}
