package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.datagen.MariposaConfiguredFeatures;
import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface MariposaSaplingGenerator {
    class SEQUOIA extends LargeTreeSaplingGenerator {
        @Nullable
        @Override
        protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
            return null;
        }

        @Nullable
        @Override
        protected RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
            return MariposaConfiguredFeatures.SEQUOIA;
        }
    }
}
