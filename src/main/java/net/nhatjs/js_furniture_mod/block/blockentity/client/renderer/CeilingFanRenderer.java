package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.block.blockentity.client.CeilingFanBlockEntity;

@Environment(EnvType.CLIENT)
public class CeilingFanRenderer implements BlockEntityRenderer<CeilingFanBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockRenderManager brm = mc.getBlockRenderManager();

    public CeilingFanRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public void render(CeilingFanBlockEntity be, float tickDelta,
                       MatrixStack ms, VertexConsumerProvider vcp, int light, int overlay) {

        World w = be.getWorld();
        if (w == null) return;

        BlockPos pos = be.getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        brm.renderBlock(be.getCachedState(), be.getPos(), w, ms, vcp.getBuffer(RenderLayer.getCutoutMipped()), false, w.getRandom());

        BakedModel blades_black = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.CEILING_FAN_BLADES_ID);
        BakedModel blades_white = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.CEILING_FAN_BLADES_B_ID);

        if (blades_black == null || blades_white == null || blades_black == mc.getBakedModelManager().getMissingBlockModel()
                || blades_white == mc.getBakedModelManager().getMissingBlockModel()) {
            return;
        }

        ms.push();
        ms.translate(0.5, 0.9375, 0.5);
        ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(be.getAngle(tickDelta)));
        float blur = Math.min(be.speed / 27f, 1f);
        float alpha = 1.0f - (blur * 0.4f);

        ms.translate(-0.5, -0.9375, -0.5);

        VertexConsumer vc = vcp.getBuffer(RenderLayer.getCutoutMipped());

        if ((w.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock() == ModBlocks.CEILING_FAN) {
            brm.getModelRenderer().render(w, blades_black, be.getCachedState(), be.getPos(), ms, vc, false, w.getRandom(), 42L, overlay);
        }
        else if ((w.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock() == ModBlocks.CEILING_FAN_B) {
            brm.getModelRenderer().render(w, blades_white, be.getCachedState(), be.getPos(), ms, vc, false, w.getRandom(), 42L, overlay);
        }
        ms.pop();
    }
}