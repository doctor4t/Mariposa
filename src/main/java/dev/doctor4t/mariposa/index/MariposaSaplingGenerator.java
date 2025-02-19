package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.tree.SequoiaSaplingGenerator;
import net.minecraft.block.sapling.SaplingGenerator;

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
