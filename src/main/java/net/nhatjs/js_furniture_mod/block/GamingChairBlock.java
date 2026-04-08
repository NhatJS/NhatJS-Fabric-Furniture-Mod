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

public class GamingChairBlock extends FurnitureHorizontalBlock {
    public GamingChairBlock(Settings settings) {
        super(settings);
    }

    private static final VoxelShape DEFAULT = VoxelShapes.union(
            Block.createCuboidShape(2, 0, 2.1, 14, 2.7, 13.9),
            Block.createCuboidShape(6.5, 2.7, 6.5, 9.5, 8.5, 9.5)
    );

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(4.45, 8.5, 2.4, 11.55, 10, 13.3),
            Block.createCuboidShape(2, 10, 12.35, 14, 28.2, 13.3),
            Block.createCuboidShape(2.8, 8.5, 2.4, 4.45, 11.35, 13.3),
            Block.createCuboidShape(11.55, 8.5, 2.4, 13.2, 11.35, 13.3),
            Block.createCuboidShape(13.05, 14.85, 2.8, 15.1, 15.35, 9.2),
            Block.createCuboidShape(0.9, 14.85, 2.8, 2.953, 15.35, 9.2),
            Block.createCuboidShape(1.55, 8.1, 5.1, 2.3, 14.85, 6.8),
            Block.createCuboidShape(13.7, 8.1, 5.1, 14.45, 14.85, 6.8),
            Block.createCuboidShape(2.3, 8.1, 5.6, 13.7, 8.5, 6.3)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(4.45, 8.5, 2.7, 11.55, 10, 13.6),
            Block.createCuboidShape(2, 10, 2.7, 14, 28.2, 3.65),
            Block.createCuboidShape(11.55, 8.5, 2.7, 13.2, 11.35, 13.6),
            Block.createCuboidShape(2.6, 8.5, 2.7, 4.45, 11.35, 13.6),
            Block.createCuboidShape(0.9, 14.85, 6.8, 2.95, 15.35, 13.2),
            Block.createCuboidShape(13.05, 14.85, 6.8, 15.1, 15.35, 13.2),
            Block.createCuboidShape(13.7, 8.1, 9.2, 14.45, 14.85, 10.9),
            Block.createCuboidShape(1.55, 8.1, 9.2, 2.3, 14.85, 10.9),
            Block.createCuboidShape(2.3, 8.1, 9.7, 13.7, 8.5, 10.4)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(2.7, 8.5, 4.45, 13.6, 10, 11.55),
            Block.createCuboidShape(2.7, 10, 2, 3.65, 28.2, 14),
            Block.createCuboidShape(2.7, 8.5, 2.8, 13.6, 11.35, 4.45),
            Block.createCuboidShape(2.7, 8.5, 11.55, 13.6, 11.35, 13.2),
            Block.createCuboidShape(6.8, 14.85, 13.05, 13.2, 15.35, 15.1),
            Block.createCuboidShape(6.8, 14.85, 0.9, 13.2, 15.35, 2.95),
            Block.createCuboidShape(9.2, 8.1, 1.55, 10.9, 14.85, 2.3),
            Block.createCuboidShape(9.2, 8.1, 13.7, 10.9, 14.85, 14.45),
            Block.createCuboidShape(9.7, 8.1, 2.3, 10.4, 8.5, 13.7)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(2.4, 8.5, 4.45, 13.3, 10, 11.55),
            Block.createCuboidShape(12.35, 10, 2, 13.3, 28.2, 14),
            Block.createCuboidShape(2.4, 8.5, 11.55, 13.3, 11.35, 13.2),
            Block.createCuboidShape(2.4, 8.5, 2.6, 13.3, 11.35, 4.45),
            Block.createCuboidShape(2.6, 14.85, 0.9, 9.2, 15.35, 2.95),
            Block.createCuboidShape(2.6, 14.85, 13.05, 9.2, 15.35, 15.1),
            Block.createCuboidShape(5.1, 8.1, 13.7, 6.8, 14.85, 14.45),
            Block.createCuboidShape(5.1, 8.1, 1.55, 6.8, 14.85, 2.3),
            Block.createCuboidShape(5.6, 8.1, 2.3, 6.3, 8.5, 13.7)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> VoxelShapes.union(DEFAULT, NORTH);
            case SOUTH -> VoxelShapes.union(DEFAULT, SOUTH);
            case EAST -> VoxelShapes.union(DEFAULT, EAST);
            case WEST -> VoxelShapes.union(DEFAULT, WEST);
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
