package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.blockentity.MonitorBlockEntity;
import org.jetbrains.annotations.Nullable;

public class MonitorSetupBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public MonitorSetupBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    private static VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(4.1, 0, 9.1, 11.9, 0.75, 15),
            Block.createCuboidShape(6.9, 0.75, 12, 9.1, 10.95, 14.25),
            Block.createCuboidShape(7.15, 7.7, 11.15, 8.85, 8.75, 12),
            Block.createCuboidShape(0.1, 3.525, 9.8, 15.9, 12.475, 11.15),
            Block.createCuboidShape(1.675, 0, 3.375, 2.975, 0.725, 5.625),
            Block.createCuboidShape(4.7, 0, 2.75, 14.625, 0.275, 6.4)
    );

    private static VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(4.1, 0, 1, 11.9, 0.75, 6.9),
            Block.createCuboidShape(6.9, 0.75, 1.75, 9.1, 10.95, 4),
            Block.createCuboidShape(7.15, 7.7, 4, 8.85, 8.75, 4.85),
            Block.createCuboidShape(0.1, 3.525, 4.85, 15.9, 12.475, 6.2),
            Block.createCuboidShape(12.975, 0, 10.375, 14.275, 0.725, 12.625),
            Block.createCuboidShape(1.325, 0, 9.6, 11.25, 0.275, 13.25)
    );

    private static VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(1, 0, 4.1, 6.9, 0.75, 11.9),
            Block.createCuboidShape(1.75, 0.75, 6.9, 4, 10.95, 9.1),
            Block.createCuboidShape(4, 7.7, 7.15, 4.85, 8.75, 8.85),
            Block.createCuboidShape(4.85, 3.525, 0.1, 6.2, 12.475, 15.9),
            Block.createCuboidShape(10.35, 0, 1.7, 12.6, 0.725, 3),
            Block.createCuboidShape(9.575, 0, 4.725, 13.225, 0.275, 14.65)
    );

    private static VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(9.1, 0, 4.1, 15, 0.75, 11.9),
            Block.createCuboidShape(12, 0.75, 6.9, 14.25, 10.95, 9.1),
            Block.createCuboidShape(11.15, 7.7, 7.15, 12, 8.75, 8.85),
            Block.createCuboidShape(9.8, 3.525, 0.1, 11.15, 12.475, 15.9),
            Block.createCuboidShape(3.35, 0, 13, 5.6, 0.725, 14.3),
            Block.createCuboidShape(2.725, 0, 1.35, 6.375, 0.275, 11.275)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> NORTH;
            case SOUTH -> SOUTH;
            case EAST -> EAST;
            case WEST -> WEST;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TURN_ON);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new MonitorBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            BlockEntity entity = world.getBlockEntity(pos);
            if (!(entity instanceof MonitorBlockEntity monitor)) return ActionResult.PASS;
            monitor.setPowered(!monitor.isPowered());
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        }
        return ActionResult.SUCCESS;
    }
}
