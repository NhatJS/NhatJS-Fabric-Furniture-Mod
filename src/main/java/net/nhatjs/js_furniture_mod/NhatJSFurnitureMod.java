package net.nhatjs.js_furniture_mod;

import net.fabricmc.api.ModInitializer;

import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.core.ModBlockEntities;
import net.nhatjs.js_furniture_mod.core.ModEntities;
import net.nhatjs.js_furniture_mod.core.ModItemGroups;
import net.nhatjs.js_furniture_mod.core.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NhatJSFurnitureMod implements ModInitializer {
	public static final String MOD_ID = "js_furniture_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
        ModBlocks.registerModBlocks();
        ModBlockEntities.registerModBlockEntities();
        ModItems.registerModItems();
        ModItemGroups.registerItemGroups();
        ModEntities.registerModEntities();
        ModBlockEntities.registerModBlockEntities();
	}
}