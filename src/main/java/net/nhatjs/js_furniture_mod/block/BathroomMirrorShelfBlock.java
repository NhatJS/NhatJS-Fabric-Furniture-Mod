package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class BathroomMirrorShelfBlock extends FurnitureHorizontalBlock {
    public BathroomMirrorShelfBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> VoxelShapes.union(createCuboidShape(3, 4.65, 14, 13, 5.5, 16), createCuboidShape(3.25, 7, 15.7, 12.75, 19, 16));
            case SOUTH -> VoxelShapes.union(createCuboidShape(3, 4.65, 0, 13, 5.5, 2), createCuboidShape(3.25, 7, 0, 12.75, 19, 0.3));
            case EAST -> VoxelShapes.union(createCuboidShape(0, 4.65, 3, 2, 5.5, 13), createCuboidShape(0, 7, 3.25, 0.3, 19, 12.75));
            case WEST -> VoxelShapes.union(createCuboidShape(14, 4.65, 3, 16, 5.5, 13), createCuboidShape(15.7, 7, 3.25, 16, 19, 12.75));
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}