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
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.ModernLightBlock;
import net.nhatjs.js_furniture_mod.blockentity.LightBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ModernLightRenderer implements BlockEntityRenderer<LightBlockEntity, ModernLightRenderState> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel modernLightEmissive;

    public ModernLightRenderer(BlockEntityRendererFactory.Context ctx) {
        modernLightEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MODERN_LIGHT_EMISSIVE_ID);
    }

    @Override
    public ModernLightRenderState createRenderState() {
        return new ModernLightRenderState();
    }

    @Override
    public void updateRenderState(LightBlockEntity blockEntity, ModernLightRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        World world = blockEntity.getWorld();
        if (world == null) return;

        state.blockState = blockEntity.getCachedState();
        Direction f = state.blockState.get(ModernLightBlock.FACING);
        state.yaw = 0f;
        state.pitch = 0f;
        switch (f) {
            default -> state.yaw = 0f;
            case SOUTH -> state.yaw = 180f;
            case WEST -> state.yaw = 90f;
            case EAST -> state.yaw = 270f;
            case UP -> state.pitch = 90f;
            case DOWN -> state.pitch = -90f;
        }
        state.powered = blockEntity.isPowered();
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(ModernLightRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        RenderLayer cutout = RenderLayer.getCutout();
        if (state.powered) {
            matrices.push();
            matrices.translate(0.5, 0.5, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(state.pitch));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
            matrices.translate(-0.5, -0.5, -0.5);
            queue.submitBlockStateModel(matrices, cutout, modernLightEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            matrices.pop();
        }
    }
}
