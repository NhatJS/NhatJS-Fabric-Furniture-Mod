package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.core.ModEntities;
import net.nhatjs.js_furniture_mod.entity.SeatBlockEntity;

import java.util.List;

public class ChairBlock extends FurnitureHorizontalBlock {
    public ChairBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(4, 9, 12.5, 12, 11, 14.25),
            Block.createCuboidShape(4, 21.5, 12.75, 12, 23.5, 13.75),
            Block.createCuboidShape(4, 18.5, 12.75, 12, 20.5, 13.75),
            Block.createCuboidShape(4, 15.5, 12.75, 12, 17.5, 13.75),
            Block.createCuboidShape(2.25, 9, 1.75, 13.75, 11, 12.5),
            Block.createCuboidShape(12, 0, 12.5, 13.75, 24, 14.25),
            Block.createCuboidShape(12, 0, 1.75, 13.75, 9, 3.5),
            Block.createCuboidShape(2.5, 6, 3.5, 3.5, 8, 12.5),
            Block.createCuboidShape(12.5, 6, 3.5, 13.5, 8, 12.5),
            Block.createCuboidShape(3.75, 6, 2.25, 12.25, 8, 3.25),
            Block.createCuboidShape(2.25, 0, 1.75, 4, 9, 3.5),
            Block.createCuboidShape(2.25, 0, 12.5, 4, 24, 14.25)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(4, 9, 1.75, 12, 11, 3.5),
            Block.createCuboidShape(4, 21.5, 2.25, 12, 23.5, 3.25),
            Block.createCuboidShape(4, 18.5, 2.25, 12, 20.5, 3.25),
            Block.createCuboidShape(4, 15.5, 2.25, 12, 17.5, 3.25),
            Block.createCuboidShape(2.25, 9, 3.5, 13.75, 11, 14.25),
            Block.createCuboidShape(2.25, 0, 1.75, 4, 24, 3.5),
            Block.createCuboidShape(2.25, 0, 12.5, 4, 9, 14.25),
            Block.createCuboidShape(12.5, 6, 3.5, 13.5, 8, 12.5),
            Block.createCuboidShape(2.5, 6, 3.5, 3.5, 8, 12.5),
            Block.createCuboidShape(3.75, 6, 12.75, 12.25, 8, 13.75),
            Block.createCuboidShape(12, 0, 12.5, 13.75, 9, 14.25),
            Block.createCuboidShape(12, 0, 1.75, 13.75, 24, 3.5)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(1.75, 9, 4, 3.5, 11, 12),
            Block.createCuboidShape(2.25, 21.5, 4, 3.25, 23.5, 12),
            Block.createCuboidShape(2.25, 18.5, 4, 3.25, 20.5, 12),
            Block.createCuboidShape(2.25, 15.5, 4, 3.25, 17.5, 12),
            Block.createCuboidShape(3.5, 9, 2.25, 14.25, 11, 13.75),
            Block.createCuboidShape(1.75, 0, 12, 3.5, 24, 13.75),
            Block.createCuboidShape(12.5, 0, 12, 14.25, 9, 13.75),
            Block.createCuboidShape(3.5, 6, 2.5, 12.5, 8, 3.5),
            Block.createCuboidShape(3.5, 6, 12.5, 12.5, 8, 13.5),
            Block.createCuboidShape(12.75, 6, 3.75, 13.75, 8, 12.25),
            Block.createCuboidShape(12.5, 0, 2.25, 14.25, 9, 4),
            Block.createCuboidShape(1.75, 0, 2.25, 3.5, 24, 4)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(12.5, 9, 4, 14.25, 11, 12),
            Block.createCuboidShape(12.75, 21.5, 4, 13.75, 23.5, 12),
            Block.createCuboidShape(12.75, 18.5, 4, 13.75, 20.5, 12),
            Block.createCuboidShape(12.75, 15.5, 4, 13.75, 17.5, 12),
            Block.createCuboidShape(1.75, 9, 2.25, 12.5, 11, 13.75),
            Block.createCuboidShape(12.5, 0, 2.25, 14.25, 24, 4),
            Block.createCuboidShape(1.75, 0, 2.25, 3.5, 9, 4),
            Block.createCuboidShape(3.5, 6, 12.5, 12.5, 8, 13.5),
            Block.createCuboidShape(3.5, 6, 2.5, 12.5, 8, 3.5),
            Block.createCuboidShape(2.25, 6, 3.75, 3.25, 8, 12.25),
            Block.createCuboidShape(1.75, 0, 12, 3.5, 9, 13.75),
            Block.createCuboidShape(12.5, 0, 12, 14.25, 24, 13.75)
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
        builder.add(FACING);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            Entity entity = null;
            List<SeatBlockEntity> entities = world.getEntitiesByType(ModEntities.CHAIR, new Box(pos), seatBlockEntity -> true);
            if(entities.isEmpty()) {
                entity = ModEntities.CHAIR.spawn((ServerWorld) world, pos, SpawnReason.TRIGGERED);
            } else {
                entity = entities.get(0);
            }

            player.startRiding(entity);
        }
        return ActionResult.SUCCESS;
    }
}
