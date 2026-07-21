package dev.doctor4t.mariposa.common.init;

import com.google.common.collect.ImmutableList;
import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations.FallenSequoiaLogConfiguration;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations.GiantSequoiaTreeConfiguration;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.TreePlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.RuleBasedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public interface MariposaConfiguredFeatures {
	ResourceKey<ConfiguredFeature<?, ?>> FALLEN_SEQUOIA_LOG = key("fallen_sequoia_log");
	ResourceKey<ConfiguredFeature<?, ?>> GIANT_SEQUOIA_TREE = key("giant_sequoia_tree");
	ResourceKey<ConfiguredFeature<?, ?>> SEQUOIA = key("sequoia");
	ResourceKey<ConfiguredFeature<?, ?>> SNOWY_SEQUOIA = key("snowy_sequoia");
	ResourceKey<ConfiguredFeature<?, ?>> TREES_REDWOOD_FOREST = key("trees_redwood_forest");
	ResourceKey<ConfiguredFeature<?, ?>> TREES_SNOWY_REDWOOD_FOREST = key("trees_snowy_redwood_forest");

	private static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Mariposa.id(name));
	}

	static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> registry) {
		HolderGetter<PlacedFeature> placedFeatures = registry.lookup(Registries.PLACED_FEATURE);

		Holder<PlacedFeature> pineChecked = placedFeatures.getOrThrow(TreePlacements.PINE_CHECKED);
		Holder<PlacedFeature> spruceChecked = placedFeatures.getOrThrow(TreePlacements.SPRUCE_CHECKED);
		Holder<PlacedFeature> sequoiaChecked = placedFeatures.getOrThrow(MariposaPlacedFeatures.SEQUOIA_CHECKED);
		Holder<PlacedFeature> snowySequoiaChecked = placedFeatures.getOrThrow(MariposaPlacedFeatures.SNOWY_SEQUOIA_CHECKED);

		FeatureUtils.register(
				registry,
				FALLEN_SEQUOIA_LOG,
				MariposaFeatureConfigurations.FALLEN_SEQUOIA_LOG,
				new FallenSequoiaLogConfiguration(List.of(
						Mariposa.id("fallen_sequoia_log")
				))
		);
		FeatureUtils.register(
				registry,
				GIANT_SEQUOIA_TREE,
				MariposaFeatureConfigurations.GIANT_SEQUOIA_TREE,
				new GiantSequoiaTreeConfiguration(List.of(
						Mariposa.id("giant_sequoia_1"),
						Mariposa.id("giant_sequoia_2"),
						Mariposa.id("giant_sequoia_3"),
						Mariposa.id("giant_sequoia_4"),
						Mariposa.id("giant_sequoia_5"),
						Mariposa.id("giant_sequoia_6"),
						Mariposa.id("giant_sequoia_7")
				), 4)
		);
		FeatureUtils.register(
				registry,
				SEQUOIA,
				Feature.TREE,
				new TreeConfiguration.TreeConfigurationBuilder(
						BlockStateProvider.simple(MariposaBlocks.SEQUOIA_LOG),
						new GiantTrunkPlacer(13, 2, 14),
						BlockStateProvider.simple(MariposaBlocks.SEQUOIA_LEAVES),
						new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(10, 14)),
						new TwoLayersFeatureSize(1, 1, 2)
				)
						.decorators(ImmutableList.of(new AlterGroundDecorator(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesTag(BlockTags.BENEATH_TREE_PODZOL_REPLACEABLE), Blocks.PODZOL))))
						.build()
		);
		FeatureUtils.register(
				registry,
				SNOWY_SEQUOIA,
				Feature.TREE,
				new TreeConfiguration.TreeConfigurationBuilder(
						BlockStateProvider.simple(MariposaBlocks.SEQUOIA_LOG),
						new GiantTrunkPlacer(13, 2, 14),
						BlockStateProvider.simple(MariposaBlocks.SEQUOIA_LEAVES),
						new MegaPineFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0), UniformInt.of(10, 14)),
						new TwoLayersFeatureSize(1, 1, 2)
				)
						.decorators(ImmutableList.of(new AlterGroundDecorator(RuleBasedStateProvider.ifTrueThenProvide(BlockPredicate.matchesTag(BlockTags.BENEATH_TREE_PODZOL_REPLACEABLE), Blocks.SNOW_BLOCK))))
						.build()
		);
		FeatureUtils.register(
				registry,
				TREES_REDWOOD_FOREST,
				Feature.RANDOM_SELECTOR,
				new RandomFeatureConfiguration(
						List.of(
								new WeightedPlacedFeature(pineChecked, 0.33333334F),
								new WeightedPlacedFeature(spruceChecked, 0.33333334F)
						),
						sequoiaChecked
				)
		);
		FeatureUtils.register(
				registry,
				TREES_SNOWY_REDWOOD_FOREST,
				Feature.RANDOM_SELECTOR,
				new RandomFeatureConfiguration(
						List.of(
								new WeightedPlacedFeature(pineChecked, 0.33333334F),
								new WeightedPlacedFeature(spruceChecked, 0.33333334F)
						),
						snowySequoiaChecked
				)
		);
	}
}
