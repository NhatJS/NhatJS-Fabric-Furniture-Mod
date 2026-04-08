package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.core.PCHorizontalBlock;
import net.nhatjs.js_furniture_mod.blockentity.DesktopBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.core.ModItems;
import org.jetbrains.annotations.Nullable;

public class DesktopAltBlock extends PCHorizontalBlock implements BlockEntityProvider {
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public DesktopAltBlock(Settings settings) {
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
    public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new DesktopBlockEntity(pos, state);
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.SUCCESS;
        ItemStack held = player.getMainHandStack();
        BlockEntity entity = world.getBlockEntity(pos);
        if (!(entity instanceof DesktopBlockEntity pc)) return ActionResult.PASS;

        if (!held.isOf(ModItems.REMOTE_CONTROL_RGB)) {
            pc.setPowered(!pc.isPowered());
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        }

        if (held.isOf(ModItems.REMOTE_CONTROL_RGB)) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            boolean turnOn = state.get(TURN_ON);
            boolean wasPowered = pc.isPowered();
            pc.setPowered(pc.isPowered());
            BlockState newState = ModBlocks.PC.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing)
                    .with(DesktopBlock.TURN_ON, turnOn);
            world.setBlockState(pos, newState, Block.NOTIFY_ALL);
            BlockEntity newEntity = world.getBlockEntity(pos);
            if (newEntity instanceof DesktopBlockEntity newPc) {
                newPc.setPowered(wasPowered);
            }
        }

        return ActionResult.SUCCESS;
    }
}
