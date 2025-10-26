package net.nhatjs.js_furniture_mod.block.blockentity.client;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.world.World;
import net.nhatjs.js_furniture_mod.block.CoffeeTableBlock;
import net.nhatjs.js_furniture_mod.block.blockentity.ModBlockEntities;

import static net.nhatjs.js_furniture_mod.block.CoffeeTableBlock.HAS_ITEM;

public class CoffeeTableBlockEntity extends BlockEntity {
    private ItemStack stack = ItemStack.EMPTY;

    public CoffeeTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.COFFEE_TABLE, pos, state);
    }

    public ItemStack getItem() { return stack; }

    public void setItem(ItemStack s) {
        this.stack = (s == null ? ItemStack.EMPTY : s);
        markDirty();

        if (world instanceof ServerWorld server) {
            boolean has = !this.stack.isEmpty();
            BlockState cur = getCachedState();
            if (cur.contains(HAS_ITEM) && cur.get(HAS_ITEM) != has) {
                server.setBlockState(pos, cur.with(HAS_ITEM, has), 3);
            }
            // gửi NBT BE update + kích client re-render
            server.getChunkManager().markForUpdate(pos);
            world.updateListeners(pos, cur, cur, Block.NOTIFY_LISTENERS);
        }
    }

    @Override protected void writeData(WriteView view) {
        super.writeData(view);
        if (stack.isEmpty()) {
            view.remove("item");
        } else {
            view.put("item", ItemStack.CODEC, stack);
        }
    }

    @Override protected void readData(ReadView view) {
        super.readData(view);
        this.stack = view.read("item", ItemStack.CODEC).orElse(ItemStack.EMPTY);
    }

    @Override public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup reg) {
        return createNbt(world != null ? world.getRegistryManager() : reg);
    }
}