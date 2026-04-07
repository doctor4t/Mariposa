/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTabOutput;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;

import java.util.function.Function;

public interface MariposaItems {
	Item SEQUOIA_DOOR = register("sequoia_door", properties -> new DoubleHighBlockItem(MariposaBlocks.SEQUOIA_DOOR, properties), new Item.Properties().useBlockDescriptionPrefix());
	Item SEQUOIA_SIGN = register("sequoia_sign", properties -> new SignItem(MariposaBlocks.SEQUOIA_SIGN, MariposaBlocks.SEQUOIA_WALL_SIGN, properties), new Item.Properties().useBlockDescriptionPrefix().stacksTo(16));
	Item SEQUOIA_HANGING_SIGN = register("sequoia_hanging_sign", properties -> new HangingSignItem(MariposaBlocks.SEQUOIA_HANGING_SIGN, MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN, properties), new Item.Properties().useBlockDescriptionPrefix().stacksTo(16));
	Item SEQUOIA_BOAT = register("sequoia_boat", properties -> new BoatItem(MariposaEntityTypes.SEQUOIA_BOAT, properties), new Item.Properties().stacksTo(1));
	Item SEQUOIA_CHEST_BOAT = register("sequoia_chest_boat", properties -> new BoatItem(MariposaEntityTypes.SEQUOIA_CHEST_BOAT, properties), new Item.Properties().stacksTo(1));

	static Item register(String name, Function<Item.Properties, Item> factory, Item.Properties properties) {
		ResourceKey<Item> key = ResourceKey.create(Registries.ITEM, Mariposa.id(name));
		Item item = factory.apply(properties.setId(key));
		if (item instanceof BlockItem blockItem) {
			blockItem.registerBlocks(Item.BY_BLOCK, item);
		}
		return Registry.register(BuiltInRegistries.ITEM, key, item);
	}

	static void initialize() {
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.BUILDING_BLOCKS).register(MariposaItems::addBuilding);
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.NATURAL_BLOCKS).register(MariposaItems::addNatural);
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(MariposaItems::addFunctional);
		CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(MariposaItems::addTools);
	}

	private static void addBuilding(FabricCreativeModeTabOutput output) {
		output.insertAfter(Blocks.CHERRY_BUTTON,
				MariposaBlocks.SEQUOIA_LOG,
				MariposaBlocks.SEQUOIA_WOOD,
				MariposaBlocks.STRIPPED_SEQUOIA_LOG,
				MariposaBlocks.STRIPPED_SEQUOIA_WOOD,
				MariposaBlocks.STACKED_SEQUOIA_LOGS,
				MariposaBlocks.SEQUOIA_PLANKS,
				MariposaBlocks.SEQUOIA_STAIRS,
				MariposaBlocks.SEQUOIA_SLAB,
				MariposaBlocks.SEQUOIA_FENCE,
				MariposaBlocks.SEQUOIA_FENCE_GATE,
				MariposaItems.SEQUOIA_DOOR,
				MariposaBlocks.SEQUOIA_TRAPDOOR,
				MariposaBlocks.SEQUOIA_PRESSURE_PLATE,
				MariposaBlocks.SEQUOIA_BUTTON);
	}

	private static void addNatural(FabricCreativeModeTabOutput output) {
		output.insertAfter(Blocks.CHERRY_LOG, MariposaBlocks.SEQUOIA_LOG);
		output.insertAfter(Blocks.CHERRY_LEAVES, MariposaBlocks.SEQUOIA_LEAVES);
		output.insertAfter(Blocks.CHERRY_SAPLING, MariposaBlocks.SEQUOIA_SAPLING);
	}

	private static void addFunctional(FabricCreativeModeTabOutput output) {
		output.insertAfter(Blocks.CHERRY_SHELF, MariposaBlocks.SEQUOIA_SHELF);
		output.insertAfter(Blocks.CHERRY_HANGING_SIGN, MariposaItems.SEQUOIA_SIGN, MariposaItems.SEQUOIA_HANGING_SIGN);
	}

	private static void addTools(FabricCreativeModeTabOutput output) {
		output.insertAfter(Items.CHERRY_CHEST_BOAT, SEQUOIA_BOAT, SEQUOIA_CHEST_BOAT);
	}
}
