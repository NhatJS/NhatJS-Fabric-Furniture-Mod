package net.nhatjs.js_furniture_mod.block.core;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;

public class FurnitureDirectionalBlock extends FacingBlock {
    public static MapCodec<FurnitureDirectionalBlock> CODEC = createCodec(FurnitureDirectionalBlock::new);

    public FurnitureDirectionalBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends FacingBlock> getCodec() {
        return CODEC;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite());
    }
}
