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
import net.nhatjs.js_furniture_mod.block.DesktopBlock;
import net.nhatjs.js_furniture_mod.blockentity.DesktopBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class DesktopRenderer implements BlockEntityRenderer<DesktopBlockEntity, DesktopRenderState> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel pcEmissive;
    private final BlockStateModel pcRGB1Emissive;

    public DesktopRenderer(BlockEntityRendererFactory.Context ctx) {
        pcEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.PC_EMISSIVE_ID);
        pcRGB1Emissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.PC_RGB1_EMISSIVE_ID);
    }

    @Override
    public DesktopRenderState createRenderState() {
        return new DesktopRenderState();
    }

    @Override
    public void updateRenderState(DesktopBlockEntity be,
                                  DesktopRenderState state,
                                  float tickDelta,
                                  Vec3d cameraPos,
                                  @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(be, state, tickDelta, cameraPos, crumblingOverlay);

        World world = be.getWorld();
        if (world == null) return;

        state.blockState = be.getCachedState();
        state.yaw = switch (state.blockState.get(DesktopBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        state.powered = be.isPowered();
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(DesktopRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        RenderLayer cutout = RenderLayer.getCutout();

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.translate(-0.5, -0.5, -0.5);
        if (state.powered) {
            if (state.blockState.getBlock() == ModBlocks.PC) {
                queue.submitBlockStateModel(matrices, cutout, pcEmissive, 1f, 1f, 1f, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.PC_RGB1_OFF) {
                queue.submitBlockStateModel(matrices, cutout, pcRGB1Emissive, 1f, 1f, 1f, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
        }
        matrices.pop();
    }
}
