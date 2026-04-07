/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.data.provider;

import com.google.common.collect.ImmutableList;
import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.init.MariposaBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaPineFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.AlterGroundDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.GiantTrunkPlacer;

import java.util.concurrent.CompletableFuture;

public class MariposaConfiguredFeatures extends FabricDynamicRegistryProvider {
	public static final ResourceKey<ConfiguredFeature<?, ?>> SEQUOIA = of("sequoia");
	public static final ResourceKey<ConfiguredFeature<?, ?>> SNOWY_SEQUOIA = of("snowy_sequoia");

	public static ResourceKey<ConfiguredFeature<?, ?>> of(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Mariposa.id(name));
	}

	public MariposaConfiguredFeatures(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
		super(output, registriesFuture);
	}

	@Override
	protected void configure(HolderLookup.Provider registries, Entries entries) {
		entries.addAll(registries.lookupOrThrow(Registries.CONFIGURED_FEATURE));
	}

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> registry) {
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
						.decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.PODZOL))))
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
						.decorators(ImmutableList.of(new AlterGroundDecorator(BlockStateProvider.simple(Blocks.SNOW_BLOCK))))
						.build()
		);
	}

	@Override
	public String getName() {
		return Mariposa.MOD_ID + "_configured_features";
	}
}
