package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class FridgeBlock extends FurnitureHorizontalBlock {
    public FridgeBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(0, 0, 1.1, 16, 31.075, 15.7);
            case SOUTH -> Block.createCuboidShape(0, 0, 0.3, 16, 31.075, 14.9);
            case EAST -> Block.createCuboidShape(0.3, 0, 0, 14.9, 31.075, 16);
            case WEST -> Block.createCuboidShape(1.1, 0, 0, 15.7, 31.075, 16);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}