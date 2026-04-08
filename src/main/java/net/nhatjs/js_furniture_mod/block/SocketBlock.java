package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureDirectionalBlock;

public class SocketBlock extends FurnitureDirectionalBlock {
    public SocketBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(6, 5, 15.75, 10, 11, 16);
            case SOUTH -> Block.createCuboidShape(6, 5, 0, 10, 11, 0.25);
            case EAST -> Block.createCuboidShape(0, 5, 6, 0.25, 11, 10);
            case WEST -> Block.createCuboidShape(15.75, 5, 6, 16, 11, 10);
            case UP -> Block.createCuboidShape(6, 0, 5, 10, 0.25, 11);
            case DOWN -> Block.createCuboidShape(6, 15.75, 5, 10, 16, 11);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}