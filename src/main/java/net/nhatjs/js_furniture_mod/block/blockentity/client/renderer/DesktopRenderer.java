package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.block.blockentity.client.DesktopBlockEntity;

@Environment(EnvType.CLIENT)
public class DesktopRenderer implements BlockEntityRenderer<DesktopBlockEntity> {
    private final ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

    public DesktopRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(DesktopBlockEntity be, float tickDelta, MatrixStack ms,
                       VertexConsumerProvider vcp, int light, int overlay) {
        if (be.getWorld() == null) return;

        // Vẽ base model (case JSON lo)
        renderGlassPanel(ms, vcp, light, overlay);
    }

    private void renderGlassPanel(MatrixStack ms, VertexConsumerProvider vcp, int light, int overlay) {
        ms.push();
        ms.translate(0.82, 0.50, 0.50); // gắn kính bên phải
        ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
        ms.scale(1.0f, 1.0f, 0.02f); // mỏng

        ItemStack glass = new ItemStack(ModBlocks.PC);
        itemRenderer.renderItem(glass, ModelTransformationMode.FIXED, light, overlay, ms, vcp, null, 0);
        ms.pop();
    }
}