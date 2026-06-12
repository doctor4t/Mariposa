/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.FallenSequoiaLogFeature;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.GiantSequoiaTreeFeature;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations.FallenSequoiaLogConfiguration;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations.GiantSequoiaTreeConfiguration;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

public interface MariposaFeatureConfigurations {
	Feature<FallenSequoiaLogConfiguration> FALLEN_SEQUOIA_LOG = register("fallen_sequoia_log", new FallenSequoiaLogFeature(FallenSequoiaLogConfiguration.CODEC));
	Feature<GiantSequoiaTreeConfiguration> GIANT_SEQUOIA_TREE = register("giant_sequoia_tree", new GiantSequoiaTreeFeature(GiantSequoiaTreeConfiguration.CODEC));

	private static <T extends FeatureConfiguration> Feature<T> register(String name, Feature<T> feature) {
		return Registry.register(BuiltInRegistries.FEATURE, Mariposa.id(name), feature);
	}

	static void initialize() {
	}
}
