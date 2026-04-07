package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
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
import net.nhatjs.js_furniture_mod.blockentity.DesktopBlockEntity;
import net.nhatjs.js_furniture_mod.blockentity.LampBlockEntity;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.core.ModItems;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;

public class LEDFloorLampRGBBlock extends FurnitureHorizontalBlock implements BlockEntityProvider {
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public LEDFloorLampRGBBlock(Settings settings) {
        super(settings.luminance(st -> st.get(TURN_ON) ? 12 : 0));
        this.setDefaultState(this.stateManager.getDefaultState()
                .with(FACING, Direction.NORTH)
                .with(TURN_ON, false));
    }

    private static final VoxelShape NORTH = VoxelShapes.union(
            Block.createCuboidShape(1, 0, 15, 6, 0.75, 15.75),
            Block.createCuboidShape(0.25, 0, 10, 1, 0.75, 15.75),
            Block.createCuboidShape(0.25, 0.75, 15, 1, 32, 15.75)
    );

    private static final VoxelShape SOUTH = VoxelShapes.union(
            Block.createCuboidShape(10, 0, 0.25, 15, 0.75, 1),
            Block.createCuboidShape(15, 0, 0.25, 15.75, 0.75, 6),
            Block.createCuboidShape(15, 0.75, 0.25, 15.75, 32, 1)
    );

    private static final VoxelShape EAST = VoxelShapes.union(
            Block.createCuboidShape(0.25, 0, 1, 1, 0.75, 6),
            Block.createCuboidShape(0.25, 0, 0.25, 6, 0.75, 1),
            Block.createCuboidShape(0.25, 0.75, 0.25, 1, 32, 1)
    );

    private static final VoxelShape WEST = VoxelShapes.union(
            Block.createCuboidShape(15, 0, 10, 15.75, 0.75, 15),
            Block.createCuboidShape(10, 0, 15, 15.75, 0.75, 15.75),
            Block.createCuboidShape(15, 0.75, 15, 15.75, 32, 15.75)
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
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient) return ActionResult.SUCCESS;
        ItemStack held = player.getMainHandStack();
        BlockEntity entity = world.getBlockEntity(pos);
        if (!(entity instanceof LampBlockEntity lampRGB)) return ActionResult.PASS;

        if (!held.isOf(ModItems.REMOTE_CONTROL_RGB)) {
            lampRGB.setPowered(!lampRGB.isPowered());
            world.updateListeners(pos, state, state, Block.NOTIFY_ALL);
        }

        if (held.isOf(ModItems.REMOTE_CONTROL_RGB)) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            boolean turnOn = state.get(TURN_ON);
            boolean wasPowered = lampRGB.isPowered();
            lampRGB.setPowered(lampRGB.isPowered());
            BlockState newState = ModBlocks.LED_FLOOR_LAMP_RGB_OFF_2.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing)
                    .with(LEDFloorLampRGBAltBlock.TURN_ON, turnOn);
            world.setBlockState(pos, newState, Block.NOTIFY_ALL);
            BlockEntity newEntity = world.getBlockEntity(pos);
            if (newEntity instanceof LampBlockEntity lampRGBAlt) {
                lampRGBAlt.setPowered(wasPowered);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        return Collections.singletonList(new ItemStack(ModBlocks.LED_FLOOR_LAMP_RGB_OFF));
    }
}
