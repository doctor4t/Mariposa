package dev.doctor4t.mariposa.world.gen.feature.config;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.FeatureConfig;

import java.util.List;

public record GiantSequoiaLogFeatureConfig(
        List<Identifier> sequoiaStructures
) implements FeatureConfig {
    public static final Codec<GiantSequoiaLogFeatureConfig> CODEC = RecordCodecBuilder.create(
            instance -> instance.group(
                            Identifier.CODEC.listOf().fieldOf("sequoia_structures").forGetter(config -> config.sequoiaStructures)
                    )
                    .apply(instance, GiantSequoiaLogFeatureConfig::new)
    );
}
