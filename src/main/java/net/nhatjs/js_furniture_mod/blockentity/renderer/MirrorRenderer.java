package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.BlackMirrorBlock;
import net.nhatjs.js_furniture_mod.blockentity.MirrorBlockEntity;

public class MirrorRenderer implements BlockEntityRenderer<MirrorBlockEntity> {
    private MinecraftClient mc = MinecraftClient.getInstance();
    private BakedModel mirror;

    public MirrorRenderer(BlockEntityRendererFactory.Context ctx) {
        mirror = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIRROR_BLACK);
    }

    @Override
    public void render(MirrorBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(BlackMirrorBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        boolean stand = entity.makeStand();
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, -0.5, -0.5);

        matrices.push();
        if (!stand) {
            bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                    state, mirror, 1, 1, 1, light, overlay);
        }
        else if (stand) {
            matrices.translate(0.5, 0.32, 0.2);
            matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(15));
            matrices.translate(-0.5, -0.5, -0.5);
            bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                    state, mirror, 1, 1, 1, light, overlay);
        }
        matrices.pop();
        matrices.pop();
    }
}
