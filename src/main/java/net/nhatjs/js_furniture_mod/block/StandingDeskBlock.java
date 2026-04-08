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

public class StandingDeskBlock extends FurnitureHorizontalBlock {
    public StandingDeskBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-11.8, 0.15, 0.25, -9.75, 1, 15.75),
            Block.createCuboidShape(-11.65, 0, 13.85, -9.9, 0.15, 15.6),
            Block.createCuboidShape(25.75, 0.15, 0.25, 27.8, 1, 15.75),
            Block.createCuboidShape(25.9, 0, 13.85, 27.65, 0.15, 15.6),
            Block.createCuboidShape(25.9, 0, 0.4, 27.65, 0.15, 2.15),
            Block.createCuboidShape(-11.65, 0, 0.4, -9.9, 0.15, 2.15),
            Block.createCuboidShape(-12.75, 15, 0, 28.75, 16, 16)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(0.25, 0.15, -11.8, 15.75, 1, -9.75),
            Block.createCuboidShape(0.4, 0, -11.65, 2.15, 0.15, -9.9),
            Block.createCuboidShape(0.25, 0.15, 25.75, 15.75, 1, 27.8),
            Block.createCuboidShape(0.4, 0, 25.9, 2.15, 0.15, 27.65),
            Block.createCuboidShape(13.85, 0, 25.9, 15.6, 0.15, 27.65),
            Block.createCuboidShape(13.85, 0, -11.65, 15.6, 0.15, -9.9),
            Block.createCuboidShape(0, 15, -12.75, 16, 16, 28.75)
    );

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(-3.35, 13.45, 8.325, 19.35, 15, 11.45),
            Block.createCuboidShape(-11.35, 14.05, 8.425, 27.35, 15, 11.35),
            Block.createCuboidShape(-11.65, 1, 8.75, -9.9, 13.45, 11),
            Block.createCuboidShape(25.9, 1, 8.75, 27.65, 13.45, 11),
            Block.createCuboidShape(22.25, 13.725, 8.2, 28.15, 13.825, 11.575),
            Block.createCuboidShape(22.25, 13.55, 8.6, 28.15, 14.925, 11.175),
            Block.createCuboidShape(-12.15, 13.725, 8.2, -6.25, 13.825, 11.575),
            Block.createCuboidShape(-12.15, 13.55, 8.6, -6.25, 14.925, 11.175)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(-3.35, 13.45, 4.55, 19.35, 15, 7.675),
            Block.createCuboidShape(-11.35, 14.05, 4.65, 27.35, 15, 7.575),
            Block.createCuboidShape(25.9, 1, 5, 27.65, 13.45, 7.25),
            Block.createCuboidShape(-11.65, 1, 5, -9.9, 13.45, 7.25),
            Block.createCuboidShape(-12.15, 13.725, 4.425, -6.25, 13.825, 7.8),
            Block.createCuboidShape(-12.15, 13.55, 4.825, -6.25, 14.925, 7.4),
            Block.createCuboidShape(22.25, 13.725, 4.425, 28.15, 13.825, 7.8),
            Block.createCuboidShape(22.25, 13.55, 4.825, 28.15, 14.925, 7.4)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(4.55, 13.45, -3.35, 7.675, 15, 19.35),
            Block.createCuboidShape(4.65, 14.05, -11.35, 7.575, 15, 27.35),
            Block.createCuboidShape(5, 1, -11.65, 7.25, 13.45, -9.9),
            Block.createCuboidShape(5, 1, 25.9, 7.25, 13.45, 27.65),
            Block.createCuboidShape(4.425, 13.725, 22.25, 7.80, 13.825, 28.15),
            Block.createCuboidShape(4.825, 13.55, 22.25, 7.4, 14.925, 28.15),
            Block.createCuboidShape(4.425, 13.725, -12.15, 7.80, 13.825, -6.25),
            Block.createCuboidShape(4.825, 13.55, -12.15, 7.4, 14.925, -6.25)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(8.325, 13.45, -3.35, 11.45, 15, 19.35),
            Block.createCuboidShape(8.425, 14.05, -11.35, 11.35, 15, 27.35),
            Block.createCuboidShape(8.75, 1, 25.9, 11, 13.45, 27.65),
            Block.createCuboidShape(8.75, 1, -11.65, 11, 13.45, -9.9),
            Block.createCuboidShape(8.2, 13.725, -12.15, 11.575, 13.825, -6.25),
            Block.createCuboidShape(8.6, 13.55, -12.15, 11.175, 14.925, -6.25),
            Block.createCuboidShape(8.2, 13.725, 22.25, 11.575, 13.825, 28.15),
            Block.createCuboidShape(8.6, 13.55, 22.25, 11.175, 14.925, 28.15)
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