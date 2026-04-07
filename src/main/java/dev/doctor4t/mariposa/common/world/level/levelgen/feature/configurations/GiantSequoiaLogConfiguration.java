/*
 * Copyright (c) doctor4t. All Rights Reserved.
 */

package dev.doctor4t.mariposa.common.world.level.levelgen.feature.configurations;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;

import java.util.List;

public record GiantSequoiaLogConfiguration(
		List<Identifier> sequoiaStructures
) implements FeatureConfiguration {
	public static final Codec<GiantSequoiaLogConfiguration> CODEC = RecordCodecBuilder.create(
			instance -> instance.group(
							Identifier.CODEC.listOf().fieldOf("sequoia_structures").forGetter(config -> config.sequoiaStructures)
					)
					.apply(instance, GiantSequoiaLogConfiguration::new)
	);
}
