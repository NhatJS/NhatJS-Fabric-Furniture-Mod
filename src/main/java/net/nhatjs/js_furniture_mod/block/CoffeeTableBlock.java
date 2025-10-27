package net.nhatjs.js_furniture_mod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.blockentity.client.CoffeeTableBlockEntity;

public class CoffeeTableBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty HAS_ITEM = BooleanProperty.of("has_item");

    public CoffeeTableBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(-2.5, 0, 2.25, -1.25, 8, 3.5),
            Block.createCuboidShape(17.25, 0, 2.25, 18.5, 8, 3.5),
            Block.createCuboidShape(17.25, 0, 12.5, 18.5, 8, 13.75),
            Block.createCuboidShape(-2.5, 0, 12.5, -1.25, 8, 13.75),
            Block.createCuboidShape(-2, 4.625, 3.5, 8, 4.975, 12.5),
            Block.createCuboidShape(-2.5, 8, 2.25, 18.5, 9.25, 13.75),
            Block.createCuboidShape(8, 4.625, 3.5, 18, 4.975, 12.5)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(12.5, 0, -2.5, 13.75, 8, -1.25),
            Block.createCuboidShape(12.5, 0, 17.25, 13.75, 8, 18.5),
            Block.createCuboidShape(2.25, 0, 17.25, 3.5, 8, 18.5),
            Block.createCuboidShape(2.25, 0, -2.5, 3.5, 8, -1.25),
            Block.createCuboidShape(3.5, 4.625, -2, 12.5, 4.975, 8),
            Block.createCuboidShape(2.25, 8, -2.5, 13.75, 9.25, 18.5),
            Block.createCuboidShape(3.5, 4.625, 8, 12.5, 4.975, 18)
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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(HAS_ITEM, false);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, HAS_ITEM);
    }

    public static final MapCodec<CoffeeTableBlock> CODEC = createCodec(CoffeeTableBlock::new);

    @Override
    public MapCodec<CoffeeTableBlock> getCodec() {
        return CODEC;
    }

    @Override public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        System.out.println("[CoffeeTableBlock] createBlockEntity at " + pos);
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
            be.markDirty();
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
            if (be instanceof CoffeeTableBlockEntity table) {
                ItemStack s = table.getItem();
                if (!s.isEmpty()) {
                    ItemScatterer.spawn(world, pos.getX() + 0.5, pos.getY() + 0.8, pos.getZ() + 0.5, s);
                }
            }
            super.onStateReplaced(state, world, pos, moved);
        }
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