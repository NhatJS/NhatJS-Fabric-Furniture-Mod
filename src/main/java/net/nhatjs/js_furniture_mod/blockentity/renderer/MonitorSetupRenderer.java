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
import net.nhatjs.js_furniture_mod.block.MonitorSetupBlock;
import net.nhatjs.js_furniture_mod.blockentity.MonitorBlockEntity;

public class MonitorSetupRenderer implements BlockEntityRenderer<MonitorBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel monitorScreenBack1;
    private final BlockStateModel monitorScreenBack2;
    private final BlockStateModel monitorScreenBack3;
    private final BlockStateModel monitorScreenBack4;
    private final BlockStateModel monitorStandMainCenter;
    private final BlockStateModel monitorStandMainLeft;
    private final BlockStateModel monitorStandMainRight;
    private final BlockStateModel monitorStandPart1;
    private final BlockStateModel monitorStandPart2;
    private final BlockStateModel monitorStandPart3;
    private final BlockStateModel monitorStandPart4;
    private final BlockStateModel monitorStandPart5;
    private final BlockStateModel monitorStandPart6;
    private final BlockStateModel monitorStandPart7;
    private final BlockStateModel monitorStandPart8;
    private final BlockStateModel monitorStandPart9;
    private final BlockStateModel monitorArmPart1;
    private final BlockStateModel monitorArmPart2;
    private final BlockStateModel monitorArmPart3;
    private final BlockStateModel monitorArmPart4a;
    private final BlockStateModel monitorArmPart4b;
    private final BlockStateModel monitorArmPart5a;
    private final BlockStateModel monitorArmPart5b;
    private final BlockStateModel monitorArmPart6a;
    private final BlockStateModel monitorArmPart6b;
    private final BlockStateModel monitorArmPart7a;
    private final BlockStateModel monitorArmPart7b;
    private final BlockStateModel monitorArmPart8;
    private final BlockStateModel monitorArmPart9;
    private final BlockStateModel monitorSetupOnEmissive;

    public MonitorSetupRenderer(BlockEntityRendererFactory.Context ctx) {
        monitorScreenBack1 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SCREEN_BACK_1_ID);
        monitorScreenBack2 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SCREEN_BACK_2_ID);
        monitorScreenBack3 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SCREEN_BACK_3_ID);
        monitorScreenBack4 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SCREEN_BACK_4_ID);
        monitorStandMainCenter = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_MAIN_CENTER_ID);
        monitorStandMainLeft = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_MAIN_LEFT_ID);
        monitorStandMainRight = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_MAIN_RIGHT_ID);
        monitorStandPart1 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_1_ID);
        monitorStandPart2 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_2_ID);
        monitorStandPart3 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_3_ID);
        monitorStandPart4 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_4_ID);
        monitorStandPart5 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_5_ID);
        monitorStandPart6 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_6_ID);
        monitorStandPart7 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_7_ID);
        monitorStandPart8 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_8_ID);
        monitorStandPart9 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_9_ID);
        monitorArmPart1 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_1_ID);
        monitorArmPart2 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_2_ID);
        monitorArmPart3 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_3_ID);
        monitorArmPart4a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_4A_ID);
        monitorArmPart4b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_4B_ID);
        monitorArmPart5a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_5A_ID);
        monitorArmPart5b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_5B_ID);
        monitorArmPart6a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_6A_ID);
        monitorArmPart6b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_6B_ID);
        monitorArmPart7a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_7A_ID);
        monitorArmPart7b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_7B_ID);
        monitorArmPart8 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_8_ID);
        monitorArmPart9 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_9_ID);
        monitorSetupOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SETUP_ON_EMISSIVE_ID);
    }

    @Override
    public void render(MonitorBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d vec3d) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(MonitorSetupBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutout());
        boolean powered = entity.isPowered();

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, 0, -0.5);

        matrices.push();
        matrices.translate(0.1076, 0.72, 0.6715);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-13.82865097f));
        matrices.translate(-0.5, -0.5, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorScreenBack1, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.8924, 0.72, 0.6715);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(13.82865097f));
        matrices.translate(-0.5, -0.5, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorScreenBack2, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(-0.0245, 0.69, 0.67);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(34.75f));
        matrices.translate(-0.5, -0.5, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorScreenBack3, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(1.0245, 0.69, 0.67);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-34.75f));
        matrices.translate(-0.5, -0.5, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorScreenBack4, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.532, 0.715);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-4.25f));
        matrices.translate(-0.5, -0.5, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandMainCenter, 1, 1, 1, light, overlay);
        matrices.pop();

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
        matrices.translate(0.5, 0.37, 0.932);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(44));
        matrices.translate(-0.5, -0.5, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorStandPart1, 1, 1, 1, light, overlay);
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
        matrices.translate(0.5, 0.042, 0.8744);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(1));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart1, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.6665, 0.807);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-29.5f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart2, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.034, 0.75);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(2.9f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart3, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.4666, 0.6442, 0.8548);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-12.5f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart4a, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5334, 0.6442, 0.8548);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(12.5f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart4b, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.4673, 0.6442, 0.807);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(10f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart5a, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5327, 0.6442, 0.807);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-10f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart5b, 1, 1, 1, light, overlay);
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

        matrices.push();
        matrices.translate(0.5, 0.656, 0.8332);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-9f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart8, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.3597, 0.7673);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(3.9603f));
        matrices.translate(-0.5, 0, -0.5);
        BlockModelRenderer.render(matrices.peek(), vc, monitorArmPart9, 1, 1, 1, light, overlay);
        matrices.pop();

        if (powered) {
            matrices.push();
            matrices.translate(0.5, 0, 0.5);
            matrices.translate(-0.5, 0, -0.5);
            BlockModelRenderer.render(matrices.peek(), vc, monitorSetupOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            matrices.pop();
        }

        matrices.pop();
    }
}
