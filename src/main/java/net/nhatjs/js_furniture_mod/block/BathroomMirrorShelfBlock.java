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

public class BathroomMirrorShelfBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public BathroomMirrorShelfBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> VoxelShapes.union(createCuboidShape(3, 4.65, 14, 13, 5.5, 16), createCuboidShape(3.25, 7, 15.7, 12.75, 19, 16));
            case SOUTH -> VoxelShapes.union(createCuboidShape(3, 4.65, 0, 13, 5.5, 2), createCuboidShape(3.25, 7, 0, 12.75, 19, 0.3));
            case EAST -> VoxelShapes.union(createCuboidShape(0, 4.65, 3, 2, 5.5, 13), createCuboidShape(0, 7, 3.25, 0.3, 19, 12.75));
            case WEST -> VoxelShapes.union(createCuboidShape(14, 4.65, 3, 16, 5.5, 13), createCuboidShape(15.7, 7, 3.25, 16, 19, 12.75));
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