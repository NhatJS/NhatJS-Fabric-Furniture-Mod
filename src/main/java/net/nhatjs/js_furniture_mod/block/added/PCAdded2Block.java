package net.nhatjs.js_furniture_mod.block.added;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.PCHorizontalBlock;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.core.ModItems;

public class PCAdded2Block extends PCHorizontalBlock {
    public PCAdded2Block(Settings settings) {
        super(settings);
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

        if (held.isOf(ModItems.RAM)) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            world.setBlockState(pos, ModBlocks.PC_ADDED_3.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing), Block.NOTIFY_ALL);
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }
}
