package net.nhatjs.js_furniture_mod.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.nhatjs.js_furniture_mod.block.CeilingFanBlock;
import net.nhatjs.js_furniture_mod.core.ModBlockEntities;

public class CeilingFanBlockEntity extends BlockEntity {
    public float angle = 0f;
    public float speed = 0f;

    private static final float MAX_SPEED = 35f;

    public CeilingFanBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CEILING_FAN, pos, state);
    }

    public void tick() {
        if (world == null) return;
        boolean on = getCachedState().get(CeilingFanBlock.TURN_ON);

        float target = on ? MAX_SPEED : 0f;

        speed = MathHelper.lerp(0.02f, speed, target);
        if (Math.abs(speed) < 0.01f && target == 0f) speed = 0f;

        angle = (angle + speed) % 360f;
    }

    public float getAngle(float tickDelta) {
        return angle + speed * tickDelta;
    }
}