package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.renderer.v1.render.BlockVertexConsumerProvider;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.blockentity.CeilingFanBlockEntity;

@Environment(EnvType.CLIENT)
public class CeilingFanRenderer implements BlockEntityRenderer<CeilingFanBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
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
    public void render(CeilingFanBlockEntity be, float tickDelta,
                       MatrixStack ms, VertexConsumerProvider vcp, int light, int overlay, Vec3d cameraPos) {
        World world = be.getWorld();
        if (world == null) return;

        BlockPos pos = be.getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        ms.push();
        ms.translate(0.5, 0.9375, 0.5);
        ms.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(be.getAngle(tickDelta)));
        ms.translate(-0.5, -0.9375, -0.5);

        VertexConsumer vc = vcp.getBuffer(RenderLayer.getCutout());
        BlockVertexConsumerProvider forcedProvider = new BlockVertexConsumerProvider() {
            @Override
            public VertexConsumer getBuffer(BlockRenderLayer blockRenderLayer) {
                return vc;
            }
        };
        Block blockState = (world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock();

        //unused
        if (blockState == ModBlocks.CEILING_FAN) {
            bmr.render(world, blades_black, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        else if (blockState == ModBlocks.CEILING_FAN_B) {
            bmr.render(world, blades_white, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        //unused

        if (blockState == ModBlocks.WOOD_LIGHT_CEILING_FAN_BLACK) {
            bmr.render(world, woodLightBladesBlack, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        else if (blockState == ModBlocks.WOOD_MEDIUM_CEILING_FAN_BLACK) {
            bmr.render(world, woodMediumBladesBlack, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        else if (blockState == ModBlocks.BLACK_CEILING_FAN_BLACK) {
            bmr.render(world, blackBladesBlack, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        else if (blockState == ModBlocks.WHITE_CEILING_FAN_BLACK) {
            bmr.render(world, whiteBladesBlack, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        else if (blockState == ModBlocks.WOOD_LIGHT_CEILING_FAN_WHITE) {
            bmr.render(world, woodLightBladesWhite, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        else if (blockState == ModBlocks.WOOD_MEDIUM_CEILING_FAN_WHITE) {
            bmr.render(world, woodMediumBladesWhite, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        else if (blockState == ModBlocks.BLACK_CEILING_FAN_WHITE) {
            bmr.render(world, blackBladesWhite, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        else if (blockState == ModBlocks.WHITE_CEILING_FAN_WHITE) {
            bmr.render(world, whiteBladesWhite, be.getCachedState(), be.getPos(), ms, forcedProvider, false, 42L, overlay);
        }
        ms.pop();
    }
}