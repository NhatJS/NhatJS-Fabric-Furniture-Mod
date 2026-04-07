package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class ShowerBlock extends FurnitureHorizontalBlock {
    public ShowerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> createCuboidShape(5.75, 5.25, 4, 10.25, 9, 16);
            case SOUTH -> createCuboidShape(5.75, 5.25, 0, 10.25, 9, 12);
            case EAST -> createCuboidShape(0, 5.25, 5.75, 12, 9, 10.25);
            case WEST -> createCuboidShape(4, 5.25, 5.75, 16, 9, 10.25);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
