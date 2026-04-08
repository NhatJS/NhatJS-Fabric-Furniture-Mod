package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.BlockModelRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureModClient;
import net.nhatjs.js_furniture_mod.block.GrooveboxBlock;
import net.nhatjs.js_furniture_mod.blockentity.MIDIBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;

public class MIDIRenderer implements BlockEntityRenderer<MIDIBlockEntity> {
    private final MinecraftClient mc = MinecraftClient.getInstance();
    private final BlockStateModel midiStandaloneGrooveboxOnEmissive;
    private final BlockStateModel midiStandaloneGroovebox2OnEmissive;
    private final BlockStateModel midiStandaloneGroovebox3OnEmissive;
    private final BlockStateModel midiKeyboardControllerOnEmissive;

    public MIDIRenderer(BlockEntityRendererFactory.Context ctx) {
        midiStandaloneGrooveboxOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIDI_STANDALONE_GROOVEBOX_ON_EMISSIVE_ID);
        midiStandaloneGroovebox2OnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIDI_STANDALONE_GROOVEBOX_2_ON_EMISSIVE_ID);
        midiStandaloneGroovebox3OnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIDI_STANDALONE_GROOVEBOX_3_ON_EMISSIVE_ID);
        midiKeyboardControllerOnEmissive = mc.getBakedModelManager().getModel(NhatJSFurnitureModClient.MIDI_KEYBOARD_CONTROLLER_ON_EMISSIVE_ID);
    }

    @Override
    public void render(MIDIBlockEntity entity, float tickDelta, MatrixStack matrices,
                       VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d vec3d) {
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
        boolean powered = entity.isPowered();
        VertexConsumer vc = vertexConsumers.getBuffer(RenderLayer.getCutout());

        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rotation));
        matrices.translate(-0.5, 0, -0.5);
        if (powered) {
            if (blockState == ModBlocks.MIDI_STANDALONE_GROOVEBOX) {
                BlockModelRenderer.render(matrices.peek(), vc, midiStandaloneGrooveboxOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.MIDI_STANDALONE_GROOVEBOX_2) {
                BlockModelRenderer.render(matrices.peek(), vc, midiStandaloneGroovebox2OnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.MIDI_STANDALONE_GROOVEBOX_3) {
                BlockModelRenderer.render(matrices.peek(), vc, midiStandaloneGroovebox3OnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
            else if (blockState == ModBlocks.MIDI_KEYBOARD_CONTROLLER) {
                BlockModelRenderer.render(matrices.peek(), vc, midiKeyboardControllerOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, overlay);
            }
        }
        matrices.pop();
    }
}
