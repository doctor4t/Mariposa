package dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.List;

public record GiantSequoiaTreeConfiguration(
		List<Identifier> sequoiaStructures,
		int minCornersInFloor
) implements FeatureConfiguration {
	public static final Codec<GiantSequoiaTreeConfiguration> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(
							Identifier.CODEC.listOf().fieldOf("sequoia_structures").forGetter(config -> config.sequoiaStructures),
							Codec.intRange(0, 7).fieldOf("min_floor_corners_allowed").forGetter(config -> config.minCornersInFloor)
					)
					.apply(instance, GiantSequoiaTreeConfiguration::new)
	);
}
