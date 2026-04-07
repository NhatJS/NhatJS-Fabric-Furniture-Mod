package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class KeyboardBlock extends FurnitureHorizontalBlock {
    public KeyboardBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(3.0375, 0, 6.175, 12.9625, 0.275, 9.825);
            case SOUTH -> Block.createCuboidShape(3.0375, 0, 6.175, 12.9625, 0.275, 9.825);
            case EAST -> Block.createCuboidShape(6.175, 0, 3.0375, 9.825, 0.275, 12.9625);
            case WEST -> Block.createCuboidShape(6.175, 0, 3.0375, 9.825, 0.275, 12.9625);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}