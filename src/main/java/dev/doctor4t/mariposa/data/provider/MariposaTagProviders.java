/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.data.provider;

import dev.doctor4t.mariposa.common.init.MariposaBiomes;
import dev.doctor4t.mariposa.common.init.MariposaBlocks;
import dev.doctor4t.mariposa.common.init.MariposaEntityTypes;
import dev.doctor4t.mariposa.common.init.MariposaItems;
import dev.doctor4t.mariposa.common.tag.MariposaTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.biome.Biome;
import org.jspecify.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class MariposaTagProviders {
	public static class MariposaBlockTags extends FabricTagsProvider.BlockTagsProvider {
		public MariposaBlockTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected void addTags(HolderLookup.Provider registries) {
			valueLookupBuilder(MariposaTags.SEQUOIA_LOGS).add(
					MariposaBlocks.SEQUOIA_LOG,
					MariposaBlocks.SEQUOIA_WOOD,
					MariposaBlocks.STRIPPED_SEQUOIA_LOG,
					MariposaBlocks.STRIPPED_SEQUOIA_WOOD,
					MariposaBlocks.STACKED_SEQUOIA_LOGS);
			valueLookupBuilder(ConventionalBlockTags.STRIPPED_LOGS)
					.add(MariposaBlocks.STRIPPED_SEQUOIA_LOG);
			valueLookupBuilder(ConventionalBlockTags.STRIPPED_WOODS)
					.add(MariposaBlocks.STRIPPED_SEQUOIA_WOOD);
			valueLookupBuilder(ConventionalBlockTags.WOODEN_FENCES)
					.add(MariposaBlocks.SEQUOIA_FENCE);
			valueLookupBuilder(ConventionalBlockTags.WOODEN_FENCE_GATES)
					.add(MariposaBlocks.SEQUOIA_FENCE_GATE);
			valueLookupBuilder(BlockTags.LOGS_THAT_BURN)
					.addTag(MariposaTags.SEQUOIA_LOGS);
			valueLookupBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
					.add(MariposaBlocks.SEQUOIA_LOG);
			valueLookupBuilder(BlockTags.SAPLINGS)
					.add(MariposaBlocks.SEQUOIA_SAPLING);
			valueLookupBuilder(BlockTags.FLOWER_POTS)
					.add(MariposaBlocks.POTTED_SEQUOIA_SAPLING);
			valueLookupBuilder(BlockTags.LEAVES)
					.add(MariposaBlocks.SEQUOIA_LEAVES);
			valueLookupBuilder(BlockTags.PLANKS)
					.add(MariposaBlocks.SEQUOIA_PLANKS);
			valueLookupBuilder(BlockTags.WOODEN_STAIRS)
					.add(MariposaBlocks.SEQUOIA_STAIRS);
			valueLookupBuilder(BlockTags.WOODEN_SLABS)
					.add(MariposaBlocks.SEQUOIA_SLAB);
			valueLookupBuilder(BlockTags.WOODEN_FENCES)
					.add(MariposaBlocks.SEQUOIA_FENCE);
			valueLookupBuilder(BlockTags.FENCE_GATES)
					.add(MariposaBlocks.SEQUOIA_FENCE_GATE);
			valueLookupBuilder(BlockTags.WOODEN_DOORS)
					.add(MariposaBlocks.SEQUOIA_DOOR);
			valueLookupBuilder(BlockTags.WOODEN_TRAPDOORS)
					.add(MariposaBlocks.SEQUOIA_TRAPDOOR);
			valueLookupBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
					.add(MariposaBlocks.SEQUOIA_PRESSURE_PLATE);
			valueLookupBuilder(BlockTags.WOODEN_BUTTONS)
					.add(MariposaBlocks.SEQUOIA_BUTTON);
			valueLookupBuilder(BlockTags.WOODEN_SHELVES)
					.add(MariposaBlocks.SEQUOIA_SHELF);
			valueLookupBuilder(BlockTags.STANDING_SIGNS)
					.add(MariposaBlocks.SEQUOIA_SIGN);
			valueLookupBuilder(BlockTags.WALL_SIGNS)
					.add(MariposaBlocks.SEQUOIA_WALL_SIGN);
			valueLookupBuilder(BlockTags.CEILING_HANGING_SIGNS)
					.add(MariposaBlocks.SEQUOIA_HANGING_SIGN);
			valueLookupBuilder(BlockTags.WALL_HANGING_SIGNS)
					.add(MariposaBlocks.SEQUOIA_WALL_HANGING_SIGN);
		}
	}

	public static class MariposaItemTags extends FabricTagsProvider.ItemTagsProvider {
		public MariposaItemTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture, @Nullable BlockTagsProvider blockTagsProvider) {
			super(output, registriesFuture, blockTagsProvider);
		}

		@Override
		protected void addTags(HolderLookup.Provider registries) {
			copy(MariposaTags.SEQUOIA_LOGS, MariposaTags.SEQUOIA_LOGS_ITEM);
			copy(ConventionalBlockTags.STRIPPED_LOGS, ConventionalItemTags.STRIPPED_LOGS);
			copy(ConventionalBlockTags.STRIPPED_WOODS, ConventionalItemTags.STRIPPED_WOODS);
			copy(ConventionalBlockTags.WOODEN_FENCES, ConventionalItemTags.WOODEN_FENCES);
			copy(ConventionalBlockTags.WOODEN_FENCE_GATES, ConventionalItemTags.WOODEN_FENCE_GATES);
			copy(BlockTags.LOGS_THAT_BURN, ItemTags.LOGS_THAT_BURN);
			copy(BlockTags.SAPLINGS, ItemTags.SAPLINGS);
			copy(BlockTags.LEAVES, ItemTags.LEAVES);
			copy(BlockTags.PLANKS, ItemTags.PLANKS);
			copy(BlockTags.WOODEN_STAIRS, ItemTags.WOODEN_STAIRS);
			copy(BlockTags.WOODEN_SLABS, ItemTags.WOODEN_SLABS);
			copy(BlockTags.WOODEN_FENCES, ItemTags.WOODEN_FENCES);
			copy(BlockTags.FENCE_GATES, ItemTags.FENCE_GATES);
			copy(BlockTags.WOODEN_DOORS, ItemTags.WOODEN_DOORS);
			copy(BlockTags.WOODEN_TRAPDOORS, ItemTags.WOODEN_TRAPDOORS);
			copy(BlockTags.WOODEN_PRESSURE_PLATES, ItemTags.WOODEN_PRESSURE_PLATES);
			copy(BlockTags.WOODEN_BUTTONS, ItemTags.WOODEN_BUTTONS);
			copy(BlockTags.WOODEN_SHELVES, ItemTags.WOODEN_SHELVES);
			valueLookupBuilder(ItemTags.SIGNS)
					.add(MariposaItems.SEQUOIA_SIGN);
			valueLookupBuilder(ItemTags.HANGING_SIGNS)
					.add(MariposaItems.SEQUOIA_HANGING_SIGN);
			valueLookupBuilder(ItemTags.BOATS)
					.add(MariposaItems.SEQUOIA_BOAT);
			valueLookupBuilder(ItemTags.CHEST_BOATS)
					.add(MariposaItems.SEQUOIA_CHEST_BOAT);
		}
	}

	public static class MariposaEntityTypeTags extends FabricTagsProvider.EntityTypeTagsProvider {
		public MariposaEntityTypeTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected void addTags(HolderLookup.Provider registries) {
			// CONVENTIONAL
			valueLookupBuilder(ConventionalEntityTypeTags.BOATS)
					.add(MariposaEntityTypes.SEQUOIA_CHEST_BOAT);
			// VANILLA
			valueLookupBuilder(EntityTypeTags.BOAT)
					.add(MariposaEntityTypes.SEQUOIA_BOAT);
		}
	}

	public static class MariposaBiomeTags extends FabricTagsProvider<Biome> {
		public MariposaBiomeTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, Registries.BIOME, registriesFuture);
		}

		@Override
		protected void addTags(HolderLookup.Provider registries) {
			builder(ConventionalBiomeTags.IS_FOREST)
					.addOptional(MariposaBiomes.REDWOOD_FOREST)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST)
			;
			builder(ConventionalBiomeTags.IS_OVERWORLD)
					.addOptional(MariposaBiomes.REDWOOD_FOREST)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST)
			;
			builder(ConventionalBiomeTags.IS_TEMPERATE_OVERWORLD)
					.addOptional(MariposaBiomes.REDWOOD_FOREST)
			;
			builder(ConventionalBiomeTags.IS_COLD_OVERWORLD)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST)
			;
			builder(ConventionalBiomeTags.IS_SNOWY)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST)
			;
			builder(BiomeTags.SPAWNS_SNOW_FOXES)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST)
			;
			builder(BiomeTags.SPAWNS_WHITE_RABBITS)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST)
			;
		}
	}
}
