package net.nhatjs.js_furniture_mod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.block.Block;
import net.minecraft.client.data.*;
import net.minecraft.client.render.model.json.ModelVariantOperator;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.AxisRotation;
import net.minecraft.util.math.Direction;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.*;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.core.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_COMPARTMENT_STORAGE_CABINET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_COMPUTER_MOUSE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_3_DRAWER_DRESSER);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_CHAIR);
        registerSimpleState(blockStateModelGenerator, ModBlocks.BLACK_CEILING_FAN_BLACK, id("ceiling_fan_base_black"));
        registerSimpleState(blockStateModelGenerator, ModBlocks.BLACK_CEILING_FAN_WHITE, id("ceiling_fan_base_white"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_COFFEE_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_DESK_COLUMN);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_DRAWER_SINGLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_GAMING_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_KEYBOARD);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_MIRROR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_STANDING_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_STANDING_DESK_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_TV_STAND);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.BLACK_VERTICAL_BLINDS, Properties.HORIZONTAL_FACING,
                VerticalBlindsBlock.TURN_ON, id("black_vertical_blinds"), id("black_vertical_blinds_open"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BOOKS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COMPUTER_CASE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COMPUTER_MOUSE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COOKTOP);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.FLOOR_STANDING_SPEAKER);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.FRIDGE_A);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.FRIDGE_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEYBOARD);
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM, id("wood_light_kitchen_cabinet_bottom"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_2, id("wood_light_kitchen_cabinet_bottom_2"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA, id("wood_light_kitchen_cabinet_bottom_2_extra"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_B, id("wood_light_kitchen_cabinet_bottom_b"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_B_2, id("wood_light_kitchen_cabinet_bottom_b_2"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK, id("wood_light_kitchen_cabinet_bottom_b_with_sink"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK, id("wood_light_kitchen_cabinet_bottom_with_sink"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_TOP, id("wood_light_kitchen_cabinet_top"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_TOP_B, id("wood_light_kitchen_cabinet_top_b"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_DRAWERS, id("wood_light_kitchen_drawers"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.KITCHEN_DRAWERS_B, id("wood_light_kitchen_drawers_b"));

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.LED_FLOOR_LAMP, Properties.HORIZONTAL_FACING,
                LEDFloorLampBlock.TURN_ON, id("led_floor_lamp"), id("led_floor_lamp_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.LED_FLOOR_LAMP_RGB_OFF, Properties.HORIZONTAL_FACING,
                LEDFloorLampRGBBlock.TURN_ON, id("led_floor_lamp_rgb_off"), id("led_floor_lamp_rgb_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.LED_FLOOR_LAMP_RGB_OFF_2, Properties.HORIZONTAL_FACING,
                LEDFloorLampRGBAltBlock.TURN_ON, id("led_floor_lamp_rgb_off_2"), id("led_floor_lamp_rgb_on_2"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.LED_RGB_TRIANGLE_PANEL, Properties.HORIZONTAL_FACING,
                LEDRGBTrianglePanelBlock.TURN_ON, id("led_rgb_triangle_panel"), id("led_rgb_triangle_panel_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MIDI_KEYBOARD_CONTROLLER, Properties.HORIZONTAL_FACING,
                MIDIKeyboardBlock.TURN_ON, id("midi_keyboard_controller"), id("midi_keyboard_controller_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MIDI_STANDALONE_GROOVEBOX, Properties.HORIZONTAL_FACING,
                GrooveboxBlock.TURN_ON, id("midi_standalone_groovebox"), id("midi_standalone_groovebox_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MIDI_STANDALONE_GROOVEBOX_2, Properties.HORIZONTAL_FACING,
                Groovebox2Block.TURN_ON, id("midi_standalone_groovebox_2"), id("midi_standalone_groovebox_2_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MIDI_STANDALONE_GROOVEBOX_3, Properties.HORIZONTAL_FACING,
                Groovebox3Block.TURN_ON, id("midi_standalone_groovebox_3"), id("midi_standalone_groovebox_3_on"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MODERN_BATHROOM_MIRROR_SHELF);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MODERN_BATHROOM_SINK_STORAGE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MODERN_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MODERN_CLOCK);

        allDirectionWithCustomModelAndBoolean(blockStateModelGenerator, ModBlocks.MODERN_LIGHT,
                Properties.FACING, ModernLightBlock.TURN_ON, id("modern_light"), id("modern_light_on"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MONITOR);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.MONITOR_SETUP, Properties.HORIZONTAL_FACING,
                MonitorSetupBlock.TURN_ON, id("monitor_setup"), id("monitor_setup_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.PC, Properties.HORIZONTAL_FACING,
                DesktopBlock.TURN_ON, id("pc"), id("pc_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.PC_RGB1_OFF, Properties.HORIZONTAL_FACING,
                DesktopAltBlock.TURN_ON, id("pc_rgb1_off"), id("pc_rgb1_on"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_1);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_3);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_4);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_5);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_6);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_7);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_8);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_9);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_10);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_ADDED_11);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PC_TOWER_GLASS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PLANT_POT);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.PORTABLE_LAPTOP_STAND);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.SHOWER);

        allDirectionWithCustomModel(blockStateModelGenerator, ModBlocks.SOCKET, "socket");
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.STUDIO_LIGHT, Properties.HORIZONTAL_FACING,
                StudioLightBlock.TURN_ON, id("studio_light"), id("studio_light_on"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.TOILET, Properties.HORIZONTAL_FACING,
                ToiletBlock.OPEN, id("toilet"), id("toilet_open"));
        registerTVStates(blockStateModelGenerator, ModBlocks.TV, Properties.HORIZONTAL_FACING,
                TVBlock.MOUNT, id("tv"), id("tv_wall_mount"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.VERTICAL_BLINDS, Properties.HORIZONTAL_FACING,
                VerticalBlindsBlock.TURN_ON, id("white_vertical_blinds"), id("white_vertical_blinds_open"));
        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.WASHING_MACHINE_AI, Properties.HORIZONTAL_FACING,
                WashingMachineBlock.TURN_ON, id("washing_machine_ai"), id("washing_machine_ai_open"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_COMPARTMENT_STORAGE_CABINET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_3_DRAWER_DRESSER);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_CHAIR);
        registerSimpleState(blockStateModelGenerator, ModBlocks.WHITE_CEILING_FAN_BLACK, id("ceiling_fan_base_black"));
        registerSimpleState(blockStateModelGenerator, ModBlocks.WHITE_CEILING_FAN_WHITE, id("ceiling_fan_base_white"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_COFFEE_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_DESK_COLUMN);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_DRAWER_SINGLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_GAMING_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_STANDING_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_STANDING_DESK_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_TV_STAND);

        registerHorizontalWithBoolean(blockStateModelGenerator, ModBlocks.WHITE_VERTICAL_BLINDS, Properties.HORIZONTAL_FACING,
                VerticalBlindsBlock.TURN_ON, id("white_vertical_blinds"), id("white_vertical_blinds_open"));

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_COMPARTMENT_STORAGE_CABINET);
        registerHorizontal(blockStateModelGenerator, ModBlocks.WOOD_3_DRAWER_DRESSER, id("wood_light_3_drawer_dresser"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_3_DRAWER_DRESSER);
        registerHorizontal(blockStateModelGenerator, ModBlocks.WOOD_CHAIR, id("wood_light_chair"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_CHAIR);
        registerSimpleState(blockStateModelGenerator, ModBlocks.WOOD_LIGHT_CEILING_FAN_BLACK, id("ceiling_fan_base_black"));
        registerSimpleState(blockStateModelGenerator, ModBlocks.WOOD_LIGHT_CEILING_FAN_WHITE, id("ceiling_fan_base_white"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.WOOD_COFFEE_TABLE, id("wood_light_coffee_table"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_COFFEE_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_DRAWER_SINGLE);
        registerHorizontal(blockStateModelGenerator, ModBlocks.WOOD_DESK, id("wood_light_desk"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2_EXTRA);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_WITH_SINK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_WITH_SINK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_TOP);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_TOP_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_DRAWERS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_KITCHEN_DRAWERS_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_STANDING_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_STANDING_DESK_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_LIGHT_TABLE);
        registerHorizontal(blockStateModelGenerator, ModBlocks.WOOD_LIGHT_TV_STAND, id("wood_light_tv_stand"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_COMPARTMENT_STORAGE_CABINET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_CHAIR);
        registerSimpleState(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_CEILING_FAN_BLACK, id("ceiling_fan_base_black"));
        registerSimpleState(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_CEILING_FAN_WHITE, id("ceiling_fan_base_white"));
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_COFFEE_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_DRAWER_SINGLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_STANDING_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_STANDING_DESK_B);
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_STRIPED_WALL, "medium_wood_striped_wall");
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WOOD_MEDIUM_TV_STAND);
        registerHorizontal(blockStateModelGenerator, ModBlocks.WOOD_STANDING_DESK, id("wood_light_standing_desk"));
        registerHorizontal(blockStateModelGenerator, ModBlocks.WOOD_STANDING_DESK_B, id("wood_light_standing_desk_b"));
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_STRIPED_WALL, "light_wood_striped_wall");
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Optional empty = Optional.empty();

        itemModelGenerator.register(ModItems.REMOTE_CONTROL_RGB, Models.GENERATED);
        itemModelGenerator.register(ModItems.CPU, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACK_MIRROR.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.MAINBOARD, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MONITOR.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModBlocks.MONITOR_SETUP.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.RAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.AIO_COOLER, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPUTER_FAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GPU, Models.GENERATED);
        itemModelGenerator.register(ModItems.PSU, Models.GENERATED);
        itemModelGenerator.register(ModItems.GARBAGE_ITEM, Models.GENERATED);

        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_bottom")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_2.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_bottom_2")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_bottom_2_extra")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_B.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_bottom_b")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_B_2.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_bottom_b_2")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_bottom_b_with_sink")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_bottom_with_sink")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_TOP.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_top")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_TOP_B.asItem(), new Model(Optional.of(id("wood_light_kitchen_cabinet_top_b")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_DRAWERS.asItem(), new Model(Optional.of(id("wood_light_kitchen_drawers")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_DRAWERS_B.asItem(), new Model(Optional.of(id("wood_light_kitchen_drawers_b")), empty));
        itemModelGenerator.register(ModBlocks.LAPTOP.asItem(), new Model(Optional.of(id("laptop_opened_off")), empty));
        itemModelGenerator.register(ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND.asItem(), new Model(Optional.of(id("laptop_opened_on_portable_laptop_stand")), empty));
        itemModelGenerator.register(ModBlocks.VERTICAL_BLINDS.asItem(), new Model(Optional.of(id("white_vertical_blinds")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_3_DRAWER_DRESSER.asItem(), new Model(Optional.of(id("wood_light_3_drawer_dresser")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_CHAIR.asItem(), new Model(Optional.of(id("wood_light_chair")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_COFFEE_TABLE.asItem(), new Model(Optional.of(id("wood_light_coffee_table")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_DESK.asItem(), new Model(Optional.of(id("wood_light_desk")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_LIGHT_TV_STAND.asItem(), new Model(Optional.of(id("wood_light_tv_stand")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_STRIPED_WALL.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_striped_wall")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_STANDING_DESK.asItem(), new Model(Optional.of(id("wood_light_standing_desk")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_STANDING_DESK_B.asItem(), new Model(Optional.of(id("wood_light_standing_desk_b")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_STRIPED_WALL.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_striped_wall")), empty));
    }

    private void horizontalWithCustomModel(BlockStateModelGenerator blockStateModelGenerator, Block block, String name) {
        Identifier model = Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/" + name);
        BlockStateVariantMap<WeightedVariant> map = BlockStateVariantMap.models(Properties.HORIZONTAL_FACING)
                .register(Direction.NORTH,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)))
                .register(Direction.EAST,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.SOUTH,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.WEST,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    private void registerHorizontalWithBoolean(BlockStateModelGenerator blockStateModelGenerator, Block block, EnumProperty<Direction> facing,
                                               BooleanProperty facingBoolean, Identifier model, Identifier modelBoolean) {
        BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, Boolean> map = BlockStateVariantMap.models(facing, facingBoolean)
                .register(Direction.NORTH, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)))
                .register(Direction.NORTH, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)))
                .register(Direction.EAST, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.EAST, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.SOUTH, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.SOUTH, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.WEST, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)))
                .register(Direction.WEST, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    private void registerHorizontal(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier model) {
        BlockStateVariantMap<WeightedVariant> map = BlockStateVariantMap.models(Properties.HORIZONTAL_FACING)
                .register(Direction.NORTH,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)))
                .register(Direction.EAST,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.SOUTH,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.WEST,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    private void registerSimpleState(BlockStateModelGenerator blockStateModelGenerator, Block block, Identifier model) {
        WeightedVariant map = BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block, map));
    }

    private void allDirectionWithCustomModel(BlockStateModelGenerator blockStateModelGenerator, Block block, String name) {
        Identifier model = Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/" + name);
        BlockStateVariantMap<WeightedVariant> map = BlockStateVariantMap.models(Properties.FACING)
                .register(Direction.NORTH,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)))
                .register(Direction.EAST,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.SOUTH,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.WEST,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)))
                .register(Direction.UP,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R270)))
                .register(Direction.DOWN,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R90)));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    private void allDirectionWithCustomModelAndBoolean(BlockStateModelGenerator blockStateModelGenerator, Block block, EnumProperty<Direction> facing,
                                                       BooleanProperty facingBoolean, Identifier model, Identifier modelBoolean) {
        BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, Boolean> map = BlockStateVariantMap.models(facing, facingBoolean)
                .register(Direction.NORTH, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)))
                .register(Direction.NORTH, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)))
                .register(Direction.EAST, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.EAST, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.SOUTH, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.SOUTH, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.WEST, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)))
                .register(Direction.WEST, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)))
                .register(Direction.UP, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R270)))
                .register(Direction.UP, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R270)))
                .register(Direction.DOWN, false,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R90)))
                .register(Direction.DOWN, true,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_X.withValue(AxisRotation.R90)));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    private void registerTVStates(BlockStateModelGenerator blockStateModelGenerator, Block block, EnumProperty<Direction> facing,
                                  EnumProperty<TVBlock.Mount> facingBoolean, Identifier model, Identifier modelBoolean) {
        BlockStateVariantMap.DoubleProperty<WeightedVariant, Direction, TVBlock.Mount> map = BlockStateVariantMap.models(facing, facingBoolean)
                .register(Direction.NORTH, TVBlock.Mount.STAND,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)))
                .register(Direction.NORTH, TVBlock.Mount.WALL,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)))
                .register(Direction.EAST, TVBlock.Mount.STAND,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.EAST, TVBlock.Mount.WALL,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R90)))
                .register(Direction.SOUTH, TVBlock.Mount.STAND,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.SOUTH, TVBlock.Mount.WALL,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R180)))
                .register(Direction.WEST, TVBlock.Mount.STAND,  BlockStateModelGenerator.createWeightedVariant(model).apply(ModelVariantOperator.MODEL.withValue(model)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)))
                .register(Direction.WEST, TVBlock.Mount.WALL,  BlockStateModelGenerator.createWeightedVariant(modelBoolean).apply(ModelVariantOperator.MODEL.withValue(modelBoolean)).apply(ModelVariantOperator.ROTATION_Y.withValue(AxisRotation.R270)));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockModelDefinitionCreator.of(block).with(map));
    }

    public static Identifier id(String path) {
        return Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/" + path);
    }
}
