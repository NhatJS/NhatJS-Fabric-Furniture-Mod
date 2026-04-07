package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
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
import net.nhatjs.js_furniture_mod.block.DesktopBlock;
import net.nhatjs.js_furniture_mod.blockentity.DesktopBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;

public class DesktopRenderer implements BlockEntityRenderer<DesktopBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BakedModel pcEmissive;
    private final BakedModel pcRGB1Emissive;

    public DesktopRenderer(BlockEntityRendererFactory.Context ctx) {
        pcEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.PC_EMISSIVE);
        pcRGB1Emissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.PC_RGB1_EMISSIVE);
    }

    @Override
    public void render(DesktopBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockPos pos = entity.getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(DesktopBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        boolean powered = entity.isPowered();
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutoutMipped());
        Block blockState = (world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock();

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, -0.5, -0.5);
        if (powered) {
            if (blockState == ModBlocks.PC) {
                bmr.render(matrices.peek(), vc, state, pcEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.PC_RGB1_OFF) {
                bmr.render(matrices.peek(), vc, state, pcRGB1Emissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
        }
        matrices.pop();
    }
}
