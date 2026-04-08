package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.blockentity.LaptopBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import org.jetbrains.annotations.Nullable;

public class PortableLaptopStandAddedBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");
    public static final BooleanProperty OPEN = BooleanProperty.of("open");

    public PortableLaptopStandAddedBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false)
                .with(OPEN, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TURN_ON, OPEN);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(1.95, 0, 3.5, 14.05, 4.45, 12.5);
            case SOUTH -> Block.createCuboidShape(1.95, 0, 3.5, 14.05, 4.45, 12.5);
            case EAST -> Block.createCuboidShape(3.5, 0, 1.95, 12.5, 4.45, 14.05);
            case WEST -> Block.createCuboidShape(3.5, 0, 1.95, 12.5, 4.45, 14.05);
        };
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LaptopBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        boolean open = state.get(OPEN);
        boolean turnOn = state.get(TURN_ON);

        double x = hit.getPos().x;
        double y = hit.getPos().y;
        double z = hit.getPos().z;

        if (player.isSneaking()) {
            if (open == false) {
                world.setBlockState(pos, state.with(OPEN, true));
                return ActionResult.CONSUME;
            }
            if (open == true) {
                if (turnOn) return ActionResult.CONSUME;
                world.setBlockState(pos, state.with(OPEN, false));
                return ActionResult.CONSUME;
            }
            return ActionResult.CONSUME;
        }
        else if (!player.isSneaking() && open == false && player.getMainHandStack().isEmpty()) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            world.setBlockState(pos, ModBlocks.PORTABLE_LAPTOP_STAND.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing), Block.NOTIFY_ALL);
            if (world instanceof ServerWorld _level) {
                ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, new ItemStack(ModBlocks.LAPTOP));
                entityToSpawn.setPickupDelay(10);
                _level.spawnEntity(entityToSpawn);
            }

            return ActionResult.SUCCESS;
        }

        if (open == true) {
            if (turnOn) {
                world.setBlockState(pos, state.with(TURN_ON, false));
            } else {
                world.setBlockState(pos, state.with(TURN_ON, true));
            }
            BlockEntity entity = world.getBlockEntity(pos);
            if (!(entity instanceof LaptopBlockEntity light)) return ActionResult.PASS;
            light.setPowered(!light.isPowered());
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        }
        return ActionResult.CONSUME;
    }
}
