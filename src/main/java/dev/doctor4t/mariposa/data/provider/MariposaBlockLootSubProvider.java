package dev.doctor4t.mariposa.data.provider;

import dev.doctor4t.mariposa.common.init.MariposaBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class MariposaBlockLootSubProvider extends FabricBlockLootSubProvider {
	public MariposaBlockLootSubProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	public void generate() {
		dropSelf(MariposaBlocks.SEQUOIA_SAPLING);
		dropPottedContents(MariposaBlocks.POTTED_SEQUOIA_SAPLING);
		dropSelf(MariposaBlocks.SEQUOIA_LOG);
		dropSelf(MariposaBlocks.SEQUOIA_WOOD);
		dropSelf(MariposaBlocks.STRIPPED_SEQUOIA_LOG);
		dropSelf(MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
		dropSelf(MariposaBlocks.STACKED_SEQUOIA_LOGS);
		add(MariposaBlocks.SEQUOIA_LEAVES, block -> createLeavesDrops(block, MariposaBlocks.SEQUOIA_SAPLING, NORMAL_LEAVES_SAPLING_CHANCES));
		dropSelf(MariposaBlocks.SEQUOIA_PLANKS);
		dropSelf(MariposaBlocks.SEQUOIA_STAIRS);
		add(MariposaBlocks.SEQUOIA_SLAB, this::createSlabItemTable);
		dropSelf(MariposaBlocks.SEQUOIA_FENCE);
		dropSelf(MariposaBlocks.SEQUOIA_FENCE_GATE);
		add(MariposaBlocks.SEQUOIA_DOOR, this::createDoorTable);
		dropSelf(MariposaBlocks.SEQUOIA_TRAPDOOR);
		dropSelf(MariposaBlocks.SEQUOIA_PRESSURE_PLATE);
		dropSelf(MariposaBlocks.SEQUOIA_BUTTON);
		dropSelf(MariposaBlocks.SEQUOIA_SHELF);
		dropSelf(MariposaBlocks.SEQUOIA_SIGN);
		dropSelf(MariposaBlocks.SEQUOIA_HANGING_SIGN);
	}
}
