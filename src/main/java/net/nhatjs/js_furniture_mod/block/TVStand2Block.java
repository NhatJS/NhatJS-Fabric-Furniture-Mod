package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class TVStand2Block extends FurnitureHorizontalBlock {
    public TVStand2Block(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(-16, 0, 6, 32, 10.25, 16);
            case SOUTH -> Block.createCuboidShape(-16, 0, 0, 32, 10.25, 10);
            case EAST -> Block.createCuboidShape(0, 0, -16, 10, 10.25, 32);
            case WEST -> Block.createCuboidShape(6, 0, -16, 16, 10.25, 32);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}