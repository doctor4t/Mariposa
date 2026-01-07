package dev.doctor4t.mariposa.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MariposaDatagen implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
		FabricDataGenerator.Pack pack = dataGenerator.createPack();
		pack.addProvider(MariposaModelGen::new);

		MariposaTagGen.MariposaBlockTagGen blockGen = pack.addProvider(MariposaTagGen.MariposaBlockTagGen::new);
		pack.addProvider((fabricDataOutput, completableFuture) -> new MariposaTagGen.MariposaItemTagGen(fabricDataOutput, completableFuture, blockGen));
		pack.addProvider(MariposaTagGen.MariposaEntityTypeTagGen::new);
		pack.addProvider(MariposaTagGen.MariposaBiomeTagGen::new);

		pack.addProvider(MariposaLangGen::new);
		pack.addProvider(MariposaBlockLootTableGen::new);
		pack.addProvider(MariposaRecipeGen::new);

		pack.addProvider(MariposaConfiguredFeatures::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, MariposaConfiguredFeatures::bootstrap);
	}
}
