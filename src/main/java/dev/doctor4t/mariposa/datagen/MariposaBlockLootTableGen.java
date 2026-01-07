package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.index.MariposaBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MariposaBlockLootTableGen extends FabricBlockLootTableProvider {
	protected MariposaBlockLootTableGen(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}

	@Override
	public void generate() {
		addDrop(MariposaBlocks.SEQUOIA_SAPLING);
		addPottedPlantDrops(MariposaBlocks.POTTED_SEQUOIA_SAPLING);
		addDrop(MariposaBlocks.SEQUOIA_LOG);
		addDrop(MariposaBlocks.SEQUOIA_WOOD);
		addDrop(MariposaBlocks.STRIPPED_SEQUOIA_LOG);
		addDrop(MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
		addDrop(MariposaBlocks.STACKED_SEQUOIA_LOGS);
		addDrop(MariposaBlocks.SEQUOIA_LEAVES, block -> leavesDrops(block, MariposaBlocks.SEQUOIA_SAPLING, SAPLING_DROP_CHANCE));
		addDrop(MariposaBlocks.SEQUOIA_PLANKS);
		addDrop(MariposaBlocks.SEQUOIA_STAIRS);
		addDrop(MariposaBlocks.SEQUOIA_SLAB, this::slabDrops);
		addDrop(MariposaBlocks.SEQUOIA_FENCE);
		addDrop(MariposaBlocks.SEQUOIA_FENCE_GATE);
		addDrop(MariposaBlocks.SEQUOIA_DOOR, this::doorDrops);
		addDrop(MariposaBlocks.SEQUOIA_TRAPDOOR);
		addDrop(MariposaBlocks.SEQUOIA_PRESSURE_PLATE);
		addDrop(MariposaBlocks.SEQUOIA_BUTTON);
		addDrop(MariposaBlocks.SEQUOIA_SHELF);
		addDrop(MariposaBlocks.SEQUOIA_SIGN);
		addDrop(MariposaBlocks.SEQUOIA_HANGING_SIGN);
	}
}
