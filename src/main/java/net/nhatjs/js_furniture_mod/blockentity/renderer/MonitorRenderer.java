package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
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
import net.nhatjs.js_furniture_mod.block.MonitorBlock;
import net.nhatjs.js_furniture_mod.blockentity.MonitorBlockEntity;

public class MonitorRenderer implements BlockEntityRenderer<MonitorBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel monitorStandMainLeft;
    private final BlockStateModel monitorStandMainRight;
    private final BlockStateModel monitorStandPart2;
    private final BlockStateModel monitorStandPart3;
    private final BlockStateModel monitorStandPart4;
    private final BlockStateModel monitorStandPart5;
    private final BlockStateModel monitorStandPart6;
    private final BlockStateModel monitorStandPart7;
    private final BlockStateModel monitorStandPart8;
    private final BlockStateModel monitorStandPart9;
    private final BlockStateModel monitorArmPart6a;
    private final BlockStateModel monitorArmPart6b;
    private final BlockStateModel monitorArmPart7a;
    private final BlockStateModel monitorArmPart7b;

    public MonitorRenderer(BlockEntityRendererFactory.Context ctx) {
        monitorStandMainLeft = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_MAIN_LEFT_ID);
        monitorStandMainRight = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_MAIN_RIGHT_ID);
        monitorStandPart2 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_2_ID);
        monitorStandPart3 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_3_ID);
        monitorStandPart4 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_4_ID);
        monitorStandPart5 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_5_ID);
        monitorStandPart6 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_6_ID);
        monitorStandPart7 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_7_ID);
        monitorStandPart8 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_8_ID);
        monitorStandPart9 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_9_ID);
        monitorArmPart6a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_6A_ID);
        monitorArmPart6b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_6B_ID);
        monitorArmPart7a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_7A_ID);
        monitorArmPart7b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_7B_ID);
    }

    @Override
    public void render(MonitorBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d vec3d) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(MonitorBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutout());

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, 0, -0.5);

        matrices.push();
        matrices.translate(0.697, 0.022, 0.754);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-4.1718f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(1.4675f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-28.1664f));
        matrices.translate(-0.5, -0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandMainLeft, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.303, 0.022, 0.754);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-4.1718f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-1.4675f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(28.1664f));
        matrices.translate(-0.5, -0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandMainRight, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.416, 0, 0.88);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(46f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-3.75f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(3.75f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart2, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.584, 0, 0.88);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(46f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(3.75f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-3.75f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart3, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.688, 0.008, 0.7335);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(13.748f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0.9713f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0.2377f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart4, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.312, 0.008, 0.7335);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-13.748f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-0.9713f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0.2377f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart5, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.322, 0, 0.856);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(53.907f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(30.284f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(34.6727f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart6, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.678, 0, 0.856);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-53.907f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-30.284f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(34.6727f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart7, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.32, 0.0015, 0.707);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(40.5985f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-8.9747f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-7.6153f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart8, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.68, 0.0015, 0.707);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-40.5985f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(8.9747f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-7.6153f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart9, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.4469, 0.036, 0.8468);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-2.4127f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-67.4789f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(2.6116f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart6a, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5531, 0.036, 0.8468);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(2.4127f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(67.4789f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(2.6116f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart6b, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.448, 0.03, 0.7835);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(4.3459f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(67.4359f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(5.0757f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart7a, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.552, 0.03, 0.7835);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-4.3459f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-67.4359f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(5.0757f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart7b, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.pop();
    }
}
