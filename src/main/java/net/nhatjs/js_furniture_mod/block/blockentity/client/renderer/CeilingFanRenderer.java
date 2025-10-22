package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.blockentity.client.CeilingFanBlockEntity;

public class CeilingFanRenderer implements BlockEntityRenderer<CeilingFanBlockEntity> {
    private final BlockRenderManager brm;
    private BakedModel blades;

    public CeilingFanRenderer(BlockEntityRendererFactory.Context ctx) {
       this.brm = MinecraftClient.getInstance().getBlockRenderManager();
        ModelIdentifier id = new ModelIdentifier(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/ceiling_fan_blades"), "");
        this.blades = MinecraftClient.getInstance().getBakedModelManager().getModel(id);
    }

    @Override
    public void render(CeilingFanBlockEntity be, float tickDelta, MatrixStack ms,
                       VertexConsumerProvider vcp, int light, int overlay) {
        World w = be.getWorld(); if (w == null) return;

        // vẽ base từ blockstate (đã có JSON, nên KHÔNG tím-đen)
        BakedModel base = brm.getModel(be.getCachedState());
        brm.getModelRenderer().render(w, base, be.getCachedState(), be.getPos(),
                ms, vcp.getBuffer(RenderLayer.getSolid()), false, w.random, 0, overlay);

        // vẽ blades (đã bake nhờ blockstate GIẢ) và xoay mượt
        ms.push();
        ms.translate(0.5, 0.9375, 0.5); // tâm quạt
        float angle = be.getWorld().getSkyAngle(tickDelta); // bạn đang cập nhật trong clientTick
        ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(angle));
        ms.translate(-0.5, -0.9375, -0.5);

        brm.getModelRenderer().render(w, blades, be.getCachedState(), be.getPos(),
                ms, vcp.getBuffer(RenderLayer.getCutout()), false, w.random, 0, overlay);
        ms.pop();
    }

    @Override
    public boolean rendersOutsideBoundingBox(CeilingFanBlockEntity be) {
        return true;
    }
}