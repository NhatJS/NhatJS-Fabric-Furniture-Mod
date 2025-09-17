package net.nhatjs.js_furniture_mod.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;

public class ModItems {
    public static final Item REMOTE_CONTROL_RGB = registerItem("remote_control_rgb", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NhatJSFurnitureMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Items for " + NhatJSFurnitureMod.MOD_ID);
    }
}
