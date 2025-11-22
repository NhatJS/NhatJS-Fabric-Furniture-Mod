package net.nhatjs.js_furniture_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.WOOD_CHAIR);
        addDrop(ModBlocks.WHITE_CHAIR);
        addDrop(ModBlocks.MODERN_CHAIR);
        addDrop(ModBlocks.SOFA);
        addDrop(ModBlocks.WOOD_LIGHT_TABLE);
        addDrop(ModBlocks.BLACK_TABLE);
        addDrop(ModBlocks.WHITE_TABLE);
        addDrop(ModBlocks.WOOD_COFFEE_TABLE);
        addDrop(ModBlocks.WHITE_COFFEE_TABLE);
        addDrop(ModBlocks.WOOD_DESK);
        addDrop(ModBlocks.WHITE_DESK);
        addDrop(ModBlocks.WOOD_STANDING_DESK);
        addDrop(ModBlocks.WOOD_STANDING_DESK_B);
        addDrop(ModBlocks.BLACK_STANDING_DESK);
        addDrop(ModBlocks.BLACK_STANDING_DESK_B);
        addDrop(ModBlocks.WHITE_STANDING_DESK);
        addDrop(ModBlocks.WHITE_STANDING_DESK_B);
        addDrop(ModBlocks.WOOD_3_DRAWER_DRESSER);
        addDrop(ModBlocks.WHITE_3_DRAWER_DRESSER);
        addDrop(ModBlocks.WOOD_LIGHT_TV_STAND);
        addDrop(ModBlocks.WHITE_TV_STAND);
        addDrop(ModBlocks.KITCHEN_CABINET_BOTTOM);
        addDrop(ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK);
        addDrop(ModBlocks.KITCHEN_CABINET_BOTTOM_2);
        addDrop(ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA);
        addDrop(ModBlocks.KITCHEN_CABINET_BOTTOM_B);
        addDrop(ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK);
        addDrop(ModBlocks.KITCHEN_CABINET_BOTTOM_B_2);
        addDrop(ModBlocks.KITCHEN_DRAWERS);
        addDrop(ModBlocks.KITCHEN_DRAWERS_B);
        addDrop(ModBlocks.KITCHEN_CABINET_TOP);
        addDrop(ModBlocks.KITCHEN_CABINET_TOP_B);
        addDrop(ModBlocks.WOOD_STRIPED_WALL);
        addDrop(ModBlocks.BLACK_MIRROR);
        addDrop(ModBlocks.VERTICAL_BLINDS);
        addDrop(ModBlocks.SOCKET);
        addDrop(ModBlocks.TV);
        addDrop(ModBlocks.FLOOR_STANDING_SPEAKER);
        addDrop(ModBlocks.MODERN_CLOCK);
        addDrop(ModBlocks.MODERN_LIGHT);
        addDrop(ModBlocks.LED_FLOOR_LAMP);
        addDrop(ModBlocks.LED_FLOOR_LAMP_RGB_OFF);
        addDrop(ModBlocks.LED_RGB_TRIANGLE_PANEL);
        addDrop(ModBlocks.STUDIO_LIGHT);
        addDrop(ModBlocks.MONITOR_SETUP);
        addDrop(ModBlocks.MONITOR);
        addDrop(ModBlocks.KEYBOARD);
        addDrop(ModBlocks.COMPUTER_MOUSE);
        addDrop(ModBlocks.PC);
        addDrop(ModBlocks.PC_RGB1_OFF);
        addDrop(ModBlocks.LAPTOP);
        addDrop(ModBlocks.PORTABLE_LAPTOP_STAND);
        addDrop(ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND);
        addDrop(ModBlocks.MIDI_STANDALONE_GROOVEBOX);
        addDrop(ModBlocks.MIDI_STANDALONE_GROOVEBOX_2);
        addDrop(ModBlocks.MIDI_STANDALONE_GROOVEBOX_3);
        addDrop(ModBlocks.COOKTOP);
        addDrop(ModBlocks.FRIDGE_A);
        addDrop(ModBlocks.FRIDGE_B);
        addDrop(ModBlocks.MODERN_BATHROOM_SINK_STORAGE);
        addDrop(ModBlocks.MODERN_BATHROOM_MIRROR_SHELF);
        addDrop(ModBlocks.SHOWER);
        addDrop(ModBlocks.WASHING_MACHINE_AI);
        addDrop(ModBlocks.PLANT_POT);
        addDrop(ModBlocks.BOOKS);

        addDrop(ModBlocks.PC_TOWER_GLASS);


        //1.0.2 update
        addDrop(ModBlocks.CEILING_FAN);
        addDrop(ModBlocks.BLACK_GAMING_CHAIR);
        addDrop(ModBlocks.WHITE_GAMING_CHAIR);
        //end

        //1.0.3 update
        addDrop(ModBlocks.TOILET);
        //end

        //1.0.4 update
        addDrop(ModBlocks.CEILING_FAN_B);
        addDrop(ModBlocks.BLACK_SOFA);
        addDrop(ModBlocks.MIDI_KEYBOARD_CONTROLLER);
        addDrop(ModBlocks.WOOD_MEDIUM_TV_STAND);
        addDrop(ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER);
        addDrop(ModBlocks.WOOD_MEDIUM_CHAIR);
        addDrop(ModBlocks.WOOD_MEDIUM_COFFEE_TABLE);
        addDrop(ModBlocks.WOOD_MEDIUM_DESK);
        addDrop(ModBlocks.WOOD_MEDIUM_STANDING_DESK);
        addDrop(ModBlocks.WOOD_MEDIUM_STANDING_DESK_B);
        addDrop(ModBlocks.WOOD_MEDIUM_STRIPED_WALL);
        addDrop(ModBlocks.WOOD_MEDIUM_TABLE);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP);
        addDrop(ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B);
        //end
    }
}
