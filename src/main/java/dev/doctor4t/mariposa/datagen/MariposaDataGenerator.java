/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.datagen;

import dev.doctor4t.mariposa.common.init.MariposaBiomes;
import dev.doctor4t.mariposa.common.init.MariposaConfiguredFeatures;
import dev.doctor4t.mariposa.common.init.MariposaPlacedFeatures;
import dev.doctor4t.mariposa.datagen.provider.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MariposaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(MariposaBlockLootSubProvider::new);
		pack.addProvider(MariposaDynamicRegistryProvider::new);
		pack.addProvider(MariposaLanguageProvider::new);
		pack.addProvider(MariposaModelProvider::new);
		pack.addProvider(MariposaRecipeProvider::new);
		MariposaTagProviders.MariposaBlockTags blockTagsProvider = pack.addProvider(MariposaTagProviders.MariposaBlockTags::new);
		pack.addProvider(MariposaTagProviders.MariposaBiomeTags::new);
		pack.addProvider((output, registriesFuture) -> new MariposaTagProviders.MariposaItemTags(output, registriesFuture, blockTagsProvider));
		pack.addProvider(MariposaTagProviders.MariposaEntityTypeTags::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.BIOME, MariposaBiomes::bootstrap);
		registryBuilder.add(Registries.CONFIGURED_FEATURE, MariposaConfiguredFeatures::bootstrap);
		registryBuilder.add(Registries.PLACED_FEATURE, MariposaPlacedFeatures::bootstrap);
	}
}
