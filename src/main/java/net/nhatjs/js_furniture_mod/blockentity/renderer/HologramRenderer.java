package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.blockentity.client.HologramBlockEntity;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class HologramRenderer implements BlockEntityRenderer<HologramBlockEntity, HologramRenderState> {
    private static final Identifier SCREEN_TEX =
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "textures/block/display_screen.png");

    public HologramRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public HologramRenderState createRenderState() {
        return new HologramRenderState();
    }

    @Override
    public void updateRenderState(HologramBlockEntity blockEntity, HologramRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        state.blockState = blockEntity.getCachedState();
    }
    @Override
    public void render(HologramRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();

        matrices.translate(0.5, 0.5, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-state.pos.getY()));
        matrices.translate(-0.5, -0.5, -0.5);

        float z  = 0.0625f;
        float x0 = 0.1875f, y0 = 0.25f;
        float x1 = 0.8125f, y1 = 0.85f;

        matrices.pop();

        float zb = 1.0f - 1.0f;
    }
}