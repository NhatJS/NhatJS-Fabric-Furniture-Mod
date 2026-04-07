package net.nhatjs.js_furniture_mod.blockentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.js_furniture_mod.block.*;
import net.nhatjs.js_furniture_mod.core.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class LampBlockEntity extends BlockEntity {
    private boolean powered;

    public LampBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.LAMP, pos, state);
    }

    public boolean isPowered() { return powered; }

    public void setPowered(boolean power) {
        if (powered == power) return;
        powered = power;
        markDirty();
        sync();

        if (world != null && !world.isClient()) {
            BlockState s = world.getBlockState(pos);
            if (s.contains(LEDFloorLampBlock.TURN_ON)) {
                world.setBlockState(pos, s.with(LEDFloorLampBlock.TURN_ON, power), Block.NOTIFY_ALL);
            }
            else if (s.contains(LEDFloorLampRGBBlock.TURN_ON)) {
                world.setBlockState(pos, s.with(LEDFloorLampRGBBlock.TURN_ON, power), Block.NOTIFY_ALL);
            }
            else if (s.contains(LEDFloorLampRGBAltBlock.TURN_ON)) {
                world.setBlockState(pos, s.with(LEDFloorLampRGBAltBlock.TURN_ON, power), Block.NOTIFY_ALL);
            }
            else if (s.contains(LEDRGBTrianglePanelBlock.TURN_ON)) {
                world.setBlockState(pos, s.with(LEDRGBTrianglePanelBlock.TURN_ON, power), Block.NOTIFY_ALL);
            }
            else if (s.contains(StudioLightBlock.TURN_ON)) {
                world.setBlockState(pos, s.with(StudioLightBlock.TURN_ON, power), Block.NOTIFY_ALL);
            }
        }
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        nbt.putBoolean("powered", powered);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.readNbt(nbt, registryLookup);
        powered = nbt.getBoolean("powered");
    }

    private void sync() {
        if (world instanceof ServerWorld serverWorld) {
            serverWorld.getChunkManager().markForUpdate(pos);
            world.updateListeners(pos, getCachedState(), getCachedState(), Block.NOTIFY_ALL);
        }
    }

    @Override
    public @Nullable Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }
}
