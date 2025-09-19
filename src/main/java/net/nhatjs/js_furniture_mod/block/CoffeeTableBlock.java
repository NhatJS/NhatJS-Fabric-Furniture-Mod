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

public class CoffeeTableBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public CoffeeTableBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-2.5, 0, 2.25, -1.25, 8, 3.5),
            Block.createCuboidShape(17.25, 0, 2.25, 18.5, 8, 3.5),
            Block.createCuboidShape(17.25, 0, 12.5, 18.5, 8, 13.75),
            Block.createCuboidShape(-2.5, 0, 12.5, -1.25, 8, 13.75),
            Block.createCuboidShape(-2, 4.625, 3.5, 8, 4.975, 12.5),
            Block.createCuboidShape(-2.5, 8, 2.25, 18.5, 9.25, 13.75),
            Block.createCuboidShape(8, 4.625, 3.5, 18, 4.975, 12.5)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(12.5, 0, -2.5, 13.75, 8, -1.25),
            Block.createCuboidShape(12.5, 0, 17.25, 13.75, 8, 18.5),
            Block.createCuboidShape(2.25, 0, 17.25, 3.5, 8, 18.5),
            Block.createCuboidShape(2.25, 0, -2.5, 3.5, 8, -1.25),
            Block.createCuboidShape(3.5, 4.625, -2, 12.5, 4.975, 8),
            Block.createCuboidShape(2.25, 8, -2.5, 13.75, 9.25, 18.5),
            Block.createCuboidShape(3.5, 4.625, 8, 12.5, 4.975, 18)
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