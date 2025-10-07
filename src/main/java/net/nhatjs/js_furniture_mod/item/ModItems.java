package net.nhatjs.js_furniture_mod.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;

import java.util.function.Function;

public class ModItems {
    public static final Item REMOTE_CONTROL_RGB = registerItem("remote_control_rgb", Item::new);

    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(NhatJSFurnitureMod.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NhatJSFurnitureMod.MOD_ID, name)))));
    }

    public static void registerModItems() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Items for " + NhatJSFurnitureMod.MOD_ID);
    }
}
