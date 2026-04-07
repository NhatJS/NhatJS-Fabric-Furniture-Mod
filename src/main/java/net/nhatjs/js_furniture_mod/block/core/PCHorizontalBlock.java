package net.nhatjs.js_furniture_mod.block.core;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;

public class PCHorizontalBlock extends HorizontalFacingBlock {
    public static MapCodec<PCHorizontalBlock> CODEC = createCodec(PCHorizontalBlock::new);

    public PCHorizontalBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(4, 0, 1.65, 12, 13.5, 14.35);
            case SOUTH -> Block.createCuboidShape(4, 0, 1.65, 12, 13.5, 14.35);
            case EAST -> Block.createCuboidShape(1.65, 0, 4, 14.35, 13.5, 12);
            case WEST -> Block.createCuboidShape(1.65, 0, 4, 14.35, 13.5, 12);
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }
}
