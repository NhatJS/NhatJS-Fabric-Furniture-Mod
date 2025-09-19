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

public class WoodTableBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;

    public WoodTableBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-16, 14.5, 0, 32, 16, 16),
            Block.createCuboidShape(-14.7, 13.5, 0, 30.75, 14.5, 0.9),
            Block.createCuboidShape(-16, 0, 14.75, -14.75, 14.5, 16),
            Block.createCuboidShape(-16, 0, 0, -14.75, 14.5, 1.25),
            Block.createCuboidShape(30.75, 0, 14.75, 32, 14.5, 16),
            Block.createCuboidShape(30.75, 0, 0, 32, 14.5, 1.25),
            Block.createCuboidShape(-14.75, 13.5, 15.1, 30.75, 14.5, 16),
            Block.createCuboidShape(32, 13.5, 1.25, 32, 14.5, 14.75),
            Block.createCuboidShape(-16, 13.5, 1.25, -15.1, 14.5, 14.75)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(0, 14.5, -16, 16, 16, 32),
            Block.createCuboidShape(15.1, 13.5, -14.75, 16, 14.5, 30.75),
            Block.createCuboidShape(0, 0, -16, 1.25, 14.5, -14.75),
            Block.createCuboidShape(14.75, 0, -16, 16, 14.5, -14.75),
            Block.createCuboidShape(0, 0, 30.75, 1.25, 14.5, 32),
            Block.createCuboidShape(14.75, 0, 30.75, 16, 14.5, 32),
            Block.createCuboidShape(0, 13.5, -14.75, 0.9, 14.5, 30.75),
            Block.createCuboidShape(1.25, 13.5, 31.1, 14.75, 14.5, 32),
            Block.createCuboidShape(1.25, 13.5, -16, 14.75, 14.5, -15.1)
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