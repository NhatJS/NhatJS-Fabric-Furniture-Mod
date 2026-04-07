package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.blockentity.MonitorBlockEntity;
import org.jetbrains.annotations.Nullable;

public class MonitorBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public MonitorBlock(Settings settings) {
        super(settings);
    }
    
    private static VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(4.1, 0, 9.1, 11.9, 0.75, 15),
            Block.createCuboidShape(6.9, 0.75, 12, 9.1, 10.95, 14.25),
            Block.createCuboidShape(7.15, 7.7, 11.15, 8.85, 8.75, 12),
            Block.createCuboidShape(0.1, 3.525, 9.8, 15.9, 12.475, 11.15)
    );

    private static VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(4.1, 0, 1, 11.9, 0.75, 6.9),
            Block.createCuboidShape(6.9, 0.75, 1.75, 9.1, 10.95, 4),
            Block.createCuboidShape(7.15, 7.7, 4, 8.85, 8.75, 4.85),
            Block.createCuboidShape(0.1, 3.525, 4.85, 15.9, 12.475, 6.2)
    );

    private static VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(1, 0, 4.1, 6.9, 0.75, 11.9),
            Block.createCuboidShape(1.75, 0.75, 6.9, 4, 10.95, 9.1),
            Block.createCuboidShape(4, 7.7, 7.15, 4.85, 8.75, 8.85),
            Block.createCuboidShape(4.85, 3.525, 0.1, 6.2, 12.475, 15.9)
    );

    private static VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(9.1, 0, 4.1, 15, 0.75, 11.9),
            Block.createCuboidShape(12, 0.75, 6.9, 14.25, 10.95, 9.1),
            Block.createCuboidShape(11.15, 7.7, 7.15, 12, 8.75, 8.85),
            Block.createCuboidShape(9.8, 3.525, 0.1, 11.15, 12.475, 15.9)
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
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MonitorBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}