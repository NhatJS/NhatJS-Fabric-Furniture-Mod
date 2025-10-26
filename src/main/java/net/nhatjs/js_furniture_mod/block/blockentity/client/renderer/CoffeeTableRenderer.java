package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.nhatjs.js_furniture_mod.block.CoffeeTableBlock;
import net.nhatjs.js_furniture_mod.block.blockentity.client.CoffeeTableBlockEntity;

import java.util.HashMap;
import java.util.Map;

@Environment(EnvType.CLIENT)
public class CoffeeTableRenderer implements BlockEntityRenderer<CoffeeTableBlockEntity> {

    public CoffeeTableRenderer(BlockEntityRendererFactory.Context ctx) {}

    private final Map<BlockPos, Integer> lastNonce = new HashMap<>();

    @Override
    public void render(CoffeeTableBlockEntity be, float tickDelta, MatrixStack ms,
                       VertexConsumerProvider vcp, int light, int overlay) {
        if (be.isRemoved() || be.getWorld() == null) return;

        BlockState st = be.getCachedState();
        ItemStack stack = be.getItem();
        if (stack.isEmpty()) return;
        if (st.contains(CoffeeTableBlock.HAS_ITEM) && !st.get(CoffeeTableBlock.HAS_ITEM)) return;

        int now = be.getRenderNonce();
        Integer prev = lastNonce.get(be.getPos());
        if (prev == null || prev != now) {
            lastNonce.put(be.getPos(), now);
            return;
        }

        ms.push();
        ms.translate(0.5, 0.6, 0.5);
        if (st.contains(CoffeeTableBlock.FACING)) {
            Direction facing = st.get(CoffeeTableBlock.FACING);
            float rotation = switch (facing) {
                default -> 0f;
                case SOUTH -> 180f;
                case WEST -> 90f;
                case EAST -> 270f;
            };
            ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        }
        ms.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));
        ms.scale(0.5f, 0.5f, 0.5f);

        MinecraftClient.getInstance().getItemRenderer()
                .renderItem(stack, ModelTransformationMode.FIXED, light, overlay, ms, vcp, be.getWorld(), 0);
        ms.pop();
    }
}