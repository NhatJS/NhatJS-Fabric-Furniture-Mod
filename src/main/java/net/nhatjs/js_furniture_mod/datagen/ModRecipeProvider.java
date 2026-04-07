package net.nhatjs.js_furniture_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.nhatjs.js_furniture_mod.core.ModBlocks;
import net.nhatjs.js_furniture_mod.core.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                //wood
                Item saplingOak = Items.OAK_SAPLING;
                Block planksBirch = Blocks.BIRCH_PLANKS;
                Block slabBirch = Blocks.BIRCH_SLAB;
                Block planksJungle = Blocks.JUNGLE_PLANKS;
                Block slabJungle = Blocks.JUNGLE_SLAB;

                //stone
                Block buttonStone = Blocks.STONE_BUTTON;

                //wool
                Block woolBlack = Blocks.BLACK_WOOL;
                Block carpetBlack = Blocks.BLACK_CARPET;
                Block woolWhite = Blocks.WHITE_WOOL;

                //banner
                Block bannerWhite = Blocks.WHITE_BANNER;
                Block bannerBlack = Blocks.BLACK_BANNER;

                //concrete
                Block concreteBlack = Blocks.BLACK_CONCRETE;
                Block concreteGray = Blocks.GRAY_CONCRETE;
                Block concreteLightGray = Blocks.LIGHT_GRAY_CONCRETE;
                Block concreteWhite = Blocks.WHITE_CONCRETE;

                //dye
                Item dyeBlack = Items.BLACK_DYE;
                Item dyeGreen = Items.GREEN_DYE;
                Item dyeWhite = Items.WHITE_DYE;

                //misc
                Item ironIngot = Items.IRON_INGOT;
                Block ironBlock = Blocks.IRON_BLOCK;

                //glass pane
                Block glassPane = Blocks.GLASS_PANE;

                //electronic
                Item redstone = Items.REDSTONE;
                Block redstoneLamp = Blocks.REDSTONE_LAMP;
                Item redstoneComparator = Items.COMPARATOR;

                //furniture mod
                Block laptop = ModBlocks.LAPTOP;
                Block portableLaptopStand = ModBlocks.PORTABLE_LAPTOP_STAND;
                Block midiGroovebox = ModBlocks.MIDI_STANDALONE_GROOVEBOX;
                Block monitor = ModBlocks.MONITOR;
                Block blackKeyboard = ModBlocks.BLACK_KEYBOARD;
                Block blackComputerMouse = ModBlocks.BLACK_COMPUTER_MOUSE;
                Item computerFan = ModItems.COMPUTER_FAN;
                Block woodLightDrawerSingle = ModBlocks.WOOD_LIGHT_DRAWER_SINGLE;
                Block woodLightCompartmentStorageCabinet = ModBlocks.WOOD_LIGHT_COMPARTMENT_STORAGE_CABINET;
                Block woodLightKitchenCompartmentStorageCabinet = ModBlocks.WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET;
                Block woodLightKitchenCompartmentStorageCabinetB = ModBlocks.WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET_B;
                Block woodLightKitchenCabinetBottom = ModBlocks.KITCHEN_CABINET_BOTTOM;
                Block woodLightKitchenCabinetBottomB = ModBlocks.KITCHEN_CABINET_BOTTOM_B;
                Item woodLightSquareStick = ModItems.WOOD_LIGHT_SQUARE_STICK;
                Item woodLightShortSquareStick = ModItems.WOOD_LIGHT_SHORT_SQUARE_STICK;
                Item woodLightPanel = ModItems.WOOD_LIGHT_PANEL;
                Block woodMediumDrawerSingle = ModBlocks.WOOD_MEDIUM_DRAWER_SINGLE;
                Block woodMediumCompartmentStorageCabinet = ModBlocks.WOOD_MEDIUM_COMPARTMENT_STORAGE_CABINET;
                Block woodMediumKitchenCompartmentStorageCabinet = ModBlocks.WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET;
                Block woodMediumKitchenCompartmentStorageCabinetB = ModBlocks.WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET_B;
                Block woodMediumKitchenCabinetBottom = ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM;
                Block woodMediumKitchenCabinetBottomB = ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B;
                Item woodMediumSquareStick = ModItems.WOOD_MEDIUM_SQUARE_STICK;
                Item woodMediumShortSquareStick = ModItems.WOOD_MEDIUM_SHORT_SQUARE_STICK;
                Item woodMediumPanel = ModItems.WOOD_MEDIUM_PANEL;
                Block blackDrawerSingle = ModBlocks.BLACK_DRAWER_SINGLE;
                Block blackCompartmentStorageCabinet = ModBlocks.BLACK_COMPARTMENT_STORAGE_CABINET;
                Item blackSquareStick = ModItems.BLACK_SQUARE_STICK;
                Item blackShortSquareStick = ModItems.BLACK_SHORT_SQUARE_STICK;
                Item blackPanel = ModItems.BLACK_PANEL;
                Block blackDeskColumn = ModBlocks.BLACK_DESK_COLUMN;
                Block whiteDrawerSingle = ModBlocks.WHITE_DRAWER_SINGLE;
                Block whiteCompartmentStorageCabinet = ModBlocks.WHITE_COMPARTMENT_STORAGE_CABINET;
                Item whiteSquareStick = ModItems.WHITE_SQUARE_STICK;
                Item whiteShortSquareStick = ModItems.WHITE_SHORT_SQUARE_STICK;
                Item whitePanel = ModItems.WHITE_PANEL;
                Block whiteDeskColumn = ModBlocks.WHITE_DESK_COLUMN;


                //others
                Item book = Items.BOOK;
                Block noteBlock = Blocks.NOTE_BLOCK;
                Item endCrystal = Items.END_CRYSTAL;
                Block chest = Blocks.CHEST;
                Item bucket = Items.BUCKET;
                Block flowerPot = Blocks.FLOWER_POT;
                Item clock = Items.CLOCK;

                createShaped(RecipeCategory.DECORATIONS, ModItems.AIO_COOLER)
                        .pattern("111")
                        .pattern("222")
                        .pattern("3  ")
                        .input('1', concreteBlack)
                        .input('2', computerFan)
                        .input('3', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(computerFan), conditionsFromItem(computerFan))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_3_DRAWER_DRESSER)
                        .pattern(" 2")
                        .pattern("12")
                        .pattern(" 2")
                        .input('1', blackCompartmentStorageCabinet)
                        .input('2', blackDrawerSingle)
                        .criterion(hasItem(blackCompartmentStorageCabinet), conditionsFromItem(blackCompartmentStorageCabinet))
                        .criterion(hasItem(blackDrawerSingle), conditionsFromItem(blackDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_CEILING_FAN_BLACK)
                        .pattern(" 1 ")
                        .pattern("121")
                        .input('1', blackSquareStick)
                        .input('2', blackShortSquareStick)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(blackShortSquareStick), conditionsFromItem(blackShortSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_CEILING_FAN_WHITE)
                        .pattern(" 3 ")
                        .pattern("121")
                        .input('1', blackSquareStick)
                        .input('2', whiteShortSquareStick)
                        .input('3', whiteSquareStick)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(whiteShortSquareStick), conditionsFromItem(whiteShortSquareStick))
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_CHAIR)
                        .pattern("1  ")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', blackSquareStick)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_COFFEE_TABLE)
                        .pattern("22")
                        .pattern("11")
                        .input('1', blackShortSquareStick)
                        .input('2', blackPanel)
                        .criterion(hasItem(blackShortSquareStick), conditionsFromItem(blackShortSquareStick))
                        .criterion(hasItem(blackPanel), conditionsFromItem(blackPanel))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.BLACK_COMPARTMENT_STORAGE_CABINET, blackPanel);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_COMPUTER_MOUSE)
                        .pattern("3")
                        .pattern("1")
                        .pattern("2")
                        .input('1', blackShortSquareStick)
                        .input('2', redstone)
                        .input('3', buttonStone)
                        .criterion(hasItem(blackShortSquareStick), conditionsFromItem(blackShortSquareStick))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_DESK)
                        .pattern("22")
                        .pattern("33")
                        .pattern("11")
                        .input('1', blackSquareStick)
                        .input('2', blackPanel)
                        .input('3', blackDrawerSingle)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(blackPanel), conditionsFromItem(blackPanel))
                        .criterion(hasItem(blackDrawerSingle), conditionsFromItem(blackDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_DESK_COLUMN)
                        .pattern(" 12")
                        .pattern(" 1 ")
                        .pattern("111")
                        .input('1', blackSquareStick)
                        .input('2', redstone)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_DRAWER_SINGLE, 3)
                        .pattern("121")
                        .input('1', concreteBlack)
                        .input('2', chest)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_GAMING_CHAIR)
                        .pattern("1  ")
                        .pattern("121")
                        .pattern("3 3")
                        .input('1', woolBlack)
                        .input('2', woolWhite)
                        .input('3', concreteBlack)
                        .criterion(hasItem(woolBlack), conditionsFromItem(woolBlack))
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_KEYBOARD)
                        .pattern("222")
                        .pattern("131")
                        .input('1', blackPanel)
                        .input('2', blackShortSquareStick)
                        .input('3', redstone)
                        .criterion(hasItem(blackPanel), conditionsFromItem(blackPanel))
                        .criterion(hasItem(blackShortSquareStick), conditionsFromItem(blackShortSquareStick))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_MIRROR)
                        .pattern("121")
                        .pattern("121")
                        .pattern("121")
                        .input('1', blackSquareStick)
                        .input('2', glassPane)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(glassPane), conditionsFromItem(glassPane))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.BLACK_PANEL)
                        .pattern("11")
                        .pattern("11")
                        .input('1', blackSquareStick)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_SOFA, 2)
                        .pattern("111")
                        .pattern("111")
                        .input('1', woolBlack)
                        .criterion(hasItem(woolBlack), conditionsFromItem(woolBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.BLACK_SHORT_SQUARE_STICK, 2)
                        .pattern("1")
                        .input('1', blackSquareStick)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.BLACK_SQUARE_STICK, 6)
                        .pattern("1")
                        .pattern("1")
                        .pattern("1")
                        .input('1', concreteBlack)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_STANDING_DESK)
                        .pattern("111")
                        .pattern("232")
                        .input('1', blackPanel)
                        .input('2', blackDeskColumn)
                        .input('3', blackSquareStick)
                        .criterion(hasItem(blackPanel), conditionsFromItem(blackPanel))
                        .criterion(hasItem(blackDeskColumn), conditionsFromItem(blackDeskColumn))
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_STANDING_DESK_B)
                        .pattern("111")
                        .pattern("232")
                        .input('1', blackPanel)
                        .input('2', whiteDeskColumn)
                        .input('3', whiteSquareStick)
                        .criterion(hasItem(blackPanel), conditionsFromItem(blackPanel))
                        .criterion(hasItem(whiteDeskColumn), conditionsFromItem(whiteDeskColumn))
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_TABLE)
                        .pattern("222")
                        .pattern("1 1")
                        .input('1', blackSquareStick)
                        .input('2', blackPanel)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(blackPanel), conditionsFromItem(blackPanel))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_TV_STAND)
                        .pattern(" 11")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', blackPanel)
                        .criterion(hasItem(blackPanel), conditionsFromItem(blackPanel))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_VERTICAL_BLINDS)
                        .pattern("111")
                        .pattern("222")
                        .pattern("222")
                        .input('1', blackSquareStick)
                        .input('2', bannerBlack)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(bannerBlack), conditionsFromItem(bannerBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BOOKS, 2)
                        .pattern("232")
                        .pattern("111")
                        .pattern("232")
                        .input('1', book)
                        .input('2', dyeWhite)
                        .input('3', dyeBlack)
                        .criterion(hasItem(book), conditionsFromItem(book))
                        .criterion(hasItem(dyeWhite), conditionsFromItem(dyeWhite))
                        .criterion(hasItem(dyeBlack), conditionsFromItem(dyeBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.COMPUTER_CASE)
                        .pattern("212")
                        .pattern("112")
                        .pattern("112")
                        .input('1', concreteBlack)
                        .input('2', computerFan)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(computerFan), conditionsFromItem(computerFan))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.COMPUTER_FAN, 3)
                        .pattern("121")
                        .pattern("212")
                        .pattern("121")
                        .input('1', concreteBlack)
                        .input('2', concreteWhite)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.COOKTOP)
                        .pattern("121")
                        .input('1', concreteBlack)
                        .input('2', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.CPU)
                        .pattern(" 2 ")
                        .pattern("212")
                        .pattern(" 2 ")
                        .input('1', endCrystal)
                        .input('2', dyeGreen)
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(dyeGreen), conditionsFromItem(dyeGreen))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.FLOOR_STANDING_SPEAKER)
                        .pattern("2")
                        .pattern("1")
                        .pattern("1")
                        .input('1', concreteBlack)
                        .input('2', noteBlock)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(noteBlock), conditionsFromItem(noteBlock))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.FRIDGE_A)
                        .pattern("414")
                        .pattern("232")
                        .pattern("414")
                        .input('1', concreteBlack)
                        .input('2', ironBlock)
                        .input('3', endCrystal)
                        .input('4', concreteGray)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(ironBlock), conditionsFromItem(ironBlock))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(concreteGray), conditionsFromItem(concreteGray))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.FRIDGE_B)
                        .pattern("414")
                        .pattern("232")
                        .pattern("414")
                        .input('1', concreteBlack)
                        .input('2', ironBlock)
                        .input('3', endCrystal)
                        .input('4', concreteWhite)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(ironBlock), conditionsFromItem(ironBlock))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.GPU)
                        .pattern("111")
                        .pattern("333")
                        .pattern("121")
                        .input('1', concreteLightGray)
                        .input('2', endCrystal)
                        .input('3', computerFan)
                        .criterion(hasItem(concreteLightGray), conditionsFromItem(concreteLightGray))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(computerFan), conditionsFromItem(computerFan))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.MAINBOARD)
                        .pattern("111")
                        .pattern("121")
                        .pattern("111")
                        .input('1', concreteGray)
                        .input('2', endCrystal)
                        .criterion(hasItem(concreteGray), conditionsFromItem(concreteGray))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.LAPTOP)
                        .pattern("111")
                        .pattern("523")
                        .pattern("141")
                        .input('1', concreteBlack)
                        .input('2', endCrystal)
                        .input('3', buttonStone)
                        .input('4', redstone)
                        .input('5', noteBlock)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(noteBlock), conditionsFromItem(noteBlock))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.LAPTOP_CLOSED_PORTABLE_LAPTOP_STAND)
                        .pattern("1")
                        .pattern("2")
                        .input('1', laptop)
                        .input('2', portableLaptopStand)
                        .criterion(hasItem(laptop), conditionsFromItem(laptop))
                        .criterion(hasItem(portableLaptopStand), conditionsFromItem(portableLaptopStand))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.LED_FLOOR_LAMP, 2)
                        .pattern(" 1 ")
                        .pattern(" 2 ")
                        .pattern("111")
                        .input('1', concreteBlack)
                        .input('2', redstoneLamp)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstoneLamp), conditionsFromItem(redstoneLamp))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.LED_FLOOR_LAMP_RGB_OFF, 2)
                        .pattern(" 1")
                        .pattern(" 2")
                        .pattern("11")
                        .input('1', concreteBlack)
                        .input('2', redstoneLamp)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstoneLamp), conditionsFromItem(redstoneLamp))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.LED_RGB_TRIANGLE_PANEL)
                        .pattern("12 ")
                        .pattern("131")
                        .pattern(" 21")
                        .input('1', concreteBlack)
                        .input('2', redstoneLamp)
                        .input('3', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstoneLamp), conditionsFromItem(redstoneLamp))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MIDI_KEYBOARD_CONTROLLER)
                        .pattern("111")
                        .pattern("244")
                        .pattern("311")
                        .input('1', concreteBlack)
                        .input('2', buttonStone)
                        .input('3', endCrystal)
                        .input('4', concreteWhite)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MIDI_STANDALONE_GROOVEBOX)
                        .pattern("111")
                        .pattern("132")
                        .pattern("222")
                        .input('1', concreteBlack)
                        .input('2', buttonStone)
                        .input('3', endCrystal)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MIDI_STANDALONE_GROOVEBOX_2)
                        .pattern("424")
                        .pattern("232")
                        .pattern("121")
                        .input('1', concreteBlack)
                        .input('2', buttonStone)
                        .input('3', endCrystal)
                        .input('4', concreteWhite)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(buttonStone), conditionsFromItem(buttonStone))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MIDI_STANDALONE_GROOVEBOX_3)
                        .pattern("11")
                        .input('1', midiGroovebox)
                        .criterion(hasItem(midiGroovebox), conditionsFromItem(midiGroovebox))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MODERN_BATHROOM_MIRROR_SHELF)
                        .pattern("121")
                        .pattern("111")
                        .input('1', concreteBlack)
                        .input('2', glassPane)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(glassPane), conditionsFromItem(glassPane))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MODERN_BATHROOM_SINK_STORAGE)
                        .pattern(" 2 ")
                        .pattern("111")
                        .pattern("222")
                        .input('1', concreteWhite)
                        .input('2', concreteBlack)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MODERN_CHAIR, 2)
                        .pattern("2  ")
                        .pattern("121")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', woolWhite)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MODERN_CLOCK)
                        .pattern(" 1 ")
                        .pattern("121")
                        .pattern(" 1 ")
                        .input('1', concreteBlack)
                        .input('2', clock)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(clock), conditionsFromItem(clock))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MODERN_LIGHT, 4)
                        .pattern("121")
                        .input('1', concreteBlack)
                        .input('2', redstoneLamp)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstoneLamp), conditionsFromItem(redstoneLamp))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MONITOR)
                        .pattern("121")
                        .pattern(" 3 ")
                        .pattern(" 1 ")
                        .input('1', concreteBlack)
                        .input('2', glassPane)
                        .input('3', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(glassPane), conditionsFromItem(glassPane))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MONITOR_SETUP)
                        .pattern("14")
                        .pattern("23")
                        .input('1', monitor)
                        .input('2', blackKeyboard)
                        .input('3', blackComputerMouse)
                        .input('4', carpetBlack)
                        .criterion(hasItem(monitor), conditionsFromItem(monitor))
                        .criterion(hasItem(blackKeyboard), conditionsFromItem(blackKeyboard))
                        .criterion(hasItem(blackComputerMouse), conditionsFromItem(blackComputerMouse))
                        .criterion(hasItem(carpetBlack), conditionsFromItem(carpetBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.PC_TOWER_GLASS)
                        .pattern("21")
                        .pattern("21")
                        .input('1', concreteBlack)
                        .input('2', glassPane)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(glassPane), conditionsFromItem(glassPane))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.PLANT_POT)
                        .pattern(" 3 ")
                        .pattern("121")
                        .input('1', ironIngot)
                        .input('2', flowerPot)
                        .input('3', saplingOak)
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .criterion(hasItem(flowerPot), conditionsFromItem(flowerPot))
                        .criterion(hasItem(saplingOak), conditionsFromItem(saplingOak))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.PORTABLE_LAPTOP_STAND)
                        .pattern("1 1")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', ironIngot)
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.PSU)
                        .pattern("111")
                        .pattern("321")
                        .input('1', concreteBlack)
                        .input('2', endCrystal)
                        .input('3', redstoneComparator)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(redstoneComparator), conditionsFromItem(redstoneComparator))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.RAM, 2)
                        .pattern("211")
                        .pattern("333")
                        .input('1', concreteBlack)
                        .input('2', ironIngot)
                        .input('3', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.SHOWER)
                        .pattern("21")
                        .input('1', dyeBlack)
                        .input('2', ironIngot)
                        .criterion(hasItem(dyeBlack), conditionsFromItem(dyeBlack))
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.SOCKET, 4)
                        .pattern("1")
                        .pattern("2")
                        .pattern("1")
                        .input('1', concreteWhite)
                        .input('2', redstone)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.STUDIO_LIGHT, 2)
                        .pattern("121")
                        .pattern(" 1 ")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', redstoneLamp)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstoneLamp), conditionsFromItem(redstoneLamp))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TOILET)
                        .pattern("1  ")
                        .pattern("111")
                        .pattern("11 ")
                        .input('1', concreteWhite)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.TV)
                        .pattern("121")
                        .pattern("131")
                        .input('1', concreteBlack)
                        .input('2', endCrystal)
                        .input('3', dyeWhite)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .criterion(hasItem(dyeWhite), conditionsFromItem(dyeWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_VERTICAL_BLINDS)
                        .pattern("111")
                        .pattern("222")
                        .pattern("222")
                        .input('1', whiteSquareStick)
                        .input('2', bannerWhite)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .criterion(hasItem(bannerWhite), conditionsFromItem(bannerWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WASHING_MACHINE_AI)
                        .pattern("121")
                        .pattern("1 1")
                        .pattern("131")
                        .input('1', concreteGray)
                        .input('2', redstone)
                        .input('3', endCrystal)
                        .criterion(hasItem(concreteGray), conditionsFromItem(concreteGray))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(endCrystal), conditionsFromItem(endCrystal))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_3_DRAWER_DRESSER)
                        .pattern(" 2")
                        .pattern("12")
                        .pattern(" 2")
                        .input('1', whiteCompartmentStorageCabinet)
                        .input('2', whiteDrawerSingle)
                        .criterion(hasItem(whiteCompartmentStorageCabinet), conditionsFromItem(whiteCompartmentStorageCabinet))
                        .criterion(hasItem(whiteDrawerSingle), conditionsFromItem(whiteDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_CEILING_FAN_BLACK)
                        .pattern(" 1 ")
                        .pattern("121")
                        .input('1', whiteSquareStick)
                        .input('2', whiteShortSquareStick)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .criterion(hasItem(whiteShortSquareStick), conditionsFromItem(whiteShortSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_CEILING_FAN_WHITE)
                        .pattern(" 3 ")
                        .pattern("121")
                        .input('1', whiteSquareStick)
                        .input('2', blackShortSquareStick)
                        .input('3', blackSquareStick)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .criterion(hasItem(blackShortSquareStick), conditionsFromItem(blackShortSquareStick))
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_CHAIR)
                        .pattern("1  ")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', whiteSquareStick)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_COFFEE_TABLE)
                        .pattern("22")
                        .pattern("11")
                        .input('1', whiteShortSquareStick)
                        .input('2', whitePanel)
                        .criterion(hasItem(whiteShortSquareStick), conditionsFromItem(whiteShortSquareStick))
                        .criterion(hasItem(whitePanel), conditionsFromItem(whitePanel))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WHITE_COMPARTMENT_STORAGE_CABINET, whitePanel);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_DESK)
                        .pattern("22")
                        .pattern("33")
                        .pattern("11")
                        .input('1', whiteSquareStick)
                        .input('2', whitePanel)
                        .input('3', whiteDrawerSingle)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .criterion(hasItem(whitePanel), conditionsFromItem(whitePanel))
                        .criterion(hasItem(whiteDrawerSingle), conditionsFromItem(whiteDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_DESK_COLUMN)
                        .pattern(" 12")
                        .pattern(" 1 ")
                        .pattern("111")
                        .input('1', whiteSquareStick)
                        .input('2', redstone)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_DRAWER_SINGLE, 3)
                        .pattern("121")
                        .input('1', concreteWhite)
                        .input('2', chest)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_GAMING_CHAIR)
                        .pattern("1  ")
                        .pattern("121")
                        .pattern("3 3")
                        .input('1', woolWhite)
                        .input('2', woolBlack)
                        .input('3', concreteBlack)
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
                        .criterion(hasItem(woolBlack), conditionsFromItem(woolBlack))
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WHITE_PANEL)
                        .pattern("11")
                        .pattern("11")
                        .input('1', whiteSquareStick)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WHITE_SHORT_SQUARE_STICK, 2)
                        .pattern("1")
                        .input('1', whiteSquareStick)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_SOFA, 2)
                        .pattern("111")
                        .pattern("111")
                        .input('1', woolWhite)
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WHITE_SQUARE_STICK, 6)
                        .pattern("1")
                        .pattern("1")
                        .pattern("1")
                        .input('1', concreteWhite)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_STANDING_DESK)
                        .pattern("111")
                        .pattern("232")
                        .input('1', whitePanel)
                        .input('2', blackDeskColumn)
                        .input('3', blackSquareStick)
                        .criterion(hasItem(whitePanel), conditionsFromItem(whitePanel))
                        .criterion(hasItem(blackDeskColumn), conditionsFromItem(blackDeskColumn))
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_STANDING_DESK_B)
                        .pattern("111")
                        .pattern("232")
                        .input('1', whitePanel)
                        .input('2', whiteDeskColumn)
                        .input('3', whiteSquareStick)
                        .criterion(hasItem(whitePanel), conditionsFromItem(whitePanel))
                        .criterion(hasItem(whiteDeskColumn), conditionsFromItem(whiteDeskColumn))
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_TABLE)
                        .pattern("222")
                        .pattern("1 1")
                        .input('1', whiteSquareStick)
                        .input('2', whitePanel)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .criterion(hasItem(whitePanel), conditionsFromItem(whitePanel))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_TV_STAND)
                        .pattern(" 11")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', whitePanel)
                        .criterion(hasItem(whitePanel), conditionsFromItem(whitePanel))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_3_DRAWER_DRESSER)
                        .pattern(" 2")
                        .pattern("12")
                        .pattern(" 2")
                        .input('1', woodLightCompartmentStorageCabinet)
                        .input('2', woodLightDrawerSingle)
                        .criterion(hasItem(woodLightCompartmentStorageCabinet), conditionsFromItem(woodLightCompartmentStorageCabinet))
                        .criterion(hasItem(woodLightDrawerSingle), conditionsFromItem(woodLightDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_CEILING_FAN_BLACK)
                        .pattern(" 1 ")
                        .pattern("323")
                        .input('1', blackSquareStick)
                        .input('2', blackShortSquareStick)
                        .input('3', woodLightSquareStick)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(blackShortSquareStick), conditionsFromItem(blackShortSquareStick))
                        .criterion(hasItem(woodLightSquareStick), conditionsFromItem(woodLightSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_CEILING_FAN_WHITE)
                        .pattern(" 1 ")
                        .pattern("323")
                        .input('1', whiteSquareStick)
                        .input('2', whiteShortSquareStick)
                        .input('3', woodLightSquareStick)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .criterion(hasItem(whiteShortSquareStick), conditionsFromItem(whiteShortSquareStick))
                        .criterion(hasItem(woodLightSquareStick), conditionsFromItem(woodLightSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_CHAIR)
                        .pattern("1  ")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', woodLightSquareStick)
                        .criterion(hasItem(woodLightSquareStick), conditionsFromItem(woodLightSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_COFFEE_TABLE)
                        .pattern("22")
                        .pattern("11")
                        .input('1', woodLightShortSquareStick)
                        .input('2', woodLightPanel)
                        .criterion(hasItem(woodLightShortSquareStick), conditionsFromItem(woodLightShortSquareStick))
                        .criterion(hasItem(woodLightPanel), conditionsFromItem(woodLightPanel))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_COMPARTMENT_STORAGE_CABINET, woodLightPanel);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_DRAWER_SINGLE, 3)
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_DESK)
                        .pattern("22")
                        .pattern("33")
                        .pattern("11")
                        .input('1', woodLightSquareStick)
                        .input('2', woodLightPanel)
                        .input('3', woodLightDrawerSingle)
                        .criterion(hasItem(woodLightSquareStick), conditionsFromItem(woodLightSquareStick))
                        .criterion(hasItem(woodLightPanel), conditionsFromItem(woodLightPanel))
                        .criterion(hasItem(woodLightDrawerSingle), conditionsFromItem(woodLightDrawerSingle))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM, woodLightPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2, woodLightPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_2_EXTRA, woodLightPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B, woodLightPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_2, woodLightPanel);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_B_WITH_SINK)
                        .pattern("2")
                        .pattern("1")
                        .input('1', woodLightKitchenCabinetBottomB)
                        .input('2', bucket)
                        .criterion(hasItem(woodLightKitchenCabinetBottomB), conditionsFromItem(woodLightKitchenCabinetBottomB))
                        .criterion(hasItem(bucket), conditionsFromItem(bucket))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_BOTTOM_WITH_SINK)
                        .pattern("2")
                        .pattern("1")
                        .input('1', woodLightKitchenCabinetBottom)
                        .input('2', bucket)
                        .criterion(hasItem(woodLightKitchenCabinetBottom), conditionsFromItem(woodLightKitchenCabinetBottom))
                        .criterion(hasItem(bucket), conditionsFromItem(bucket))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_TOP, woodLightPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_CABINET_TOP_B, woodLightPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET, woodLightPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_COMPARTMENT_STORAGE_CABINET_B, woodLightPanel);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_DRAWERS)
                        .pattern(" 2")
                        .pattern("12")
                        .pattern(" 2")
                        .input('1', woodLightKitchenCompartmentStorageCabinet)
                        .input('2', woodLightDrawerSingle)
                        .criterion(hasItem(woodLightKitchenCompartmentStorageCabinet), conditionsFromItem(woodLightKitchenCompartmentStorageCabinet))
                        .criterion(hasItem(woodLightDrawerSingle), conditionsFromItem(woodLightDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_KITCHEN_DRAWERS_B)
                        .pattern(" 2")
                        .pattern("12")
                        .pattern(" 2")
                        .input('1', woodLightKitchenCompartmentStorageCabinetB)
                        .input('2', woodLightDrawerSingle)
                        .criterion(hasItem(woodLightKitchenCompartmentStorageCabinetB), conditionsFromItem(woodLightKitchenCompartmentStorageCabinetB))
                        .criterion(hasItem(woodLightDrawerSingle), conditionsFromItem(woodLightDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WOOD_LIGHT_PANEL)
                        .pattern("11")
                        .pattern("11")
                        .input('1', woodLightSquareStick)
                        .criterion(hasItem(woodLightSquareStick), conditionsFromItem(woodLightSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WOOD_LIGHT_SHORT_SQUARE_STICK, 2)
                        .pattern("1")
                        .input('1', woodLightSquareStick)
                        .criterion(hasItem(woodLightSquareStick), conditionsFromItem(woodLightSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WOOD_LIGHT_SQUARE_STICK, 6)
                        .pattern("1")
                        .pattern("1")
                        .pattern("1")
                        .input('1', planksBirch)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_STANDING_DESK)
                        .pattern("111")
                        .pattern("232")
                        .input('1', woodLightPanel)
                        .input('2', blackDeskColumn)
                        .input('3', blackSquareStick)
                        .criterion(hasItem(woodLightPanel), conditionsFromItem(woodLightPanel))
                        .criterion(hasItem(blackDeskColumn), conditionsFromItem(blackDeskColumn))
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_STANDING_DESK_B)
                        .pattern("111")
                        .pattern("232")
                        .input('1', woodLightPanel)
                        .input('2', whiteDeskColumn)
                        .input('3', whiteSquareStick)
                        .criterion(hasItem(woodLightPanel), conditionsFromItem(woodLightPanel))
                        .criterion(hasItem(whiteDeskColumn), conditionsFromItem(whiteDeskColumn))
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_TABLE)
                        .pattern("222")
                        .pattern("1 1")
                        .input('1', woodLightSquareStick)
                        .input('2', woodLightPanel)
                        .criterion(hasItem(woodLightSquareStick), conditionsFromItem(woodLightSquareStick))
                        .criterion(hasItem(woodLightPanel), conditionsFromItem(woodLightPanel))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_TV_STAND)
                        .pattern(" 11")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', woodLightPanel)
                        .criterion(hasItem(woodLightPanel), conditionsFromItem(woodLightPanel))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER)
                        .pattern(" 2")
                        .pattern("12")
                        .pattern(" 2")
                        .input('1', woodMediumCompartmentStorageCabinet)
                        .input('2', woodMediumDrawerSingle)
                        .criterion(hasItem(woodMediumCompartmentStorageCabinet), conditionsFromItem(woodMediumCompartmentStorageCabinet))
                        .criterion(hasItem(woodMediumDrawerSingle), conditionsFromItem(woodMediumDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_CEILING_FAN_BLACK)
                        .pattern(" 1 ")
                        .pattern("323")
                        .input('1', blackSquareStick)
                        .input('2', blackShortSquareStick)
                        .input('3', woodMediumSquareStick)
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .criterion(hasItem(blackShortSquareStick), conditionsFromItem(blackShortSquareStick))
                        .criterion(hasItem(woodMediumSquareStick), conditionsFromItem(woodMediumSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_CEILING_FAN_WHITE)
                        .pattern(" 1 ")
                        .pattern("323")
                        .input('1', whiteSquareStick)
                        .input('2', whiteShortSquareStick)
                        .input('3', woodMediumSquareStick)
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .criterion(hasItem(whiteShortSquareStick), conditionsFromItem(whiteShortSquareStick))
                        .criterion(hasItem(woodMediumSquareStick), conditionsFromItem(woodMediumSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_CHAIR)
                        .pattern("1  ")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', woodMediumSquareStick)
                        .criterion(hasItem(woodMediumSquareStick), conditionsFromItem(woodMediumSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_COFFEE_TABLE)
                        .pattern("22")
                        .pattern("11")
                        .input('1', woodMediumShortSquareStick)
                        .input('2', woodMediumPanel)
                        .criterion(hasItem(woodMediumShortSquareStick), conditionsFromItem(woodMediumShortSquareStick))
                        .criterion(hasItem(woodMediumPanel), conditionsFromItem(woodMediumPanel))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_COMPARTMENT_STORAGE_CABINET, woodMediumPanel);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_DESK)
                        .pattern("22")
                        .pattern("33")
                        .pattern("11")
                        .input('1', woodMediumSquareStick)
                        .input('2', woodMediumPanel)
                        .input('3', woodMediumDrawerSingle)
                        .criterion(hasItem(woodMediumSquareStick), conditionsFromItem(woodMediumSquareStick))
                        .criterion(hasItem(woodMediumPanel), conditionsFromItem(woodMediumPanel))
                        .criterion(hasItem(woodMediumDrawerSingle), conditionsFromItem(woodMediumDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_DRAWER_SINGLE, 3)
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM, woodMediumPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2, woodMediumPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA, woodMediumPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B, woodMediumPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2, woodMediumPanel);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK)
                        .pattern("2")
                        .pattern("1")
                        .input('1', woodMediumKitchenCabinetBottomB)
                        .input('2', bucket)
                        .criterion(hasItem(woodMediumKitchenCabinetBottomB), conditionsFromItem(woodMediumKitchenCabinetBottomB))
                        .criterion(hasItem(bucket), conditionsFromItem(bucket))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK)
                        .pattern("2")
                        .pattern("1")
                        .input('1', woodMediumKitchenCabinetBottom)
                        .input('2', bucket)
                        .criterion(hasItem(woodMediumKitchenCabinetBottom), conditionsFromItem(woodMediumKitchenCabinetBottom))
                        .criterion(hasItem(bucket), conditionsFromItem(bucket))
                        .offerTo(recipeExporter);

                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP, woodMediumPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B, woodMediumPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET, woodMediumPanel);
                offerStonecuttingRecipe(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_COMPARTMENT_STORAGE_CABINET_B, woodMediumPanel);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS)
                        .pattern(" 2")
                        .pattern("12")
                        .pattern(" 2")
                        .input('1', woodMediumKitchenCompartmentStorageCabinet)
                        .input('2', woodMediumDrawerSingle)
                        .criterion(hasItem(woodMediumKitchenCompartmentStorageCabinet), conditionsFromItem(woodMediumKitchenCompartmentStorageCabinet))
                        .criterion(hasItem(woodMediumDrawerSingle), conditionsFromItem(woodMediumDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B)
                        .pattern(" 2")
                        .pattern("12")
                        .pattern(" 2")
                        .input('1', woodMediumKitchenCompartmentStorageCabinetB)
                        .input('2', woodMediumDrawerSingle)
                        .criterion(hasItem(woodMediumKitchenCompartmentStorageCabinetB), conditionsFromItem(woodMediumKitchenCompartmentStorageCabinetB))
                        .criterion(hasItem(woodMediumDrawerSingle), conditionsFromItem(woodMediumDrawerSingle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WOOD_MEDIUM_PANEL)
                        .pattern("11")
                        .pattern("11")
                        .input('1', woodMediumSquareStick)
                        .criterion(hasItem(woodMediumSquareStick), conditionsFromItem(woodMediumSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WOOD_MEDIUM_SHORT_SQUARE_STICK, 2)
                        .pattern("1")
                        .input('1', woodMediumSquareStick)
                        .criterion(hasItem(woodMediumSquareStick), conditionsFromItem(woodMediumSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModItems.WOOD_MEDIUM_SQUARE_STICK, 6)
                        .pattern("1")
                        .pattern("1")
                        .pattern("1")
                        .input('1', planksJungle)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_STANDING_DESK)
                        .pattern("111")
                        .pattern("232")
                        .input('1', woodMediumPanel)
                        .input('2', blackDeskColumn)
                        .input('3', blackSquareStick)
                        .criterion(hasItem(woodMediumPanel), conditionsFromItem(woodMediumPanel))
                        .criterion(hasItem(blackDeskColumn), conditionsFromItem(blackDeskColumn))
                        .criterion(hasItem(blackSquareStick), conditionsFromItem(blackSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_STANDING_DESK_B)
                        .pattern("111")
                        .pattern("232")
                        .input('1', woodMediumPanel)
                        .input('2', whiteDeskColumn)
                        .input('3', whiteSquareStick)
                        .criterion(hasItem(woodMediumPanel), conditionsFromItem(woodMediumPanel))
                        .criterion(hasItem(whiteDeskColumn), conditionsFromItem(whiteDeskColumn))
                        .criterion(hasItem(whiteSquareStick), conditionsFromItem(whiteSquareStick))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_STRIPED_WALL, 4)
                        .pattern("111")
                        .pattern("111")
                        .pattern("111")
                        .input('1', planksJungle)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_TABLE)
                        .pattern("222")
                        .pattern("1 1")
                        .input('1', woodMediumSquareStick)
                        .input('2', woodMediumPanel)
                        .criterion(hasItem(woodMediumSquareStick), conditionsFromItem(woodMediumSquareStick))
                        .criterion(hasItem(woodMediumPanel), conditionsFromItem(woodMediumPanel))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_TV_STAND)
                        .pattern(" 11")
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', woodMediumPanel)
                        .criterion(hasItem(woodMediumPanel), conditionsFromItem(woodMediumPanel))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_STRIPED_WALL, 4)
                        .pattern("111")
                        .pattern("111")
                        .pattern("111")
                        .input('1', planksBirch)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .offerTo(recipeExporter);
            }
        };
    }

    @Override
    public String getName() {
        return "NhatJSFurnitureMod Recipes";
    }
}
