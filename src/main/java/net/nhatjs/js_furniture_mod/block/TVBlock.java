package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class TVBlock extends Block {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final EnumProperty<Mount> MOUNT = EnumProperty.of("mount", Mount.class);

    public TVBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(MOUNT, Mount.STAND));
    }

    public enum Mount implements StringIdentifiable
    {
        STAND("stand"),
        WALL("wall");

        private final String name;

        Mount(String name)
        {
            this.name = name;
        }

        @Override
        public String asString()
        {
            return name;
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, MOUNT);
    }

    private static final VoxelShape NORTH_MOUNT = Block.createCuboidShape(0, 0, 15, 16, 16, 16);
    private static final VoxelShape SOUTH_MOUNT = Block.createCuboidShape(0, 0, 0, 16, 16, 1);
    private static final VoxelShape WEST_MOUNT = Block.createCuboidShape(15, 0, 0, 16, 16, 16);
    private static final VoxelShape EAST_MOUNT = Block.createCuboidShape(0, 0, 0, 1, 16, 16);

    private static final VoxelShape NORTH_STAND = Block.createCuboidShape(0, 0, 14, 16, 15, 15);
    private static final VoxelShape SOUTH_STAND = Block.createCuboidShape(0, 0, 1, 16, 15, 2);
    private static final VoxelShape WEST_STAND = Block.createCuboidShape(14, 0, 0, 15, 15, 16);
    private static final VoxelShape EAST_STAND = Block.createCuboidShape(1, 0, 0, 2, 15, 16);

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        Direction direction = state.get(FACING);
        boolean wall = state.get(MOUNT) == Mount.WALL;
        return switch (state.get(FACING)) {
            default -> wall ? NORTH_MOUNT : VoxelShapes.union(NORTH_STAND);
            case SOUTH -> wall ? SOUTH_MOUNT : VoxelShapes.union(SOUTH_STAND);
            case EAST -> wall ? EAST_MOUNT : VoxelShapes.union(EAST_STAND);
            case WEST -> wall ? WEST_MOUNT : VoxelShapes.union(WEST_STAND);
        };
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction face = ctx.getSide();
        if (face.getAxis().isHorizontal()) {
            BlockPos back = ctx.getBlockPos().offset(face.getOpposite());
            if (hasSupport(ctx.getWorld(), back, face)) {
                return getDefaultState()
                        .with(FACING, face)
                        .with(MOUNT, Mount.WALL);
            }
            return null;
        }
        return getDefaultState()
                .with(FACING, ctx.getHorizontalPlayerFacing().getOpposite())
                .with(MOUNT, Mount.STAND);
    }

    private boolean hasSupport(WorldView world, BlockPos pos, Direction supportFace) {
        BlockState bs = world.getBlockState(pos);
        return bs.isSideSolidFullSquare(world, pos, supportFace) || bs.isSolidBlock(world, pos);
    }
}