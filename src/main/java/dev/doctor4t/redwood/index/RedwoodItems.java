package dev.doctor4t.redwood.index;

import dev.doctor4t.redwood.Redwood;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface RedwoodItems {
    Item SEQUOIA_SIGN = create("sequoia_sign", new SignItem(new Item.Settings().maxCount(16), RedwoodBlocks.SEQUOIA_SIGN, RedwoodBlocks.SEQUOIA_WALL_SIGN));
    Item SEQUOIA_HANGING_SIGN = create(
            "sequoia_hanging_sign", new HangingSignItem(RedwoodBlocks.SEQUOIA_HANGING_SIGN, RedwoodBlocks.SEQUOIA_WALL_HANGING_SIGN, new Item.Settings().maxCount(16))
    );
    Item SEQUOIA_DOOR = create("sequoia_door", new TallBlockItem(RedwoodBlocks.SEQUOIA_DOOR, new Item.Settings()));

    static <T extends Item> T create(String name, T item) {
        return Registry.register(Registries.ITEM, Redwood.id(name), item);
    }

    static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(RedwoodItems::addBuildingEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(RedwoodItems::addNaturalEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(RedwoodItems::addFunctionalEntries);
    }

    private static void addBuildingEntries(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_BUTTON,
                RedwoodBlocks.SEQUOIA_LOG,
                RedwoodBlocks.SEQUOIA_WOOD,
                RedwoodBlocks.STRIPPED_SEQUOIA_LOG,
                RedwoodBlocks.STRIPPED_SEQUOIA_WOOD,
                RedwoodBlocks.STACKED_SEQUOIA_LOGS,
                RedwoodBlocks.SEQUOIA_PLANKS,
                RedwoodBlocks.SEQUOIA_STAIRS,
                RedwoodBlocks.SEQUOIA_SLAB,
                RedwoodBlocks.SEQUOIA_FENCE,
                RedwoodBlocks.SEQUOIA_FENCE_GATE,
                RedwoodItems.SEQUOIA_DOOR,
                RedwoodBlocks.SEQUOIA_TRAPDOOR,
                RedwoodBlocks.SEQUOIA_PRESSURE_PLATE,
                RedwoodBlocks.SEQUOIA_BUTTON);
    }

    private static void addNaturalEntries(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_LOG, RedwoodBlocks.SEQUOIA_LOG);
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_LEAVES, RedwoodBlocks.SEQUOIA_LEAVES);
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_SAPLING, RedwoodBlocks.SEQUOIA_SAPLING);
    }

    private static void addFunctionalEntries(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_HANGING_SIGN, RedwoodItems.SEQUOIA_SIGN, RedwoodItems.SEQUOIA_HANGING_SIGN);
    }
}
