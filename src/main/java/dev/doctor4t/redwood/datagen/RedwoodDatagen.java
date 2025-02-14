package dev.doctor4t.redwood.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class RedwoodDatagen implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator dataGenerator) {
        FabricDataGenerator.Pack pack = dataGenerator.createPack();
        pack.addProvider(RedwoodModelGen::new);

        pack.addProvider(RedwoodTagGen.RedwoodBlockTagGen::new);
        pack.addProvider(RedwoodTagGen.RedwoodItemTagGen::new);

        pack.addProvider(RedwoodLangGen::new);
        pack.addProvider(RedwoodBlockLootTableGen::new);
        pack.addProvider(RedwoodRecipeGen::new);

        pack.addProvider(RedwoodConfiguredFeatures::new);
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, RedwoodConfiguredFeatures::bootstrap);
    }
}
