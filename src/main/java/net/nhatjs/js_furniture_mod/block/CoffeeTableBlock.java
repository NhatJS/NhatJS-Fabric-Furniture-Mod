package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.blockentity.CoffeeTableBlockEntity;

public class CoffeeTableBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public static final BooleanProperty HAS_ITEM = BooleanProperty.of("has_item");

    public CoffeeTableBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH).with(HAS_ITEM, false));
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-2.5, 0, 2.25, -1, 7.75, 3.75),
            Block.createCuboidShape(17, 0, 2.25, 18.5, 7.75, 3.75),
            Block.createCuboidShape(17, 0, 12.25, 18.5, 7.75, 13.75),
            Block.createCuboidShape(-2.5, 0, 12.25, -1, 7.75, 13.75),
            Block.createCuboidShape(-2.5, 7.75, 2.25, 18.5, 9.25, 13.75),
            Block.createCuboidShape(-2, 2.625, 3.75, 18, 3.625, 12.25)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(12.25, 0, -2.5, 13.75, 7.75, -1),
            Block.createCuboidShape(12.25, 0, 17, 13.75, 7.75, 18.5),
            Block.createCuboidShape(2.25, 0, 17, 3.75, 7.75, 18.5),
            Block.createCuboidShape(2.25, 0, -2.5, 3.75, 7.75, -1),
            Block.createCuboidShape(2.25, 7.75, -2.5, 13.75, 9.25, 18.5),
            Block.createCuboidShape(3.75, 2.625, -2, 12.25, 3.625, 18)
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
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_ITEM);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CoffeeTableBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.SUCCESS;

        CoffeeTableBlockEntity be = (CoffeeTableBlockEntity) world.getBlockEntity(pos);
        ItemStack held = player.getMainHandStack();

        assert be != null;
        if (be.getItem().isEmpty() && !held.isEmpty()) {
            ItemStack put = held.copy(); put.setCount(1);
            be.setItem(put);
            held.decrement(1);
        } else if (!be.getItem().isEmpty()) {
            ItemScatterer.spawn(world, pos.getX()+0.5, pos.getY()+1, pos.getZ()+0.5, be.getItem());
            be.setItem(ItemStack.EMPTY);
        }
        return ActionResult.CONSUME;
    }

    @Override
    public void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
        if (state.getBlock() != state.getBlock()) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof CoffeeTableBlockEntity ct) {
                ItemStack s = ct.getItem();
                if (!s.isEmpty()) ItemScatterer.spawn(world, pos, DefaultedList.copyOf(ItemStack.EMPTY, s));
            }
            super.onStateReplaced(state, world, pos, moved);
        } else super.onStateReplaced(state, world, pos, moved);
    }

    @Override
    public BlockState onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        if (!world.isClient()) {
            BlockEntity be = world.getBlockEntity(pos);
            if (be instanceof CoffeeTableBlockEntity table) {
                ItemStack s = table.getItem();
                if (!s.isEmpty()) {
                    ItemScatterer.spawn(world, pos.getX(), pos.getY(), pos.getZ(), s);
                    table.setItem(ItemStack.EMPTY);
                }
            }
        }
        super.onBreak(world, pos, state, player);
        return state;
    }
}