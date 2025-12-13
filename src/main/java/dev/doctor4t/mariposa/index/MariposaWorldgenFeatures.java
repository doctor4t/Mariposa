package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.world.gen.feature.GiantSequoiaLogFeature;
import dev.doctor4t.mariposa.world.gen.feature.GiantSequoiaTreeFeature;
import dev.doctor4t.mariposa.world.gen.feature.config.GiantSequoiaLogFeatureConfig;
import dev.doctor4t.mariposa.world.gen.feature.config.GiantSequoiaTreeFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public interface MariposaWorldgenFeatures {
    static void create(String name, Feature<? extends FeatureConfig> feature) {
        Registry.register(Registries.FEATURE, Mariposa.id(name), feature);
    }

    static void initialize() {
        create("giant_sequoia_tree", new GiantSequoiaTreeFeature(GiantSequoiaTreeFeatureConfig.CODEC));
        create("giant_sequoia_log", new GiantSequoiaLogFeature(GiantSequoiaLogFeatureConfig.CODEC));
    }
}
