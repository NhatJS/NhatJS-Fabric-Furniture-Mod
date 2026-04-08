package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
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

public class ToiletBlock extends FurnitureHorizontalBlock {
    public static final BooleanProperty OPEN = BooleanProperty.of("open");

    public ToiletBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(OPEN, false));
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 13.35, 12, 7.85, 14.675),
            Block.createCuboidShape(4, 7.85, 13.35, 12, 17.35, 16),
            Block.createCuboidShape(4, 6.35, 2.15, 12, 9.325, 13.35),
            Block.createCuboidShape(5.325, 0, 5.35, 10.675, 6.35, 13.35)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(4, 0, 1.325, 12, 7.85, 2.65),
            Block.createCuboidShape(4, 7.85, 0, 12, 17.35, 2.65),
            Block.createCuboidShape(4, 6.35, 2.65, 12, 9.325, 13.85),
            Block.createCuboidShape(5.325, 0, 2.65, 10.675, 6.35, 10.65)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(1.325, 0, 4, 2.65, 7.85, 12),
            Block.createCuboidShape(0, 7.85, 4, 2.65, 17.35, 12),
            Block.createCuboidShape(2.65, 6.35, 4, 13.85, 9.325, 12),
            Block.createCuboidShape(2.65, 0, 5.325, 10.65, 6.35, 10.675)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(13.35, 0, 4, 14.675, 7.85, 12),
            Block.createCuboidShape(13.35, 7.85, 4, 16, 17.35, 12),
            Block.createCuboidShape(2.15, 6.35, 4, 13.35, 9.325, 12),
            Block.createCuboidShape(5.35, 0, 5.325, 13.35, 6.35, 10.675)
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
        builder.add(FACING, OPEN);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            boolean current = state.get(OPEN);
            world.setBlockState(pos, state.with(OPEN, !current), 3, Block.NOTIFY_ALL);
        }
        return ActionResult.SUCCESS;
    }
}