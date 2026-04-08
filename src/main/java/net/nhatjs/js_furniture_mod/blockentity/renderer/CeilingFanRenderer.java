package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.blockentity.CeilingFanBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.function.Function;

@Environment(EnvType.CLIENT)
public class CeilingFanRenderer implements BlockEntityRenderer<CeilingFanBlockEntity, CeilingFanRenderState> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel blades_black;
    private final BlockStateModel blades_white;

    private final BlockStateModel woodLightBladesBlack;
    private final BlockStateModel woodMediumBladesBlack;
    private final BlockStateModel blackBladesBlack;
    private final BlockStateModel whiteBladesBlack;
    private final BlockStateModel woodLightBladesWhite;
    private final BlockStateModel woodMediumBladesWhite;
    private final BlockStateModel blackBladesWhite;
    private final BlockStateModel whiteBladesWhite;

    public CeilingFanRenderer(BlockEntityRendererFactory.Context ctx) {
        blades_black = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.CEILING_FAN_BLADES_ID);
        blades_white = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.CEILING_FAN_BLADES_B_ID);

        woodLightBladesBlack = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WOOD_LIGHT_CEILING_FAN_BLADES_BLACK_ID);
        woodMediumBladesBlack = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WOOD_MEDIUM_CEILING_FAN_BLADES_BLACK_ID);
        blackBladesBlack = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.BLACK_CEILING_FAN_BLADES_BLACK_ID);
        whiteBladesBlack = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WHITE_CEILING_FAN_BLADES_BLACK_ID);
        woodLightBladesWhite = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WOOD_LIGHT_CEILING_FAN_BLADES_WHITE_ID);
        woodMediumBladesWhite = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WOOD_MEDIUM_CEILING_FAN_BLADES_WHITE_ID);
        blackBladesWhite = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.BLACK_CEILING_FAN_BLADES_WHITE_ID);
        whiteBladesWhite = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.WHITE_CEILING_FAN_BLADES_WHITE_ID);
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

        World world = be.getWorld();
        if (world == null) return;

        state.light = WorldRenderer.getLightmapCoordinates(world, state.pos);
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(CeilingFanRenderState state,
                       MatrixStack ms,
                       OrderedRenderCommandQueue queue,
                       CameraRenderState cameraState) {
        RenderLayer cutout = RenderLayer.getCutout();

        ms.push();
        ms.translate(0.5, 0.9375, 0.5);
        ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.angle));
        ms.translate(-0.5, -0.9375, -0.5);

        //unused
        if (state.blockState.getBlock() == ModBlocks.CEILING_FAN) {
            queue.submitBlockStateModel(ms, cutout, blades_black, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        else if (state.blockState.getBlock() == ModBlocks.CEILING_FAN_B) {
            queue.submitBlockStateModel(ms, cutout, blades_white, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        //unused

        if (state.blockState.getBlock() == ModBlocks.WOOD_LIGHT_CEILING_FAN_BLACK) {
            queue.submitBlockStateModel(ms, cutout, woodLightBladesBlack, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        else if (state.blockState.getBlock() == ModBlocks.WOOD_MEDIUM_CEILING_FAN_BLACK) {
            queue.submitBlockStateModel(ms, cutout, woodMediumBladesBlack, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        else if (state.blockState.getBlock() == ModBlocks.BLACK_CEILING_FAN_BLACK) {
            queue.submitBlockStateModel(ms, cutout, blackBladesBlack, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        else if (state.blockState.getBlock() == ModBlocks.WHITE_CEILING_FAN_BLACK) {
            queue.submitBlockStateModel(ms, cutout, whiteBladesBlack, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        else if (state.blockState.getBlock() == ModBlocks.WOOD_LIGHT_CEILING_FAN_WHITE) {
            queue.submitBlockStateModel(ms, cutout, woodLightBladesWhite, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        else if (state.blockState.getBlock() == ModBlocks.WOOD_MEDIUM_CEILING_FAN_WHITE) {
            queue.submitBlockStateModel(ms, cutout, woodMediumBladesWhite, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        else if (state.blockState.getBlock() == ModBlocks.BLACK_CEILING_FAN_WHITE) {
            queue.submitBlockStateModel(ms, cutout, blackBladesWhite, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        else if (state.blockState.getBlock() == ModBlocks.WHITE_CEILING_FAN_WHITE) {
            queue.submitBlockStateModel(ms, cutout, whiteBladesWhite, 1f, 1f, 1f, state.light, state.overlay, 0);
        }
        ms.pop();
    }
}