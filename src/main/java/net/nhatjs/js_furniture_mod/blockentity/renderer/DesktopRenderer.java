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
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.DesktopBlock;
import net.nhatjs.js_furniture_mod.blockentity.DesktopBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;

public class DesktopRenderer implements BlockEntityRenderer<DesktopBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel pcEmissive;
    private final BlockStateModel pcRGB1Emissive;

    public DesktopRenderer(BlockEntityRendererFactory.Context ctx) {
        pcEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.PC_EMISSIVE_ID);
        pcRGB1Emissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.PC_RGB1_EMISSIVE_ID);
    }

    @Override
    public void render(DesktopBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d vec3d) {
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
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutout());
        Block blockState = (world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock();

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, -0.5, -0.5);
        if (powered) {
            if (blockState == ModBlocks.PC) {
                BlockModelRenderer.render(matrices.peek(), vc, pcEmissive, 1f, 1f, 1f, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.PC_RGB1_OFF) {
                BlockModelRenderer.render(matrices.peek(), vc, pcRGB1Emissive, 1f, 1f, 1f, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
        }
        matrices.pop();
    }
}
