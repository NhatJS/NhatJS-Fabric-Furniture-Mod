package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.blockentity.client.DesktopBlockEntity;

@Environment(EnvType.CLIENT)
public class DesktopRenderer implements BlockEntityRenderer<DesktopBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockRenderManager brm = mc.getBlockRenderManager();

    public DesktopRenderer(BlockEntityRendererFactory.Context ctx) {}

    public void render(DesktopBlockEntity be, float tickDelta,
                       MatrixStack ms, VertexConsumerProvider vcp, int light, int overlay) {
        if (be.getWorld() == null) return;
        BlockState state = be.getCachedState();

        brm.renderBlock(be.getCachedState(), be.getPos(), be.getWorld(), ms,
                vcp.getBuffer(RenderLayer.getCutoutMipped()), false, be.getWorld().getRandom());


        ms.push();
        if (state.contains(HorizontalFacingBlock.FACING))
        {
            float rotY = switch (state.get(HorizontalFacingBlock.FACING)) {
                default -> 0f;
                case SOUTH -> 180f;
                case WEST -> 90f;
                case EAST -> 270f;
            };
            ms.translate(0.5, 0.5, 0.5);
            ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotY));
            ms.translate(-0.5, -0.5, -0.5);
        }
        renderGlassModel(ms, vcp, light, overlay);
        ms.pop();
    }

    private void renderGlassModel(MatrixStack ms, VertexConsumerProvider vcp, int light, int overlay) {
        MinecraftClient mc = MinecraftClient.getInstance();
        VertexConsumer vc = vcp.getBuffer(TexturedRenderLayers.getEntityCutout());

        BakedModel blades = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.PC_TOWER_GLASS_ID);
        mc.getBlockRenderManager().getModelRenderer().render(ms.peek(), vc, null,
                blades, 1.0f, 1.0f, 1.0f, light, overlay);
    }
}