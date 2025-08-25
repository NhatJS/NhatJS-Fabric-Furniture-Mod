package net.nhatjs.js_furniture_mod.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.JsFurnitureModMod;

public class JSFurnitureModItems {
    public static final Item REMOTE_CONTROL_RGB = registerItem("remote_control_rgb", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(JsFurnitureModMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        JsFurnitureModMod.LOGGER.info("Registering Mod Items for " + JsFurnitureModMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(REMOTE_CONTROL_RGB);
        });
    }
}
