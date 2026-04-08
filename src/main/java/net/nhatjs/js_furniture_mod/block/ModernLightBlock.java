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
import net.nhatjs.js_furniture_mod.block.core.FurnitureDirectionalBlock;
import net.nhatjs.js_furniture_mod.blockentity.LightBlockEntity;
import org.jetbrains.annotations.Nullable;

public class ModernLightBlock extends FurnitureDirectionalBlock implements BlockEntityProvider {
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public ModernLightBlock(Settings settings) {
        super(settings.luminance(st -> st.get(TURN_ON) ? 12 : 0));
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(6, 6, 15.5, 10, 10, 16);
            case SOUTH -> Block.createCuboidShape(6, 6, 0, 10, 10, 0.5);
            case EAST -> Block.createCuboidShape(0, 6, 6, 0.5, 10, 10);
            case WEST -> Block.createCuboidShape(15.5, 6, 6, 16, 10, 10);
            case UP -> Block.createCuboidShape(6, 0, 6, 10, 0.5, 10);
            case DOWN -> Block.createCuboidShape(6, 15.5, 6, 10, 16, 10);
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TURN_ON);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LightBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            BlockEntity entity = world.getBlockEntity(pos);
            if (!(entity instanceof LightBlockEntity light)) return ActionResult.PASS;
            light.setPowered(!light.isPowered());
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        }
        return ActionResult.SUCCESS;
    }
}
