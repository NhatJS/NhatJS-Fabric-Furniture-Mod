package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class ComputerMouseBlock extends FurnitureHorizontalBlock {
    public ComputerMouseBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(7.35, 0, 6.875, 8.65, 0.725, 9.125);
            case SOUTH -> Block.createCuboidShape(7.35, 0, 6.875, 8.65, 0.725, 9.125);
            case EAST -> Block.createCuboidShape(6.875, 0, 7.35, 9.125, 0.725, 8.65);
            case WEST -> Block.createCuboidShape(6.875, 0, 7.35, 9.125, 0.725, 8.65);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}