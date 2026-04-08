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

public class DeskBlock extends FurnitureHorizontalBlock {
    public DeskBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-8, 0, 0, -6.25, 13, 1.75),
            Block.createCuboidShape(22.25, 0, 0, 24, 13, 1.75),
            Block.createCuboidShape(-8, 0, 14.25, -6.25, 13, 16),
            Block.createCuboidShape(22.25, 0, 14.25, 24, 13, 16),
            Block.createCuboidShape(-8, 13, 0, 24, 16, 16),
            Block.createCuboidShape(-7.5, 9, 1.75, -6.75, 10, 14.25),
            Block.createCuboidShape(22.75, 9, 1.75, 23.5, 10, 14.25)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(14.25, 0, -8, 16, 13, -6.25),
            Block.createCuboidShape(14.25, 0, 22.25, 16, 13, 24),
            Block.createCuboidShape(0, 0, -8, 1.75, 13, -6.25),
            Block.createCuboidShape(0, 0, 22.25, 1.75, 13, 24),
            Block.createCuboidShape(0, 13, -8, 16, 16, 24),
            Block.createCuboidShape(1.75, 9, -7.5, 14.25, 10, -6.75),
            Block.createCuboidShape(1.75, 9, 22.75, 14.25, 10, 23.5)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> VoxelShapes.union(HORIZONTAL, Block.createCuboidShape(-6.25, 3, 14.75, 22.25, 4, 15.5));
            case SOUTH -> VoxelShapes.union(HORIZONTAL, Block.createCuboidShape(-6.25, 3, 0.5, 22.25, 4, 1.25));
            case EAST -> VoxelShapes.union(VERTICAL, Block.createCuboidShape(0.5, 3, -6.25, 1.25, 4, 22.25));
            case WEST -> VoxelShapes.union(VERTICAL, Block.createCuboidShape(14.75, 3, -6.25, 15.5, 4, 22.25));
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}