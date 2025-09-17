package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class WashingMachineBlock extends TurnOnOffBlock{

    public WashingMachineBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(1.1, 0, 0.3, 14.9, 22, 15.9);
            case SOUTH -> Block.createCuboidShape(1.1, 0, 0.1, 14.9, 22, 15.7);
            case EAST -> Block.createCuboidShape(0.1, 0, 1.1, 15.7, 22, 14.9);
            case WEST -> Block.createCuboidShape(0.3, 0, 1.1, 15.9, 22, 14.9);
        };
    }


    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
