package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.core.ModItems;

public class ComputerCaseBlock extends FurnitureHorizontalBlock {
    public ComputerCaseBlock(Settings settings) {
        super(settings);
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        ItemStack held = player.getMainHandStack();

        if (held.isOf(ModItems.MAINBOARD)) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            world.setBlockState(pos, ModBlocks.PC_ADDED_1.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing), Block.NOTIFY_ALL);
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }
}
