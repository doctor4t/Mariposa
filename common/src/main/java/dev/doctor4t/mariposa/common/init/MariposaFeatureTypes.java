package dev.doctor4t.mariposa.common.init;

import dev.doctor4t.mariposa.common.Mariposa;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.FallenSequoiaLogFeature;
import dev.doctor4t.mariposa.common.world.level.levelgen.feature.GiantSequoiaTreeFeature;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;

public interface MariposaFeatureTypes {
	static void initialize() {
		Registry.register(BuiltInRegistries.FEATURE_TYPE, Mariposa.id("fallen_sequoia_log"), FallenSequoiaLogFeature.CODEC);
		Registry.register(BuiltInRegistries.FEATURE_TYPE, Mariposa.id("giant_sequoia_tree"), GiantSequoiaTreeFeature.CODEC);
	}
}
