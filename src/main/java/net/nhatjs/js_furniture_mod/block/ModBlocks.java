package net.nhatjs.js_furniture_mod.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;

import java.util.function.Function;

import static net.nhatjs.js_furniture_mod.NhatJSFurnitureMod.MOD_ID;

public class ModBlocks {
    public static Block WOOD_CHAIR = registerBlock("wood_chair",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MODERN_CHAIR = registerBlock("modern_chair",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block SOFA = registerBlock("sofa",
            properties -> new SofaBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_TABLE = registerBlock("wood_light_table",
            properties -> new WoodTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_TABLE = registerBlock("black_table",
            properties -> new ModernTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_TABLE = registerBlock("white_table",
            properties -> new ModernTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_COFFEE_TABLE = registerBlock("wood_coffee_table",
            properties -> new CoffeeTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_COFFEE_TABLE = registerBlock("white_coffee_table",
            properties -> new CoffeeTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_DESK = registerBlock("wood_desk",
            properties -> new DeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_DESK = registerBlock("white_desk",
            properties -> new DeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_STANDING_DESK = registerBlock("wood_standing_desk",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_STANDING_DESK_B = registerBlock("wood_standing_desk_b",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_STANDING_DESK = registerBlock("black_standing_desk",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_STANDING_DESK_B = registerBlock("black_standing_desk_b",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_STANDING_DESK = registerBlock("white_standing_desk",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_STANDING_DESK_B = registerBlock("white_standing_desk_b",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_3_DRAWER_DRESSER = registerBlock("wood_3_drawer_dresser",
            properties -> new ThreeDrawerDresserBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_3_DRAWER_DRESSER = registerBlock("white_3_drawer_dresser",
            properties -> new ThreeDrawerDresserBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_TV_STAND = registerBlock("wood_light_tv_stand",
            properties -> new TVStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM = registerBlock("kitchen_cabinet_bottom",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_WITH_SINK = registerBlock("kitchen_cabinet_bottom_with_sink",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_2 = registerBlock("kitchen_cabinet_bottom_2",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_2_EXTRA = registerBlock("kitchen_cabinet_bottom_2_extra",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_B = registerBlock("kitchen_cabinet_bottom_b",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_B_WITH_SINK = registerBlock("kitchen_cabinet_bottom_b_with_sink",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_BOTTOM_B_2 = registerBlock("kitchen_cabinet_bottom_b_2",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_DRAWERS = registerBlock("kitchen_drawers",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_TOP = registerBlock("kitchen_cabinet_top",
            properties -> new KitchenTopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_TOP_B = registerBlock("kitchen_cabinet_top_b",
            properties -> new KitchenTopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_STRIPED_WALL = registerBlock("wood_striped_wall",
            properties -> new WoodStripedWallBlock(properties.strength(0.3f).nonOpaque()));
    public static Block BLACK_MIRROR = registerBlock("black_mirror",
            properties -> new BlackMirrorBlock(properties.strength(0.3f).nonOpaque()));
    public static Block SOCKET = registerBlock("socket",
            properties -> new SocketBlock(properties.strength(0.2f).nonOpaque()));
    public static Block MODERN_CLOCK = registerBlock("modern_clock",
            properties -> new ModernClockBlock(properties.strength(0.4f).nonOpaque()));
    public static Block MODERN_LIGHT = registerBlock("modern_light",
            properties -> new ModernLightBlock(properties.strength(0.2f).nonOpaque()));
    public static Block LED_FLOOR_LAMP = registerBlock("led_floor_lamp",
            properties -> new LEDFloorLampBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LED_FLOOR_LAMP_RGB_OFF = registerBlock("led_floor_lamp_rgb_off",
            properties -> new LEDFloorLampRGBBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LED_FLOOR_LAMP_RGB_OFF_2 = registerBlock("led_floor_lamp_rgb_off_2",
            properties -> new LEDFloorLampRGBAltBlock(properties.strength(1.0f).nonOpaque()));
    public static Block STUDIO_LIGHT = registerBlock("studio_light",
            properties -> new StudioLightBlock(properties.strength(1.5f).nonOpaque()));
    public static Block MONITOR_SETUP = registerBlock("monitor_setup",
            properties -> new MonitorSetupBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MONITOR = registerBlock("monitor",
            properties -> new MonitorBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KEYBOARD = registerBlock("keyboard",
            properties -> new KeyboardBlock(properties.strength(0.7f).nonOpaque()));
    public static Block COMPUTER_MOUSE = registerBlock("computer_mouse",
            properties -> new ComputerMouseBlock(properties.strength(0.2f).nonOpaque()));
    public static Block PC = registerBlock("pc",
            properties -> new DesktopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PC_RGB1_OFF = registerBlock("pc_rgb1_off",
            properties -> new DesktopAltBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PC_TOWER_GLASS = registerBlock("pc_tower_glass",
            properties -> new DesktopTowerGlassBlock(properties.sounds(BlockSoundGroup.GLASS).strength(0.4f).nonOpaque().noCollision()));
    public static Block LAPTOP = registerBlock("laptop",
            properties -> new LaptopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PORTABLE_LAPTOP_STAND = registerBlock("portable_laptop_stand",
            properties -> new PortableLaptopStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND = registerBlock("laptop_closed_portable_laptop_stand",
            properties -> new PortableLaptopStandAddedBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX = registerBlock("midi_standalone_groovebox",
            properties -> new GrooveboxBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX_2 = registerBlock("midi_standalone_groovebox_2",
            properties -> new Groovebox2Block(properties.strength(1.0f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX_3 = registerBlock("midi_standalone_groovebox_3",
            properties -> new Groovebox3Block(properties.strength(1.0f).nonOpaque()));
    public static Block COOKTOP = registerBlock("cooktop",
            properties -> new CooktopBlock(properties.strength(0.5f).nonOpaque()));
    public static Block FRIDGE_A = registerBlock("fridge_a",
            properties -> new FridgeBlock(properties.strength(2f).nonOpaque()));
    public static Block FRIDGE_B = registerBlock("fridge_b",
            properties -> new FridgeBlock(properties.strength(2f).nonOpaque()));
    public static Block MODERN_BATHROOM_SINK_STORAGE = registerBlock("modern_bathroom_sink_storage",
            properties -> new BathroomSinkStorageBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MODERN_BATHROOM_MIRROR_SHELF = registerBlock("modern_bathroom_mirror_shelf",
            properties -> new BathroomMirrorShelfBlock(properties.strength(0.5f).nonOpaque()));
    public static Block SHOWER = registerBlock("shower",
            properties -> new ShowerBlock(properties.strength(0.5f).nonOpaque()));
    public static Block WASHING_MACHINE_AI = registerBlock("washing_machine_ai",
            properties -> new WashingMachineBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PLANT_POT = registerBlock("plant_pot",
            properties -> new PotBlock(properties.strength(0.4f).nonOpaque()));

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(NhatJSFurnitureMod.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(NhatJSFurnitureMod.MOD_ID, name), toRegister);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(NhatJSFurnitureMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(NhatJSFurnitureMod.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Blocks for " + MOD_ID);
    }
    private ModBlocks() {}
}
