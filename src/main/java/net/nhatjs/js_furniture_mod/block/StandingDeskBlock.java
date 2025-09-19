package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class StandingDeskBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public StandingDeskBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(-11.8, 0, 0.25, -9.75, 0.75, 15.75),
            Block.createCuboidShape(-11.8, 0.75, 8.75, -9.75, 15.25, 11),
            Block.createCuboidShape(25.75, 0, 0.25, 27.8, 0.75, 15.75),
            Block.createCuboidShape(25.75, 0.75, 8.75, 27.8, 15.25, 11),
            Block.createCuboidShape(-9.75, 13.65, 8.25, 25.75, 15.25, 11.5),
            Block.createCuboidShape(-12.75, 15.25, 0, 28.75, 16, 16)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(-11.8, 0, 0.25, -9.75, 0.75, 15.75),
            Block.createCuboidShape(-11.8, 0.75, 5, -9.75, 15.25, 7.25),
            Block.createCuboidShape(25.75, 0, 0.25, 27.8, 0.75, 15.75),
            Block.createCuboidShape(25.75, 0.75, 5, 27.8, 15.25, 7.25),
            Block.createCuboidShape(-9.75, 13.65, 4.5, 25.75, 15.25, 7.75),
            Block.createCuboidShape(-12.75, 15.25, 0, 28.75, 16, 16)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(0.25, 0, -11.8, 15.75, 0.75, -9.75),
            Block.createCuboidShape(5, 0.75, -11.8, 7.25, 15.25, -9.75),
            Block.createCuboidShape(0.25, 0, 25.75, 15.75, 0.75, 27.8),
            Block.createCuboidShape(5, 0.75, 25.75, 7.25, 15.25, 27.8),
            Block.createCuboidShape(5, 13.65, -9.75, 7.75, 15.25, 25.75),
            Block.createCuboidShape(0, 15.25, -12.75, 16, 16, 28.75)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(0.25, 0, -11.8, 15.75, 0.75, -9.75),
            Block.createCuboidShape(8.75, 0.75, -11.8, 11, 15.25, -9.75),
            Block.createCuboidShape(0.25, 0, 25.75, 15.75, 0.75, 27.8),
            Block.createCuboidShape(8.75, 0.75, 25.75, 11, 15.25, 27.8),
            Block.createCuboidShape(8.25, 13.65, -9.75, 11.5, 15.25, 25.75),
            Block.createCuboidShape(0, 15.25, -12.75, 16, 16, 28.75)
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