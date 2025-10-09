package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootWorldContext;
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
import net.nhatjs.js_furniture_mod.item.ModItems;

import java.util.Collections;
import java.util.List;

public class LEDFloorLampRGBAltBlock extends Block{
    public static final EnumProperty<Direction> FACING = Properties.HORIZONTAL_FACING;
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public LEDFloorLampRGBAltBlock(Settings settings) {
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
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos,
                              PlayerEntity player, BlockHitResult hit) {
        if (world.isClient()) return ActionResult.SUCCESS;
        ItemStack held = player.getMainHandStack();

        if (!held.isOf(ModItems.REMOTE_CONTROL_RGB)) {
            boolean next = !state.get(TURN_ON);
            world.setBlockState(pos, state.with(TURN_ON, next), Block.NOTIFY_ALL);
            return ActionResult.SUCCESS;
        }

        if (held.isOf(ModItems.REMOTE_CONTROL_RGB) && state.get(TURN_ON)) {
            Direction facing =  state.get(HorizontalFacingBlock.FACING);
            world.setBlockState(pos, ModBlocks.LED_FLOOR_LAMP_RGB_OFF.getDefaultState()
                    .with(HorizontalFacingBlock.FACING, facing)
                    .with(LEDFloorLampRGBBlock.TURN_ON, true), Block.NOTIFY_ALL);
            return ActionResult.SUCCESS;
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public List<ItemStack> getDroppedStacks(BlockState state, LootWorldContext.Builder builder) {
        return Collections.singletonList(new ItemStack(ModBlocks.LED_FLOOR_LAMP_RGB_OFF_2));
    }
}
