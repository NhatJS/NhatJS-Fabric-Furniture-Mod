package net.nhatjs.js_furniture_mod.block.blockentity.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.js_furniture_mod.block.CeilingFanBlock;
import net.nhatjs.js_furniture_mod.block.blockentity.ModBlockEntities;

public class CeilingFanBlockEntity extends BlockEntity {
    public float angle;
    public float speed;
    private static final float MAX_SPEED = 30;
    private static final float ACCEL = 1.25f;

    public CeilingFanBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CEILING_FAN, pos, state);
    }

    public void clientTick() {
        if (world == null) return;
        boolean on = getCachedState().get(CeilingFanBlock.TURN_ON);
        float target = on ? MAX_SPEED : 0f;

        speed += (target - speed) * 0.05f;
        if (Math.abs(speed) < 0.01f && target == 0f) speed = 0f;
        angle = (angle + speed) % 360f;
    }
}
