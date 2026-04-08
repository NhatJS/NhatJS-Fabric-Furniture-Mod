package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
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
import net.nhatjs.js_furniture_mod.block.GrooveboxBlock;
import net.nhatjs.js_furniture_mod.blockentity.MIDIBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class MIDIRenderer implements BlockEntityRenderer<MIDIBlockEntity, MIDIRenderState> {
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
    public MIDIRenderState createRenderState() {
        return new MIDIRenderState();
    }

    @Override
    public void updateRenderState(MIDIBlockEntity blockEntity, MIDIRenderState state, float tickProgress, Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);
        World world = blockEntity.getWorld();
        if (world == null) return;

        state.blockState = blockEntity.getCachedState();
        state.yaw = switch (state.blockState.get(GrooveboxBlock.FACING)) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST -> 90f;
            case EAST -> 270f;
        };
        state.powered = blockEntity.isPowered();
        state.overlay = OverlayTexture.DEFAULT_UV;
    }

    @Override
    public void render(MIDIRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        RenderLayer cutout = RenderLayers.cutout();
                
        matrices.push();
        matrices.translate(0.5, 0, 0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.translate(-0.5, 0, -0.5);
        if (state.powered) {
            if (state.blockState.getBlock() == ModBlocks.MIDI_STANDALONE_GROOVEBOX) {
                queue.submitBlockStateModel(matrices, cutout, midiStandaloneGrooveboxOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.MIDI_STANDALONE_GROOVEBOX_2) {
                queue.submitBlockStateModel(matrices, cutout, midiStandaloneGroovebox2OnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.MIDI_STANDALONE_GROOVEBOX_3) {
                queue.submitBlockStateModel(matrices, cutout, midiStandaloneGroovebox3OnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
            else if (state.blockState.getBlock() == ModBlocks.MIDI_KEYBOARD_CONTROLLER) {
                queue.submitBlockStateModel(matrices, cutout, midiKeyboardControllerOnEmissive, 1, 1, 1, LightmapTextureManager.MAX_LIGHT_COORDINATE, state.overlay, 0);
            }
        }
        matrices.pop();
    }
}
