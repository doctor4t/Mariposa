/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.data;

import dev.doctor4t.mariposa.data.provider.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class MariposaDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();
		pack.addProvider(MariposaModelProvider::new);

		MariposaTagProviders.MariposaBlockTags blockGen = pack.addProvider(MariposaTagProviders.MariposaBlockTags::new);
		pack.addProvider((fabricDataOutput, completableFuture) -> new MariposaTagProviders.MariposaItemTags(fabricDataOutput, completableFuture, blockGen));
		pack.addProvider(MariposaTagProviders.MariposaEntityTypeTags::new);
		pack.addProvider(MariposaTagProviders.MariposaBiomeTags::new);

		pack.addProvider(MariposaLanguageProvider::new);
		pack.addProvider(MariposaBlockLootSubProvider::new);
		pack.addProvider(MariposaRecipeProvider::new);

		pack.addProvider(MariposaConfiguredFeatures::new);
	}

	@Override
	public void buildRegistry(RegistrySetBuilder registryBuilder) {
		registryBuilder.add(Registries.CONFIGURED_FEATURE, MariposaConfiguredFeatures::bootstrap);
	}
}
