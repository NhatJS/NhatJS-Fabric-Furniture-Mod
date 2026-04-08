package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class ModernClockBlock extends FurnitureHorizontalBlock {
    public ModernClockBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(3.5, 3.5, 15.35, 12.5, 12.5, 16);
            case SOUTH -> Block.createCuboidShape(3.5, 3.5, 0, 12.5, 12.5, 0.65);
            case EAST -> Block.createCuboidShape(0, 3.5, 3.5, 0.65, 12.5, 12.5);
            case WEST -> Block.createCuboidShape(15.35, 3.5, 3.5, 16, 12.5, 12.5);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
