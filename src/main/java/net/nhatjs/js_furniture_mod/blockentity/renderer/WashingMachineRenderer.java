package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
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
import net.nhatjs.js_furniture_mod.block.WashingMachineBlock;
import net.nhatjs.js_furniture_mod.blockentity.WashingMachineBlockEntity;

public class WashingMachineRenderer implements BlockEntityRenderer<WashingMachineBlockEntity> {
    private MinecraftClient mc = MinecraftClient.getInstance();
    private BakedModel washingMachineScreen;

    public WashingMachineRenderer(BlockEntityRendererFactory.Context ctx) {
        washingMachineScreen = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WASHING_MACHINE_AI_SCREEN);
    }

    @Override
    public void render(WashingMachineBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(WashingMachineBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        boolean powered = entity.isPowered();
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, -0.5, -0.5);
        if (powered) {
            bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                    state, washingMachineScreen, 1, 1, 1,
                    LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
        }
        matrices.pop();
    }
}
