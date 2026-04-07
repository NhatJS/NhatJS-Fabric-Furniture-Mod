package net.nhatjs.js_furniture_mod.blockentity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.nhatjs.js_furniture_mod.core.ModBlockEntities;

import static net.nhatjs.js_furniture_mod.block.CoffeeTableBlock.HAS_ITEM;

public class CoffeeTableBlockEntity extends BlockEntity {
    private ItemStack stack = ItemStack.EMPTY;
    private int renderNonce = 0;

    public CoffeeTableBlockEntity(BlockPos pos, BlockState s) { super(ModBlockEntities.COFFEE_TABLE, pos, s); }

    public ItemStack getItem() { return stack; }
    public int getRenderNonce() { return renderNonce; }

    public void setItem(ItemStack s) {
        this.stack = (s == null ? ItemStack.EMPTY : s);
        this.renderNonce++;
        markDirty();

        if (world != null && !world.isClient) {
            world.setBlockState(pos, getCachedState().with(HAS_ITEM, !stack.isEmpty()), 3);
            ((ServerWorld)world).getChunkManager().markForUpdate(pos);
        }
    }

    @Override protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup register) {
        super.writeNbt(nbt, register);
        if (!stack.isEmpty()) nbt.put("it", stack.encode(register));
        nbt.putInt("rn", renderNonce);
    }

    @Override protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup register) {
        super.readNbt(nbt, register);
        stack = nbt.contains("it")
                ? ItemStack.fromNbt(register, nbt.getCompound("it")).orElse(ItemStack.EMPTY)
                : ItemStack.EMPTY;
        renderNonce = nbt.getInt("rn");
    }

    @Override public Packet<ClientPlayPacketListener> toUpdatePacket() { return BlockEntityUpdateS2CPacket.create(this); }
    @Override public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup register) { return createNbt(register); }
}