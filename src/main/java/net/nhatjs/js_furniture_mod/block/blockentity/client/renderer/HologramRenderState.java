package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class HologramRenderState extends BlockEntityRenderState {
    public float angle;
    public BlockState blockState;
    public Direction facing;
    public BlockPos pos;
}