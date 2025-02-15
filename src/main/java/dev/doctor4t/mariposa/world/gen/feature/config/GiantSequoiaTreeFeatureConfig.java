package dev.doctor4t.mariposa.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public record GiantSequoiaTreeFeatureConfig(
        List<Identifier> sequoiaStructures,
        int minCornersInFloor
) implements FeatureConfig {
    public static final Codec<GiantSequoiaTreeFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Identifier.CODEC.listOf().fieldOf("sequoia_structures").forGetter(config -> config.sequoiaStructures),
                            Codec.intRange(0, 7).fieldOf("min_floor_corners_allowed").forGetter(config -> config.minCornersInFloor)
                    )
                    .apply(instance, GiantSequoiaTreeFeatureConfig::new)
    );
}
