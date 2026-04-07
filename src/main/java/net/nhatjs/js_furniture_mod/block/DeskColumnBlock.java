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

public class DeskColumnBlock extends FurnitureHorizontalBlock {
    public DeskColumnBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(6.975, 0.15, 0.25, 9.025, 1, 15.75),
            Block.createCuboidShape(7.125, 0, 0.4, 8.875, 0.15, 2.15),
            Block.createCuboidShape(7.125, 0, 13.85, 8.875, 0.15, 15.6)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(0.25, 0.15, 6.975, 15.75, 1, 9.025),
            Block.createCuboidShape(13.85, 0, 7.125, 15.6, 0.15, 8.875),
            Block.createCuboidShape(0.4, 0, 7.125, 2.15, 0.15, 8.875)
    );

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(7.125, 1, 8.75, 8.875, 13.55, 11),
            Block.createCuboidShape(3.475, 13.55, 8.6, 9.375, 13.725, 11.175),
            Block.createCuboidShape(3.475, 13.725, 8.2, 9.375, 13.825, 11.575),
            Block.createCuboidShape(3.475, 13.825, 8.725, 9.375, 14.925, 11.05)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(7.125, 1, 5, 8.875, 13.55, 7.25),
            Block.createCuboidShape(6.625, 13.55, 4.825, 12.525, 13.725, 7.4),
            Block.createCuboidShape(6.625, 13.725, 4.425, 12.525, 13.825, 7.8),
            Block.createCuboidShape(6.625, 13.825, 4.959, 12.525, 14.925, 7.275)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(5, 1, 7.125, 7.25, 13.55, 8.875),
            Block.createCuboidShape(4.825, 13.55, 3.475, 7.4, 13.725, 9.375),
            Block.createCuboidShape(4.425, 13.725, 3.475, 7.8, 13.825, 9.375),
            Block.createCuboidShape(4.95, 13.825, 3.475, 7.275, 14.925, 9.375)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(8.75, 1, 7.125, 11, 13.55, 8.875),
            Block.createCuboidShape(8.6, 13.55, 6.625, 11.175, 13.725, 12.525),
            Block.createCuboidShape(8.2, 13.725, 6.625, 11.575, 13.825, 12.525),
            Block.createCuboidShape(8.725, 13.825, 6.625, 11.05, 14.925, 12.525)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> VoxelShapes.union(HORIZONTAL, NORTH);
            case SOUTH -> VoxelShapes.union(HORIZONTAL, SOUTH);
            case EAST -> VoxelShapes.union(VERTICAL, EAST);
            case WEST -> VoxelShapes.union(VERTICAL, WEST);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}