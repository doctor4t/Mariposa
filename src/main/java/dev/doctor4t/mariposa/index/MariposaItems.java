package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

public interface MariposaItems {
    Item SEQUOIA_SIGN = create("sequoia_sign", settings -> new SignItem(MariposaBlocks.SEQUOIA_SIGN, MariposaBlocks.SEQUOIA_WALL_SIGN, settings), new Item.Settings().useBlockPrefixedTranslationKey().maxCount(16));
    Item SEQUOIA_HANGING_SIGN = create("sequoia_hanging_sign", settings -> new HangingSignItem(MariposaBlocks.SEQUOIA_HANGING_SIGN, MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN, settings), new Item.Settings().useBlockPrefixedTranslationKey().maxCount(16));
    Item SEQUOIA_DOOR = create("sequoia_door", settings -> new TallBlockItem(MariposaBlocks.SEQUOIA_DOOR, settings), new Item.Settings().useBlockPrefixedTranslationKey());

    static Item create(String name, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return Items.register(RegistryKey.of(RegistryKeys.ITEM, Mariposa.id(name)), factory, settings);
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
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_SAPLING, MariposaBlocks.SEQUOIA_SAPLING);
    }

    private static void addFunctionalEntries(FabricItemGroupEntries fabricItemGroupEntries) {
        fabricItemGroupEntries.addAfter(Blocks.CHERRY_HANGING_SIGN, MariposaItems.SEQUOIA_SIGN, MariposaItems.SEQUOIA_HANGING_SIGN);
    }
}
