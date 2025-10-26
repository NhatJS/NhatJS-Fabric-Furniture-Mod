package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.impl.client.indigo.renderer.mesh.MeshViewImpl;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.item.ItemModelManager;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.command.ModelCommandRenderer;
import net.minecraft.client.render.command.OrderedRenderCommandQueue;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.render.state.CameraRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.BlockRenderView;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.CoffeeTableBlock;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.block.blockentity.client.CoffeeTableBlockEntity;
import org.jetbrains.annotations.Nullable;

import java.util.*;

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
        // vì đây là block của bạn, FACING luôn có -> get trực tiếp
        Direction f = st.get(CoffeeTableBlock.FACING);
        state.yaw = switch (f) {
            default -> 0f;
            case SOUTH -> 180f;
            case WEST  -> 90f;
            case EAST  -> 270f;
        };

        // --- build item render state khi có item ---
        ItemStack stack = blockEntity.getItem();
        if (stack.isEmpty()) {
            state.itemRenderState.clear();
            return;
        }

        itemModelManager.clearAndUpdate(state.itemRenderState,
                blockEntity.getItem(), ItemDisplayContext.FIXED, blockEntity.getWorld(), null, 0);
    }

    @Override
    public void render(CoffeeTableRenderState state, MatrixStack matrices, OrderedRenderCommandQueue queue, CameraRenderState cameraState) {
        matrices.push();

        matrices.translate(0.5f, 0.6f, 0.5f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.yaw));
        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90f));
        matrices.scale(0.5f, 0.5f, 0.5f);

        state.itemRenderState.render(matrices, queue, getLightLevel(state.world, state.pos), OverlayTexture.DEFAULT_UV, 0);

        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}