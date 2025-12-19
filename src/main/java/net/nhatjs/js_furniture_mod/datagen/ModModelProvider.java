package net.nhatjs.js_furniture_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.*;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_GAMING_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_MIRROR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_STANDING_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_STANDING_DESK_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BLACK_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.BOOKS);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COMPUTER_CASE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COMPUTER_MOUSE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.COOKTOP);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.FLOOR_STANDING_SPEAKER);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.FRIDGE_A);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.FRIDGE_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.KEYBOARD);
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM, "light_wood_kitchen_cabinet_bottom");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_2, "light_wood_kitchen_cabinet_bottom_2");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA, "light_wood_kitchen_cabinet_bottom_2_extra");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_B, "light_wood_kitchen_cabinet_bottom_b");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_B_2, "light_wood_kitchen_cabinet_bottom_b_2");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK, "light_wood_kitchen_cabinet_bottom_b_with_sink");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK, "light_wood_kitchen_cabinet_bottom_with_sink");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_TOP, "light_wood_kitchen_cabinet_top");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_CABINET_TOP_B, "light_wood_kitchen_cabinet_top_b");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_DRAWERS, "light_wood_kitchen_drawers");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.KITCHEN_DRAWERS_B, "light_wood_kitchen_drawers_b");
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MODERN_BATHROOM_MIRROR_SHELF);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MODERN_BATHROOM_SINK_STORAGE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MODERN_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MODERN_CLOCK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.MONITOR);
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
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.TOILET);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_3_DRAWER_DRESSER);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_COFFEE_TABLE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_GAMING_CHAIR);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_STANDING_DESK);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_STANDING_DESK_B);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.WHITE_TABLE);
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WHITE_TV_STAND, "tv_stand_2");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_3_DRAWER_DRESSER, "light_wood_3_drawer_dresser");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_CHAIR, "light_wood_chair");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_COFFEE_TABLE, "light_wood_coffee_table");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_DESK, "light_wood_desk");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_LIGHT_TABLE, "light_wood_table");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_LIGHT_TV_STAND, "light_wood_tv_stand");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER, "medium_wood_3_drawer_dresser");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_CHAIR, "medium_wood_chair");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_COFFEE_TABLE, "medium_wood_coffee_table");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_DESK, "medium_wood_desk");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM, "medium_wood_kitchen_cabinet_bottom");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2, "medium_wood_kitchen_cabinet_bottom_2");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA, "medium_wood_kitchen_cabinet_bottom_2_extra");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B, "medium_wood_kitchen_cabinet_bottom_b");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2, "medium_wood_kitchen_cabinet_bottom_b_2");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK, "medium_wood_kitchen_cabinet_bottom_b_with_sink");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK, "medium_wood_kitchen_cabinet_bottom_with_sink");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP, "medium_wood_kitchen_cabinet_top");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B, "medium_wood_kitchen_cabinet_top_b");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS, "medium_wood_kitchen_drawers");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B, "medium_wood_kitchen_drawers_b");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_STANDING_DESK, "medium_wood_standing_desk");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_STANDING_DESK_B, "medium_wood_standing_desk_b");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_STRIPED_WALL, "medium_wood_striped_wall");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_TABLE, "medium_wood_table");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_MEDIUM_TV_STAND, "medium_wood_tv_stand");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_STANDING_DESK, "light_wood_standing_desk");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_STANDING_DESK_B, "light_wood_standing_desk_b");
        horizontalWithCustomModel(blockStateModelGenerator, ModBlocks.WOOD_STRIPED_WALL, "light_wood_striped_wall");
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        Optional empty = Optional.empty();

        itemModelGenerator.register(ModItems.REMOTE_CONTROL_RGB, Models.GENERATED);
        itemModelGenerator.register(ModItems.CPU, Models.GENERATED);
        itemModelGenerator.register(ModBlocks.BLACK_MIRROR.asItem(), Models.GENERATED);
        itemModelGenerator.register(ModItems.MAINBOARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.AIO_COOLER, Models.GENERATED);
        itemModelGenerator.register(ModItems.COMPUTER_FAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.GPU, Models.GENERATED);
        itemModelGenerator.register(ModItems.PSU, Models.GENERATED);

        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_bottom")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_2.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_bottom_2")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_bottom_2_extra")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_B.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_bottom_b")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_B_2.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_bottom_b_2")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_bottom_b_with_sink")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_bottom_with_sink")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_TOP.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_top")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_CABINET_TOP_B.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_cabinet_top_b")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_DRAWERS.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_drawers")), empty));
        itemModelGenerator.register(ModBlocks.KITCHEN_DRAWERS_B.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_kitchen_drawers_b")), empty));
        itemModelGenerator.register(ModBlocks.WHITE_TV_STAND.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/tv_stand_2")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_3_DRAWER_DRESSER.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_3_drawer_dresser")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_CHAIR.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_chair")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_COFFEE_TABLE.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_coffee_table")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_DESK.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_desk")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_LIGHT_TABLE.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_table")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_LIGHT_TV_STAND.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_tv_stand")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_3_drawer_dresser")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_CHAIR.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_chair")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_COFFEE_TABLE.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_coffee_table")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_DESK.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_desk")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_bottom")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_bottom_2")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_bottom_2_extra")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_bottom_b")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_bottom_b_2")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_bottom_b_with_sink")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_bottom_with_sink")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_top")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_cabinet_top_b")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_drawers")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_kitchen_drawers_b")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_STANDING_DESK.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_standing_desk")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_STANDING_DESK_B.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_standing_desk_b")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_STRIPED_WALL.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_striped_wall")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_TABLE.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_table")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_MEDIUM_TV_STAND.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/medium_wood_tv_stand")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_STANDING_DESK.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_standing_desk")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_STANDING_DESK_B.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_standing_desk_b")), empty));
        itemModelGenerator.register(ModBlocks.WOOD_STRIPED_WALL.asItem(),
                new Model(Optional.of(Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/light_wood_striped_wall")), empty));
    }

    private void horizontalWithCustomModel(BlockStateModelGenerator blockStateModelGenerator, Block block, String name) {
        Identifier model = Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/" + name);
        BlockStateVariantMap map = BlockStateVariantMap.create(Properties.HORIZONTAL_FACING)
                .register(Direction.NORTH,  BlockStateVariant.create().put(VariantSettings.MODEL, model))
                .register(Direction.EAST,  BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.SOUTH,  BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.WEST,  BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R270));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(map));
    }

    private void allDirectionWithCustomModel(BlockStateModelGenerator blockStateModelGenerator, Block block, String name) {
        Identifier model = Identifier.of(NhatJSFurnitureMod.MOD_ID, "block/" + name);
        BlockStateVariantMap map = BlockStateVariantMap.create(Properties.FACING)
                .register(Direction.NORTH,  BlockStateVariant.create().put(VariantSettings.MODEL, model))
                .register(Direction.EAST,  BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R90))
                .register(Direction.SOUTH,  BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R180))
                .register(Direction.WEST,  BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.Y, VariantSettings.Rotation.R270))
                .register(Direction.UP,  BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.X, VariantSettings.Rotation.R270))
                .register(Direction.DOWN,  BlockStateVariant.create().put(VariantSettings.MODEL, model).put(VariantSettings.X, VariantSettings.Rotation.R90));
        blockStateModelGenerator.blockStateCollector.accept(VariantsBlockStateSupplier.create(block).coordinate(map));
    }
}
