package net.nhatjs.js_furniture_mod.block.core;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;

public class NonFunctionalSimpleBlock extends FurnitureHorizontalBlock {
    public NonFunctionalSimpleBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
