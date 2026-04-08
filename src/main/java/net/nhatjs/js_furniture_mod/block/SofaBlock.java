package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import net.minecraft.world.tick.ScheduledTickView;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.core.ModEntities;
import net.nhatjs.js_furniture_mod.entity.SeatBlockEntity;

import java.util.List;

public class SofaBlock extends FurnitureHorizontalBlock {
    public static final EnumProperty<Sofa> SOFA = EnumProperty.of("sofa", Sofa.class);

    public SofaBlock(Settings settings)
    {
        super(settings);
    }

    public enum Sofa implements StringIdentifiable
    {
        SINGLE("single"),
        LEFT("left"),
        RIGHT("right"),
        MIDDLE("middle"),
        CORNER_LEFT("corner_left"),
        CORNER_RIGHT("corner_right");

        private final String name;

        Sofa(String name)
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
        builder.add(FACING, SOFA);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState state = this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
        if(state != null)
        {
            return state.with(SOFA, this.getShape(state, ctx.getWorld(), ctx.getBlockPos()));
        }
        return null;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(0, 0.5, 0, 16, 7.525, 16);
        };
    }

    @Override
    protected BlockState getStateForNeighborUpdate(BlockState state, WorldView world, ScheduledTickView tickView, BlockPos pos, Direction dir, BlockPos neighborPos, BlockState neighborState, Random random) {
        return state.with(SOFA, this.getShape(state, (WorldAccess) world, pos));
    }

    public Sofa getShape(BlockState state, WorldAccess level, BlockPos pos)
    {
        Direction facing = state.get(FACING);
        Direction front = this.getSofaState(level, pos, facing);
        if(front != null)
        {
            if(front == facing.rotateYClockwise())
            {
                return Sofa.CORNER_RIGHT;
            }
            else if(front == facing.rotateYCounterclockwise())
            {
                return Sofa.CORNER_LEFT;
            }
        }
        boolean left = this.isConnectable(level, pos, facing, facing.rotateYClockwise());
        boolean right = this.isConnectable(level, pos, facing, facing.rotateYCounterclockwise());
        if(left && right)
        {
            return Sofa.MIDDLE;
        }
        else if(left)
        {
            return Sofa.RIGHT;
        }
        else if(right)
        {
            return Sofa.LEFT;
        }
        return Sofa.SINGLE;
    }

    private Direction getSofaState(WorldAccess level, BlockPos pos, Direction side)
    {
        BlockState relativeState = level.getBlockState(pos.offset(side));
        return relativeState.getBlock() instanceof SofaBlock ? relativeState.get(FACING) : null;
    }

    private boolean isConnectable(WorldAccess level, BlockPos pos, Direction facing, Direction offset)
    {
        BlockPos relativePos = pos.offset(offset);
        BlockState relativeState = level.getBlockState(pos.offset(offset));
        if(relativeState.getBlock() instanceof SofaBlock)
        {
            Direction other = relativeState.get(FACING);
            return other == facing || other == offset.getOpposite();
        }
        return relativeState.isSideSolidFullSquare(level, relativePos, offset);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            Entity entity = null;
            List<SeatBlockEntity> entities = world.getEntitiesByType(ModEntities.SOFA, new Box(pos), seatBlockEntity -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.SOFA.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }
        return ActionResult.SUCCESS;
    }
}