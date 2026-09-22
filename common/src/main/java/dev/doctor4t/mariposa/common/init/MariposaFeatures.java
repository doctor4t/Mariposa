package dev.doctor4t.mariposa.common.init;

import com.google.common.collect.ImmutableList;
import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.FallenSequoiaLogFeature;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.GiantSequoiaTreeFeature;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BlockStateProviders;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.RandomSelectorFeature;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public interface MariposaFeatures {
	ResourceKey<Feature> FALLEN_SEQUOIA_LOG = key("fallen_sequoia_log");
	ResourceKey<Feature> GIANT_SEQUOIA_TREE = key("giant_sequoia_tree");
	ResourceKey<Feature> SEQUOIA = key("sequoia");
	ResourceKey<Feature> SNOWY_SEQUOIA = key("snowy_sequoia");
	ResourceKey<Feature> TREES_REDWOOD_FOREST = key("trees_redwood_forest");
	ResourceKey<Feature> TREES_SNOWY_REDWOOD_FOREST = key("trees_snowy_redwood_forest");

	private static ResourceKey<Feature> key(String name) {
		return ResourceKey.create(Registries.FEATURE, Mariposa.id(name));
	}

	static void bootstrap(BootstrapContext<Feature> registry) {
		HolderGetter<BlockStateProvider> blockStateProviders = registry.lookup(Registries.BLOCK_STATE_PROVIDER);
		HolderGetter<PlacedFeature> placedFeatures = registry.lookup(Registries.PLACED_FEATURE);

		Holder<BlockStateProvider> belowTrunkProvider = blockStateProviders.getOrThrow(BlockStateProviders.SOIL_BENEATH_TREE);
		Holder<BlockStateProvider> podzol = blockStateProviders.getOrThrow(BlockStateProviders.PODZOL_BENEATH_TREE);
		Holder<BlockStateProvider> snow = blockStateProviders.getOrThrow(MariposaBlockStateProviders.SNOW_BENEATH_TREE);

		Holder<PlacedFeature> pineChecked = placedFeatures.getOrThrow(TreePlacements.PINE_CHECKED);
		Holder<PlacedFeature> spruceChecked = placedFeatures.getOrThrow(TreePlacements.SPRUCE_CHECKED);
		Holder<PlacedFeature> sequoiaChecked = placedFeatures.getOrThrow(MariposaPlacedFeatures.SEQUOIA_CHECKED);
		Holder<PlacedFeature> snowySequoiaChecked = placedFeatures.getOrThrow(MariposaPlacedFeatures.SNOWY_SEQUOIA_CHECKED);

		registry.register(
				FALLEN_SEQUOIA_LOG,
				new FallenSequoiaLogFeature(List.of(
						Mariposa.id("fallen_sequoia_log")
				))
		);
		registry.register(
				GIANT_SEQUOIA_TREE,
				new GiantSequoiaTreeFeature(List.of(
						Mariposa.id("giant_sequoia_1"),
						Mariposa.id("giant_sequoia_2"),
						Mariposa.id("giant_sequoia_3"),
						Mariposa.id("giant_sequoia_4"),
						Mariposa.id("giant_sequoia_5"),
						Mariposa.id("giant_sequoia_6"),
						Mariposa.id("giant_sequoia_7")
				), 4)
		);
		registry.register(
				SEQUOIA,
				sequoiaTree(belowTrunkProvider, podzol).build()
		);
		registry.register(
				SNOWY_SEQUOIA,
				sequoiaTree(belowTrunkProvider, snow).build()
		);
		registry.register(
				TREES_REDWOOD_FOREST,
				new RandomSelectorFeature(
						List.of(
								new WeightedPlacedFeature(pineChecked, 0.33333334F),
								new WeightedPlacedFeature(spruceChecked, 0.33333334F)
						),
						sequoiaChecked
				)
		);
		registry.register(
				TREES_SNOWY_REDWOOD_FOREST,
				new RandomSelectorFeature(
						List.of(
								new WeightedPlacedFeature(pineChecked, 0.33333334F),
								new WeightedPlacedFeature(spruceChecked, 0.33333334F)
						),
						snowySequoiaChecked
				)
		);
	}

	private static TreeFeature.Builder sequoiaTree(Holder<BlockStateProvider> belowTrunkProvider, Holder<BlockStateProvider> floorDecoratorProvider) {
		return new TreeFeature.Builder(
				BlockStateProvider.of(MariposaBlocks.SEQUOIA_LOG),
				new GiantTrunkPlacer(13, 2, 14),
				BlockStateProvider.of(MariposaBlocks.SEQUOIA_LEAVES),
				new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(10, 14)),
				new TwoLayersFeatureSize(1, 1, 2),
				belowTrunkProvider
		).decorators(ImmutableList.of(new AlterGroundDecorator(floorDecoratorProvider)));
	}
}
