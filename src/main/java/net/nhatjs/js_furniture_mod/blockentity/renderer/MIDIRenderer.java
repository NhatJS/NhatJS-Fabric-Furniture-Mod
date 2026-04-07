package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.GrooveboxBlock;
import net.nhatjs.js_furniture_mod.blockentity.MIDIBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;

public class MIDIRenderer implements BlockEntityRenderer<MIDIBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BakedModel midiStandaloneGrooveboxOnEmissive;
    private final BakedModel midiStandaloneGroovebox2OnEmissive;
    private final BakedModel midiStandaloneGroovebox3OnEmissive;
    private final BakedModel midiKeyboardControllerOnEmissive;

    public MIDIRenderer(BlockEntityRendererFactory.Context ctx) {
        midiStandaloneGrooveboxOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIDI_STANDALONE_GROOVEBOX_ON_EMISSIVE);
        midiStandaloneGroovebox2OnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIDI_STANDALONE_GROOVEBOX_2_ON_EMISSIVE);
        midiStandaloneGroovebox3OnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIDI_STANDALONE_GROOVEBOX_3_ON_EMISSIVE);
        midiKeyboardControllerOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIDI_KEYBOARD_CONTROLLER_ON_EMISSIVE);
    }

    @Override
    public void render(MIDIBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay) {
        World world = entity.getWorld();
        if (world == null) return;

        BlockPos pos = entity.getPos();
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();
        Block blockState = (world.getBlockState(BlockPos.ofFloored(x, y, z))).getBlock();

        BlockState state = entity.getCachedState();
        float rotation = switch (state.get(GrooveboxBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        BlockModelRenderer bmr = mc.getBlockRenderManager().getModelRenderer();
        boolean powered = entity.isPowered();

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, 0, -0.5);
        if (powered) {
            if (blockState == ModBlocks.MIDI_STANDALONE_GROOVEBOX) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, midiStandaloneGrooveboxOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.MIDI_STANDALONE_GROOVEBOX_2) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, midiStandaloneGroovebox2OnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.MIDI_STANDALONE_GROOVEBOX_3) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, midiStandaloneGroovebox3OnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.MIDI_KEYBOARD_CONTROLLER) {
                bmr.render(matrices.peek(), vertexConsumers.getBuffer(RenderLayer.getCutout()),
                        state, midiKeyboardControllerOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
        }
        matrices.pop();
    }
}
