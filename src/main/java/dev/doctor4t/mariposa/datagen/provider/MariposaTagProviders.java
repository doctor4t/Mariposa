/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.datagen.provider;

import dev.doctor4t.mariposa.common.init.MariposaBiomes;
import dev.doctor4t.mariposa.common.references.MariposaBlockIds;
import dev.doctor4t.mariposa.common.references.MariposaBlockItemIds;
import dev.doctor4t.mariposa.common.references.MariposaEntityTypeIds;
import dev.doctor4t.mariposa.common.references.MariposaItemIds;
import dev.doctor4t.mariposa.common.tag.MariposaTags;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBiomeTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalEntityTypeTags;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.*;
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
			builder(MariposaTags.SEQUOIA_LOGS).add(
					MariposaBlockItemIds.SEQUOIA_LOG,
					MariposaBlockItemIds.SEQUOIA_WOOD,
					MariposaBlockItemIds.STRIPPED_SEQUOIA_LOG,
					MariposaBlockItemIds.STRIPPED_SEQUOIA_WOOD,
					MariposaBlockItemIds.STACKED_SEQUOIA_LOGS);
			builder(ConventionalBlockTags.STRIPPED_LOGS)
					.add(MariposaBlockItemIds.STRIPPED_SEQUOIA_LOG);
			builder(ConventionalBlockTags.STRIPPED_WOODS)
					.add(MariposaBlockItemIds.STRIPPED_SEQUOIA_WOOD);
			builder(ConventionalBlockTags.WOODEN_FENCES)
					.add(MariposaBlockItemIds.SEQUOIA_FENCE);
			builder(ConventionalBlockTags.WOODEN_FENCE_GATES)
					.add(MariposaBlockItemIds.SEQUOIA_FENCE_GATE);
			builder(BlockItemTags.LOGS_THAT_BURN.block())
					.addTag(MariposaTags.SEQUOIA_LOGS);
			builder(BlockTags.OVERWORLD_NATURAL_LOGS)
					.add(MariposaBlockItemIds.SEQUOIA_LOG);
			builder(BlockItemTags.SAPLINGS.block())
					.add(MariposaBlockItemIds.SEQUOIA_SAPLING);
			builder(BlockTags.FLOWER_POTS)
					.add(MariposaBlockIds.POTTED_SEQUOIA_SAPLING);
			builder(BlockTags.LEAVES)
					.add(MariposaBlockItemIds.SEQUOIA_LEAVES);
			builder(BlockTags.PLANKS)
					.add(MariposaBlockItemIds.SEQUOIA_PLANKS);
			builder(BlockTags.WOODEN_STAIRS)
					.add(MariposaBlockItemIds.SEQUOIA_STAIRS);
			builder(BlockTags.WOODEN_SLABS)
					.add(MariposaBlockItemIds.SEQUOIA_SLAB);
			builder(BlockTags.WOODEN_FENCES)
					.add(MariposaBlockItemIds.SEQUOIA_FENCE);
			builder(BlockTags.FENCE_GATES)
					.add(MariposaBlockItemIds.SEQUOIA_FENCE_GATE);
			builder(BlockTags.WOODEN_DOORS)
					.add(MariposaBlockItemIds.SEQUOIA_DOOR);
			builder(BlockTags.WOODEN_TRAPDOORS)
					.add(MariposaBlockItemIds.SEQUOIA_TRAPDOOR);
			builder(BlockTags.WOODEN_PRESSURE_PLATES)
					.add(MariposaBlockItemIds.SEQUOIA_PRESSURE_PLATE);
			builder(BlockTags.WOODEN_BUTTONS)
					.add(MariposaBlockItemIds.SEQUOIA_BUTTON);
			builder(BlockTags.WOODEN_SHELVES)
					.add(MariposaBlockItemIds.SEQUOIA_SHELF);
			builder(BlockTags.STANDING_SIGNS)
					.add(MariposaBlockItemIds.SEQUOIA_SIGN);
			builder(BlockTags.WALL_SIGNS)
					.add(MariposaBlockIds.SEQUOIA_WALL_SIGN);
			builder(BlockTags.CEILING_HANGING_SIGNS)
					.add(MariposaBlockItemIds.SEQUOIA_HANGING_SIGN);
			builder(BlockTags.WALL_HANGING_SIGNS)
					.add(MariposaBlockIds.SEQUOIA_WALL_HANGING_SIGN);
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
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST);
			builder(ConventionalBiomeTags.IS_OVERWORLD)
					.addOptional(MariposaBiomes.REDWOOD_FOREST)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST);
			builder(ConventionalBiomeTags.IS_TEMPERATE_OVERWORLD)
					.addOptional(MariposaBiomes.REDWOOD_FOREST);
			builder(ConventionalBiomeTags.IS_COLD_OVERWORLD)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST);
			builder(ConventionalBiomeTags.IS_SNOWY)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST);
			builder(BiomeTags.SPAWNS_SNOW_FOXES)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST);
			builder(BiomeTags.SPAWNS_WHITE_RABBITS)
					.addOptional(MariposaBiomes.SNOWY_REDWOOD_FOREST);
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
			copy(BlockItemTags.LOGS_THAT_BURN.block(), ItemTags.LOGS_THAT_BURN);
			copy(BlockItemTags.SAPLINGS.block(), ItemTags.SAPLINGS);
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
			builder(ItemTags.SIGNS)
					.add(MariposaBlockItemIds.SEQUOIA_SIGN);
			builder(ItemTags.HANGING_SIGNS)
					.add(MariposaBlockItemIds.SEQUOIA_HANGING_SIGN);
			builder(ItemTags.BOATS)
					.add(MariposaItemIds.SEQUOIA_BOAT);
			builder(ItemTags.CHEST_BOATS)
					.add(MariposaItemIds.SEQUOIA_CHEST_BOAT);
		}
	}

	public static class MariposaEntityTypeTags extends FabricTagsProvider.EntityTypeTagsProvider {
		public MariposaEntityTypeTags(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
			super(output, registriesFuture);
		}

		@Override
		protected void addTags(HolderLookup.Provider registries) {
			// CONVENTIONAL
			builder(ConventionalEntityTypeTags.BOATS)
					.add(MariposaEntityTypeIds.SEQUOIA_CHEST_BOAT);
			// VANILLA
			builder(EntityTypeTags.BOAT)
					.add(MariposaEntityTypeIds.SEQUOIA_BOAT);
		}
	}
}
