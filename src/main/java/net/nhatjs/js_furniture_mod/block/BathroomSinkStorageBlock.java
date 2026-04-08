package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class BathroomSinkStorageBlock extends FurnitureHorizontalBlock {
    public BathroomSinkStorageBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(2, 5.75, 5.25, 14, 16, 16);
            case SOUTH -> Block.createCuboidShape(2, 5.75, 0, 14, 16, 10.75);
            case EAST -> Block.createCuboidShape(0, 5.75, 2, 10.75, 16, 14);
            case WEST -> Block.createCuboidShape(5.25, 5.75, 2, 16, 16, 14);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}