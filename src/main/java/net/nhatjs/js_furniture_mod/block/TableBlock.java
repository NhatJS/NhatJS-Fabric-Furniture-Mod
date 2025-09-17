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

public class TableBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public TableBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-12, 15, 0, 28, 16, 16),
            Block.createCuboidShape(-11.75, 0, 0.25, -10.75, 15, 1.25),
            Block.createCuboidShape(-11.75, 0, 14.75, -10.75, 15, 15.75),
            Block.createCuboidShape(26.75, 0, 14.75, 27.75, 15, 15.75),
            Block.createCuboidShape(26.75, 0, 0.25, 27.75, 15, 1.25),
            Block.createCuboidShape(26.85, 0.4, 1.25, 27.65, 1.2, 14.75),
            Block.createCuboidShape(-11.65, 0.4, 1.25, -10.85, 1.2, 14.75)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(0, 15, -12, 16, 16, 28),
            Block.createCuboidShape(14.75, 0, -11.75, 15.75, 15, -10.75),
            Block.createCuboidShape(0.25, 0, -11.75, 1.25, 15, -10.75),
            Block.createCuboidShape(0.25, 0, 26.75, 1.25, 15, 27.75),
            Block.createCuboidShape(14.75, 0, 26.75, 15.75, 15, 27.75),
            Block.createCuboidShape(1.25, 0.4, 26.85, 14.75, 1.2, 27.65),
            Block.createCuboidShape(1.25, 0.4, -11.65, 14.75, 1.2, -10.85)
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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}