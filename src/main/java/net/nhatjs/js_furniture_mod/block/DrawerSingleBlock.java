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

public class DrawerSingleBlock extends FurnitureHorizontalBlock {
    public DrawerSingleBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(0.1, 0, 0.75, 15.9, 4.25, 1.75),
            Block.createCuboidShape(2.1, 0, 1.75, 13.9, 1, 15.75),
            Block.createCuboidShape(13.9, 0, 1.75, 14.9, 4, 15.75),
            Block.createCuboidShape(1.1, 0, 1.75, 2.1, 4, 15.75),
            Block.createCuboidShape(2.1, 1, 14.75, 13.9, 4, 15.75),
            Block.createCuboidShape(6.1, 3, 0.25, 9.9, 3.75, 0.25),
            Block.createCuboidShape(9.9, 3, 0.25, 9.9, 3.75, 0.75),
            Block.createCuboidShape(6.1, 3, 0.25, 6.1, 3.75, 0.75)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(0.1, 0, 14.25, 15.9, 4.25, 15.25),
            Block.createCuboidShape(2.1, 0, 0.25, 13.9, 1, 14.25),
            Block.createCuboidShape(1.1, 0, 0.25, 2.1, 4, 14.25),
            Block.createCuboidShape(13.9, 0, 0.25, 14.9, 4, 14.25),
            Block.createCuboidShape(2.1, 1, 0.25, 13.9, 4, 1.25),
            Block.createCuboidShape(6.1, 3, 15.75, 9.9, 3.75, 15.75),
            Block.createCuboidShape(6.1, 3, 15.25, 6.1, 3.75, 15.75),
            Block.createCuboidShape(9.9, 3, 15.25, 9.9, 3.75, 15.75)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(14.25, 0, 0.1, 15.25, 4.25, 15.9),
            Block.createCuboidShape(0.25, 0, 2.1, 14.25, 1, 13.9),
            Block.createCuboidShape(0.25, 0, 13.9, 14.25, 4, 14.9),
            Block.createCuboidShape(0.25, 0, 1.1, 14.25, 4, 2.1),
            Block.createCuboidShape(0.25, 1, 2.1, 1.25, 4, 13.9),
            Block.createCuboidShape(15.75, 3, 6.1, 15.75, 3.75, 9.9),
            Block.createCuboidShape(15.25, 3, 9.9, 15.75, 3.75, 9.9),
            Block.createCuboidShape(15.25, 3, 6.1, 15.75, 3.75, 6.1)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(0.75, 0, 0.1, 1.75, 4.25, 15.9),
            Block.createCuboidShape(1.75, 0, 2.1, 15.75, 1, 13.9),
            Block.createCuboidShape(1.75, 0, 1.1, 15.75, 4, 2.1),
            Block.createCuboidShape(1.75, 0, 13.9, 15.75, 4, 14.9),
            Block.createCuboidShape(14.75, 1, 2.1, 15.75, 4, 13.9),
            Block.createCuboidShape(0.25, 3, 6.1, 0.25, 3.75, 9.9),
            Block.createCuboidShape(0.25, 3, 6.1, 0.75, 3.75, 6.1),
            Block.createCuboidShape(0.25, 3, 9.9, 0.75, 3.75, 9.9)
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
