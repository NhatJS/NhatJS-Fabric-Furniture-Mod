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
import net.nhatjs.js_furniture_mod.block.LaptopBlock;
import net.nhatjs.js_furniture_mod.block.PortableLaptopStandAddedBlock;
import net.nhatjs.js_furniture_mod.blockentity.LaptopBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class LaptopRenderer implements BlockEntityRenderer<LaptopBlockEntity, LaptopRenderState> {
    private MinecraftClient mc = MinecraftClient.getInstance();
    private BlockStateModel laptopScreen;
    private BlockStateModel laptopScreenPortable;

    public LaptopRenderer(BlockEntityRendererFactory.Context ctx) {
        laptopScreen = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LAPTOP_OPENED_ON_EMISSIVE_ID);
        laptopScreenPortable = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LAPTOP_OPENED_ON_PORTABLE_EMISSIVE_ID);
    }

    @Override
    public LaptopRenderState createRenderState() {
        return new LaptopRenderState();
    }

    @Override
    public void updateRenderState(LaptopBlockEntity blockEntity, LaptopRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        World world = blockEntity.getWorld();
        if (world == null) return;

        state.blockState = blockEntity.getCachedState();
        state.yaw = switch (state.blockState.get(LaptopBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        state.yawPortable = switch (state.blockState.get(PortableLaptopStandAddedBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        state.powered = blockEntity.isPowered();
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(LaptopRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        RenderLayer cutout = RenderLayers.cutout();

        matrices.push();
        if (state.blockState.getBlock() == ModBlocks.LAPTOP) {
            matrices.translate(0.5, 0.5, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
            matrices.translate(-0.5, -0.5, -0.5);
            if (state.powered) {
                queue.submitBlockStateModel(matrices, cutout, laptopScreen, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
        }
        else if (state.blockState.getBlock() == ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND) {
            matrices.translate(0.5, 0.5, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yawPortable));
            matrices.translate(-0.5, -0.5, -0.5);
            if (state.powered) {
                queue.submitBlockStateModel(matrices, cutout, laptopScreenPortable, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
        }
        matrices.pop();

    }
}
