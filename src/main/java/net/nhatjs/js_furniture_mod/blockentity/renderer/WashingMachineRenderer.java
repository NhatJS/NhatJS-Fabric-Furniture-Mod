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
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.WashingMachineBlock;
import net.nhatjs.js_furniture_mod.blockentity.WashingMachineBlockEntity;

public class WashingMachineRenderer implements BlockEntityRenderer<WashingMachineBlockEntity> {
    private MinecraftClient mc = MinecraftClient.getInstance();
    private BlockStateModel washingMachineScreen;

    public WashingMachineRenderer(BlockEntityRendererFactory.Context ctx) {
        washingMachineScreen = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WASHING_MACHINE_AI_SCREEN_ID);
    }

    @Override
    public void render(WashingMachineBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d vec3d) {
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
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutout());

        matrices.push();
        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, -0.5, -0.5);
        if (powered) {
            BlockModelRenderer.render(matrices.peek(), vc, washingMachineScreen, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
        }
        matrices.pop();
    }
}
