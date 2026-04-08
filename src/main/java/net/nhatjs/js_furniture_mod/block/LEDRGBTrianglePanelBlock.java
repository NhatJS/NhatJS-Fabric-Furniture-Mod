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
import net.nhatjs.js_furniture_mod.blockentity.LampBlockEntity;
import org.jetbrains.annotations.Nullable;

public class LEDRGBTrianglePanelBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public LEDRGBTrianglePanelBlock(Settings settings) {
        super(settings.luminance(st -> st.get(TURN_ON) ? 12 : 0));
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            default -> Block.createCuboidShape(0, 0, 15.5, 16, 16, 16);
            case SOUTH -> Block.createCuboidShape(0, 0, 0, 16, 16, 0.5);
            case EAST -> Block.createCuboidShape(0, 0, 0, 0.5, 16, 16);
            case WEST -> Block.createCuboidShape(15.5, 0, 0, 16, 16, 16);
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
            if (!(entity instanceof LampBlockEntity panelRGB)) return ActionResult.PASS;
            panelRGB.setPowered(!panelRGB.isPowered());
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        }
        return ActionResult.SUCCESS;
    }
}
