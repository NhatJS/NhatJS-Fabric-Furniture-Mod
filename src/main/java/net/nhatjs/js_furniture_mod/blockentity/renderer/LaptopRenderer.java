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
import net.nhatjs.js_furniture_mod.block.LaptopBlock;
import net.nhatjs.js_furniture_mod.block.PortableLaptopStandAddedBlock;
import net.nhatjs.js_furniture_mod.blockentity.LaptopBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;

public class LaptopRenderer implements BlockEntityRenderer<LaptopBlockEntity> {
    private MinecraftClient mc = MinecraftClient.getInstance();
    private BakedModel laptopScreen;
    private BakedModel laptopScreenPortable;

    public LaptopRenderer(BlockEntityRendererFactory.Context ctx) {
        laptopScreen = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LAPTOP_OPENED_ON_EMISSIVE);
        laptopScreenPortable = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.LAPTOP_OPENED_ON_PORTABLE_EMISSIVE);
    }

    @Override
    public void render(LaptopBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockPos pos = entity.getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(LaptopBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        float rotationPortable = switch (state.get(PortableLaptopStandAddedBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        boolean powered = entity.isPowered();
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
        Block blockState = (world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock();

        matrices.push();
        if (blockState == ModBlocks.LAPTOP) {
            matrices.translate(0.5, 0.5, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
            matrices.translate(-0.5, -0.5, -0.5);
            if (powered) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, laptopScreen, 1, 1, 1,
                        LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
        }
        else if (blockState == ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND) {
            matrices.translate(0.5, 0.5, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotationPortable));
            matrices.translate(-0.5, -0.5, -0.5);
            if (powered) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, laptopScreenPortable, 1, 1, 1,
                        LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
        }
        matrices.pop();
    }
}
