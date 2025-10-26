package net.nhatjs.js_furniture_mod.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.blockentity.client.CeilingFanBlockEntity;
import org.jetbrains.annotations.Nullable;

public class CeilingFanBlock extends BlockWithEntity {
    public static final BooleanProperty TURN_ON = BooleanProperty.of("turn_on");

    public CeilingFanBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(TURN_ON, false));
    }

    public static final MapCodec<CeilingFanBlock> CODEC = createCodec(CeilingFanBlock::new);

    @Override
    public MapCodec<CeilingFanBlock> getCodec() {
        return CODEC;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return Block.createCuboidShape(0, 11, 0, 16, 16, 16);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(TURN_ON);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        if (!world.isClient()) {
            world.setBlockState(pos, state.cycle(TURN_ON), Block.NOTIFY_ALL);
        }
        return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CeilingFanBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state,
                                                                  BlockEntityType<T> type) {
        return world.isClient
                ? (w, p, s, be) -> ((CeilingFanBlockEntity) be).tick()
                : null;
    }
}