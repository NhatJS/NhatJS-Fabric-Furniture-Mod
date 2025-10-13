package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.blockentity.client.HologramBlockEntity;

import static java.text.DateFormat.FULL;

@Environment(EnvType.CLIENT)
public class HologramRenderer implements BlockEntityRenderer<HologramBlockEntity> {
    private static final Identifier SCREEN_TEX =
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "textures/block/display_screen.png");

    public HologramRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(HologramBlockEntity be, float tickDelta, MatrixStack ms,
                       VertexConsumerProvider buf, int light, int overlay) {

        ms.push();

        BlockState state = be.getCachedState();
        Direction facing = state.getOrEmpty(Properties.HORIZONTAL_FACING).orElse(Direction.NORTH);

        ms.translate(0.5, 0.5, 0.5);
        ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-facing.asRotation()));
        ms.translate(-0.5, -0.5, -0.5);

        VertexConsumer vc = buf.getBuffer(RenderLayer.getEyes(SCREEN_TEX));

        MatrixStack.Entry entry = ms.peek();
        org.joml.Matrix4f pose = entry.getPositionMatrix();

        float z  = 0.0625f;
        float x0 = 0.1875f, y0 = 0.25f;
        float x1 = 0.8125f, y1 = 0.85f;

        vc.vertex(pose, x0, y0, z).color(255,255,255,255).texture(0f,1f)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(LightmapTextureManager.MAX_LIGHT_COORDINATE)
                .normal(0f, 0f, 1f);

        vc.vertex(pose, x1, y0, z).color(255,255,255,255).texture(1f,1f)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(LightmapTextureManager.MAX_LIGHT_COORDINATE)
                .normal(0f, 0f, 1f);

        vc.vertex(pose, x1, y1, z).color(255,255,255,255).texture(1f,0f)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(LightmapTextureManager.MAX_LIGHT_COORDINATE)
                .normal(0f, 0f, 1f);

        vc.vertex(pose, x0, y1, z).color(255,255,255,255).texture(0f,0f)
                .overlay(OverlayTexture.DEFAULT_UV)
                .light(LightmapTextureManager.MAX_LIGHT_COORDINATE)
                .normal(0f, 0f, 1f);

        ms.pop();

        float zb = 1.0f - 1.0f;
        vc.vertex(pose, x0, y1, zb).color(255,255,255,255).texture(0f,0f)
                .overlay(OverlayTexture.DEFAULT_UV).light(FULL).normal(0f, 0f, -1f);
        vc.vertex(pose, x1, y1, zb).color(255,255,255,255).texture(1f,0f)
                .overlay(OverlayTexture.DEFAULT_UV).light(FULL).normal(0f, 0f, -1f);
        vc.vertex(pose, x1, y0, zb).color(255,255,255,255).texture(1f,1f)
                .overlay(OverlayTexture.DEFAULT_UV).light(FULL).normal(0f, 0f, -1f);
        vc.vertex(pose, x0, y0, zb).color(255,255,255,255).texture(0f,1f)
                .overlay(OverlayTexture.DEFAULT_UV).light(FULL).normal(0f, 0f, -1f);
    }
}