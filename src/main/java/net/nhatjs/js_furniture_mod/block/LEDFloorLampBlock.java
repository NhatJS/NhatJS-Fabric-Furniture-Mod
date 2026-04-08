package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;
import net.nhatjs.js_furniture_mod.blockentity.LampBlockEntity;
import org.jetbrains.annotations.Nullable;

public class LEDFloorLampBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public LEDFloorLampBlock(Settings settings) {
        super(settings.luminance(st -> st.get(TURN_ON) ? 12 : 0));
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    private static final VoxelShape HORIZONTAL = VoxelShapes.union(
            Block.createCuboidShape(7, 0.5, 7.5, 9, 29.75, 8.5),
            Block.createCuboidShape(5.75, 0, 5.75, 10.25, 0.5, 10.25)
    );

    private static final VoxelShape VERTICAL = VoxelShapes.union(
            Block.createCuboidShape(7.5, 0.5, 7, 8.5, 29.75, 9),
            Block.createCuboidShape(5.75, 0, 5.75, 10.25, 0.5, 10.25)
    );

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> HORIZONTAL;
            case SOUTH -> HORIZONTAL;
            case EAST -> VERTICAL;
            case WEST -> VERTICAL;
        };
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING, TURN_ON);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new LampBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            BlockEntity entity = world.getBlockEntity(pos);
            if (!(entity instanceof LampBlockEntity floorLamp)) return ActionResult.PASS;
            floorLamp.setPowered(!floorLamp.isPowered());
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        }
        return ActionResult.SUCCESS;
    }
}
