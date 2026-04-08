package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.nhatjs.js_furniture_mod.block.core.FurnitureHorizontalBlock;

public class DesktopTowerGlassBlock extends FurnitureHorizontalBlock {
    public DesktopTowerGlassBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}