package net.nhatjs.js_furniture_mod.core;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.*;
import net.nhatjs.js_furniture_mod.block.added.*;
import net.nhatjs.js_furniture_mod.block.core.NonFunctionalSimpleBlock;

import static net.nhatjs.js_furniture_mod.NhatJSFurnitureMod.MOD_ID;

public class ModBlocks {
    public static Block BLACK_MIRROR = registerBlock("black_mirror",
            new BlackMirrorBlock(AbstractBlock.Settings.create().strength(0.3f).nonOpaque()));
    public static Block BLACK_STANDING_DESK = registerBlock("black_standing_desk",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_STANDING_DESK_B = registerBlock("black_standing_desk_b",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_TABLE = registerBlock("black_table",
            new TableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BOOKS = registerBlock("books",
            new BooksBlock(AbstractBlock.Settings.create().strength(0.1f).nonOpaque()));
    public static Block COMPUTER_MOUSE = registerBlock("computer_mouse",
            new ComputerMouseBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static Block COOKTOP = registerBlock("cooktop",
            new CooktopBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));
    public static Block FLOOR_STANDING_SPEAKER = registerBlock("floor_standing_speaker",
            new FloorStandingSpeakerBlock(AbstractBlock.Settings.create().strength(0.9f).nonOpaque()));
    public static Block FRIDGE_A = registerBlock("fridge_a",
            new FridgeBlock(AbstractBlock.Settings.create().strength(2f).nonOpaque()));
    public static Block FRIDGE_B = registerBlock("fridge_b",
            new FridgeBlock(AbstractBlock.Settings.create().strength(2f).nonOpaque()));
    public static Block KEYBOARD = registerBlock("keyboard",
            new KeyboardBlock(AbstractBlock.Settings.create().strength(0.7f).nonOpaque()));
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
    public static Block KITCHEN_CABINET_TOP = registerBlock("kitchen_cabinet_top",
            new KitchenTopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_CABINET_TOP_B = registerBlock("kitchen_cabinet_top_b",
            new KitchenTopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_DRAWERS = registerBlock("kitchen_drawers",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block KITCHEN_DRAWERS_B = registerBlock("kitchen_drawers_b",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block LAPTOP = registerBlock("laptop",
            new LaptopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND = registerBlock("laptop_closed_portable_laptop_stand",
            new PortableLaptopStandAddedBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block LED_FLOOR_LAMP = registerBlock("led_floor_lamp",
            new LEDFloorLampBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block LED_FLOOR_LAMP_RGB_OFF = registerBlock("led_floor_lamp_rgb_off",
            new LEDFloorLampRGBBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block LED_FLOOR_LAMP_RGB_OFF_2 = registerBlock("led_floor_lamp_rgb_off_2",
            new LEDFloorLampRGBAltBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block LED_RGB_TRIANGLE_PANEL = registerBlock("led_rgb_triangle_panel",
            new LEDRGBTrianglePanelBlock(AbstractBlock.Settings.create().strength(0.8f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX = registerBlock("midi_standalone_groovebox",
            new GrooveboxBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX_2 = registerBlock("midi_standalone_groovebox_2",
            new Groovebox2Block(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block MIDI_STANDALONE_GROOVEBOX_3 = registerBlock("midi_standalone_groovebox_3",
            new Groovebox3Block(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block MODERN_BATHROOM_MIRROR_SHELF = registerBlock("modern_bathroom_mirror_shelf",
            new BathroomMirrorShelfBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));
    public static Block MODERN_BATHROOM_SINK_STORAGE = registerBlock("modern_bathroom_sink_storage",
            new BathroomSinkStorageBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block MODERN_CHAIR = registerBlock("modern_chair",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block MODERN_CLOCK = registerBlock("modern_clock",
            new ModernClockBlock(AbstractBlock.Settings.create().strength(0.4f).nonOpaque()));
    public static Block MODERN_LIGHT = registerBlock("modern_light",
            new ModernLightBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static Block MONITOR = registerBlock("monitor",
            new MonitorBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block MONITOR_SETUP = registerBlock("monitor_setup",
            new MonitorSetupBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block PC = registerBlock("pc",
            new DesktopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block PC_RGB1_OFF = registerBlock("pc_rgb1_off",
            new DesktopAltBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block PC_TOWER_GLASS = registerBlock("pc_tower_glass",
            new DesktopTowerGlassBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.GLASS).strength(0.4f).nonOpaque().noCollision()));
    public static Block PLANT_POT = registerBlock("plant_pot",
            new PotBlock(AbstractBlock.Settings.create().strength(0.4f).nonOpaque()));
    public static Block PORTABLE_LAPTOP_STAND = registerBlock("portable_laptop_stand",
            new PortableLaptopStandBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block SHOWER = registerBlock("shower",
            new ShowerBlock(AbstractBlock.Settings.create().strength(0.5f).nonOpaque()));
    public static Block SOCKET = registerBlock("socket",
            new SocketBlock(AbstractBlock.Settings.create().strength(0.2f).nonOpaque()));
    public static Block SOFA = registerBlock("sofa",
            new SofaBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block STUDIO_LIGHT = registerBlock("studio_light",
            new StudioLightBlock(AbstractBlock.Settings.create().strength(1.5f).nonOpaque()));
    public static Block TV = registerBlock("tv",
            new TVBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block VERTICAL_BLINDS = registerBlock("vertical_blinds",
            new VerticalBlindsBlock(AbstractBlock.Settings.create().strength(0.7f).nonOpaque()));
    public static Block WASHING_MACHINE_AI = registerBlock("washing_machine_ai",
            new WashingMachineBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_3_DRAWER_DRESSER = registerBlock("white_3_drawer_dresser",
            new ThreeDrawerDresserBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_CHAIR = registerBlock("white_chair",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_COFFEE_TABLE = registerBlock("white_coffee_table",
            new CoffeeTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_DESK = registerBlock("white_desk",
            new DeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_STANDING_DESK = registerBlock("white_standing_desk",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_STANDING_DESK_B = registerBlock("white_standing_desk_b",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_TABLE = registerBlock("white_table",
            new TableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_TV_STAND = registerBlock("white_tv_stand",
            new TVStandBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_3_DRAWER_DRESSER = registerBlock("wood_3_drawer_dresser",
            new ThreeDrawerDresserBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_CHAIR = registerBlock("wood_chair",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_COFFEE_TABLE = registerBlock("wood_coffee_table",
            new CoffeeTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_DESK = registerBlock("wood_desk",
            new DeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_TABLE = registerBlock("wood_light_table",
            new TableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_TV_STAND = registerBlock("wood_light_tv_stand",
            new TVStandBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_STANDING_DESK = registerBlock("wood_standing_desk",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_STANDING_DESK_B = registerBlock("wood_standing_desk_b",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_STRIPED_WALL = registerBlock("wood_striped_wall",
            new WoodStripedWallBlock(AbstractBlock.Settings.create().strength(0.3f).nonOpaque()));

    public static Block CEILING_FAN = registerBlock("ceiling_fan",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_GAMING_CHAIR = registerBlock("black_gaming_chair",
            new GamingChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_GAMING_CHAIR = registerBlock("white_gaming_chair",
            new GamingChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));

    public static Block TOILET = registerBlock("toilet",
            new ToiletBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));

    public static Block CEILING_FAN_B = registerBlock("ceiling_fan_b",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_SOFA = registerBlock("black_sofa",
            new SofaBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block MIDI_KEYBOARD_CONTROLLER = registerBlock("midi_keyboard_controller",
            new MIDIKeyboardBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_TV_STAND = registerBlock("wood_medium_tv_stand",
            new TVStandBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_3_DRAWER_DRESSER = registerBlock("wood_medium_3_drawer_dresser",
            new ThreeDrawerDresserBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_CHAIR = registerBlock("wood_medium_chair",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_COFFEE_TABLE = registerBlock("wood_medium_coffee_table",
            new CoffeeTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_DESK = registerBlock("wood_medium_desk",
            new DeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_STANDING_DESK = registerBlock("wood_medium_standing_desk",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_STANDING_DESK_B = registerBlock("wood_medium_standing_desk_b",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_STRIPED_WALL = registerBlock("wood_medium_striped_wall",
            new WoodStripedWallBlock(AbstractBlock.Settings.create().strength(0.3f).nonOpaque()));
    public static Block WOOD_MEDIUM_TABLE = registerBlock("wood_medium_table",
            new TableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM = registerBlock("wood_medium_kitchen_cabinet_bottom",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK = registerBlock("wood_medium_kitchen_cabinet_bottom_with_sink",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2 = registerBlock("wood_medium_kitchen_cabinet_bottom_2",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA = registerBlock("wood_medium_kitchen_cabinet_bottom_2_extra",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B = registerBlock("wood_medium_kitchen_cabinet_bottom_b",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK = registerBlock("wood_medium_kitchen_cabinet_bottom_b_with_sink",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2 = registerBlock("wood_medium_kitchen_cabinet_bottom_b_2",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_TOP = registerBlock("wood_medium_kitchen_cabinet_top",
            new KitchenTopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_CABINET_TOP_B = registerBlock("wood_medium_kitchen_cabinet_top_b",
            new KitchenTopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_DRAWERS = registerBlock("wood_medium_kitchen_drawers",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_DRAWERS_B = registerBlock("wood_medium_kitchen_drawers_b",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));

    public static Block COMPUTER_CASE = registerBlock("computer_case",
            new ComputerCaseBlock(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_1 = registerBlock("pc_added_1",
            new PCAdded1Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_2 = registerBlock("pc_added_2",
            new PCAdded2Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_3 = registerBlock("pc_added_3",
            new PCAdded3Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_4 = registerBlock("pc_added_4",
            new PCAdded4Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_5 = registerBlock("pc_added_5",
            new PCAdded5Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_6 = registerBlock("pc_added_6",
            new PCAdded6Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_7 = registerBlock("pc_added_7",
            new PCAdded7Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_8 = registerBlock("pc_added_8",
            new PCAdded8Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_9 = registerBlock("pc_added_9",
            new PCAdded9Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_10 = registerBlock("pc_added_10",
            new PCAdded10Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block PC_ADDED_11 = registerBlock("pc_added_11",
            new PCAdded11Block(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));

    public static Block BLACK_CHAIR = registerBlock("black_chair",
            new ChairBlock(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block BLACK_COFFEE_TABLE = registerBlock("black_coffee_table",
            new CoffeeTableBlock(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block BLACK_3_DRAWER_DRESSER = registerBlock("black_3_drawer_dresser",
            new ThreeDrawerDresserBlock(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block WOOD_LIGHT_DRAWER_SINGLE = registerBlock("wood_light_drawer_single",
            new DrawerSingleBlock(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block WOOD_MEDIUM_DRAWER_SINGLE = registerBlock("wood_medium_drawer_single",
            new DrawerSingleBlock(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block BLACK_DRAWER_SINGLE = registerBlock("black_drawer_single",
            new DrawerSingleBlock(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block WHITE_DRAWER_SINGLE = registerBlock("white_drawer_single",
            new DrawerSingleBlock(AbstractBlock.Settings.create().strength(0.75f).nonOpaque()));
    public static Block BLACK_DESK = registerBlock("black_desk",
            new DeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_TV_STAND = registerBlock("black_tv_stand",
            new TVStandBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_DESK_COLUMN = registerBlock("black_desk_column",
            new DeskColumnBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_DESK_COLUMN = registerBlock("white_desk_column",
            new DeskColumnBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_VERTICAL_BLINDS = registerBlock("black_vertical_blinds",
            new VerticalBlindsBlock(AbstractBlock.Settings.create().strength(0.7f).nonOpaque()));
    public static Block WOOD_LIGHT_CEILING_FAN_BLACK = registerBlock("wood_light_ceiling_fan_black",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_CEILING_FAN_BLACK = registerBlock("wood_medium_ceiling_fan_black",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_CEILING_FAN_BLACK = registerBlock("black_ceiling_fan_black",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_CEILING_FAN_BLACK = registerBlock("white_ceiling_fan_black",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_CEILING_FAN_WHITE = registerBlock("wood_light_ceiling_fan_white",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_CEILING_FAN_WHITE = registerBlock("wood_medium_ceiling_fan_white",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_CEILING_FAN_WHITE = registerBlock("black_ceiling_fan_white",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_CEILING_FAN_WHITE = registerBlock("white_ceiling_fan_white",
            new CeilingFanBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_SOFA = registerBlock("white_sofa",
            new SofaBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_COMPARTMENT_STORAGE_CABINET = registerBlock("wood_light_compartment_storage_cabinet",
            new NonFunctionalSimpleBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_COMPARTMENT_STORAGE_CABINET = registerBlock("wood_medium_compartment_storage_cabinet",
            new NonFunctionalSimpleBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_COMPARTMENT_STORAGE_CABINET = registerBlock("black_compartment_storage_cabinet",
            new NonFunctionalSimpleBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_COMPARTMENT_STORAGE_CABINET = registerBlock("white_compartment_storage_cabinet",
            new NonFunctionalSimpleBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET = registerBlock("wood_light_kitchen_compartment_storage_cabinet",
            new NonFunctionalSimpleBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET = registerBlock("wood_medium_kitchen_compartment_storage_cabinet",
            new NonFunctionalSimpleBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET_B = registerBlock("wood_light_kitchen_compartment_storage_cabinet_b",
            new NonFunctionalSimpleBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET_B = registerBlock("wood_medium_kitchen_compartment_storage_cabinet_b",
            new NonFunctionalSimpleBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WHITE_VERTICAL_BLINDS = registerBlock("white_vertical_blinds",
            new VerticalBlindsBlock(AbstractBlock.Settings.create().strength(0.7f).nonOpaque()));
    public static Block WOOD_LIGHT_3_DRAWER_DRESSER = registerBlock("wood_light_3_drawer_dresser",
            new ThreeDrawerDresserBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_CHAIR = registerBlock("wood_light_chair",
            new ChairBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_COFFEE_TABLE = registerBlock("wood_light_coffee_table",
            new CoffeeTableBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_DESK = registerBlock("wood_light_desk",
            new DeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_STANDING_DESK = registerBlock("wood_light_standing_desk",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_STANDING_DESK_B = registerBlock("wood_light_standing_desk_b",
            new StandingDeskBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM = registerBlock("wood_light_kitchen_cabinet_bottom",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_WITH_SINK = registerBlock("wood_light_kitchen_cabinet_bottom_with_sink",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2 = registerBlock("wood_light_kitchen_cabinet_bottom_2",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2_EXTRA = registerBlock("wood_light_kitchen_cabinet_bottom_2_extra",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B = registerBlock("wood_light_kitchen_cabinet_bottom_b",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_WITH_SINK = registerBlock("wood_light_kitchen_cabinet_bottom_b_with_sink",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_2 = registerBlock("wood_light_kitchen_cabinet_bottom_b_2",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_TOP = registerBlock("wood_light_kitchen_cabinet_top",
            new KitchenTopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_CABINET_TOP_B = registerBlock("wood_light_kitchen_cabinet_top_b",
            new KitchenTopBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_DRAWERS = registerBlock("wood_light_kitchen_drawers",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block WOOD_LIGHT_KITCHEN_DRAWERS_B = registerBlock("wood_light_kitchen_drawers_b",
            new KitchenBottomBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_KEYBOARD = registerBlock("black_keyboard",
            new KeyboardBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));
    public static Block BLACK_COMPUTER_MOUSE = registerBlock("black_computer_mouse",
            new ComputerMouseBlock(AbstractBlock.Settings.create().strength(1.0f).nonOpaque()));

    private static <T extends Block> T registerBlock(String name, T block) {
        Identifier id = Identifier.of(MOD_ID, name);
        Registry.register(Registries.BLOCK, id, block);
        Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
        return block;
    }

    public static void registerModBlocks() {
        NhatJSFurnitureMod.LOGGER.info("Registering Mod Blocks for " + MOD_ID);
    }
}
