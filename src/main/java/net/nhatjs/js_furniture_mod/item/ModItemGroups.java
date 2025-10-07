package net.nhatjs.js_furniture_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.nhatjs.js_furniture_mod.NhatJSFurnitureMod;
import net.nhatjs.js_furniture_mod.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup NEXTGEN_FURNITURE_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(NhatJSFurnitureMod.MOD_ID, "js_furniture_logo"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.BLACK_TABLE))
                    .displayName(Text.translatable("itemgroup.js_furniture_mod.js_furniture_tab"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.WOOD_CHAIR);
                        entries.add(ModBlocks.MODERN_CHAIR);
                        entries.add(ModBlocks.SOFA);
                        entries.add(ModBlocks.WOOD_LIGHT_TABLE);
                        entries.add(ModBlocks.BLACK_TABLE);
                        entries.add(ModBlocks.WHITE_TABLE);
                        entries.add(ModBlocks.WOOD_COFFEE_TABLE);
                        entries.add(ModBlocks.WHITE_COFFEE_TABLE);
                        entries.add(ModBlocks.WOOD_DESK);
                        entries.add(ModBlocks.WHITE_DESK);
                        entries.add(ModBlocks.WOOD_STANDING_DESK);
                        entries.add(ModBlocks.WOOD_STANDING_DESK_B);
                        entries.add(ModBlocks.BLACK_STANDING_DESK);
                        entries.add(ModBlocks.BLACK_STANDING_DESK_B);
                        entries.add(ModBlocks.WHITE_STANDING_DESK);
                        entries.add(ModBlocks.WHITE_STANDING_DESK_B);
                        entries.add(ModBlocks.WOOD_3_DRAWER_DRESSER);
                        entries.add(ModBlocks.WHITE_3_DRAWER_DRESSER);
                        entries.add(ModBlocks.WOOD_LIGHT_TV_STAND);
                        entries.add(ModBlocks.KITCHEN_CABINET_BOTTOM);
                        entries.add(ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK);
                        entries.add(ModBlocks.KITCHEN_CABINET_BOTTOM_2);
                        entries.add(ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA);
                        entries.add(ModBlocks.KITCHEN_CABINET_BOTTOM_B);
                        entries.add(ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK);
                        entries.add(ModBlocks.KITCHEN_CABINET_BOTTOM_B_2);
                        entries.add(ModBlocks.KITCHEN_DRAWERS);
                        entries.add(ModBlocks.KITCHEN_CABINET_TOP);
                        entries.add(ModBlocks.KITCHEN_CABINET_TOP_B);
                        entries.add(ModBlocks.WOOD_STRIPED_WALL);
                        entries.add(ModBlocks.BLACK_MIRROR);
                        entries.add(ModBlocks.SOCKET);
                        entries.add(ModBlocks.MODERN_CLOCK);
                        entries.add(ModBlocks.MODERN_LIGHT);
                        entries.add(ModBlocks.LED_FLOOR_LAMP);
                        entries.add(ModBlocks.LED_FLOOR_LAMP_RGB_OFF);
                        entries.add(ModBlocks.STUDIO_LIGHT);
                        entries.add(ModBlocks.MONITOR_SETUP);
                        entries.add(ModBlocks.MONITOR);
                        entries.add(ModBlocks.KEYBOARD);
                        entries.add(ModBlocks.COMPUTER_MOUSE);
                        entries.add(ModBlocks.PC);
                        entries.add(ModBlocks.PC_TOWER_GLASS);
                        entries.add(ModBlocks.LAPTOP);
                        entries.add(ModBlocks.PORTABLE_LAPTOP_STAND);
                        entries.add(ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND);
                        entries.add(ModBlocks.MIDI_STANDALONE_GROOVEBOX);
                        entries.add(ModBlocks.MIDI_STANDALONE_GROOVEBOX_2);
                        entries.add(ModBlocks.MIDI_STANDALONE_GROOVEBOX_3);
                        entries.add(ModBlocks.COOKTOP);
                        entries.add(ModBlocks.FRIDGE_A);
                        entries.add(ModBlocks.FRIDGE_B);
                        entries.add(ModBlocks.MODERN_BATHROOM_SINK_STORAGE);
                        entries.add(ModBlocks.MODERN_BATHROOM_MIRROR_SHELF);
                        entries.add(ModBlocks.SHOWER);
                        entries.add(ModBlocks.WASHING_MACHINE_AI);
                        entries.add(ModBlocks.PLANT_POT);
                        entries.add(ModItems.REMOTE_CONTROL_RGB);
                    }).build());

    public static void registerItemGroups() {
        NhatJSFurnitureMod.LOGGER.info("Registering Item Groups for " + NhatJSFurnitureMod.MOD_ID);
    }
}
