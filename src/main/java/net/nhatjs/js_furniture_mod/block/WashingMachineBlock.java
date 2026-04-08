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
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.blockentity.WashingMachineBlockEntity;
import org.jetbrains.annotations.Nullable;

public class WashingMachineBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public WashingMachineBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TURN_ON);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(0, 0, 0, 16, 23, 16);
        };
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new WashingMachineBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (player.isSneaking()) {
            boolean current = state.get(TURN_ON);
            world.setBlockState(pos, state.with(TURN_ON, !current), 3);
        }
        else {
            BlockEntity entity = world.getBlockEntity(pos);
            if (!(entity instanceof WashingMachineBlockEntity light)) return ActionResult.PASS;
            light.setPowered(!light.isPowered());
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        }
        return ActionResult.SUCCESS;
    }
}
