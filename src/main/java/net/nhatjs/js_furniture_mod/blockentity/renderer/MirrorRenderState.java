package net.nhatjs.js_furniture_mod.blockentity.renderer;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;

public class MirrorRenderState extends BlockEntityRenderState {
    public float yaw;
    public BlockState blockState;
    public int light;
    public int overlay;
    public boolean stand;
}