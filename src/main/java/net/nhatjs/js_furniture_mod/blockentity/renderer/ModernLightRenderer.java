package net.nhatjs.js_furniture_mod.blockentity.renderer;

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
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.ModernLightBlock;
import net.nhatjs.js_furniture_mod.blockentity.LightBlockEntity;

public class ModernLightRenderer implements BlockEntityRenderer<LightBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BakedModel modernLightEmissive;

    public ModernLightRenderer(BlockEntityRendererFactory.Context ctx) {
        modernLightEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MODERN_LIGHT_EMISSIVE);
    }

    @Override
    public void render(LightBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockState state = entity.getCachedState();
        Direction f = state.get(ModernLightBlock.FACING);
        float yaw = 0f;
        float pitch = 0f;
        switch (f) {
            default -> yaw = 0f;
            case SOUTH -> yaw = 180f;
            case WEST -> yaw = 90f;
            case EAST -> yaw = 270f;
            case UP -> pitch = 90f;
            case DOWN -> pitch = -90f;
        }
        boolean powered = entity.isPowered();
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutoutMipped());

        if (powered) {

            matrices.push();
            matrices.translate(0.5, 0.5, 0.5);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(pitch));
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(yaw));
            matrices.translate(-0.5, -0.5, -0.5);
            bmr.render(matrices.peek(), vc, state, modernLightEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            matrices.pop();
        }
    }
}
