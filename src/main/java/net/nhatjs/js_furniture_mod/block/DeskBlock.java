package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class DeskBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public DeskBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(-8, 12.925, 0, 24, 16, 16),
            Block.createCuboidShape(23, 0, 0, 24, 12.925, 1),
            Block.createCuboidShape(23, 0, 15, 24, 12.925, 16),
            Block.createCuboidShape(-8, 0, 0, -7, 12.925, 1),
            Block.createCuboidShape(-8, 0, 15, -7, 12.925, 16),
            Block.createCuboidShape(23.1, 12.125, 1, 23.9, 12.925, 15),
            Block.createCuboidShape(-7.9, 12.125, 1, -7.1, 12.925, 15),
            Block.createCuboidShape(-7.9, 2.2, 1, -7.1, 3, 15),
            Block.createCuboidShape(23.1, 2.2, 1, 23.9, 3, 15),
            Block.createCuboidShape(-7, 2.2, 15.1, 23, 3, 15.9),
            Block.createCuboidShape(-7, 12.125, 15.1, 23, 12.925, 15.9)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(-8, 12.925, 0, 24, 16, 16),
            Block.createCuboidShape(23, 0, 15, 24, 12.925, 16),
            Block.createCuboidShape(23, 0, 0, 24, 12.925, 1),
            Block.createCuboidShape(-8, 0, 15, -7, 12.925, 16),
            Block.createCuboidShape(-8, 0, 0, -7, 12.925, 1),
            Block.createCuboidShape(23.1, 12.125, 1, 23.9, 12.925, 15),
            Block.createCuboidShape(-7.9, 12.125, 1, -7.1, 12.925, 15),
            Block.createCuboidShape(-7.9, 2.2, 1, -7.1, 3, 15),
            Block.createCuboidShape(23.1, 2.2, 1, 23.9, 3, 15),
            Block.createCuboidShape(-7, 2.2, 0.1, 23, 3, 0.9),
            Block.createCuboidShape(-7, 12.125, 0.1, 23, 12.925, 0.9)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(-0.025, 12.925, -7.975, 15.975, 16, 24.025),
            Block.createCuboidShape(14.975, 0, 23.025, 15.975, 12.925, 24.025),
            Block.createCuboidShape(-0.025, 0, 23.025, 0.975, 12.925, 24.025),
            Block.createCuboidShape(14.975, 0, -7.975, 15.975, 12.925, -6.975),
            Block.createCuboidShape(-0.025, 0, -7.975, 0.975, 12.925, -6.975),
            Block.createCuboidShape(0.975, 12.125, 23.125, 14.975, 12.925, 23.925),
            Block.createCuboidShape(0.975, 12.125, -7.875, 14.975, 12.925, -7.075),
            Block.createCuboidShape(0.975, 2.2, -7.875, 14.975, 3, -7.075),
            Block.createCuboidShape(0.975, 2.2, 23.125, 14.975, 3, 23.925),
            Block.createCuboidShape(0.075, 2.2, -6.975, 0.875, 3, 23.025),
            Block.createCuboidShape(0.075, 12.125, -6.975, 0.875, 12.925, 23.025)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(0, 12.925, -8, 16, 16, 24),
            Block.createCuboidShape(0, 0, -8, 1, 12.925, -7),
            Block.createCuboidShape(15, 0, -8, 16, 12.925, -7),
            Block.createCuboidShape(0, 0, 23, 1, 12.925, 24),
            Block.createCuboidShape(15, 0, 23, 16, 12.925, 24),
            Block.createCuboidShape(1, 12.125, -7.9, 15, 12.925, -7.1),
            Block.createCuboidShape(1, 12.125, 23.1, 15, 12.925, 23.9),
            Block.createCuboidShape(1, 2.2, 23.1, 15, 3, 23.9),
            Block.createCuboidShape(1, 2.2, -7.9, 15, 3, -7.1),
            Block.createCuboidShape(15.1, 2.2, -7, 15.9, 3, 23),
            Block.createCuboidShape(15.1, 12.125, -7, 15.9, 12.925, 23)
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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}