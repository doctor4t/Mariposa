package dev.doctor4t.mariposa.tree;

//import net.minecraft.block.SaplingGenerator;
import dev.doctor4t.mariposa.datagen.MariposaConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.jetbrains.annotations.Nullable;

public class SequoiaSaplingGenerator extends SaplingGenerator {

    @Nullable
    @Override
    protected RegistryKey<ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return MariposaConfiguredFeatures.SEQUOIA;
    }

//    SaplingGenerator SEQUOIA = new SaplingGenerator(
//            "sequoia",
//            0.5F,
//            Optional.of(TreeConfiguredFeatures.MEGA_SPRUCE),
//            Optional.of(TreeConfiguredFeatures.MEGA_PINE),
//            Optional.of(TreeConfiguredFeatures.SPRUCE),
//            Optional.empty(),
//            Optional.empty(),
//            Optional.empty()
//    );
}
