package dev.doctor4t.mariposa.index;

//import net.minecraft.block.SaplingGenerator;
import dev.doctor4t.mariposa.datagen.MariposaConfiguredFeatures;
import dev.doctor4t.mariposa.tree.SequoiaSaplingGenerator;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeConfiguredFeatures;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public interface MariposaSaplingGenerator {
    SaplingGenerator SEQUOIA = new SequoiaSaplingGenerator();
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
