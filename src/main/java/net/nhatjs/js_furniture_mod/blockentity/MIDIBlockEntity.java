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
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.js_furniture_mod.block.Groovebox2Block;
import net.nhatjs.js_furniture_mod.block.Groovebox3Block;
import net.nhatjs.js_furniture_mod.block.GrooveboxBlock;
import net.nhatjs.js_furniture_mod.block.MIDIKeyboardBlock;
import net.nhatjs.js_furniture_mod.core.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class MIDIBlockEntity extends BlockEntity {
    private boolean powered;

    public MIDIBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.MIDI, pos, state);
    }

    public boolean isPowered() { return powered; }

    public void setPowered(boolean power) {
        if (powered == power) return;
        powered = power;
        markDirty();
        sync();

        if (world != null && !world.isClient()) {
            BlockState s = world.getBlockState(pos);
            if (s.contains(GrooveboxBlock.TURN_ON)) {
                world.setBlockState(pos, s.with(GrooveboxBlock.TURN_ON, power), Block.NOTIFY_ALL);
            }
            else if (s.contains(Groovebox2Block.TURN_ON)) {
                world.setBlockState(pos, s.with(Groovebox2Block.TURN_ON, power), Block.NOTIFY_ALL);
            }
            else if (s.contains(Groovebox3Block.TURN_ON)) {
                world.setBlockState(pos, s.with(Groovebox3Block.TURN_ON, power), Block.NOTIFY_ALL);
            }
            else if (s.contains(MIDIKeyboardBlock.TURN_ON)) {
                world.setBlockState(pos, s.with(MIDIKeyboardBlock.TURN_ON, power), Block.NOTIFY_ALL);
            }
        }
    }

    @Override
    protected void writeData(WriteView view) {
        super.writeData(view);
        view.putBoolean("powered", powered);
    }

    @Override
    protected void readData(ReadView view) {
        super.readData(view);
        powered = view.getBoolean("powered", powered);
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
