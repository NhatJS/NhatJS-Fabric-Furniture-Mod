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

public class TableBlock extends FurnitureHorizontalBlock {
    public TableBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-16, 14, 0, 32, 16, 16),
            Block.createCuboidShape(-16, 0, 0, -14, 14, 2),
            Block.createCuboidShape(30, 0, 0, 32, 14, 2),
            Block.createCuboidShape(30, 0, 14, 32, 14, 16),
            Block.createCuboidShape(-16, 0, 14, -14, 14, 16)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(0, 14, -16, 16, 16, 32),
            Block.createCuboidShape(14, 0, -16, 16, 14, -14),
            Block.createCuboidShape(14, 0, 30, 16, 14, 32),
            Block.createCuboidShape(0, 0, 30, 2, 14, 32),
            Block.createCuboidShape(0, 0, -16, 2, 14, -14)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> HORIZONTAL;
            case SOUTH -> HORIZONTAL;
            case EAST -> VERTICAL;
            case WEST -> VERTICAL;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}