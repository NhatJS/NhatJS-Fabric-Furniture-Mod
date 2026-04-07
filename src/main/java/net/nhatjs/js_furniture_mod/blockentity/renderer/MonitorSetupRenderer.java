package net.nhatjs.js_furniture_mod.blockentity.renderer;

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
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.MonitorSetupBlock;
import net.nhatjs.js_furniture_mod.blockentity.MonitorBlockEntity;

public class MonitorSetupRenderer implements BlockEntityRenderer<MonitorBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BakedModel monitorScreenBack1;
    private final BakedModel monitorScreenBack2;
    private final BakedModel monitorScreenBack3;
    private final BakedModel monitorScreenBack4;
    private final BakedModel monitorStandMainCenter;
    private final BakedModel monitorStandMainLeft;
    private final BakedModel monitorStandMainRight;
    private final BakedModel monitorStandPart1;
    private final BakedModel monitorStandPart2;
    private final BakedModel monitorStandPart3;
    private final BakedModel monitorStandPart4;
    private final BakedModel monitorStandPart5;
    private final BakedModel monitorStandPart6;
    private final BakedModel monitorStandPart7;
    private final BakedModel monitorStandPart8;
    private final BakedModel monitorStandPart9;
    private final BakedModel monitorArmPart1;
    private final BakedModel monitorArmPart2;
    private final BakedModel monitorArmPart3;
    private final BakedModel monitorArmPart4a;
    private final BakedModel monitorArmPart4b;
    private final BakedModel monitorArmPart5a;
    private final BakedModel monitorArmPart5b;
    private final BakedModel monitorArmPart6a;
    private final BakedModel monitorArmPart6b;
    private final BakedModel monitorArmPart7a;
    private final BakedModel monitorArmPart7b;
    private final BakedModel monitorArmPart8;
    private final BakedModel monitorArmPart9;
    private final BakedModel monitorSetupOnEmissive;

    public MonitorSetupRenderer(BlockEntityRendererFactory.Context ctx) {
        monitorScreenBack1 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SCREEN_BACK_1);
        monitorScreenBack2 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SCREEN_BACK_2);
        monitorScreenBack3 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SCREEN_BACK_3);
        monitorScreenBack4 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SCREEN_BACK_4);
        monitorStandMainCenter = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_MAIN_CENTER);
        monitorStandMainLeft = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_MAIN_LEFT);
        monitorStandMainRight = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_MAIN_RIGHT);
        monitorStandPart1 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_1);
        monitorStandPart2 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_2);
        monitorStandPart3 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_3);
        monitorStandPart4 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_4);
        monitorStandPart5 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_5);
        monitorStandPart6 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_6);
        monitorStandPart7 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_7);
        monitorStandPart8 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_8);
        monitorStandPart9 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_STAND_PART_9);
        monitorArmPart1 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_1);
        monitorArmPart2 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_2);
        monitorArmPart3 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_3);
        monitorArmPart4a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_4A);
        monitorArmPart4b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_4B);
        monitorArmPart5a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_5A);
        monitorArmPart5b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_5B);
        monitorArmPart6a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_6A);
        monitorArmPart6b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_6B);
        monitorArmPart7a = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_7A);
        monitorArmPart7b = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_7B);
        monitorArmPart8 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_8);
        monitorArmPart9 = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_ARM_PART_9);
        monitorSetupOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MONITOR_SETUP_ON_EMISSIVE);
    }

    @Override
    public void render(MonitorBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(MonitorSetupBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
        boolean powered = entity.isPowered();

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, 0, -0.5);

        matrices.push();
        matrices.translate(0.1076, 0.72, 0.6715);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-13.82865097f));
        matrices.translate(-0.5, -0.5, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorScreenBack1, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.8924, 0.72, 0.6715);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(13.82865097f));
        matrices.translate(-0.5, -0.5, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorScreenBack2, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(-0.0245, 0.69, 0.67);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(34.75f));
        matrices.translate(-0.5, -0.5, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorScreenBack3, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(1.0245, 0.69, 0.67);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-34.75f));
        matrices.translate(-0.5, -0.5, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorScreenBack4, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.532, 0.715);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-4.25f));
        matrices.translate(-0.5, -0.5, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandMainCenter, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.697, 0.022, 0.754);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-4.1718f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(1.4675f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-28.1664f));
        matrices.translate(-0.5, -0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandMainLeft, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.303, 0.022, 0.754);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-4.1718f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-1.4675f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(28.1664f));
        matrices.translate(-0.5, -0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandMainRight, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.37, 0.932);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(44));
        matrices.translate(-0.5, -0.5, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart1, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.416, 0, 0.88);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(46f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-3.75f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(3.75f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart2, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.584, 0, 0.88);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(46f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(3.75f));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-3.75f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart3, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.688, 0.008, 0.7335);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(13.748f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(0.9713f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0.2377f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart4, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.312, 0.008, 0.7335);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-13.748f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-0.9713f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(0.2377f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart5, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.322, 0, 0.856);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(53.907f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(30.284f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(34.6727f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart6, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.678, 0, 0.856);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-53.907f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-30.284f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(34.6727f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart7, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.32, 0.0015, 0.707);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(40.5985f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-8.9747f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-7.6153f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart8, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.68, 0.0015, 0.707);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-40.5985f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(8.9747f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-7.6153f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorStandPart9, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.042, 0.8744);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(1));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart1, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.6665, 0.807);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-29.5f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart2, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.034, 0.75);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(2.9f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart3, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.4666, 0.6442, 0.8548);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-12.5f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart4a, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5334, 0.6442, 0.8548);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(12.5f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart4b, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.4673, 0.6442, 0.807);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(10f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart5a, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5327, 0.6442, 0.807);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-10f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart5b, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.4469, 0.036, 0.8468);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-2.4127f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-67.4789f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(2.6116f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart6a, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5531, 0.036, 0.8468);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(2.4127f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(67.4789f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(2.6116f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart6b, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.448, 0.03, 0.7835);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(4.3459f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(67.4359f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(5.0757f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart7a, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.552, 0.03, 0.7835);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-4.3459f));
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-67.4359f));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(5.0757f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart7b, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.656, 0.8332);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(-9f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart8, 1, 1, 1, light, overlay);
        matrices.pop();

        matrices.push();
        matrices.translate(0.5, 0.3597, 0.7673);
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(3.9603f));
        matrices.translate(-0.5, 0, -0.5);
        bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                state, monitorArmPart9, 1, 1, 1, light, overlay);
        matrices.pop();

        if (powered) {
            matrices.push();
            matrices.translate(0.5, 0, 0.5);
            matrices.translate(-0.5, 0, -0.5);
            bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                    state, monitorSetupOnEmissive, 1, 1, 1,
                    LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            matrices.pop();
        }

        matrices.pop();
    }
}
