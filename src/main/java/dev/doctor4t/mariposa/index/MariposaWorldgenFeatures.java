package dev.doctor4t.mariposa.index;

import dev.doctor4t.mariposa.Mariposa;
import dev.doctor4t.mariposa.world.gen.feature.GiantSequoiaLogFeature;
import dev.doctor4t.mariposa.world.gen.feature.GiantSequoiaTreeFeature;
import dev.doctor4t.mariposa.world.gen.feature.config.GiantSequoiaLogFeatureConfig;
import dev.doctor4t.mariposa.world.gen.feature.config.GiantSequoiaTreeFeatureConfig;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.DefaultFeatureConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.LinkedHashMap;
import java.util.Map;

public interface MariposaWorldgenFeatures {
    Map<Feature<? extends FeatureConfig>, Identifier> FEATURES = new LinkedHashMap<>();

    Feature<? extends FeatureConfig> GIANT_SEQUOIA_TREE = create("giant_sequoia_tree", new GiantSequoiaTreeFeature(GiantSequoiaTreeFeatureConfig.CODEC));
    Feature<? extends FeatureConfig> GIANT_SEQUOIA_LOG = create("giant_sequoia_log", new GiantSequoiaLogFeature(GiantSequoiaLogFeatureConfig.CODEC));

    static Feature<? extends FeatureConfig> create(String name, Feature<? extends FeatureConfig> feature) {
        FEATURES.put(feature, Mariposa.id(name));
        return feature;
    }

    static void initialize() {
        FEATURES.forEach((block, id) -> Registry.register(Registries.FEATURE, id, block));
    }
}
