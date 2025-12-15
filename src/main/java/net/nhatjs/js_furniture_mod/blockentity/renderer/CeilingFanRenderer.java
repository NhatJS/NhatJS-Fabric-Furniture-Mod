package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.blockentity.client.CeilingFanBlockEntity;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class CeilingFanRenderer implements BlockEntityRenderer<CeilingFanBlockEntity, CeilingFanRenderState> {
    private final MinecraftClient mc = MinecraftClient.getInstance();

    public CeilingFanRenderer(BlockEntityRendererFactory.Context ctx) {
    }

    @Override
    public CeilingFanRenderState createRenderState() {
        return new CeilingFanRenderState();
    }

    @Override
    public void updateRenderState(CeilingFanBlockEntity be,
                                  CeilingFanRenderState state,
                                  float tickDelta,
                                  Vec3d cameraPos,
                                  @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(be, state, tickDelta, cameraPos, crumblingOverlay);

        state.pos = be.getPos();
        state.blockState = be.getCachedState();
        state.angle = be.getAngle(tickDelta);

        World w = be.getWorld();
        if (w == null || state.blockState == null) {
            state.light = 0;
            state.overlay = OverlayTexture.DEFAULT_UV;
            return;
        }

        state.light = WorldRenderer.getLightmapCoordinates(w, state.pos);
        state.overlay = OverlayTexture.DEFAULT_UV;

    }

    @Override
    public void render(CeilingFanRenderState state,
                       MatrixStack ms,
                       OrderedRenderCommandQueue queue,
                       CameraRenderState cameraState) {
        if (state.blockState == null || state.pos == null) return;

        BlockState blades_black = ModBlocks.CEILING_FAN_BLADES.getDefaultState();
        BlockState blades_white = ModBlocks.CEILING_FAN_BLADES_B.getDefaultState();

        ms.push();
        try {
            ms.translate(0.5, 0.9375, 0.5);
            ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.angle));
            ms.translate(-0.5, -0.9375, -0.5);

            CeilingFanBlockEntity be = (CeilingFanBlockEntity) mc.world.getBlockEntity(state.pos);
            float blur = 0f;
            float alpha = 1f;
            if (be != null) {
                blur = Math.min(be.speed / 27f, 1f);
                alpha = 1.0f - (blur * 0.4f);
            }

            if (state.blockState.getBlock() == ModBlocks.CEILING_FAN) {
                queue.submitBlock(ms, blades_black, state.light, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.CEILING_FAN_B) {
                queue.submitBlock(ms, blades_white, state.light, state.overlay, 0);
            }
        } finally {
            ms.pop();
        }
    }
}