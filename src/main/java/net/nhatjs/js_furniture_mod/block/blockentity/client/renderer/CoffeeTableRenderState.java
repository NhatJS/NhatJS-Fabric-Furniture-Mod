package net.nhatjs.js_furniture_mod.block.blockentity.client.renderer;

import net.minecraft.client.render.block.entity.state.BlockEntityRenderState;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class CoffeeTableRenderState extends BlockEntityRenderState {
    public final ItemRenderState itemRenderState = new ItemRenderState();
    public World world;
    public BlockPos pos;
    public float yaw;
}