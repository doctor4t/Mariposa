package dev.doctor4t.mariposa.index;

import net.minecraft.block.sapling.LargeTreeSaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

@SuppressWarnings("unused")
public interface MariposaSaplingGenerator {
    class SEQUOIA extends LargeTreeSaplingGenerator {
        @Nullable
        @Override
        protected RegistryKey<ConfiguredFeature<?, ?>> getLargeTreeFeature(Random random) {
            return random.nextBoolean() ? TreeConfiguredFeatures.MEGA_SPRUCE : TreeConfiguredFeatures.MEGA_PINE;
        }

        @Nullable
        @Override
        protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
            return TreeConfiguredFeatures.SPRUCE;
        }
    }
}
