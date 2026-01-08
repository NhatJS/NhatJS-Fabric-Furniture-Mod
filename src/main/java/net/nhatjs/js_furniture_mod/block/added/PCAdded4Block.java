package net.nhatjs.js_furniture_mod.block.added;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.item.ModItems;

public class PCAdded4Block extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public PCAdded4Block(Settings settings) {
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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.SUCCESS;
        ItemStack held = player.getMainHandStack();

        if (held.isOf(ModItems.RAM)) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            world.setBlockState(pos, ModBlocks.PC_ADDED_5.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing), Block.NOTIFY_ALL);
            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }
}
