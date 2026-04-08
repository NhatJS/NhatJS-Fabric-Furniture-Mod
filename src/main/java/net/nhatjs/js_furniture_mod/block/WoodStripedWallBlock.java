package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class WoodStripedWallBlock extends FurnitureHorizontalBlock {
    public WoodStripedWallBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(0, 0, 15.5, 16, 16, 16);
            case SOUTH -> Block.createCuboidShape(0, 0, 0, 16, 16, 0.5);
            case EAST -> Block.createCuboidShape(0, 0, 0, 0.5, 16, 16);
            case WEST -> Block.createCuboidShape(15.5, 0, 0, 16, 16, 16);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}