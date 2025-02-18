package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public interface MariposaItems {
    Item SEQUOIA_SIGN = create("sequoia_sign", new SignItem(new Item.Settings().maxCount(16), MariposaBlocks.SEQUOIA_SIGN, MariposaBlocks.SEQUOIA_WALL_SIGN));
    Item SEQUOIA_HANGING_SIGN = create(
            "sequoia_hanging_sign", new HangingSignItem(MariposaBlocks.SEQUOIA_HANGING_SIGN, MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN, new Item.Settings().maxCount(16))
    );
    Item SEQUOIA_DOOR = create("sequoia_door", new TallBlockItem(MariposaBlocks.SEQUOIA_DOOR, new Item.Settings()));

    static <T extends Item> T create(String name, T item) {
        return Registry.register(Registries.ITEM, Mariposa.id(name), item);
    }

    static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(MariposaItems::addBuildingEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(MariposaItems::addNaturalEntries);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(MariposaItems::addFunctionalEntries);
    }

    private static void addBuildingEntries(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_BUTTON,
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

    private static void addNaturalEntries(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_LOG, MariposaBlocks.SEQUOIA_LOG);
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_LEAVES, MariposaBlocks.SEQUOIA_LEAVES);
//        fabricItemGroupEntries.addAfter(Blocks.CHERRY_SAPLING, MariposaBlocks.SEQUOIA_SAPLING);
    }

    private static void addFunctionalEntries(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_HANGING_SIGN, MariposaItems.SEQUOIA_SIGN, MariposaItems.SEQUOIA_HANGING_SIGN);
    }
}
