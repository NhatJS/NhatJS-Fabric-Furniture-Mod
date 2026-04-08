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
import net.nhatjs.js_furniture_mod.block.BlackMirrorBlock;
import net.nhatjs.js_furniture_mod.blockentity.MirrorBlockEntity;
import org.jetbrains.annotations.Nullable;

public class MirrorRenderer implements BlockEntityRenderer<MirrorBlockEntity, MirrorRenderState> {
    private MinecraftClient mc = MinecraftClient.getInstance();
    private BlockStateModel mirror;

    public MirrorRenderer(BlockEntityRendererFactory.Context ctx) {
        mirror = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIRROR_BLACK_ID);
    }

    @Override
    public MirrorRenderState createRenderState() {
        return new MirrorRenderState();
    }

    @Override
    public void updateRenderState(MirrorBlockEntity blockEntity, MirrorRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        World world = blockEntity.getWorld();
        if (world == null) return;

        state.blockState = blockEntity.getCachedState();
        state.yaw = switch (state.blockState.get(BlackMirrorBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        state.stand = blockEntity.makeStand();
        state.light = WorldRenderer.getLightmapCoordinates(world, state.pos);
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(MirrorRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        RenderLayer cutout = RenderLayer.getCutout();

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.translate(-0.5, -0.5, -0.5);

        matrices.push();
        if (!state.stand) {
            queue.submitBlockStateModel(matrices, cutout, mirror, 1, 1, 1, state.light, state.overlay, 0);
        }
        else if (state.stand) {
            matrices.translate(0.5, 0.32, 0.2);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(15));
            matrices.translate(-0.5, -0.5, -0.5);
            queue.submitBlockStateModel(matrices, cutout, mirror, 1, 1, 1, state.light, state.overlay, 0);
        }
        matrices.pop();
        matrices.pop();
    }
}
