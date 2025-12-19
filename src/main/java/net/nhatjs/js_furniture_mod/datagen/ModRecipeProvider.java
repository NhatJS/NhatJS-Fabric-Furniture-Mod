package net.nhatjs.js_furniture_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.nhatjs.js_furniture_mod.block.ModBlocks;
import net.nhatjs.js_furniture_mod.item.ModItems;

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
                Item lever = Items.LEVER;
                Block redstoneLamp = Blocks.REDSTONE_LAMP;
                Item redstoneComparator = Items.COMPARATOR;

                //furniture mod
                Block laptop = ModBlocks.LAPTOP;
                Block portableLaptopStand = ModBlocks.PORTABLE_LAPTOP_STAND;
                Block midiGroovebox = ModBlocks.MIDI_STANDALONE_GROOVEBOX;
                Block monitor = ModBlocks.MONITOR;
                Block keyboard = ModBlocks.KEYBOARD;
                Block computerMouse = ModBlocks.COMPUTER_MOUSE;
                Item computerFan = ModItems.COMPUTER_FAN;

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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_MIRROR)
                        .pattern("1")
                        .pattern("2")
                        .pattern("1")
                        .input('1', concreteBlack)
                        .input('2', glassPane)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(glassPane), conditionsFromItem(glassPane))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_SOFA, 2)
                        .pattern("111")
                        .pattern("111")
                        .input('1', woolBlack)
                        .criterion(hasItem(woolBlack), conditionsFromItem(woolBlack))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_STANDING_DESK)
                        .pattern("111")
                        .pattern("223")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', redstone)
                        .input('3', lever)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(lever), conditionsFromItem(lever))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_STANDING_DESK_B)
                        .pattern("111")
                        .pattern("223")
                        .pattern("4 4")
                        .input('1', concreteBlack)
                        .input('2', redstone)
                        .input('3', lever)
                        .input('4', concreteWhite)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(lever), conditionsFromItem(lever))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.BLACK_TABLE, 2)
                        .pattern("111")
                        .pattern("1 1")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.CEILING_FAN)
                        .pattern(" 2 ")
                        .pattern("111")
                        .input('1', concreteBlack)
                        .input('2', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.CEILING_FAN_B)
                        .pattern(" 2 ")
                        .pattern("111")
                        .input('1', concreteWhite)
                        .input('2', redstone)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.COMPUTER_MOUSE)
                        .pattern("2")
                        .pattern("1")
                        .input('1', concreteBlack)
                        .input('2', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KEYBOARD)
                        .pattern("121")
                        .pattern("111")
                        .input('1', concreteBlack)
                        .input('2', redstone)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_BOTTOM, 2)
                        .pattern("333")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', slabBirch)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(slabBirch), conditionsFromItem(slabBirch))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_BOTTOM_2, 2)
                        .pattern("131")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', ironIngot)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_BOTTOM_2_EXTRA, 2)
                        .pattern("111")
                        .pattern("131")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', ironIngot)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_BOTTOM_B, 2)
                        .pattern("333")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', concreteWhite)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_BOTTOM_B_2, 2)
                        .pattern("111")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_BOTTOM_B_WITH_SINK, 2)
                        .pattern("343")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', concreteWhite)
                        .input('4', bucket)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(bucket), conditionsFromItem(bucket))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_BOTTOM_WITH_SINK, 2)
                        .pattern("343")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', slabBirch)
                        .input('4', bucket)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(slabBirch), conditionsFromItem(slabBirch))
                        .criterion(hasItem(bucket), conditionsFromItem(bucket))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_TOP, 2)
                        .pattern("11")
                        .pattern("23")
                        .pattern("11")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', ironIngot)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_CABINET_TOP_B, 2)
                        .pattern("11")
                        .pattern("21")
                        .pattern("11")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_DRAWERS, 2)
                        .pattern("323")
                        .pattern("121")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', slabBirch)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(slabBirch), conditionsFromItem(slabBirch))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.KITCHEN_DRAWERS_B, 2)
                        .pattern("323")
                        .pattern("121")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .input('3', concreteWhite)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.MODERN_CHAIR, 4)
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
                        .input('2', keyboard)
                        .input('3', computerMouse)
                        .input('4', carpetBlack)
                        .criterion(hasItem(monitor), conditionsFromItem(monitor))
                        .criterion(hasItem(keyboard), conditionsFromItem(keyboard))
                        .criterion(hasItem(computerMouse), conditionsFromItem(computerMouse))
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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.SOFA, 2)
                        .pattern("111")
                        .pattern("111")
                        .input('1', woolWhite)
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.VERTICAL_BLINDS)
                        .pattern("111")
                        .pattern("222")
                        .pattern("222")
                        .input('1', concreteWhite)
                        .input('2', bannerWhite)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_3_DRAWER_DRESSER, 2)
                        .pattern("121")
                        .pattern("121")
                        .pattern("121")
                        .input('1', concreteWhite)
                        .input('2', chest)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_CHAIR, 4)
                        .pattern("2  ")
                        .pattern("122")
                        .pattern("1 1")
                        .input('1', concreteWhite)
                        .input('2', woolWhite)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_COFFEE_TABLE, 2)
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', concreteWhite)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_DESK, 2)
                        .pattern("121")
                        .pattern("1 1")
                        .pattern("1 1")
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

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_STANDING_DESK)
                        .pattern("222")
                        .pattern("334")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', concreteWhite)
                        .input('3', redstone)
                        .input('4', lever)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(lever), conditionsFromItem(lever))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_STANDING_DESK_B)
                        .pattern("222")
                        .pattern("334")
                        .pattern("2 2")
                        .input('2', concreteWhite)
                        .input('3', redstone)
                        .input('4', lever)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(lever), conditionsFromItem(lever))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_TABLE, 2)
                        .pattern("111")
                        .pattern("1 1")
                        .pattern("1 1")
                        .input('1', concreteWhite)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WHITE_TV_STAND)
                        .pattern("111")
                        .pattern("212")
                        .input('1', concreteWhite)
                        .input('2', chest)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_3_DRAWER_DRESSER, 2)
                        .pattern("121")
                        .pattern("121")
                        .pattern("121")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_CHAIR, 4)
                        .pattern("2  ")
                        .pattern("122")
                        .pattern("1 1")
                        .input('1', planksBirch)
                        .input('2', woolWhite)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_COFFEE_TABLE, 2)
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', planksBirch)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_DESK, 2)
                        .pattern("121")
                        .pattern("1 1")
                        .pattern("1 1")
                        .input('1', planksBirch)
                        .input('2', chest)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_TABLE, 2)
                        .pattern("222")
                        .pattern("1 1")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', planksBirch)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_LIGHT_TV_STAND, 2)
                        .pattern("211")
                        .pattern("1 1")
                        .input('1', planksBirch)
                        .input('2', concreteWhite)
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_3_DRAWER_DRESSER, 2)
                        .pattern("121")
                        .pattern("121")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_CHAIR, 4)
                        .pattern("2  ")
                        .pattern("122")
                        .pattern("1 1")
                        .input('1', planksJungle)
                        .input('2', woolWhite)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(woolWhite), conditionsFromItem(woolWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_COFFEE_TABLE, 2)
                        .pattern("111")
                        .pattern("1 1")
                        .input('1', planksJungle)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_DESK, 2)
                        .pattern("121")
                        .pattern("1 1")
                        .pattern("1 1")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM, 2)
                        .pattern("333")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', slabJungle)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(slabJungle), conditionsFromItem(slabJungle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2, 2)
                        .pattern("131")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', ironIngot)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_2_EXTRA, 2)
                        .pattern("111")
                        .pattern("131")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', ironIngot)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B, 2)
                        .pattern("333")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', concreteWhite)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_2, 2)
                        .pattern("111")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_B_WITH_SINK, 2)
                        .pattern("343")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', concreteWhite)
                        .input('4', bucket)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(bucket), conditionsFromItem(bucket))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_BOTTOM_WITH_SINK, 2)
                        .pattern("343")
                        .pattern("111")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', slabJungle)
                        .input('4', bucket)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(slabJungle), conditionsFromItem(slabJungle))
                        .criterion(hasItem(bucket), conditionsFromItem(bucket))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP, 2)
                        .pattern("11")
                        .pattern("23")
                        .pattern("11")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', ironIngot)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(ironIngot), conditionsFromItem(ironIngot))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_CABINET_TOP_B, 2)
                        .pattern("11")
                        .pattern("21")
                        .pattern("11")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS, 2)
                        .pattern("323")
                        .pattern("121")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', slabJungle)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(slabJungle), conditionsFromItem(slabJungle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_KITCHEN_DRAWERS_B, 2)
                        .pattern("323")
                        .pattern("121")
                        .pattern("121")
                        .input('1', planksJungle)
                        .input('2', chest)
                        .input('3', concreteWhite)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(chest), conditionsFromItem(chest))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_STANDING_DESK)
                        .pattern("222")
                        .pattern("334")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', planksJungle)
                        .input('3', redstone)
                        .input('4', lever)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(lever), conditionsFromItem(lever))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_STANDING_DESK_B)
                        .pattern("222")
                        .pattern("334")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', planksJungle)
                        .input('3', redstone)
                        .input('4', lever)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(lever), conditionsFromItem(lever))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_STRIPED_WALL, 4)
                        .pattern("111")
                        .pattern("111")
                        .pattern("111")
                        .input('1', planksJungle)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_TABLE, 2)
                        .pattern("222")
                        .pattern("1 1")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', planksJungle)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_MEDIUM_TV_STAND, 2)
                        .pattern("211")
                        .pattern("1 1")
                        .input('1', planksJungle)
                        .input('2', concreteWhite)
                        .criterion(hasItem(planksJungle), conditionsFromItem(planksJungle))
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_STANDING_DESK)
                        .pattern("222")
                        .pattern("334")
                        .pattern("1 1")
                        .input('1', concreteBlack)
                        .input('2', planksBirch)
                        .input('3', redstone)
                        .input('4', lever)
                        .criterion(hasItem(concreteBlack), conditionsFromItem(concreteBlack))
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(lever), conditionsFromItem(lever))
                        .offerTo(recipeExporter);

                createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOOD_STANDING_DESK_B)
                        .pattern("222")
                        .pattern("334")
                        .pattern("1 1")
                        .input('1', concreteWhite)
                        .input('2', planksBirch)
                        .input('3', redstone)
                        .input('4', lever)
                        .criterion(hasItem(concreteWhite), conditionsFromItem(concreteWhite))
                        .criterion(hasItem(planksBirch), conditionsFromItem(planksBirch))
                        .criterion(hasItem(redstone), conditionsFromItem(redstone))
                        .criterion(hasItem(lever), conditionsFromItem(lever))
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