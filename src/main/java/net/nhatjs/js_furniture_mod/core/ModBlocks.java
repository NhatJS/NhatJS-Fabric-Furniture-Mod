package net.nhatjs.js_furniture_mod.core;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.*;
import net.nhatjs.js_furniture_mod.block.added.*;
import net.nhatjs.js_furniture_mod.block.core.NonFunctionalSimpleBlock;

import java.util.function.Function;

import static net.nhatjs.js_furniture_mod.NhatJSFurnitureMod.MOD_ID;

public class ModBlocks {
    public static Block BLACK_MIRROR = registerBlock("black_mirror",
            properties -> new BlackMirrorBlock(properties.strength(0.3f).nonOpaque()));
    public static Block BLACK_STANDING_DESK = registerBlock("black_standing_desk",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_STANDING_DESK_B = registerBlock("black_standing_desk_b",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_TABLE = registerBlock("black_table",
            properties -> new TableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BOOKS = registerBlock("books",
            properties -> new BooksBlock(properties.strength(0.1f).nonOpaque()));
    public static Block COMPUTER_MOUSE = registerBlock("computer_mouse",
            properties -> new ComputerMouseBlock(properties.strength(0.2f).nonOpaque()));
    public static Block COOKTOP = registerBlock("cooktop",
            properties -> new CooktopBlock(properties.strength(0.5f).nonOpaque()));
    public static Block FLOOR_STANDING_SPEAKER = registerBlock("floor_standing_speaker",
            properties -> new FloorStandingSpeakerBlock(properties.strength(0.9f).nonOpaque()));
    public static Block FRIDGE_A = registerBlock("fridge_a",
            properties -> new FridgeBlock(properties.strength(2f).nonOpaque()));
    public static Block FRIDGE_B = registerBlock("fridge_b",
            properties -> new FridgeBlock(properties.strength(2f).nonOpaque()));
    public static Block KEYBOARD = registerBlock("keyboard",
            properties -> new KeyboardBlock(properties.strength(0.7f).nonOpaque()));
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
    public static Block KITCHEN_CABINET_TOP = registerBlock("kitchen_cabinet_top",
            properties -> new KitchenTopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_TOP_B = registerBlock("kitchen_cabinet_top_b",
            properties -> new KitchenTopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_DRAWERS = registerBlock("kitchen_drawers",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block KITCHEN_DRAWERS_B = registerBlock("kitchen_drawers_b",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LAPTOP = registerBlock("laptop",
            properties -> new LaptopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND = registerBlock("laptop_closed_portable_laptop_stand",
            properties -> new PortableLaptopStandAddedBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LED_FLOOR_LAMP = registerBlock("led_floor_lamp",
            properties -> new LEDFloorLampBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LED_FLOOR_LAMP_RGB_OFF = registerBlock("led_floor_lamp_rgb_off",
            properties -> new LEDFloorLampRGBBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LED_FLOOR_LAMP_RGB_OFF_2 = registerBlock("led_floor_lamp_rgb_off_2",
            properties -> new LEDFloorLampRGBAltBlock(properties.strength(1.0f).nonOpaque()));
    public static Block LED_RGB_TRIANGLE_PANEL = registerBlock("led_rgb_triangle_panel",
            properties -> new LEDRGBTrianglePanelBlock(properties.strength(0.8f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX = registerBlock("midi_standalone_groovebox",
            properties -> new GrooveboxBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX_2 = registerBlock("midi_standalone_groovebox_2",
            properties -> new Groovebox2Block(properties.strength(1.0f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX_3 = registerBlock("midi_standalone_groovebox_3",
            properties -> new Groovebox3Block(properties.strength(1.0f).nonOpaque()));
    public static Block MODERN_BATHROOM_MIRROR_SHELF = registerBlock("modern_bathroom_mirror_shelf",
            properties -> new BathroomMirrorShelfBlock(properties.strength(0.5f).nonOpaque()));
    public static Block MODERN_BATHROOM_SINK_STORAGE = registerBlock("modern_bathroom_sink_storage",
            properties -> new BathroomSinkStorageBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MODERN_CHAIR = registerBlock("modern_chair",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MODERN_CLOCK = registerBlock("modern_clock",
            properties -> new ModernClockBlock(properties.strength(0.4f).nonOpaque()));
    public static Block MODERN_LIGHT = registerBlock("modern_light",
            properties -> new ModernLightBlock(properties.strength(0.2f).nonOpaque()));
    public static Block MONITOR = registerBlock("monitor",
            properties -> new MonitorBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MONITOR_SETUP = registerBlock("monitor_setup",
            properties -> new MonitorSetupBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PC = registerBlock("pc",
            properties -> new DesktopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PC_RGB1_OFF = registerBlock("pc_rgb1_off",
            properties -> new DesktopAltBlock(properties.strength(1.0f).nonOpaque()));
    public static Block PC_TOWER_GLASS = registerBlock("pc_tower_glass",
            properties -> new DesktopTowerGlassBlock(properties.sounds(BlockSoundGroup.GLASS).strength(0.4f).nonOpaque().noCollision()));
    public static Block PLANT_POT = registerBlock("plant_pot",
            properties -> new PotBlock(properties.strength(0.4f).nonOpaque()));
    public static Block PORTABLE_LAPTOP_STAND = registerBlock("portable_laptop_stand",
            properties -> new PortableLaptopStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block SHOWER = registerBlock("shower",
            properties -> new ShowerBlock(properties.strength(0.5f).nonOpaque()));
    public static Block SOCKET = registerBlock("socket",
            properties -> new SocketBlock(properties.strength(0.2f).nonOpaque()));
    public static Block SOFA = registerBlock("sofa",
            properties -> new SofaBlock(properties.strength(1.0f).nonOpaque()));
    public static Block STUDIO_LIGHT = registerBlock("studio_light",
            properties -> new StudioLightBlock(properties.strength(1.5f).nonOpaque()));
    public static Block TV = registerBlock("tv",
            properties -> new TVBlock(properties.strength(1.0f).nonOpaque()));
    public static Block VERTICAL_BLINDS = registerBlock("vertical_blinds",
            properties -> new VerticalBlindsBlock(properties.strength(0.7f).nonOpaque()));
    public static Block WASHING_MACHINE_AI = registerBlock("washing_machine_ai",
            properties -> new WashingMachineBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_3_DRAWER_DRESSER = registerBlock("white_3_drawer_dresser",
            properties -> new ThreeDrawerDresserBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_CHAIR = registerBlock("white_chair",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_COFFEE_TABLE = registerBlock("white_coffee_table",
            properties -> new CoffeeTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_DESK = registerBlock("white_desk",
            properties -> new DeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_STANDING_DESK = registerBlock("white_standing_desk",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_STANDING_DESK_B = registerBlock("white_standing_desk_b",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_TABLE = registerBlock("white_table",
            properties -> new TableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_TV_STAND = registerBlock("white_tv_stand",
            properties -> new TVStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_3_DRAWER_DRESSER = registerBlock("wood_3_drawer_dresser",
            properties -> new ThreeDrawerDresserBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_CHAIR = registerBlock("wood_chair",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_COFFEE_TABLE = registerBlock("wood_coffee_table",
            properties -> new CoffeeTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_DESK = registerBlock("wood_desk",
            properties -> new DeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_TABLE = registerBlock("wood_light_table",
            properties -> new TableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_TV_STAND = registerBlock("wood_light_tv_stand",
            properties -> new TVStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_STANDING_DESK = registerBlock("wood_standing_desk",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_STANDING_DESK_B = registerBlock("wood_standing_desk_b",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_STRIPED_WALL = registerBlock("wood_striped_wall",
            properties -> new WoodStripedWallBlock(properties.strength(0.3f).nonOpaque()));

    public static Block CEILING_FAN = registerBlock("ceiling_fan",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_GAMING_CHAIR = registerBlock("black_gaming_chair",
            properties -> new GamingChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_GAMING_CHAIR = registerBlock("white_gaming_chair",
            properties -> new GamingChairBlock(properties.strength(1.0f).nonOpaque()));

    public static Block TOILET = registerBlock("toilet",
            properties -> new ToiletBlock(properties.strength(1.0f).nonOpaque()));

    public static Block CEILING_FAN_B = registerBlock("ceiling_fan_b",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_SOFA = registerBlock("black_sofa",
            properties -> new SofaBlock(properties.strength(1.0f).nonOpaque()));
    public static Block MIDI_KEYBOARD_CONTROLLER = registerBlock("midi_keyboard_controller",
            properties -> new MIDIKeyboardBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_TV_STAND = registerBlock("wood_medium_tv_stand",
            properties -> new TVStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_3_DRAWER_DRESSER = registerBlock("wood_medium_3_drawer_dresser",
            properties -> new ThreeDrawerDresserBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_CHAIR = registerBlock("wood_medium_chair",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_COFFEE_TABLE = registerBlock("wood_medium_coffee_table",
            properties -> new CoffeeTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_DESK = registerBlock("wood_medium_desk",
            properties -> new DeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_STANDING_DESK = registerBlock("wood_medium_standing_desk",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_STANDING_DESK_B = registerBlock("wood_medium_standing_desk_b",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_STRIPED_WALL = registerBlock("wood_medium_striped_wall",
            properties -> new WoodStripedWallBlock(properties.strength(0.3f).nonOpaque()));
    public static Block WOOD_MEDIUM_TABLE = registerBlock("wood_medium_table",
            properties -> new TableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM = registerBlock("wood_medium_kitchen_cabinet_bottom",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK = registerBlock("wood_medium_kitchen_cabinet_bottom_with_sink",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2 = registerBlock("wood_medium_kitchen_cabinet_bottom_2",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA = registerBlock("wood_medium_kitchen_cabinet_bottom_2_extra",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B = registerBlock("wood_medium_kitchen_cabinet_bottom_b",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK = registerBlock("wood_medium_kitchen_cabinet_bottom_b_with_sink",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2 = registerBlock("wood_medium_kitchen_cabinet_bottom_b_2",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_TOP = registerBlock("wood_medium_kitchen_cabinet_top",
            properties -> new KitchenTopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_TOP_B = registerBlock("wood_medium_kitchen_cabinet_top_b",
            properties -> new KitchenTopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_DRAWERS = registerBlock("wood_medium_kitchen_drawers",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_DRAWERS_B = registerBlock("wood_medium_kitchen_drawers_b",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));

    public static Block COMPUTER_CASE = registerBlock("computer_case",
            properties -> new ComputerCaseBlock(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_1 = registerBlock("pc_added_1",
            properties -> new PCAdded1Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_2 = registerBlock("pc_added_2",
            properties -> new PCAdded2Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_3 = registerBlock("pc_added_3",
            properties -> new PCAdded3Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_4 = registerBlock("pc_added_4",
            properties -> new PCAdded4Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_5 = registerBlock("pc_added_5",
            properties -> new PCAdded5Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_6 = registerBlock("pc_added_6",
            properties -> new PCAdded6Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_7 = registerBlock("pc_added_7",
            properties -> new PCAdded7Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_8 = registerBlock("pc_added_8",
            properties -> new PCAdded8Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_9 = registerBlock("pc_added_9",
            properties -> new PCAdded9Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_10 = registerBlock("pc_added_10",
            properties -> new PCAdded10Block(properties.strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_11 = registerBlock("pc_added_11",
            properties -> new PCAdded11Block(properties.strength(0.75f).nonOpaque()));

    public static Block BLACK_CHAIR = registerBlock("black_chair",
            properties -> new ChairBlock(properties.strength(0.75f).nonOpaque()));
    public static Block BLACK_COFFEE_TABLE = registerBlock("black_coffee_table",
            properties -> new CoffeeTableBlock(properties.strength(0.75f).nonOpaque()));
    public static Block BLACK_3_DRAWER_DRESSER = registerBlock("black_3_drawer_dresser",
            properties -> new ThreeDrawerDresserBlock(properties.strength(0.75f).nonOpaque()));
    public static Block WOOD_LIGHT_DRAWER_SINGLE = registerBlock("wood_light_drawer_single",
            properties -> new DrawerSingleBlock(properties.strength(0.75f).nonOpaque()));
    public static Block WOOD_MEDIUM_DRAWER_SINGLE = registerBlock("wood_medium_drawer_single",
            properties -> new DrawerSingleBlock(properties.strength(0.75f).nonOpaque()));
    public static Block BLACK_DRAWER_SINGLE = registerBlock("black_drawer_single",
            properties -> new DrawerSingleBlock(properties.strength(0.75f).nonOpaque()));
    public static Block WHITE_DRAWER_SINGLE = registerBlock("white_drawer_single",
            properties -> new DrawerSingleBlock(properties.strength(0.75f).nonOpaque()));
    public static Block BLACK_DESK = registerBlock("black_desk",
            properties -> new DeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_TV_STAND = registerBlock("black_tv_stand",
            properties -> new TVStandBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_DESK_COLUMN = registerBlock("black_desk_column",
            properties -> new DeskColumnBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_DESK_COLUMN = registerBlock("white_desk_column",
            properties -> new DeskColumnBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_VERTICAL_BLINDS = registerBlock("black_vertical_blinds",
            properties -> new VerticalBlindsBlock(properties.strength(0.7f).nonOpaque()));
    public static Block WOOD_LIGHT_CEILING_FAN_BLACK = registerBlock("wood_light_ceiling_fan_black",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_CEILING_FAN_BLACK = registerBlock("wood_medium_ceiling_fan_black",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_CEILING_FAN_BLACK = registerBlock("black_ceiling_fan_black",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_CEILING_FAN_BLACK = registerBlock("white_ceiling_fan_black",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_CEILING_FAN_WHITE = registerBlock("wood_light_ceiling_fan_white",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_CEILING_FAN_WHITE = registerBlock("wood_medium_ceiling_fan_white",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_CEILING_FAN_WHITE = registerBlock("black_ceiling_fan_white",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_CEILING_FAN_WHITE = registerBlock("white_ceiling_fan_white",
            properties -> new CeilingFanBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_SOFA = registerBlock("white_sofa",
            properties -> new SofaBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_COMPARTMENT_STORAGE_CABINET = registerBlock("wood_light_compartment_storage_cabinet",
            properties -> new NonFunctionalSimpleBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_COMPARTMENT_STORAGE_CABINET = registerBlock("wood_medium_compartment_storage_cabinet",
            properties -> new NonFunctionalSimpleBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_COMPARTMENT_STORAGE_CABINET = registerBlock("black_compartment_storage_cabinet",
            properties -> new NonFunctionalSimpleBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_COMPARTMENT_STORAGE_CABINET = registerBlock("white_compartment_storage_cabinet",
            properties -> new NonFunctionalSimpleBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET = registerBlock("wood_light_kitchen_compartment_storage_cabinet",
            properties -> new NonFunctionalSimpleBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET = registerBlock("wood_medium_kitchen_compartment_storage_cabinet",
            properties -> new NonFunctionalSimpleBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET_B = registerBlock("wood_light_kitchen_compartment_storage_cabinet_b",
            properties -> new NonFunctionalSimpleBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET_B = registerBlock("wood_medium_kitchen_compartment_storage_cabinet_b",
            properties -> new NonFunctionalSimpleBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WHITE_VERTICAL_BLINDS = registerBlock("white_vertical_blinds",
            properties -> new VerticalBlindsBlock(properties.strength(0.7f).nonOpaque()));
    public static Block WOOD_LIGHT_3_DRAWER_DRESSER = registerBlock("wood_light_3_drawer_dresser",
            properties -> new ThreeDrawerDresserBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_CHAIR = registerBlock("wood_light_chair",
            properties -> new ChairBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_COFFEE_TABLE = registerBlock("wood_light_coffee_table",
            properties -> new CoffeeTableBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_DESK = registerBlock("wood_light_desk",
            properties -> new DeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_STANDING_DESK = registerBlock("wood_light_standing_desk",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_STANDING_DESK_B = registerBlock("wood_light_standing_desk_b",
            properties -> new StandingDeskBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM = registerBlock("wood_light_kitchen_cabinet_bottom",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_WITH_SINK = registerBlock("wood_light_kitchen_cabinet_bottom_with_sink",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2 = registerBlock("wood_light_kitchen_cabinet_bottom_2",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2_EXTRA = registerBlock("wood_light_kitchen_cabinet_bottom_2_extra",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B = registerBlock("wood_light_kitchen_cabinet_bottom_b",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_WITH_SINK = registerBlock("wood_light_kitchen_cabinet_bottom_b_with_sink",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_2 = registerBlock("wood_light_kitchen_cabinet_bottom_b_2",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_TOP = registerBlock("wood_light_kitchen_cabinet_top",
            properties -> new KitchenTopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_TOP_B = registerBlock("wood_light_kitchen_cabinet_top_b",
            properties -> new KitchenTopBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_DRAWERS = registerBlock("wood_light_kitchen_drawers",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_DRAWERS_B = registerBlock("wood_light_kitchen_drawers_b",
            properties -> new KitchenBottomBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_KEYBOARD = registerBlock("black_keyboard",
            properties -> new KeyboardBlock(properties.strength(1.0f).nonOpaque()));
    public static Block BLACK_COMPUTER_MOUSE = registerBlock("black_computer_mouse",
            properties -> new ComputerMouseBlock(properties.strength(1.0f).nonOpaque()));

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
