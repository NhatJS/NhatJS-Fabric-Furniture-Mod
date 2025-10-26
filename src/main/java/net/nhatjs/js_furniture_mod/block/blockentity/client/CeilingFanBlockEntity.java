package net.nhatjs.js_furniture_mod.block.blockentity.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.js_furniture_mod.block.CeilingFanBlock;
import net.nhatjs.js_furniture_mod.block.blockentity.ModBlockEntities;

public class CeilingFanBlockEntity extends BlockEntity {
    private double angle = 0.0;
    private double prevAngle = 0.0;
    private double vel = 0.0;

    private static final double MAX_RPM = 120;
    private static final double MAX_VEL = MAX_RPM * 360.0 / 1200.0;

    private static final double APPROACH = 0.02;
    private static final double FRICTION = 0.985;

    public CeilingFanBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.CEILING_FAN, pos, state);
    }

    // Tick animation: chỉ client
    public void tick() {
        if (world == null || !world.isClient) return;

        boolean on = getCachedState().get(CeilingFanBlock.TURN_ON);
        double targetVel = on ? MAX_VEL : 0.0;

        prevAngle = angle;

        vel += (targetVel - vel) * APPROACH;

        if (!on) vel *= FRICTION;

        if (Math.abs(vel) < 1e-4 && !on) vel = 0.0;

        angle += vel;

        angle %= 360.0;
        if (angle < 0) angle += 360.0;
    }

    public float getAngle(float tickDelta) {
        double delta = angle - prevAngle;
        if (delta < -180.0) delta += 360.0;
        if (delta >  180.0) delta -= 360.0;

        double shown = prevAngle + delta * tickDelta;
        shown %= 360.0;
        if (shown < 0) shown += 360.0;

        return (float) shown;
    }
}