package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class FloorStandingSpeakerBlock extends FurnitureHorizontalBlock {
    public FloorStandingSpeakerBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(5.7, 0, 9.4, 10.3, 21.75, 14);
            case SOUTH -> Block.createCuboidShape(5.7, 0, 2, 10.3, 21.75, 6.6);
            case EAST -> Block.createCuboidShape(2, 0, 5.7, 6.6, 21.75, 10.3);
            case WEST -> Block.createCuboidShape(9.4, 0, 5.7, 14, 21.75, 10.3);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}