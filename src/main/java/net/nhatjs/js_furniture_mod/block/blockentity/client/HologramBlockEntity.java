package net.nhatjs.js_furniture_mod.block.blockentity.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.js_furniture_mod.block.blockentity.ModBlockEntities;

public class HologramBlockEntity extends BlockEntity {
    public HologramBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.HOLOGRAM, pos, state);
    }
}
