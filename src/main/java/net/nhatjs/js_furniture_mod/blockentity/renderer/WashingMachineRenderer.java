package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
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
import net.nhatjs.js_furniture_mod.block.WashingMachineBlock;
import net.nhatjs.js_furniture_mod.blockentity.WashingMachineBlockEntity;
import org.jetbrains.annotations.Nullable;

public class WashingMachineRenderer implements BlockEntityRenderer<WashingMachineBlockEntity, WashingMachineRenderState> {
    private MinecraftClient mc = MinecraftClient.getInstance();
    private BlockStateModel washingMachineScreen;

    public WashingMachineRenderer(BlockEntityRendererFactory.Context ctx) {
        washingMachineScreen = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WASHING_MACHINE_AI_SCREEN_ID);
    }

    @Override
    public WashingMachineRenderState createRenderState() {
        return new WashingMachineRenderState();
    }

    @Override
    public void updateRenderState(WashingMachineBlockEntity blockEntity, WashingMachineRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        World world = blockEntity.getWorld();
        if (world == null) return;

        state.blockState = blockEntity.getCachedState();
        state.yaw = switch (state.blockState.get(WashingMachineBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        state.powered = blockEntity.isPowered();
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(WashingMachineRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.translate(-0.5, -0.5, -0.5);
        if (state.powered) {
            queue.submitBlockStateModel(matrices, RenderLayer.getCutout(), washingMachineScreen, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
        }
        matrices.pop();
    }
}
