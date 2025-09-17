package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;

import static net.nhatjs.js_furniture_mod.NhatJSFurnitureMod.MOD_ID;

public class ModBlocks {
    public static Block BLACK_TABLE = registerBlock("black_table",
            new TableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_TABLE = registerBlock("white_table",
            new TableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_DESK = registerBlock("white_desk",
            new DeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block SOCKET = registerBlock("socket",
            new SocketBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static Block LED_FLOOR_LAMP = registerBlock("led_floor_lamp",
            new LEDFloorLampBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WASHING_MACHINE_AI = registerBlock("washing_machine_ai",
            new WashingMachineBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));

    private static <T extends Block> T registerBlock(String name, T block) {
        Identifier id = Identifier.of(MOD_ID, name);
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        return block;
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Blocks for " + MOD_ID);
    }
    private ModBlocks() {}
}
