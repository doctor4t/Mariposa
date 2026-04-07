package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.GiantSequoiaLogFeature;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.GiantSequoiaTreeFeature;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations.GiantSequoiaLogConfiguration;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations.GiantSequoiaTreeConfiguration;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public interface MariposaWorldgenFeatures {
	static void create(String name, Feature<? extends FeatureConfiguration> feature) {
		Registry.register(BuiltInRegistries.FEATURE, Mariposa.id(name), feature);
	}

	static void initialize() {
		create("giant_sequoia_tree", new GiantSequoiaTreeFeature(GiantSequoiaTreeConfiguration.CODEC));
		create("giant_sequoia_log", new GiantSequoiaLogFeature(GiantSequoiaLogConfiguration.CODEC));
	}
}
