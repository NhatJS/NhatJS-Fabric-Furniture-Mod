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
import net.minecraft.world.BlockView;

public class SocketBlock extends Block {
    public static final DirectionProperty FACING = Properties.FACING;

    public SocketBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(6, 5, 15.75, 10, 11, 16);
            case SOUTH -> Block.createCuboidShape(6, 5, 0, 10, 11, 0.25);
            case EAST -> Block.createCuboidShape(0, 5, 6, 0.25, 11, 10);
            case WEST -> Block.createCuboidShape(15.75, 5, 6, 16, 11, 10);
            case UP -> Block.createCuboidShape(15.75, 5, 6, 16, 11, 10);
            case DOWN -> Block.createCuboidShape(15.75, 5, 6, 16, 11, 10);
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}