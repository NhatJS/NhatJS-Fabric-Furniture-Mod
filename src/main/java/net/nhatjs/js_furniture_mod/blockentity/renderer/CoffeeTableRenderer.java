package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.CoffeeTableBlock;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.blockentity.CoffeeTableBlockEntity;
import org.jetbrains.annotations.Nullable;

@Environment(EnvType.CLIENT)
public class CoffeeTableRenderer implements BlockEntityRenderer<CoffeeTableBlockEntity, CoffeeTableRenderState> {
    private final ItemModelManager itemModelManager;

    public CoffeeTableRenderer(BlockEntityRendererFactory.Context context) {
        itemModelManager = context.itemModelManager();
    }

    @Override
    public CoffeeTableRenderState createRenderState() {
        return new CoffeeTableRenderState();
    }

    @Override
    public void updateRenderState(CoffeeTableBlockEntity blockEntity, CoffeeTableRenderState state, float tickProgress,
                                  Vec3d cameraPos, @Nullable ModelCommandRenderer.CrumblingOverlayCommand crumblingOverlay) {
        BlockEntityRenderer.super.updateRenderState(blockEntity, state, tickProgress, cameraPos, crumblingOverlay);

        state.pos = blockEntity.getPos();
        state.world = blockEntity.getWorld();

        BlockState st = blockEntity.getCachedState();
        Direction f = st.get(CoffeeTableBlock.FACING);
        state.yaw = switch (f) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST  -> 90f;
            case EAST  -> 270f;
        };
        state.stack = blockEntity.getItem();
        if (state.stack.isEmpty()) {
            state.itemRenderState.clear();
            return;
        }
        if (st.contains(CoffeeTableBlock.HAS_ITEM) && !st.get(CoffeeTableBlock.HAS_ITEM)) return;

        itemModelManager.clearAndUpdate(state.itemRenderState,
                blockEntity.getItem(), ItemDisplayContext.FIXED, blockEntity.getWorld(), null, 0);
    }

    @Override
    public void render(CoffeeTableRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        
        matrices.push();

        matrices.translate(0.5f, 0.6f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90f));
        if (state.stack.isOf(ModBlocks.LAPTOP.asItem()) || state.stack.isOf(ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND.asItem())
                || state.stack.isOf(ModBlocks.PLANT_POT.asItem()) || state.stack.isOf(ModBlocks.PORTABLE_LAPTOP_STAND.asItem())
                || state.stack.isOf(ModBlocks.MIDI_STANDALONE_GROOVEBOX.asItem()) || state.stack.isOf(ModBlocks.MIDI_STANDALONE_GROOVEBOX_2.asItem())
                || state.stack.isOf(ModBlocks.MIDI_STANDALONE_GROOVEBOX_3.asItem()) || state.stack.isOf(ModBlocks.MIDI_KEYBOARD_CONTROLLER.asItem())) {
            matrices.scale(1.0f, 1.0f, 1.0f);
        }
        else {
            matrices.scale(0.5f, 0.5f, 0.5f);
        }

        state.itemRenderState.render(matrices, queue, getLightLevel(state.world, state.pos), OverlayTexture.DEFAULT_UV, 0);

        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
