package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class LaptopBlock extends Block {
    public static final DirectionProperty FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");
    public static final BooleanProperty OPEN = BooleanProperty.of("open");

    public LaptopBlock(Settings settings) {
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
            default -> Block.createCuboidShape(1.975, 0, 3, 14.025, 1.25, 12.25);
            case SOUTH -> Block.createCuboidShape(1.975, 0, 3.75, 14.025, 1.25, 13);
            case EAST -> Block.createCuboidShape(3.75, 0, 1.975, 13, 1.25, 14.025);
            case WEST -> Block.createCuboidShape(3, 0, 1.975, 12.25, 1.25, 14.025);
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;

        boolean open = state.get(OPEN);
        boolean turnOn = state.get(TURN_ON);

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

        if (open == true) {
            if (turnOn) {
                world.setBlockState(pos, state.with(TURN_ON, false));
            } else {
                world.setBlockState(pos, state.with(TURN_ON, true));
                return ActionResult.CONSUME;
            }
            return ActionResult.CONSUME;
        }

        return ActionResult.CONSUME;
    }
}
