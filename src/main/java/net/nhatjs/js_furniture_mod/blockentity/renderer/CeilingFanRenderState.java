package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CeilingFanRenderState extends BlockEntityRenderState {
    public float angle;
    public BlockState blockState;
    public BlockPos pos;
    public int light;
    public int overlay;
}