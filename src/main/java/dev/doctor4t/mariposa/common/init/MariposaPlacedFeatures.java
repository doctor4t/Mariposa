/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public interface MariposaPlacedFeatures {
	ResourceKey<PlacedFeature> FALLEN_SEQUOIA_LOG = key("fallen_sequoia_log");
	ResourceKey<PlacedFeature> GIANT_SEQUOIA_TREE = key("giant_sequoia_tree");
	ResourceKey<PlacedFeature> SEQUOIA_CHECKED = key("sequoia_checked");
	ResourceKey<PlacedFeature> SNOWY_SEQUOIA_CHECKED = key("snowy_sequoia_checked");
	ResourceKey<PlacedFeature> TREES_REDWOOD_FOREST = key("trees_redwood_forest");
	ResourceKey<PlacedFeature> TREES_SNOWY_REDWOOD_FOREST = key("trees_snowy_redwood_forest");

	private static ResourceKey<PlacedFeature> key(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, Mariposa.id(name));
	}

	static void bootstrap(BootstrapContext<PlacedFeature> registry) {
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = registry.lookup(Registries.CONFIGURED_FEATURE);

		PlacementUtils.register(registry, FALLEN_SEQUOIA_LOG, configuredFeatures.getOrThrow(MariposaConfiguredFeatures.FALLEN_SEQUOIA_LOG), RarityFilter.onAverageOnceEvery(128), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PlacementUtils.register(registry, GIANT_SEQUOIA_TREE, configuredFeatures.getOrThrow(MariposaConfiguredFeatures.GIANT_SEQUOIA_TREE), RarityFilter.onAverageOnceEvery(1), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP_WORLD_SURFACE, BiomeFilter.biome());
		PlacementUtils.register(registry, SEQUOIA_CHECKED, configuredFeatures.getOrThrow(MariposaConfiguredFeatures.SEQUOIA), PlacementUtils.filteredByBlockSurvival(MariposaBlocks.SEQUOIA_SAPLING));
		PlacementUtils.register(registry, SNOWY_SEQUOIA_CHECKED, configuredFeatures.getOrThrow(MariposaConfiguredFeatures.SNOWY_SEQUOIA), PlacementUtils.filteredByBlockSurvival(MariposaBlocks.SEQUOIA_SAPLING));
		PlacementUtils.register(registry, TREES_REDWOOD_FOREST, configuredFeatures.getOrThrow(MariposaConfiguredFeatures.TREES_REDWOOD_FOREST), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
		PlacementUtils.register(registry, TREES_SNOWY_REDWOOD_FOREST, configuredFeatures.getOrThrow(MariposaConfiguredFeatures.TREES_SNOWY_REDWOOD_FOREST), VegetationPlacements.treePlacement(PlacementUtils.countExtra(10, 0.1F, 1)));
	}
}
