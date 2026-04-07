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

public class TVStandBlock extends FurnitureHorizontalBlock {
    public TVStandBlock(Settings settings) {
        super(settings);
    }

    private static VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(-16, 0, 3, -14.5, 11, 16),
            Block.createCuboidShape(-14.5, 9.5, 3, 24, 11, 16),
            Block.createCuboidShape(16.5, 6, 4, 18, 9.5, 4.75),
            Block.createCuboidShape(16.5, 6, 14.25, 18, 9.5, 15),
            Block.createCuboidShape(16.5, 6, 4.75, 18, 6.75, 14.25),
            Block.createCuboidShape(1.5, 0, 4.75, 3, 0.75, 14.25),
            Block.createCuboidShape(1.5, 0, 14.25, 3, 4.5, 15),
            Block.createCuboidShape(1.5, 0, 4, 3, 4.5, 4.75),
            Block.createCuboidShape(-2, 4.5, 3, 32, 6, 16),
            Block.createCuboidShape(30.5, 0, 3, 32, 4.5, 16)
    );

    private static VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(30.5, 0, 0, 32, 11, 13),
            Block.createCuboidShape(-8, 9.5, 0, 30.5, 11, 13),
            Block.createCuboidShape(-2, 6, 11.25, -0.5, 9.5, 12),
            Block.createCuboidShape(-2, 6, 1, -0.5, 9.5, 1.75),
            Block.createCuboidShape(-2, 6, 1.75, -0.5, 6.75, 11.25),
            Block.createCuboidShape(13, 0, 1.75, 14.5, 0.75, 11.25),
            Block.createCuboidShape(13, 0, 1, 14.5, 4.5, 1.75),
            Block.createCuboidShape(13, 0, 11.25, 14.5, 4.5, 12),
            Block.createCuboidShape(-16, 4.5, 0, 18, 6, 13),
            Block.createCuboidShape(-16, 0, 0, -14.5, 4.5, 13)
    );

    private static VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(0, 0, -16, 13, 11, -14.5),
            Block.createCuboidShape(0, 9.5, -14.5, 13, 11, 24),
            Block.createCuboidShape(11.25, 6, 16.5, 12, 9.5, 18),
            Block.createCuboidShape(1, 6, 16.5, 1.75, 9.5, 18),
            Block.createCuboidShape(1.75, 6, 16.5, 11.25, 6.75, 18),
            Block.createCuboidShape(1.75, 0, 1.5, 11.25, 0.75, 3),
            Block.createCuboidShape(1, 0, 1.5, 1.75, 4.5, 3),
            Block.createCuboidShape(11.25, 0, 1.5, 12, 4.5, 3),
            Block.createCuboidShape(0, 4.5, -2, 13, 6, 32),
            Block.createCuboidShape(0, 0, 30.5, 13, 4.5, 32)
    );

    private static VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(3, 0, 30.5, 16, 11, 32),
            Block.createCuboidShape(3, 9.5, -8, 16, 11, 30.5),
            Block.createCuboidShape(4, 6, -2, 4.75, 9.5, -0.5),
            Block.createCuboidShape(14.25, 6, -2, 15, 9.5, -0.5),
            Block.createCuboidShape(4.75, 6, -2, 14.25, 6.75, -0.5),
            Block.createCuboidShape(4.75, 0, 13, 14.25, 0.75, 14.5),
            Block.createCuboidShape(14.25, 0, 13, 15, 4.5, 14.5),
            Block.createCuboidShape(4, 0, 13, 4.75, 4.5, 14.5),
            Block.createCuboidShape(3, 4.5, -16, 16, 6, 18),
            Block.createCuboidShape(3, 0, -16, 16, 4.5, -14.5)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> NORTH;
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}