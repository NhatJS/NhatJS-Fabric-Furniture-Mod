package net.nhatjs.js_furniture_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup NEXTGEN_FURNITURE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "js_furniture_logo"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BLACK_TABLE))
                    .displayName(Text.translatable("itemgroup.js_furniture_mod.js_furniture_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.BLACK_TABLE);
                        entries.add(ModBlocks.WHITE_TABLE);
                        entries.add(ModBlocks.WHITE_DESK);
                        entries.add(ModBlocks.SOCKET);
                        entries.add(ModBlocks.LED_FLOOR_LAMP);
                        entries.add(ModBlocks.WASHING_MACHINE_AI);
                        entries.add(ModItems.REMOTE_CONTROL_RGB);
                    }).build());

    public static void registerItemGroups() {
        NhatJSFurnitureMod.LOGGER.info("Registering Item Groups for " + NhatJSFurnitureMod.MOD_ID);
    }
}
