package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.blockentity.MirrorBlockEntity;
import org.jetbrains.annotations.Nullable;

public class BlackMirrorBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public BlackMirrorBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(2.5, -12, 15.2, 13.5, 28, 16);
            case SOUTH -> Block.createCuboidShape(2.5, -12, 0, 13.5, 28, 0.8);
            case EAST -> Block.createCuboidShape(0, -12, 2.5, 0.8, 28, 13.5);
            case WEST -> Block.createCuboidShape(15.2, -12, 2.5, 16, 28, 13.5);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MirrorBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        BlockEntity entity = world.getBlockEntity(pos);
        if (!(entity instanceof MirrorBlockEntity mirror)) return ActionResult.PASS;
        mirror.setStand(!mirror.makeStand());
        world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        return ActionResult.SUCCESS;
    }
}
