package net.nhatjs.js_furniture_mod.core;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;

public class ModItems {
    public static final Item REMOTE_CONTROL_RGB = registerItem("remote_control_rgb", new Item(new Item.Settings()));
    public static final Item CPU = registerItem("cpu", new Item(new Item.Settings()));
    public static final Item MAINBOARD = registerItem("mainboard", new Item(new Item.Settings()));
    public static final Item RAM = registerItem("ram", new Item(new Item.Settings()));
    public static final Item AIO_COOLER = registerItem("aio_cooler", new Item(new Item.Settings()));
    public static final Item COMPUTER_FAN = registerItem("computer_fan", new Item(new Item.Settings()));
    public static final Item GPU = registerItem("gpu", new Item(new Item.Settings()));
    public static final Item PSU = registerItem("psu", new Item(new Item.Settings()));
    public static final Item WOOD_LIGHT_SQUARE_STICK = registerItem("wood_light_square_stick", new Item(new Item.Settings()));
    public static final Item WOOD_MEDIUM_SQUARE_STICK = registerItem("wood_medium_square_stick", new Item(new Item.Settings()));
    public static final Item BLACK_SQUARE_STICK = registerItem("black_square_stick", new Item(new Item.Settings()));
    public static final Item WHITE_SQUARE_STICK = registerItem("white_square_stick", new Item(new Item.Settings()));
    public static final Item WOOD_LIGHT_PANEL = registerItem("wood_light_panel", new Item(new Item.Settings()));
    public static final Item WOOD_MEDIUM_PANEL = registerItem("wood_medium_panel", new Item(new Item.Settings()));
    public static final Item BLACK_PANEL = registerItem("black_panel", new Item(new Item.Settings()));
    public static final Item WHITE_PANEL = registerItem("white_panel", new Item(new Item.Settings()));
    public static final Item WOOD_LIGHT_SHORT_SQUARE_STICK = registerItem("wood_light_short_square_stick", new Item(new Item.Settings()));
    public static final Item WOOD_MEDIUM_SHORT_SQUARE_STICK = registerItem("wood_medium_short_square_stick", new Item(new Item.Settings()));
    public static final Item BLACK_SHORT_SQUARE_STICK = registerItem("black_short_square_stick", new Item(new Item.Settings()));
    public static final Item WHITE_SHORT_SQUARE_STICK = registerItem("white_short_square_stick", new Item(new Item.Settings()));

    public static final Item GARBAGE_ITEM = registerItem("garbage_item", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(NhatJSFurnitureMod.MOD_ID, name), item);
    }

    public static void registerModItems() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Items for " + NhatJSFurnitureMod.MOD_ID);
    }
}
