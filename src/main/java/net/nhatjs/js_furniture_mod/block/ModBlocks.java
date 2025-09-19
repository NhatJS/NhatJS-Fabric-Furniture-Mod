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
    public static Block MODERN_CHAIR = registerBlock("modern_chair",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_TABLE = registerBlock("wood_light_table",
            new WoodTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_TABLE = registerBlock("black_table",
            new ModernTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_TABLE = registerBlock("white_table",
            new ModernTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_COFFEE_TABLE = registerBlock("wood_coffee_table",
            new CoffeeTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_COFFEE_TABLE = registerBlock("white_coffee_table",
            new CoffeeTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_DESK = registerBlock("wood_desk",
            new DeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_DESK = registerBlock("white_desk",
            new DeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_STANDING_DESK = registerBlock("wood_standing_desk",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_STANDING_DESK = registerBlock("black_standing_desk",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_STANDING_DESK = registerBlock("white_standing_desk",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_3_DRAWER_DRESSER = registerBlock("wood_3_drawer_dresser",
            new ThreeDrawerDresserBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_3_DRAWER_DRESSER = registerBlock("white_3_drawer_dresser",
            new ThreeDrawerDresserBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_TV_STAND = registerBlock("wood_light_tv_stand",
            new TVStandBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM = registerBlock("kitchen_cabinet_bottom",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_WITH_SINK = registerBlock("kitchen_cabinet_bottom_with_sink",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_2 = registerBlock("kitchen_cabinet_bottom_2",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_2_EXTRA = registerBlock("kitchen_cabinet_bottom_2_extra",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_B = registerBlock("kitchen_cabinet_bottom_b",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_B_WITH_SINK = registerBlock("kitchen_cabinet_bottom_b_with_sink",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_B_2 = registerBlock("kitchen_cabinet_bottom_b_2",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_DRAWERS = registerBlock("kitchen_drawers",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_TOP = registerBlock("kitchen_cabinet_top",
            new KitchenTopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_TOP_B = registerBlock("kitchen_cabinet_top_b",
            new KitchenTopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_STRIPED_WALL = registerBlock("wood_striped_wall",
            new WoodStripedWallBlock(AbstractBlock.Settings.create().strength(0.3f).nonOpaque()));
    public static Block BLACK_MIRROR = registerBlock("black_mirror",
            new BlackMirrorBlock(AbstractBlock.Settings.create().strength(0.3f).nonOpaque()));
    public static Block SOCKET = registerBlock("socket",
            new SocketBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static Block MODERN_CLOCK = registerBlock("modern_clock",
            new ModernClockBlock(AbstractBlock.Settings.create().strength(0.4f).nonOpaque()));
    public static Block MODERN_LIGHT = registerBlock("modern_light",
            new ModernLightBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static Block LED_FLOOR_LAMP = registerBlock("led_floor_lamp",
            new LEDFloorLampBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block LAPTOP = registerBlock("laptop",
            new LaptopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block COOKTOP = registerBlock("cooktop",
            new CooktopBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));
    public static Block MODERN_BATHROOM_SINK_STORAGE = registerBlock("modern_bathroom_sink_storage",
            new BathroomSinkStorageBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block MODERN_BATHROOM_MIRROR_SHELF = registerBlock("modern_bathroom_mirror_shelf",
            new BathroomMirrorShelfBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));
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
