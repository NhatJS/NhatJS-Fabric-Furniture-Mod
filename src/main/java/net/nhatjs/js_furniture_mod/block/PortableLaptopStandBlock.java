package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.LivingEntity;
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

public class PortableLaptopStandBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;

    public PortableLaptopStandBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(4.6, 0, 3.5, 11.4, 3.25, 12.2);
            case SOUTH -> Block.createCuboidShape(4.6, 0, 3.8, 11.4, 3.25, 12.5);
            case EAST -> Block.createCuboidShape(3.8, 0, 4.6, 12.5, 3.25, 11.4);
            case WEST -> Block.createCuboidShape(3.5, 0, 4.6, 12.2, 3.25, 11.4);
        };
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

        if (held.isOf(ModBlocks.LAPTOP.asItem())) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            world.setBlockState(pos, ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing), Block.NOTIFY_ALL);

            if (player instanceof PlayerEntity _player) {
                ItemStack _stktoremove = (player instanceof LivingEntity _livEnt ? _livEnt.getMainHandStack() : ItemStack.EMPTY);
                _player.getInventory().remove(p -> _stktoremove.getItem() == p.getItem(), 1, _player.playerScreenHandler.getCraftingInput());
            }

            return ActionResult.SUCCESS;
        }
        return ActionResult.SUCCESS;
    }
}

